package edu.aku.hassannaqvi.uen_midline.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class UsersContract {

    private static final String TAG = "Users_CONTRACT";
    Long _ID;
    String ROW_USERNAME;
    String ROW_PASSWORD;
    String DIST_ID;
//    String REGION_DSS;

    public UsersContract() {
        // Default Constructor
    }

    public UsersContract(String username, String password) {
        this.ROW_PASSWORD = password;
        this.ROW_USERNAME = username;
    }

    public Long getUserID() {
        return this._ID;
    }

    public void setId(int id) {
        this._ID = Long.valueOf(id);
    }

    public String getUserName() {
        return this.ROW_USERNAME;
    }

    public void setUserName(String username) {
        this.ROW_USERNAME = username;
    }

    public String getPassword() {
        return this.ROW_PASSWORD;
    }

    public void setPassword(String password) {
        this.ROW_PASSWORD = password;
    }

    public String getDIST_ID() {
        return DIST_ID;
    }

    public void setDIST_ID(String DIST_ID) {
        this.DIST_ID = DIST_ID;
    }

/*    public String getREGION_DSS() {
        return REGION_DSS;
    }

    public void setREGION_DSS(String REGION_DSS) {
        this.REGION_DSS = REGION_DSS;
    }*/

    public UsersContract Sync(JSONObject jsonObject) throws JSONException {
        this.ROW_USERNAME = jsonObject.getString(singleUser.ROW_USERNAME);
        this.ROW_PASSWORD = jsonObject.getString(singleUser.ROW_PASSWORD);
        this.DIST_ID = jsonObject.getString(singleUser.DIST_ID);
//        this.REGION_DSS = jsonObject.getString(singleUser.REGION_DSS);
        return this;

    }

    public UsersContract Hydrate(Cursor cursor) {
        this._ID = cursor.getLong(cursor.getColumnIndex(singleUser._ID));
        this.ROW_USERNAME = cursor.getString(cursor.getColumnIndex(singleUser.ROW_USERNAME));
        this.ROW_PASSWORD = cursor.getString(cursor.getColumnIndex(singleUser.ROW_PASSWORD));
        this.DIST_ID = cursor.getString(cursor.getColumnIndex(singleUser.DIST_ID));
//        this.REGION_DSS = cursor.getString(cursor.getColumnIndex(singleUser.REGION_DSS));
        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(singleUser._ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(singleUser.ROW_USERNAME, this.ROW_USERNAME == null ? JSONObject.NULL : this.ROW_USERNAME);
        json.put(singleUser.ROW_PASSWORD, this.ROW_PASSWORD == null ? JSONObject.NULL : this.ROW_PASSWORD);
        json.put(singleUser.DIST_ID, this.DIST_ID == null ? JSONObject.NULL : this.DIST_ID);
//        json.put(singleUser.REGION_DSS, this.REGION_DSS == null ? JSONObject.NULL : this.REGION_DSS);
        return json;
    }

    public static abstract class singleUser implements BaseColumns {

        public static final String TABLE_NAME = "users";
        public static final String _ID = "id";
        public static final String ROW_USERNAME = "username";
        public static final String ROW_PASSWORD = "password";
        public static final String DIST_ID = "dist_id";
//        public static final String REGION_DSS = "region";

        public static final String _URI = "users.php";
    }
}