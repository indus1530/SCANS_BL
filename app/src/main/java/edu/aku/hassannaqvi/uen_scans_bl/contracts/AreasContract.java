package edu.aku.hassannaqvi.uen_scans_bl.contracts;


import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class AreasContract {

    private static final String TAG = "Areas_CONTRACT";
    String areacode;
    String area;
    String uc_code;

    public AreasContract() {
        // Default Constructor
    }

    public AreasContract Sync(JSONObject jsonObject) throws JSONException {
        this.areacode = jsonObject.getString(singleAreas.COLUMN_AREACODE);
        this.area = jsonObject.getString(singleAreas.COLUMN_AREA);
        this.uc_code = jsonObject.getString(singleAreas.COLUMN_UC_CODE);
        return this;
    }

    public AreasContract HydrateUCs(Cursor cursor) {
        this.areacode = cursor.getString(cursor.getColumnIndex(singleAreas.COLUMN_AREACODE));
        this.area = cursor.getString(cursor.getColumnIndex(singleAreas.COLUMN_AREA));
        this.uc_code = cursor.getString(cursor.getColumnIndex(singleAreas.COLUMN_UC_CODE));
        return this;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getUc_code() {
        return uc_code;
    }

    public void setUc_code(String uc_code) {
        this.uc_code = uc_code;
    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(singleAreas.COLUMN_AREACODE, this.areacode == null ? JSONObject.NULL : this.areacode);
        json.put(singleAreas.COLUMN_AREA, this.area == null ? JSONObject.NULL : this.area);
        json.put(singleAreas.COLUMN_UC_CODE, this.uc_code == null ? JSONObject.NULL : this.uc_code);
        return json;
    }


    public static abstract class singleAreas implements BaseColumns {

        public static final String TABLE_NAME = "areas";
        public static final String COLUMN_AREACODE = "area_code";
        public static final String COLUMN_AREA = "area_name";
        public static final String COLUMN_UC_CODE = "uc_code";

        public static final String _URI = "areas.php";
    }
}