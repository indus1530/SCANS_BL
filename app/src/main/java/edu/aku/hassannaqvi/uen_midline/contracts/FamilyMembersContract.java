package edu.aku.hassannaqvi.uen_midline.contracts;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class FamilyMembersContract implements Parcelable {
    private String uid;
    private String uuid;
    private String formdate;
    private String age;
    private String clusterno;
    private String hhno;
    private String motherid;
    private String name;
    private String serialno;
    private String motherName;
    private String type;

    public static final Creator<FamilyMembersContract> CREATOR = new Creator<FamilyMembersContract>() {
        @Override
        public FamilyMembersContract createFromParcel(Parcel in) {
            return new FamilyMembersContract(in);
        }

        @Override
        public FamilyMembersContract[] newArray(int size) {
            return new FamilyMembersContract[size];
        }
    };

    public FamilyMembersContract(Parcel in) {
        uid = in.readString();
        uuid = in.readString();
        formdate = in.readString();
        age = in.readString();
        clusterno = in.readString();
        hhno = in.readString();
        motherid = in.readString();
        name = in.readString();
        serialno = in.readString();
        motherName = in.readString();
        type = in.readString();
    }

    public FamilyMembersContract() {
    }

    public FamilyMembersContract Sync(JSONObject jsonObject) throws JSONException {
        this.uid = jsonObject.getString(singleMember.COLUMN_UID);
        this.uuid = jsonObject.getString(singleMember.COLUMN_UUID);
        this.formdate = jsonObject.getString(singleMember.COLUMN_FORMDATE);
        this.age = jsonObject.getString(singleMember.COLUMN_AGE);
        this.clusterno = jsonObject.getString(singleMember.COLUMN_CLUSTER_CODE);
        this.hhno = jsonObject.getString(singleMember.COLUMN_HHNO);
        this.motherid = jsonObject.getString(singleMember.COLUMN_MOTHER_ID);
        this.name = jsonObject.getString(singleMember.COLUMN_NAME);
        this.serialno = jsonObject.getString(singleMember.COLUMN_SERIAL_NO);
        this.motherName = jsonObject.getString(singleMember.COLUMN_MOMTHER_NAME);
        this.type = jsonObject.getString(singleMember.COLUMN_TYPE);

        return this;
    }

    public FamilyMembersContract hydrate(Cursor cursor) {
        this.uid = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_UUID));
        this.formdate = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_FORMDATE));
        this.age = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_AGE));
        this.clusterno = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_CLUSTER_CODE));
        this.hhno = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_HHNO));
        this.motherid = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_MOTHER_ID));
        this.name = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_NAME));
        this.serialno = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_SERIAL_NO));
        this.motherName = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_MOMTHER_NAME));
        this.type = cursor.getString(cursor.getColumnIndex(singleMember.COLUMN_TYPE));


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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public String getMotherid() {
        return motherid;
    }

    public void setMotherid(String motherid) {
        this.motherid = motherid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(uid);
        dest.writeString(uuid);
        dest.writeString(formdate);
        dest.writeString(age);
        dest.writeString(clusterno);
        dest.writeString(hhno);
        dest.writeString(motherid);
        dest.writeString(name);
        dest.writeString(serialno);
        dest.writeString(motherName);
        dest.writeString(type);
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
        public static final String COLUMN_MOTHER_ID = "motherid";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SERIAL_NO = "serialno";
        public static final String COLUMN_MOMTHER_NAME = "mother_name";
        public static final String COLUMN_TYPE = "type";
        public static String _URL = "sosas.php";
    }
}
