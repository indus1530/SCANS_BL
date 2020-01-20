package edu.aku.hassannaqvi.uen_midline.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 10/31/2016.
 */

public class VillagesContract {


    private String areaCode;
    private String villagecode;
    private String villagename;


    public VillagesContract() {
    }


    public String getAreaCode() {
        return areaCode;
    }

    public String getVillagecode() {
        return villagecode;
    }

    public String getVillagename() {
        return villagename;
    }

    public VillagesContract sync(JSONObject jsonObject) throws JSONException {
        this.areaCode = jsonObject.getString(singleVillage.COLUMN_AREA_CODE);
        this.villagecode = jsonObject.getString(singleVillage.COLUMN_VILLAGE_CODE);
        this.villagename = jsonObject.getString(singleVillage.COLUMN_VILLAGE_NAME);

        return this;
    }

    public VillagesContract hydrate(Cursor cursor) {
        this.areaCode = cursor.getString(cursor.getColumnIndex(singleVillage.COLUMN_AREA_CODE));
        this.villagecode = cursor.getString(cursor.getColumnIndex(singleVillage.COLUMN_VILLAGE_CODE));
        this.villagename = cursor.getString(cursor.getColumnIndex(singleVillage.COLUMN_VILLAGE_NAME));

        return this;
    }


    public static abstract class singleVillage implements BaseColumns {

        public static final String TABLE_NAME = "villages";
        public static final String _ID = "_id";
        public static final String COLUMN_AREA_CODE = "area_code";
        public static final String COLUMN_VILLAGE_CODE = "village_code";
        public static final String COLUMN_VILLAGE_NAME = "village_name";

        public static final String _URI = "villages.php";
    }

}