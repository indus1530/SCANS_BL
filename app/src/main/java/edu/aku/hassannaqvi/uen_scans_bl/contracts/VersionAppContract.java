package edu.aku.hassannaqvi.uen_scans_bl.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class VersionAppContract {

    private static final String TAG = VersionAppContract.class.getName();
    String versioncode;
    String versionname;
    String pathname;

    public VersionAppContract() {
        // Default Constructor
    }

    public VersionAppContract Sync(JSONObject jsonObject) throws JSONException {
        this.versioncode = jsonObject.getJSONObject(VersionAppTable.COLUMN_VERSION_PATH).getString(VersionAppTable.COLUMN_VERSION_CODE);
        this.pathname = jsonObject.getString(VersionAppTable.COLUMN_PATH_NAME);
        this.versionname = jsonObject.getJSONObject(VersionAppTable.COLUMN_VERSION_PATH).getString(VersionAppTable.COLUMN_VERSION_NAME);
        return this;
    }

    public VersionAppContract hydrate(Cursor cursor) {
        this.versioncode = cursor.getString(cursor.getColumnIndex(VersionAppTable.COLUMN_VERSION_CODE));
        this.pathname = cursor.getString(cursor.getColumnIndex(VersionAppTable.COLUMN_PATH_NAME));
        this.versionname = cursor.getString(cursor.getColumnIndex(VersionAppTable.COLUMN_VERSION_NAME));
        return this;
    }

    public String getVersioncode() {
        return versioncode;
    }

    public void setVersioncode(String versioncode) {
        this.versioncode = versioncode;
    }

    public String getPathname() {
        return pathname;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    public String getVersionname() {
        return versionname;
    }

    public void setVersionname(String versionname) {
        this.versionname = versionname;
    }

    public static abstract class VersionAppTable implements BaseColumns {

        public static final String TABLE_NAME = "versionApp";
        public static final String COLUMN_VERSION_PATH = "apkData";
        public static final String COLUMN_VERSION_CODE = "versionCode";
        public static final String COLUMN_VERSION_NAME = "versionName";
        public static final String COLUMN_PATH_NAME = "path";

        public static final String _URI = "output.json";
    }
}