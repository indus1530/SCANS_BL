package edu.aku.hassannaqvi.uen_scans_bl.sync;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;

import static edu.aku.hassannaqvi.uen_scans_bl.utils.CreateTable.PROJECT_NAME;

/**
 * Created by ali.azaz on 3/14/2018.
 */

public class SyncAllPhotos extends AsyncTask<Void, Integer, String> {


    private String TAG;
    private Context mContext;
    private String fileName;
    private File filePath;
    private File sdDir;
    private String appFolder;
    private ProgressDialog pd;

    public SyncAllPhotos(String fileName, Context c) {
        this.mContext = c;
        this.fileName = fileName;

        sdDir = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        appFolder = PROJECT_NAME;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setTitle("Syncing Photo: " + fileName);
        pd.setMessage("Getting connected to server...");
        pd.show();

    }


    @Override
    protected String doInBackground(Void... params) {


        filePath = new File(sdDir, appFolder);
        try {
            return uploadPhoto(String.valueOf(new File(filePath + File.separator + fileName)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        pd.setTitle("Syncing Photos");
        pd.setMessage("Uploading..." + values[0]);
        pd.show();
    }

    private String uploadPhoto(String filepath) throws Exception {
        HttpURLConnection connection = null;
        DataOutputStream outputStream = null;
        InputStream inputStream = null;

        String twoHyphens = "--";
        String boundary = "*****" + System.currentTimeMillis() + "*****";
        String lineEnd = "\r\n";

        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1 * 1024 * 1024;

        String filefield = "image";

        String[] q = filepath.split("/");
        int idx = q.length - 1;

        File file = new File(filepath);
        FileInputStream fileInputStream = null;
        Log.d(TAG, "uploadPhoto: " + file);
        fileInputStream = new FileInputStream(file);


        URL url = null;

        url = new URL(MainApp._PHOTO_UPLOAD_URL);

        connection = (HttpURLConnection) url.openConnection();

        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setRequestProperty("User-Agent", "Android Multipart HTTP Client 1.0");
        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

        outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.writeBytes(twoHyphens + boundary + lineEnd);
        outputStream.writeBytes("Content-Disposition: form-data; name=\"" + filefield + "\"; filename=\"" + q[idx] + "\"" + lineEnd);
        outputStream.writeBytes("Content-Type: image/jpeg" + lineEnd);
        outputStream.writeBytes("Content-Transfer-Encoding: binary" + lineEnd);
        outputStream.writeBytes(lineEnd);

        bytesAvailable = fileInputStream.available();
        bufferSize = Math.min(bytesAvailable, maxBufferSize);
        buffer = new byte[bufferSize];

        bytesRead = fileInputStream.read(buffer, 0, bufferSize);
        while (bytesRead > 0) {
            outputStream.write(buffer, 0, bufferSize);
            bytesAvailable = fileInputStream.available();
            bufferSize = Math.min(bytesAvailable, maxBufferSize);
            bytesRead = fileInputStream.read(buffer, 0, bufferSize);
        }

        outputStream.writeBytes(lineEnd);

        outputStream.writeBytes(twoHyphens + boundary + lineEnd);
        outputStream.writeBytes("Content-Disposition: form-data; name=\"tagname\"" + lineEnd);
        outputStream.writeBytes("Content-Type: text/plain" + lineEnd);
        outputStream.writeBytes(lineEnd);
        outputStream.writeBytes("0000");
        outputStream.writeBytes(lineEnd);
        outputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

        inputStream = connection.getInputStream();

        int status = connection.getResponseCode();
        if (status == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            inputStream.close();
            connection.disconnect();
            fileInputStream.close();
            outputStream.flush();
            outputStream.close();

            return response.toString();
        } else {
            throw new Exception("Non ok response returned");
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        StringBuilder sSyncedError = new StringBuilder();
        JSONArray json;
        try {
            Log.d(TAG, "onPostExecute: " + result);
            // json = new JSONArray(result);


            JSONObject jsonObject = new JSONObject(result);

            if (jsonObject.getString("status").equals("1") && jsonObject.getString("error").equals("0")) {

                //TODO:   db.updateUploadedPhoto(jsonObject.getString("id"));  // UPDATE SYNCED

                pd.setMessage("Photo synced:" + fileName);
                pd.setTitle("Done uploading Photos");
                pd.show();
                moveFile(fileName);

            } else if (jsonObject.getString("status").equals("2") && jsonObject.getString("error").equals("0")) {

                pd.setMessage("Duplicate Photo: " + fileName);
                pd.setTitle("Done uploading Photos");
                pd.show();
                moveFile(fileName);


            } else {
                sSyncedError.append("\nError: ").append(jsonObject.getString("message"));
            }


            //syncStatus.setText(syncStatus.getText() + "\r\nDone uploading +" + syncClass + " data");

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(mContext, "Sync Result:  " + result, Toast.LENGTH_SHORT).show();
            //syncStatus.setText(syncStatus.getText() + "\r\n" + syncClass + " Sync Failed");
        }
    }

    private void moveFile(String inputFile) {
        Toast.makeText(mContext, "Saving Photo...", Toast.LENGTH_LONG).show();
        sdDir = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        InputStream in = null;
        OutputStream out = null;
        File inputPath = filePath;
        File outputPath = new File(filePath + File.separator + "uploaded");
        try {

            //create output directory if it doesn't exist (not needed, just a precaution)
            //File dir = getDir(1);
            if (!outputPath.exists()) {
                outputPath.mkdirs();
            }

            in = new FileInputStream(inputPath + File.separator + inputFile);
            out = new FileOutputStream(outputPath + File.separator + inputFile);

            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            in.close();
            in = null;

            // write the output file
            out.flush();
            out.close();
            out = null;

            // delete the original file
            new File(inputPath + File.separator + inputFile).delete();
            Toast.makeText(mContext, "Photo Saved in " + outputPath + File.separator + inputFile, Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException fnfe1) {
            Log.e("tag", fnfe1.getMessage());
        } catch (Exception e) {
            Log.e("tag", e.getMessage());
        }

    }
}