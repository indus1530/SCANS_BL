package edu.aku.hassannaqvi.uen_midline.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class FamilyMembersContract {
    private String _id;
    private String uid;
    private String uuid;
    private String formdate;
    private String clusterno;
    private String hhno;

    private String serialno;
    private String name;
    private String relHH;
    private String age;
    private String mother_name;
    private String mother_serial;
    private String gender;
    private String marital;
    private String sD;

    //Not required in db
    private String fName;
    private String available;

    public FamilyMembersContract() {
    }

    public FamilyMembersContract hydrate(Cursor cursor) {
        this._id = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_UUID));
        this.formdate = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_FORMDATE));
        this.clusterno = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_CLUSTERNO));
        this.hhno = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_HHNO));
        this.serialno = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_SERIAL_NO));
        this.name = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_NAME));
        this.relHH = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_RELATION_HH));
        this.age = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_AGE));
        this.mother_name = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_MOTHER_NAME));
        this.mother_serial = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_MOTHER_SERIAL));
        this.gender = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_GENDER));
        this.marital = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_MARITAL));
        this.sD = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_SD));

        return this;
    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(singleMember.COLUMN_ID, this._id == null ? JSONObject.NULL : this._id);
        json.put(singleMember.COLUMN_UID, this.uid == null ? JSONObject.NULL : this.uid);
        json.put(singleMember.COLUMN_UUID, this.uuid == null ? JSONObject.NULL : this.uuid);
        json.put(singleMember.COLUMN_FORMDATE, this.formdate == null ? JSONObject.NULL : this.formdate);
        json.put(singleMember.COLUMN_CLUSTERNO, this.clusterno == null ? JSONObject.NULL : this.clusterno);
        json.put(singleMember.COLUMN_HHNO, this.hhno == null ? JSONObject.NULL : this.hhno);
        json.put(singleMember.COLUMN_SERIAL_NO, this.serialno == null ? JSONObject.NULL : this.serialno);
        json.put(singleMember.COLUMN_NAME, this.name == null ? JSONObject.NULL : this.name);
        json.put(singleMember.COLUMN_RELATION_HH, this.relHH == null ? JSONObject.NULL : this.relHH);
        json.put(singleMember.COLUMN_AGE, this.age == null ? JSONObject.NULL : this.age);
        json.put(singleMember.COLUMN_MOTHER_NAME, this.mother_name == null ? JSONObject.NULL : this.mother_name);
        json.put(singleMember.COLUMN_MOTHER_SERIAL, this.mother_serial == null ? JSONObject.NULL : this.mother_serial);
        json.put(singleMember.COLUMN_GENDER, this.gender == null ? JSONObject.NULL : this.gender);
        json.put(singleMember.COLUMN_MARITAL, this.marital == null ? JSONObject.NULL : this.marital);

        if (!this.sD.equals("")) {
            json.put(singleMember.COLUMN_SD, this.sD.equals("") ? JSONObject.NULL : new JSONObject(this.sD));
        }

        return json;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFormdate() {
        return formdate;
    }

    public void setFormdate(String formdate) {
        this.formdate = formdate;
    }

    public String getClusterno() {
        return clusterno;
    }

    public void setClusterno(String clusterno) {
        this.clusterno = clusterno;
    }

    public String getHhno() {
        return hhno;
    }

    public void setHhno(String hhno) {
        this.hhno = hhno;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelHH() {
        return relHH;
    }

    public void setRelHH(String relHH) {
        this.relHH = relHH;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getMother_serial() {
        return mother_serial;
    }

    public void setMother_serial(String mother_serial) {
        this.mother_serial = mother_serial;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getsD() {
        return sD;
    }

    public void setsD(String sD) {
        this.sD = sD;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public static abstract class singleMember implements BaseColumns {

        public static final String TABLE_NAME = "familymembers";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_UUID = "_uuid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_AGE = "age";
        public static final String COLUMN_CLUSTERNO = "clusterno";
        public static final String COLUMN_HHNO = "hhno";
        public static final String COLUMN_RELATION_HH = "relHH";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SERIAL_NO = "serial_no";
        public static final String COLUMN_MOTHER_NAME = "mother_name";
        public static final String COLUMN_MOTHER_SERIAL = "mother_serial";
        public static final String COLUMN_GENDER = "gender";
        public static final String COLUMN_MARITAL = "marital";
        public static final String COLUMN_SD = "sD";

        public static String _URL = "sosas.php";
    }
}
