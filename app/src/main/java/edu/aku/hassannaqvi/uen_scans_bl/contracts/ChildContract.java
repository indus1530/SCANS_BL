package edu.aku.hassannaqvi.uen_scans_bl.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class ChildContract {


    private String _ID = "";
    private String UID = "";
    private String _UUID = "";
    private String deviceId = "";
    private String formDate = ""; // Date
    private String user = ""; // Interviewer
    private String sI1 = "";
    private String sI2 = "";
    private String sJ = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";

     /*
    saved in JSON
    =============
    * hhno
    * cluster
    * i1_fm_uid
    * i1_fm_serial
    * i1_res_fm_uid
    * i1_res_fm_serial
    * i2_fm_uid
    * i2_fm_serial
    * i2_res_fm_uid
    * i2_res_fm_serial
    * j_fm_uid
    * j_fm_serial
    * j_res_fm_uid
    * j_res_fm_serial
    * */


    public ChildContract hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN__ID));
        this.UID = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN__UUID));
        this.deviceId = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_DEVICEID));
        this.formDate = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_FORMDATE));
        this.user = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_USER));
        this.sI1 = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_SI1));
        this.sI2 = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_SI2));
        this.sJ = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_SJ));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_DEVICETAGID));

        return this;

    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(SingleChild.COLUMN__ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(SingleChild.COLUMN_UID, this.UID == null ? JSONObject.NULL : this.UID);
        json.put(SingleChild.COLUMN__UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(SingleChild.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
        json.put(SingleChild.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(SingleChild.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);

        if (!this.sI1.equals("")) {
            json.put(SingleChild.COLUMN_SI1, this.sI1.equals("") ? JSONObject.NULL : new JSONObject(this.sI1));
        }
        if (!this.sI2.equals("")) {
            json.put(SingleChild.COLUMN_SI2, this.sI2.equals("") ? JSONObject.NULL : new JSONObject(this.sI2));
        }
        if (!this.sJ.equals("")) {
            json.put(SingleChild.COLUMN_SJ, this.sJ.equals("") ? JSONObject.NULL : new JSONObject(this.sJ));
        }
        json.put(SingleChild.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);

        return json;

    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String get_UUID() {
        return _UUID;
    }

    public void set_UUID(String _UUID) {
        this._UUID = _UUID;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getsI1() {
        return sI1;
    }

    public void setsI1(String sI1) {
        this.sI1 = sI1;
    }

    public String getsI2() {
        return sI2;
    }

    public void setsI2(String sI2) {
        this.sI2 = sI2;
    }

    public String getsJ() {
        return sJ;
    }

    public void setsJ(String sJ) {
        this.sJ = sJ;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    public static abstract class SingleChild implements BaseColumns {

        public static final String TABLE_NAME = "child_table";
        public static final String COLUMN__ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN__UUID = "_uuid";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_SI1 = "si1";
        public static final String COLUMN_SI2 = "si2";
        public static final String COLUMN_SJ = "sj";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";


    }


}
