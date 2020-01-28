package edu.aku.hassannaqvi.uen_midline.contracts;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gul.sanober on 5/9/2017.
 */

public class MWRAContract implements Parcelable {

    private String projectName = "uen_mdLine20";

    private String _ID = "";
    private String UID = "";
    private String _UUID = "";
    private String deviceId = "";
    private String formDate = ""; // Date
    private String user = ""; // Interviewer
    private String sE1 = "";
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


    public MWRAContract() {
    }

    protected MWRAContract(Parcel in) {
        projectName = in.readString();
        _ID = in.readString();
        UID = in.readString();
        _UUID = in.readString();
        deviceId = in.readString();
        formDate = in.readString();
        user = in.readString();
        sE1 = in.readString();
        devicetagID = in.readString();
        synced = in.readString();
        synced_date = in.readString();
        fmuid = in.readString();
        fm_serial = in.readString();
    }

    public static final Creator<MWRAContract> CREATOR = new Creator<MWRAContract>() {
        @Override
        public MWRAContract createFromParcel(Parcel in) {
            return new MWRAContract(in);
        }

        @Override
        public MWRAContract[] newArray(int size) {
            return new MWRAContract[size];
        }
    };

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

    public String getsE1() {
        return sE1;
    }

    public void setsE1(String sE1) {
        this.sE1 = sE1;
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

    public MWRAContract Sync(JSONObject jsonObject) throws JSONException {

        this._ID = jsonObject.getString(MWRATable.COLUMN_ID);
        this.UID = jsonObject.getString(MWRATable.COLUMN_UID);
        this._UUID = jsonObject.getString(MWRATable.COLUMN_UUID);
        this.formDate = jsonObject.getString(MWRATable.COLUMN_FORMDATE);
        this.deviceId = jsonObject.getString(MWRATable.COLUMN_DEVICEID);
        this.user = jsonObject.getString(MWRATable.COLUMN_USER);
        this.sE1 = jsonObject.getString(MWRATable.COLUMN_SE1);
        this.synced = jsonObject.getString(MWRATable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(MWRATable.COLUMN_SYNCED_DATE);
        this.devicetagID = jsonObject.getString(MWRATable.COLUMN_DEVICETAGID);

        return this;

    }

    public MWRAContract Hydrate(Cursor cursor) {

        this._ID = cursor.getString(cursor.getColumnIndex(MWRATable.COLUMN_ID));
        this.UID = cursor.getString(cursor.getColumnIndex(MWRATable.COLUMN_UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(MWRATable.COLUMN_UUID));
        this.formDate = cursor.getString(cursor.getColumnIndex(MWRATable.COLUMN_FORMDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndex(MWRATable.COLUMN_DEVICEID));
        this.user = cursor.getString(cursor.getColumnIndex(MWRATable.COLUMN_USER));
        this.sE1 = cursor.getString(cursor.getColumnIndex(MWRATable.COLUMN_SE1));
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
        if (!this.sE1.equals("")) {

            json.put(MWRATable.COLUMN_SE1, this.sE1.equals("") ? JSONObject.NULL : new JSONObject(this.sE1));
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
        dest.writeString(sE1);
        dest.writeString(devicetagID);
        dest.writeString(synced);
        dest.writeString(synced_date);
        dest.writeString(fmuid);
        dest.writeString(fm_serial);
    }

    public static abstract class MWRATable implements BaseColumns {

        public static final String TABLE_NAME = "mwra";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "project_name";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_UUID = "uuid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_SE1 = "sE1";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "sync_date";
        public static final String COLUMN_DEVICETAGID = "tagid";


        public static String _URL = "mother.php";
    }
}