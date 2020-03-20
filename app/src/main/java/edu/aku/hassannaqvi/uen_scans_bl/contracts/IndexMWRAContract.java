package edu.aku.hassannaqvi.uen_scans_bl.contracts;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gul.sanober on 5/9/2017.
 */

public class IndexMWRAContract implements Parcelable {

    private String projectName = "uen_scans_bl_2020";

    private String _ID = "";
    private String UID = "";
    private String _UUID = "";
    private String deviceId = "";
    private String formDate = ""; // Date
    private String user = ""; // Interviewer
    private String sB1 = "";
    private String sB2 = "";


    private String sB3 = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";

    // Only for run time
    private String fmuid = "";
    private String fm_serial = "";


    /*
    saved in JSON
    =============
    fmuid
    fm_serial
    hhno
    cluster
    * */


    public IndexMWRAContract() {
    }

    protected IndexMWRAContract(Parcel in) {
        projectName = in.readString();
        _ID = in.readString();
        UID = in.readString();
        _UUID = in.readString();
        deviceId = in.readString();
        formDate = in.readString();
        user = in.readString();
        sB1 = in.readString();
        sB2 = in.readString();
        sB3 = in.readString();
        devicetagID = in.readString();
        synced = in.readString();
        synced_date = in.readString();
        fmuid = in.readString();
        fm_serial = in.readString();
    }

    public static final Creator<IndexMWRAContract> CREATOR = new Creator<IndexMWRAContract>() {
        @Override
        public IndexMWRAContract createFromParcel(Parcel in) {
            return new IndexMWRAContract(in);
        }

        @Override
        public IndexMWRAContract[] newArray(int size) {
            return new IndexMWRAContract[size];
        }
    };

    public String getsB2() {
        return sB2;
    }

    public void setsB2(String sB2) {
        this.sB2 = sB2;
    }

    public String getsB3() {
        return sB3;
    }

    public void setsB3(String sB3) {
        this.sB3 = sB3;
    }

    public String getProjectName() {
        return projectName;
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

    public String getsB1() {
        return sB1;
    }

    public void setsB1(String sB1) {
        this.sB1 = sB1;
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

    public String getFmuid() {
        return fmuid;
    }

    public void setFmuid(String fmuid) {
        this.fmuid = fmuid;
    }

    public String getFm_serial() {
        return fm_serial;
    }

    public void setFm_serial(String fm_serial) {
        this.fm_serial = fm_serial;
    }

    public IndexMWRAContract Sync(JSONObject jsonObject) throws JSONException {

        this._ID = jsonObject.getString(MWRATable.COLUMN_ID);
        this.UID = jsonObject.getString(MWRATable.COLUMN_UID);
        this._UUID = jsonObject.getString(MWRATable.COLUMN_UUID);
        this.formDate = jsonObject.getString(MWRATable.COLUMN_FORMDATE);
        this.deviceId = jsonObject.getString(MWRATable.COLUMN_DEVICEID);
        this.user = jsonObject.getString(MWRATable.COLUMN_USER);
        this.sB1 = jsonObject.getString(MWRATable.COLUMN_SB1);
        this.sB2 = jsonObject.getString(MWRATable.COLUMN_SB2);
        this.sB3 = jsonObject.getString(MWRATable.COLUMN_SB3);
        this.synced = jsonObject.getString(MWRATable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(MWRATable.COLUMN_SYNCED_DATE);
        this.devicetagID = jsonObject.getString(MWRATable.COLUMN_DEVICETAGID);

        return this;

    }

    public IndexMWRAContract Hydrate(Cursor cursor) {

        this._ID = cursor.getString(cursor.getColumnIndex(MWRATable.COLUMN_ID));
        this.UID = cursor.getString(cursor.getColumnIndex(MWRATable.COLUMN_UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(MWRATable.COLUMN_UUID));
        this.formDate = cursor.getString(cursor.getColumnIndex(MWRATable.COLUMN_FORMDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndex(MWRATable.COLUMN_DEVICEID));
        this.user = cursor.getString(cursor.getColumnIndex(MWRATable.COLUMN_USER));
        this.sB1 = cursor.getString(cursor.getColumnIndex(MWRATable.COLUMN_SB1));
        this.sB2 = cursor.getString(cursor.getColumnIndex(MWRATable.COLUMN_SB2));
        this.sB3 = cursor.getString(cursor.getColumnIndex(MWRATable.COLUMN_SB3));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(MWRATable.COLUMN_DEVICETAGID));

        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(MWRATable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(MWRATable.COLUMN_UID, this.UID == null ? JSONObject.NULL : this.UID);
        json.put(MWRATable.COLUMN_UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(MWRATable.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(MWRATable.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
        json.put(MWRATable.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        if (!this.sB1.equals("")) {

            json.put(MWRATable.COLUMN_SB1, this.sB1.equals("") ? JSONObject.NULL : new JSONObject(this.sB1));
        }
        if (!this.sB2.equals("")) {

            json.put(MWRATable.COLUMN_SB2, this.sB2.equals("") ? JSONObject.NULL : new JSONObject(this.sB2));
        }
        if (!this.sB3.equals("")) {

            json.put(MWRATable.COLUMN_SB3, this.sB3.equals("") ? JSONObject.NULL : new JSONObject(this.sB3));
        }
        json.put(MWRATable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);

        return json;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(projectName);
        dest.writeString(_ID);
        dest.writeString(UID);
        dest.writeString(_UUID);
        dest.writeString(deviceId);
        dest.writeString(formDate);
        dest.writeString(user);
        dest.writeString(sB1);
        dest.writeString(sB2);
        dest.writeString(sB3);
        dest.writeString(devicetagID);
        dest.writeString(synced);
        dest.writeString(synced_date);
        dest.writeString(fmuid);
        dest.writeString(fm_serial);
    }

    public static abstract class MWRATable implements BaseColumns {

        public static final String TABLE_NAME = "indexMwra";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "project_name";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_UUID = "_uuid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_USER = "username";
        public static final String COLUMN_SB1 = "sB1";
        public static final String COLUMN_SB2 = "sB2";
        public static final String COLUMN_SB3 = "sB3";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "sync_date";
        public static final String COLUMN_DEVICETAGID = "tagid";


        public static String _URL = "mother.php";
    }
}