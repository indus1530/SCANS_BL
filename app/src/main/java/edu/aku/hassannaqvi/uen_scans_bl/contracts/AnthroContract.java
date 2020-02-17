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
    private String sK1;
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String istatus = "";
    private String formType = "";



    /**
     * Info,
     * K1,
     * K2
     */

    public AnthroContract hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(SingleAnthro.COLUMN__ID));
        this.UID = cursor.getString(cursor.getColumnIndex(SingleAnthro.COLUMN_UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(SingleAnthro.COLUMN__UUID));
        this.deviceId = cursor.getString(cursor.getColumnIndex(SingleAnthro.COLUMN_DEVICEID));
        this.formDate = cursor.getString(cursor.getColumnIndex(SingleAnthro.COLUMN_FORMDATE));
        this.user = cursor.getString(cursor.getColumnIndex(SingleAnthro.COLUMN_USER));
        this.sK1 = cursor.getString(cursor.getColumnIndex(SingleAnthro.COLUMN_SK1));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(SingleAnthro.COLUMN_DEVICETAGID));
        this.istatus = cursor.getString(cursor.getColumnIndex(SingleAnthro.COLUMN_ISTATUS));
        this.formType = cursor.getString(cursor.getColumnIndex(SingleAnthro.COLUMN_FORMTYPE));
        return this;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
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

    public String getsK1() {
        return sK1;
    }

    public void setsK1(String sK1) {
        this.sK1 = sK1;
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

        json.put(SingleAnthro.COLUMN__ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(SingleAnthro.COLUMN_UID, this.UID == null ? JSONObject.NULL : this.UID);
        json.put(SingleAnthro.COLUMN__UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(SingleAnthro.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
        json.put(SingleAnthro.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(SingleAnthro.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);

        if (!this.sK1.equals("")) {
            json.put(SingleAnthro.COLUMN_SK1, this.sK1.equals("") ? JSONObject.NULL : new JSONObject(this.sK1));
        }

        json.put(SingleAnthro.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(SingleAnthro.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(SingleAnthro.COLUMN_FORMTYPE, this.formType == null ? JSONObject.NULL : this.formType);

        return json;

    }

    public interface SingleAnthro extends BaseColumns {

        String TABLE_NAME = "anthro";
        String COLUMN_NAME_NULLABLE = "NULLHACK";
        String COLUMN__ID = "_id";
        String COLUMN_UID = "_uid";
        String COLUMN__UUID = "_uuid";
        String COLUMN_DEVICEID = "deviceid";
        String COLUMN_FORMDATE = "formdate";
        String COLUMN_USER = "username";
        String COLUMN_SK1 = "sk1";
        String COLUMN_FORMTYPE = "f_type";
        String COLUMN_DEVICETAGID = "tagid";
        String COLUMN_ISTATUS = "istatus";
        String COLUMN_SYNCED = "synced";
        String COLUMN_SYNCED_DATE = "synced_date";


    }


}
