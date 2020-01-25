package edu.aku.hassannaqvi.uen_midline.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class MWRA_PREContract {


    private String _ID = "";
    private String UID = "";
    private String _UUID = "";
    private String deviceId = "";
    private String formDate = ""; // Date
    private String user = ""; // Interviewer
    private String sE2 = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";

    /*
    saved in JSON
    =============
    * hhno
    * cluster
    * mw_uid
    * fm_serial
    * counter
    * */

    public MWRA_PREContract hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(SingleMWRAPRE.COLUMN__ID));
        this.UID = cursor.getString(cursor.getColumnIndex(SingleMWRAPRE.COLUMN_UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(SingleMWRAPRE.COLUMN__UUID));
        this.deviceId = cursor.getString(cursor.getColumnIndex(SingleMWRAPRE.COLUMN_DEVICEID));
        this.formDate = cursor.getString(cursor.getColumnIndex(SingleMWRAPRE.COLUMN_FORMDATE));
        this.user = cursor.getString(cursor.getColumnIndex(SingleMWRAPRE.COLUMN_USER));
        this.sE2 = cursor.getString(cursor.getColumnIndex(SingleMWRAPRE.COLUMN_SE2));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(SingleMWRAPRE.COLUMN_DEVICETAGID));
        this.synced = cursor.getString(cursor.getColumnIndex(SingleMWRAPRE.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(SingleMWRAPRE.COLUMN_SYNCED_DATE));

        return this;

    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(SingleMWRAPRE.COLUMN__ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(SingleMWRAPRE.COLUMN_UID, this.UID == null ? JSONObject.NULL : this.UID);
        json.put(SingleMWRAPRE.COLUMN__UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(SingleMWRAPRE.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
        json.put(SingleMWRAPRE.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(SingleMWRAPRE.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);

        if (!this.sE2.equals("")) {
            json.put(SingleMWRAPRE.COLUMN_SE2, this.sE2.equals("") ? JSONObject.NULL : new JSONObject(this.sE2));
        }

        json.put(SingleMWRAPRE.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(SingleMWRAPRE.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(SingleMWRAPRE.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);

        return json;

    }


    public static abstract class SingleMWRAPRE implements BaseColumns {

        public static final String COLUMN__ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN__UUID = "_uuid";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_SE2 = "se2";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";


    }

}
