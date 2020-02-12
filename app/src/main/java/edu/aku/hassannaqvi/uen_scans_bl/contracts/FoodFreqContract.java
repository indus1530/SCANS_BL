package edu.aku.hassannaqvi.uen_scans_bl.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class FoodFreqContract {


    private String _ID = "";
    private String UID = "";
    private String _UUID = "";
    private String deviceId = "";
    private String formDate = ""; // Date
    private String user = ""; // Interviewer
    private String sD1 = "";
    private String sD2 = "";
    private String sD3 = "";
    private String sD4 = "";
    private String sD5 = "";
    private String sD6 = "";
    private String sD7 = "";
    private String sD8 = "";
    private String sD9 = "";
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

    public String getsD1() {
        return sD1;
    }

    public void setsD1(String sD1) {
        this.sD1 = sD1;
    }

    public String getsD2() {
        return sD2;
    }

    public void setsD2(String sD2) {
        this.sD2 = sD2;
    }

    public String getsD3() {
        return sD3;
    }

    public void setsD3(String sD3) {
        this.sD3 = sD3;
    }

    public String getsD4() {
        return sD4;
    }

    public void setsD4(String sD4) {
        this.sD4 = sD4;
    }

    public String getsD5() {
        return sD5;
    }

    public void setsD5(String sD5) {
        this.sD5 = sD5;
    }

    public String getsD6() {
        return sD6;
    }

    public void setsD6(String sD6) {
        this.sD6 = sD6;
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

    public String getsD7() {
        return sD7;
    }

    public void setsD7(String sD7) {
        this.sD7 = sD7;
    }

    public String getsD8() {
        return sD8;
    }

    public void setsD8(String sD8) {
        this.sD8 = sD8;
    }

    public String getsD9() {
        return sD9;
    }

    public void setsD9(String sD9) {
        this.sD9 = sD9;
    }

    public FoodFreqContract hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(SingleFoodFreq.COLUMN__ID));
        this.UID = cursor.getString(cursor.getColumnIndex(SingleFoodFreq.COLUMN_UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(SingleFoodFreq.COLUMN__UUID));
        this.deviceId = cursor.getString(cursor.getColumnIndex(SingleFoodFreq.COLUMN_DEVICEID));
        this.formDate = cursor.getString(cursor.getColumnIndex(SingleFoodFreq.COLUMN_FORMDATE));
        this.user = cursor.getString(cursor.getColumnIndex(SingleFoodFreq.COLUMN_USER));
        this.sD1 = cursor.getString(cursor.getColumnIndex(SingleFoodFreq.COLUMN_SD1));
        this.sD2 = cursor.getString(cursor.getColumnIndex(SingleFoodFreq.COLUMN_SD2));
        this.sD3 = cursor.getString(cursor.getColumnIndex(SingleFoodFreq.COLUMN_SD3));
        this.sD4 = cursor.getString(cursor.getColumnIndex(SingleFoodFreq.COLUMN_SD4));
        this.sD5 = cursor.getString(cursor.getColumnIndex(SingleFoodFreq.COLUMN_SD5));
        this.sD6 = cursor.getString(cursor.getColumnIndex(SingleFoodFreq.COLUMN_SD6));
        this.sD7 = cursor.getString(cursor.getColumnIndex(SingleFoodFreq.COLUMN_SD7));
        this.sD8 = cursor.getString(cursor.getColumnIndex(SingleFoodFreq.COLUMN_SD8));
        this.sD9 = cursor.getString(cursor.getColumnIndex(SingleFoodFreq.COLUMN_SD9));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(SingleFoodFreq.COLUMN_DEVICETAGID));


        return this;

    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(SingleFoodFreq.COLUMN__ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(SingleFoodFreq.COLUMN_UID, this.UID == null ? JSONObject.NULL : this.UID);
        json.put(SingleFoodFreq.COLUMN__UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(SingleFoodFreq.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
        json.put(SingleFoodFreq.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(SingleFoodFreq.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);


        if (!this.sD1.equals("")) {
            json.put(SingleFoodFreq.COLUMN_SD1, new JSONObject(this.sD1));
        }
        if (!this.sD2.equals("")) {
            json.put(SingleFoodFreq.COLUMN_SD2, new JSONObject(this.sD2));
        }
        if (!this.sD3.equals("")) {
            json.put(SingleFoodFreq.COLUMN_SD3, new JSONObject(this.sD3));
        }
        if (!this.sD4.equals("")) {
            json.put(SingleFoodFreq.COLUMN_SD4, new JSONObject(this.sD4));
        }
        if (!this.sD5.equals("")) {
            json.put(SingleFoodFreq.COLUMN_SD5, new JSONObject(this.sD5));
        }
        if (!this.sD6.equals("")) {
            json.put(SingleFoodFreq.COLUMN_SD6, new JSONObject(this.sD6));
        }
        if (!this.sD7.equals("")) {
            json.put(SingleFoodFreq.COLUMN_SD7, new JSONObject(this.sD7));
        }
        if (!this.sD8.equals("")) {
            json.put(SingleFoodFreq.COLUMN_SD8, new JSONObject(this.sD8));
        }
        if (!this.sD9.equals("")) {
            json.put(SingleFoodFreq.COLUMN_SD9, new JSONObject(this.sD9));
        }

        json.put(SingleFoodFreq.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);


        return json;

    }

    public interface SingleFoodFreq extends BaseColumns {

        String TABLE_NAME = "food_freq";
        String COLUMN_NAME_NULLABLE = "NULLHACK";
        String COLUMN__ID = "_id";
        String COLUMN_UID = "uid";
        String COLUMN__UUID = "_uuid";
        String COLUMN_DEVICEID = "deviceid";
        String COLUMN_FORMDATE = "formdate";
        String COLUMN_USER = "user";
        String COLUMN_SD1 = "sd1";
        String COLUMN_SD2 = "sd2";
        String COLUMN_SD3 = "sd3";
        String COLUMN_SD4 = "sd4";
        String COLUMN_SD5 = "sd5";
        String COLUMN_SD6 = "sd6";
        String COLUMN_SD7 = "sd7";
        String COLUMN_SD8 = "sd8";
        String COLUMN_SD9 = "sd9";
        String COLUMN_DEVICETAGID = "devicetagid";
        String COLUMN_SYNCED = "synced";
        String COLUMN_SYNCED_DATE = "synced_date";


    }

}
