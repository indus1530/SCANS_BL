package edu.aku.hassannaqvi.uen_scans_bl.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class AnthroContract {


    private String _ID = "";
    private String UID = "";
    private String _UUID = "";
    private String deviceId = "";
    private String formDate = ""; // Date
    private String user = ""; // Interviewer
    private String sE3;
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";

    /**
     * Info,
     * K1,
     * K2,
     * L,
     * M,
     */

    public AnthroContract hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(SingleMortality.COLUMN__ID));
        this.UID = cursor.getString(cursor.getColumnIndex(SingleMortality.COLUMN_UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(SingleMortality.COLUMN__UUID));
        this.deviceId = cursor.getString(cursor.getColumnIndex(SingleMortality.COLUMN_DEVICEID));
        this.formDate = cursor.getString(cursor.getColumnIndex(SingleMortality.COLUMN_FORMDATE));
        this.user = cursor.getString(cursor.getColumnIndex(SingleMortality.COLUMN_USER));
        this.sE3 = cursor.getString(cursor.getColumnIndex(SingleMortality.COLUMN_SE3));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(SingleMortality.COLUMN_DEVICETAGID));
        return this;
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

    public String getsE3() {
        return sE3;
    }

    public void setsE3(String sE3) {
        this.sE3 = sE3;
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

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(SingleMortality.COLUMN__ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(SingleMortality.COLUMN_UID, this.UID == null ? JSONObject.NULL : this.UID);
        json.put(SingleMortality.COLUMN__UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(SingleMortality.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
        json.put(SingleMortality.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(SingleMortality.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);

        if (!this.sE3.equals("")) {
            json.put(SingleMortality.COLUMN_SE3, this.sE3.equals("") ? JSONObject.NULL : new JSONObject(this.sE3));
        }

        json.put(SingleMortality.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);

        return json;

    }

    public static abstract class SingleMortality implements BaseColumns {

        public static final String TABLE_NAME = "mortality";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN__ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN__UUID = "_uuid";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_SE3 = "se3";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";


    }


}
