package edu.aku.hassannaqvi.uen_midline.sync;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

import edu.aku.hassannaqvi.uen_midline.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_midline.adapter.UploadListAdapter;
import edu.aku.hassannaqvi.uen_midline.otherClasses.SyncModel;

/**
 * Created by ali.azaz on 3/14/2018.
 */

public class SyncAllData extends AsyncTask<Void, Integer, String> {

    UploadListAdapter adapter;
    List<SyncModel> uploadlist;
    int position;
    private String TAG = "";
    private Context mContext;
    private ProgressDialog pd;
    private String syncClass, url, tableName, updateSyncClass;
    private Class contractClass;
    private Collection dbData;

    public SyncAllData(Context context, String syncClass, String updateSyncClass, Class contractClass, String url, String tableName, Collection dbData, int position, UploadListAdapter adapter, List<SyncModel> uploadlist) {
        mContext = context;
        this.syncClass = syncClass;
        this.updateSyncClass = updateSyncClass;
        this.contractClass = contractClass;
        this.url = url;
        this.tableName = tableName;
        this.dbData = dbData;
        this.position = position;
        this.adapter = adapter;
        this.uploadlist = uploadlist;
        TAG = "Get" + syncClass;
        uploadlist.get(position).settableName(syncClass);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setTitle("Syncing " + syncClass);
        pd.setMessage("Getting connected to server...");
//        pd.show();
        uploadlist.get(position).setstatus("Getting connected to server...");
        uploadlist.get(position).setstatusID(2);
        uploadlist.get(position).setmessage("");
        adapter.updatesyncList(uploadlist);
        //syncStatus.setText(syncStatus.getText() + "\r\nSyncing " + syncClass);
    }


    @Override
    protected String doInBackground(Void... params) {
        Log.d(TAG, "doInBackground: URL " + url);

        return downloadUrl(contractClass);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        uploadlist.get(values[0]).setstatus("Syncing");
        uploadlist.get(values[0]).setstatusID(2);
        uploadlist.get(values[0]).setmessage("");
        adapter.updatesyncList(uploadlist);
    }

