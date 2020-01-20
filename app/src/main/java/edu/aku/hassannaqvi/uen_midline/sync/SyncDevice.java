package edu.aku.hassannaqvi.uen_midline.sync;

import android.content.Context;
import android.content.SharedPreferences;
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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.R;

import static android.content.Context.MODE_PRIVATE;

public class SyncDevice extends AsyncTask<Void, Integer, String> {
    Context context;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    private String TAG = "";

    public SyncDevice(Context context) {
        this.context = context;


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(Void... voids) {
        Log.d(TAG, "doInBackground: URL " + MainApp.DeviceURL);

        return downloadUrl();
    }

    private String downloadUrl() {
        String line = "No Response";
        HttpURLConnection connection = null;
        try {
            String request = MainApp._HOST_URL + MainApp.DeviceURL;
            URL url = new URL(request);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            int HttpResult = connection.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {

                connection = (HttpURLConnection) url.openConnection();
                JSONObject jsonObject = new JSONObject();
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setInstanceFollowRedirects(false);
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("charset", "utf-8");
                connection.setUseCaches(false);
                connection.connect();

                DataOutputStream wr = new DataOutputStream(connection.getOutputStream());

                try {
                    jsonObject.put("imei", MainApp.IMEI);
                    jsonObject.put("appversion", MainApp.versionName + "." + MainApp.versionCode);
                    jsonObject.put("appname", context.getString(R.string.app_name));

                } catch (Exception e) {
                    e.printStackTrace();
                }

                wr.writeBytes(jsonObject.toString().replace("\uFEFF", "") + "\n");
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
        } finally {
            if (connection != null)
                connection.disconnect();
        }
        return line;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        int sSynced = 0;
        String sSyncedError = "";
        JSONArray json = null;
        try {
            json = new JSONArray(result);
            for (int i = 0; i < json.length(); i++) {
                JSONObject jsonObject = new JSONObject(json.getString(i));
                if (!jsonObject.equals("")) {
                    //  db.updateSyncedChildForm(jsonObject.getString("id"));  // UPDATE SYNCED
                    String tag = jsonObject.getString("tag");
                    sharedPref = context.getSharedPreferences("tagName", MODE_PRIVATE);
                    editor = sharedPref.edit();
                    editor.putString("tagName", tag);
                    editor.commit();
                } else if (jsonObject.getString("status").equals("0") && jsonObject.getString("error").equals("1")) {
                } else {
                    sSyncedError += "\nError:This device is not found on server.";
                }
            }
//            Toast.makeText(context,  " synced: " + sSynced + "\r\n\r\n Errors: " + sSyncedError, Toast.LENGTH_SHORT).show();

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Failed to get TAG ID " + result, Toast.LENGTH_LONG).show();
        }
    }
}
