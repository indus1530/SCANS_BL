package edu.aku.hassannaqvi.uen_midline.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class KishMWRAContract {


    private String _ID = "";
    private String UID = "";
    private String _UUID = "";
    private String deviceId = "";
    private String formDate = ""; // Date
    private String user = ""; // Interviewer
    private String sF = "";
    private String sG = "";
    private String sH1 = "";
    private String sH2 = "";
    private String sK = "";
    private String sL = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";

    /*
    saved in JSON
    =============
    * hhno
    * cluster
    * fm_uid
    * fm_serial
    * */

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

    public String getsF() {
        return sF;
    }

    public void setsF(String sF) {
        this.sF = sF;
    }

    public String getsG() {
        return sG;
    }

    public void setsG(String sG) {
        this.sG = sG;
    }

    public String getsH1() {
        return sH1;
    }

    public void setsH1(String sH1) {
        this.sH1 = sH1;
    }

    public String getsH2() {
        return sH2;
    }

    public void setsH2(String sH2) {
        this.sH2 = sH2;
    }

    public String getsK() {
        return sK;
    }

    public void setsK(String sK) {
        this.sK = sK;
    }

    public String getsL() {
        return sL;
    }

    public void setsL(String sL) {
        this.sL = sL;
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


    public KishMWRAContract hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(SingleKishMWRA.COLUMN__ID));
        this.UID = cursor.getString(cursor.getColumnIndex(SingleKishMWRA.COLUMN_UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(SingleKishMWRA.COLUMN__UUID));
        this.deviceId = cursor.getString(cursor.getColumnIndex(SingleKishMWRA.COLUMN_DEVICEID));
        this.formDate = cursor.getString(cursor.getColumnIndex(SingleKishMWRA.COLUMN_FORMDATE));
        this.user = cursor.getString(cursor.getColumnIndex(SingleKishMWRA.COLUMN_USER));
        this.sF = cursor.getString(cursor.getColumnIndex(SingleKishMWRA.COLUMN_SF));
        this.sG = cursor.getString(cursor.getColumnIndex(SingleKishMWRA.COLUMN_SG));
        this.sH1 = cursor.getString(cursor.getColumnIndex(SingleKishMWRA.COLUMN_SH1));
        this.sH2 = cursor.getString(cursor.getColumnIndex(SingleKishMWRA.COLUMN_SH2));
        this.sK = cursor.getString(cursor.getColumnIndex(SingleKishMWRA.COLUMN_SK));
        this.sL = cursor.getString(cursor.getColumnIndex(SingleKishMWRA.COLUMN_SL));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(SingleKishMWRA.COLUMN_DEVICETAGID));
        this.synced = cursor.getString(cursor.getColumnIndex(SingleKishMWRA.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(SingleKishMWRA.COLUMN_SYNCED_DATE));


        return this;

    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(SingleKishMWRA.COLUMN__ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(SingleKishMWRA.COLUMN_UID, this.UID == null ? JSONObject.NULL : this.UID);
        json.put(SingleKishMWRA.COLUMN__UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(SingleKishMWRA.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
        json.put(SingleKishMWRA.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(SingleKishMWRA.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);


        if (!this.sF.equals("")) {
            json.put(SingleKishMWRA.COLUMN_SF, this.sF.equals("") ? JSONObject.NULL : new JSONObject(this.sF));
        }
        if (!this.sG.equals("")) {
            json.put(SingleKishMWRA.COLUMN_SG, this.sG.equals("") ? JSONObject.NULL : new JSONObject(this.sG));
        }
        if (!this.sH1.equals("")) {
            json.put(SingleKishMWRA.COLUMN_SH1, this.sH1.equals("") ? JSONObject.NULL : new JSONObject(this.sH1));
        }
        if (!this.sH2.equals("")) {
            json.put(SingleKishMWRA.COLUMN_SH2, this.sH2.equals("") ? JSONObject.NULL : new JSONObject(this.sH2));
        }
        if (!this.sK.equals("")) {
            json.put(SingleKishMWRA.COLUMN_SK, this.sK.equals("") ? JSONObject.NULL : new JSONObject(this.sK));
        }
        if (!this.sL.equals("")) {
            json.put(SingleKishMWRA.COLUMN_SL, this.sF.equals("") ? JSONObject.NULL : new JSONObject(this.sL));
        }

        json.put(SingleKishMWRA.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(SingleKishMWRA.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(SingleKishMWRA.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);


        return json;

    }

    public static abstract class SingleKishMWRA implements BaseColumns {

        public static final String TABLE_NAME = "kish_mwra";
        public static final String COLUMN__ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN__UUID = "_uuid";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_SF = "sf";
        public static final String COLUMN_SG = "sg";
        public static final String COLUMN_SH1 = "sh1";
        public static final String COLUMN_SH2 = "sh2";
        public static final String COLUMN_SK = "sk";
        public static final String COLUMN_SL = "sl";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";


    }

}
