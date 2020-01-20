package edu.aku.hassannaqvi.uen_midline.contracts;


import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class TalukasContract {

    private static final String TAG = "Talukas_CONTRACT";
    String talukacode;
    String taluka;

    public TalukasContract() {
        // Default Constructor
    }

    public TalukasContract Sync(JSONObject jsonObject) throws JSONException {
        this.talukacode = jsonObject.getString(singleTalukas.COLUMN_TALUKA_CODE);
        this.taluka = jsonObject.getString(singleTalukas.COLUMN_TALUKA);
        return this;
    }

    public TalukasContract HydrateTalukas(Cursor cursor) {
        this.talukacode = cursor.getString(cursor.getColumnIndex(singleTalukas.COLUMN_TALUKA_CODE));
        this.taluka = cursor.getString(cursor.getColumnIndex(singleTalukas.COLUMN_TALUKA));
        return this;
    }

    public String getTalukacode() {
        return talukacode;
    }

    public void setTalukacode(String talukacode) {
        this.talukacode = talukacode;
    }

    public String getTaluka() {
        return taluka;
    }

    public void setTaluka(String taluka) {
        this.taluka = taluka;
    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(singleTalukas.COLUMN_TALUKA_CODE, this.talukacode == null ? JSONObject.NULL : this.talukacode);
        json.put(singleTalukas.COLUMN_TALUKA, this.taluka == null ? JSONObject.NULL : this.taluka);
        return json;
    }


    public static abstract class singleTalukas implements BaseColumns {

        public static final String TABLE_NAME = "talukas";
        public static final String COLUMN_TALUKA_CODE = "taluka_code";
        public static final String COLUMN_TALUKA = "taluka_name";

        public static final String _URI = "talukas.php";
    }
}