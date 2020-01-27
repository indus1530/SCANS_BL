package edu.aku.hassannaqvi.uen_midline.sync;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;

import static android.content.Context.MODE_PRIVATE;

public class SyncDevice extends AsyncTask<Void, Integer, String> {
    private SyncDevicInterface delegate;
    private Context context;
    private boolean flag;
    private String TAG = SyncDevice.class.getName();

    public SyncDevice(Context context, boolean flag) {
        this.context = context;
        this.flag = flag;

        delegate = (SyncDevicInterface) context;
        delegate.processFinish(false);
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
                JsonObject jsonObject = new JsonObject();
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
                    jsonObject.addProperty("imei", MainApp.IMEI);
                    jsonObject.addProperty("appversion", MainApp.appInfo.getVersionName() + "." + MainApp.appInfo.getVersionCode());
                    jsonObject.addProperty("appname", context.getString(R.string.app_name));

                } catch (Exception e) {
                    e.printStackTrace();
                }

                wr.writeBytes(jsonObject.toString().replace("\uFEFF", "") + "\n");
                wr.flush();


                BufferedReader br = new BufferedReader(new InputStreamReader(
                        connection.getInputStream(), StandardCharsets.UTF_8));
                StringBuilder sb = new StringBuilder();

                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                br.close();
                System.out.println("" + sb.toString());
                return sb.toString();
            } else {
                System.out.println(connection.getResponseMessage());
                return connection.getResponseMessage();
            }
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
        StringBuilder sSyncedError = new StringBuilder();
        JSONArray json = null;
        try {
            json = new JSONArray(result);
            if (json.length() > 0) {
                for (int i = 0; i < json.length(); i++) {
                    JSONObject jsonObject = new JSONObject(json.getString(i));
                    if (!jsonObject.equals("")) {
                        //  db.updateSyncedChildForm(jsonObject.getString("id"));  // UPDATE SYNCED
                        String tag = jsonObject.getString("tag");
                        SharedPreferences sharedPref = context.getSharedPreferences("tagName", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("tagName", tag);
                        editor.putString("countryID", jsonObject.getString("country_id"));
                        editor.apply();

                        if (flag) {
                            delegate.processFinish(true);
                        }

                    } else if (jsonObject.getString("status").equals("0") && jsonObject.getString("error").equals("1")) {
                    } else {
                        sSyncedError.append("\nError:This device is not found on server.");
                    }
                }
            } else {
                if (flag) {
                    delegate.processFinish(true);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Failed to get TAG ID " + result, Toast.LENGTH_SHORT).show();
            if (flag) {
                delegate.processFinish(true);
            }
        }
    }

    public interface SyncDevicInterface {
        void processFinish(boolean flag);
    }

}