    private String downloadUrl(Class<?> contractClass) {
        String line = "No Response";

        Collection<?> DBData = dbData; // pass data that's coming from db

        Log.d(TAG, String.valueOf(DBData.size()));

        if (DBData.size() > 0) {

            HttpURLConnection connection = null;
            try {
                String request = url;
                publishProgress(position);
                URL url = new URL(request);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                int HttpResult = connection.getResponseCode();
                if (HttpResult == HttpURLConnection.HTTP_OK) {
                    JSONArray jsonSync = new JSONArray();
                    connection = (HttpURLConnection) url.openConnection();

                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    connection.setReadTimeout(100000 /* milliseconds */);
                    connection.setConnectTimeout(150000 /* milliseconds */);
                    connection.setInstanceFollowRedirects(false);
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setRequestProperty("charset", "utf-8");
                    connection.setUseCaches(false);
                    connection.connect();

                    DataOutputStream wr = new DataOutputStream(connection.getOutputStream());

                    try {
                        while (contractClass != null) {
                            for (Method method : contractClass.getDeclaredMethods()) {
                                String methodName = method.getName();
                                if (methodName.equals("toJSONObject")) {
                                    for (Object fc : DBData) {
                                        jsonSync.put(fc.getClass().getMethod(methodName).invoke(fc));
                                    }
                                    break;
                                }
                            }
                            break;
                        }

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                    //TODO table server
                    JSONObject jsonTable = new JSONObject();
                    jsonTable.put("table", tableName);


                    JSONArray jsonParam = new JSONArray();
                    jsonParam
                            .put(jsonTable)
                            .put(jsonSync);
//                            .put(jsonSync.toString().replace("\uFEFF", "") + "\n");


                    wr.writeBytes(String.valueOf(jsonParam));
                    wr.flush();


                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            connection.getInputStream(), StandardCharsets.UTF_8));
                    StringBuffer sb = new StringBuffer();

                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();
                    System.out.println("" + sb.toString());
                    return sb.toString();
                } else {
                    System.out.println(connection.getResponseMessage());
                    return connection.getResponseMessage();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null)
                    connection.disconnect();
            }
        } else {
          /*  uploadlist.get(position).setstatus("Completed");
            uploadlist.get(position).setstatusID(3);
            adapter.updatesyncList(uploadlist);*/
            return "No new records to sync";
        }
        /*uploadlist.get(position).setstatus("Completed");
        uploadlist.get(position).setstatusID(3);
        adapter.updatesyncList(uploadlist);*/
        return line;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        int sSynced = 0;
        int sDuplicate = 0;
        String sSyncedError = "";
        JSONArray json = null;
        try {
            json = new JSONArray(result);

            DatabaseHelper db = new DatabaseHelper(mContext); // Database Helper

            Method method = null;
            for (Method method1 : db.getClass().getDeclaredMethods()) {
                if (method1.getName().equals(updateSyncClass)) {
                    method = method1;
                    break;
                }
            }

            for (int i = 0; i < json.length(); i++) {
                JSONObject jsonObject = new JSONObject(json.getString(i));

                if (jsonObject.getString("status").equals("1") && jsonObject.getString("error").equals("0")) {

                    //  db.updateSyncedChildForm(jsonObject.getString("id"));  // UPDATE SYNCED

                    method.invoke(db, jsonObject.getString("id"));

                    sSynced++;
                } else if (jsonObject.getString("status").equals("2") && jsonObject.getString("error").equals("0")) {
                    //db.updateSyncedChildForm(jsonObject.getString("id")); // UPDATE DUPLICATES

                    method.invoke(db, jsonObject.getString("id"));

                    sDuplicate++;
                } else {
                    sSyncedError += "\nError: " + jsonObject.getString("message");
                }
            }
            Toast.makeText(mContext, syncClass + " synced: " + sSynced + "\r\n\r\n Errors: " + sSyncedError, Toast.LENGTH_SHORT).show();


            pd.setMessage(syncClass + " synced: " + sSynced + "\r\n\r\n Duplicates: " + sDuplicate + "\r\n\r\n Errors: " + sSyncedError);
            pd.setTitle("Done uploading +" + syncClass + " data");
//            pd.show();
            if (sSyncedError.equals("")) {
                uploadlist.get(position).setmessage(syncClass + " synced: " + sSynced + "\r\n\r\n Duplicates: " + sDuplicate + "\r\n\r\n Errors: " + sSyncedError);
                uploadlist.get(position).setstatus("Completed");
                uploadlist.get(position).setstatusID(3);
                adapter.updatesyncList(uploadlist);
            } else {
                uploadlist.get(position).setmessage(syncClass + " synced: " + sSynced + "\r\n\r\n Duplicates: " + sDuplicate + "\r\n\r\n Errors: " + sSyncedError);
                uploadlist.get(position).setstatus("Failed");
                uploadlist.get(position).setstatusID(1);
                adapter.updatesyncList(uploadlist);
            }

            //syncStatus.setText(syncStatus.getText() + "\r\nDone uploading +" + syncClass + " data");

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(mContext, "Sync Result:  " + result, Toast.LENGTH_SHORT).show();

            pd.setMessage(result);
            pd.setTitle(syncClass + " Sync Failed");
//            pd.show();
            if (result.equals("No new records to sync")) {
                uploadlist.get(position).setmessage(result);
                uploadlist.get(position).setstatus("Not processed");
                uploadlist.get(position).setstatusID(4);
                adapter.updatesyncList(uploadlist);
            } else {
                uploadlist.get(position).setmessage(result);
                uploadlist.get(position).setstatus("Failed");
                uploadlist.get(position).setstatusID(1);
                adapter.updatesyncList(uploadlist);
            }
            //syncStatus.setText(syncStatus.getText() + "\r\n" + syncClass + " Sync Failed");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}