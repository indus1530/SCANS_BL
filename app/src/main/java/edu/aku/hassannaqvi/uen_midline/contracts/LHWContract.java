package edu.aku.hassannaqvi.uen_midline.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class LHWContract {

    private String talukacode;
    private String talukaname;
    private String uccode;
    private String ucname;
    private String lhwcode;
    private String lhwname;


    public LHWContract() {
    }


    public String getTalukacode() {
        return talukacode;
    }

    public String getTalukaname() {
        return talukaname;
    }

    public String getUccode() {
        return uccode;
    }

    public String getUcname() {
        return ucname;
    }

    public String getLhwcode() {
        return lhwcode;
    }

    public String getLhwname() {
        return lhwname;
    }

    public LHWContract sync(JSONObject jsonObject) throws JSONException {
        this.talukacode = jsonObject.getString(lhwEntry.COLUMN_TALUKA_CODE);
        this.talukaname = jsonObject.getString(LHWContract.lhwEntry.COLUMN_TALUKA_NAME);
        this.uccode = jsonObject.getString(LHWContract.lhwEntry.COLUMN_UC_CODE);
        this.ucname = jsonObject.getString(LHWContract.lhwEntry.COLUMN_UC_NAME);
        this.lhwcode = jsonObject.getString(LHWContract.lhwEntry.COLUMN_LHW_CODE);
        this.lhwname = jsonObject.getString(LHWContract.lhwEntry.COLUMN_LHW_NAME);

        return this;
    }

    public LHWContract hydrate(Cursor cursor) {
        this.talukacode = cursor.getString(cursor.getColumnIndex(LHWContract.lhwEntry.COLUMN_TALUKA_CODE));
        this.talukaname = cursor.getString(cursor.getColumnIndex(LHWContract.lhwEntry.COLUMN_TALUKA_NAME));
        this.uccode = cursor.getString(cursor.getColumnIndex(LHWContract.lhwEntry.COLUMN_UC_CODE));
        this.ucname = cursor.getString(cursor.getColumnIndex(LHWContract.lhwEntry.COLUMN_UC_NAME));
        this.lhwcode = cursor.getString(cursor.getColumnIndex(LHWContract.lhwEntry.COLUMN_LHW_CODE));
        this.lhwname = cursor.getString(cursor.getColumnIndex(LHWContract.lhwEntry.COLUMN_LHW_NAME));

        return this;
    }


    public static abstract class lhwEntry implements BaseColumns {

        public static final String TABLE_NAME = "lhw";
        public static final String COLUMN_NAME_NULLABLE = "nullColumnHack";
        public static final String _ID = "_ID";
        public static final String COLUMN_TALUKA_CODE = "taluka_code";
        public static final String COLUMN_TALUKA_NAME = "taluka_name";
        public static final String COLUMN_UC_CODE = "uc_code";
        public static final String COLUMN_UC_NAME = "uc_name";
        public static final String COLUMN_LHW_CODE = "lhw_code";
        public static final String COLUMN_LHW_NAME = "lhw_name";

        public static final String _URI = "lhws.php";

    }
}