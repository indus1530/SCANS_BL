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
    private String sC1 = "";
    private String sC2 = "";
    private String sC3 = "";
    private String sC4 = "";
    private String sC5 = "";
    private String sC6 = "";
    private String sL = "";
    private String sK1 = "";


    private String sM = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";

    /**
     * C1,
     * C2,
     * C3,
     * C4,
     * C5,
     * C6
     */


    public ChildContract hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN__ID));
        this.UID = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN__UUID));
        this.deviceId = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_DEVICEID));
        this.formDate = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_FORMDATE));
        this.user = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_USER));
        this.sC1 = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_SC1));
        this.sC2 = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_SC2));
        this.sC3 = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_SC3));
        this.sC4 = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_SC4));
        this.sC5 = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_SC5));
        this.sC6 = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_SC6));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_DEVICETAGID));
        this.sL = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_SL));
        this.sM = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_SM));
        this.sK1 = cursor.getString(cursor.getColumnIndex(SingleChild.COLUMN_SK1));

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

        if (!this.sC1.equals("")) {
            json.put(SingleChild.COLUMN_SC1, new JSONObject(this.sC1));
        }
        if (!this.sC2.equals("")) {
            json.put(SingleChild.COLUMN_SC2, new JSONObject(this.sC2));
        }
        if (!this.sC3.equals("")) {
            json.put(SingleChild.COLUMN_SC3, new JSONObject(this.sC3));
        }
        if (!this.sC4.equals("")) {
            json.put(SingleChild.COLUMN_SC4, new JSONObject(this.sC4));
        }
        if (!this.sC5.equals("")) {
            json.put(SingleChild.COLUMN_SC5, new JSONObject(this.sC5));
        }
        if (!this.sC6.equals("")) {
            json.put(SingleChild.COLUMN_SC6, new JSONObject(this.sC6));
        }/*
        if (!this.sL.equals("")) {
            json.put(SingleChild.COLUMN_SL, new JSONObject(this.sL));
        }
        if (!this.sM.equals("")) {
            json.put(SingleChild.COLUMN_SM, new JSONObject(this.sM));
        }
        if (!this.sK1.equals("")) {
            json.put(SingleChild.COLUMN_SK1, new JSONObject(this.sK1));
        }*/
        json.put(SingleChild.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);

        return json;

    }

    public String getsK1() {
        return sK1;
    }

    public void setsK1(String sK1) {
        this.sK1 = sK1;
    }

    public String getsL() {
        return sL;
    }

    public void setsL(String sL) {
        this.sL = sL;
    }

    public String getsM() {
        return sM;
    }

    public void setsM(String sM) {
        this.sM = sM;
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

    public String getsC1() {
        return sC1;
    }

    public void setsC1(String sC1) {
        this.sC1 = sC1;
    }

    public String getsC2() {
        return sC2;
    }

    public void setsC2(String sC2) {
        this.sC2 = sC2;
    }

    public String getsC3() {
        return sC3;
    }

    public void setsC3(String sC3) {
        this.sC3 = sC3;
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

    public String getsC4() {
        return sC4;
    }

    public void setsC4(String sC4) {
        this.sC4 = sC4;
    }

    public String getsC5() {
        return sC5;
    }

    public void setsC5(String sC5) {
        this.sC5 = sC5;
    }

    public String getsC6() {
        return sC6;
    }

    public void setsC6(String sC6) {
        this.sC6 = sC6;
    }

    public interface SingleChild extends BaseColumns {

        String TABLE_NAME = "child_table";
        String COLUMN__ID = "_id";
        String COLUMN_UID = "uid";
        String COLUMN__UUID = "_uuid";
        String COLUMN_DEVICEID = "deviceid";
        String COLUMN_FORMDATE = "formdate";
        String COLUMN_USER = "username";
        String COLUMN_SC1 = "sc1";
        String COLUMN_SC2 = "sc2";
        String COLUMN_SC3 = "sc3";
        String COLUMN_SC4 = "sc4";
        String COLUMN_SC5 = "sc5";
        String COLUMN_SC6 = "sc6";
        String COLUMN_SL = "sL";
        String COLUMN_SM = "sM";
        String COLUMN_SK1 = "sK1";
        String COLUMN_DEVICETAGID = "devicetagid";
        String COLUMN_SYNCED = "synced";
        String COLUMN_SYNCED_DATE = "synced_date";


    }


}
