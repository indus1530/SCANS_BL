package edu.aku.hassannaqvi.uen_midline.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class FamilyMembersContract {
    private String uid;
    private String uuid;
    private String formdate;
    private String clusterno;
    private String hhno;

    private String serialno;
    private String name;
    private String relHH;
    private String age;
    private String motherName;
    private String gender;
    private String marital;
    private String sD;

    //Not required in db
    private String mName, fName;

    public FamilyMembersContract() {
    }

    public FamilyMembersContract Sync(JSONObject jsonObject) throws JSONException {
        this.uid = jsonObject.getString(singleMember.COLUMN_UID);
        this.uuid = jsonObject.getString(singleMember.COLUMN_UUID);
        this.formdate = jsonObject.getString(singleMember.COLUMN_FORMDATE);
        this.age = jsonObject.getString(singleMember.COLUMN_AGE);
        this.clusterno = jsonObject.getString(singleMember.COLUMN_CLUSTER_CODE);
        this.hhno = jsonObject.getString(singleMember.COLUMN_HHNO);
        this.relHH = jsonObject.getString(singleMember.COLUMN_RELATION_HH);
        this.name = jsonObject.getString(singleMember.COLUMN_NAME);
        this.serialno = jsonObject.getString(singleMember.COLUMN_SERIAL_NO);
        this.motherName = jsonObject.getString(singleMember.COLUMN_MOMTHER_NAME);
        this.sD = jsonObject.getString(singleMember.COLUMN_SD);

        return this;
    }

    public FamilyMembersContract hydrate(Cursor cursor) {
        this.uid = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_UUID));
        this.formdate = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_FORMDATE));
        this.age = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_AGE));
        this.clusterno = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_CLUSTER_CODE));
        this.hhno = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_HHNO));
        this.relHH = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_RELATION_HH));
        this.name = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_NAME));
        this.serialno = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_SERIAL_NO));
        this.motherName = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_MOMTHER_NAME));
        this.sD = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_SD));
        return this;
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

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getsD() {
        return sD;
    }

    public void setsD(String sD) {
        this.sD = sD;
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

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public static abstract class singleMember implements BaseColumns {

        public static final String TABLE_NAME = "familymembers";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_UUID = "_uuid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_AGE = "age";
        public static final String COLUMN_CLUSTER_CODE = "clusterno";
        public static final String COLUMN_HHNO = "hhno";
        public static final String COLUMN_RELATION_HH = "relHH";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SERIAL_NO = "serialno";
        public static final String COLUMN_MOMTHER_NAME = "mother_name";
        public static final String COLUMN_GENDER = "gender";
        public static final String COLUMN_MARITAL = "marital";
        public static final String COLUMN_SD = "sD";
        public static String _URL = "sosas.php";
    }
}
