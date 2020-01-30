 package edu.aku.hassannaqvi.uen_scans_bl.contracts;


import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class EnumBlockContract {

    private static final String TAG = "EnumBlock_CONTRACT";
    String dsit_code;
    String geoarea;
    String cluster;

    public EnumBlockContract() {
        // Default Constructor
    }

    public EnumBlockContract Sync(JSONObject jsonObject) throws JSONException {
        this.dsit_code = jsonObject.getString(EnumBlockTable.COLUMN_DIST_ID);
        this.geoarea = jsonObject.getString(EnumBlockTable.COLUMN_GEO_AREA);
        this.cluster = jsonObject.getString(EnumBlockTable.COLUMN_CLUSTER_AREA);
        return this;
    }

    public EnumBlockContract HydrateEnum(Cursor cursor) {
        this.dsit_code = cursor.getString(cursor.getColumnIndex(EnumBlockTable.COLUMN_DIST_ID));
        this.geoarea = cursor.getString(cursor.getColumnIndex(EnumBlockTable.COLUMN_GEO_AREA));
        this.cluster = cursor.getString(cursor.getColumnIndex(EnumBlockTable.COLUMN_CLUSTER_AREA));
        return this;
    }

    public String getDsit_code() {
        return dsit_code;
    }

    public void setDsit_code(String dsit_code) {
        this.dsit_code = dsit_code;
    }

    public String getGeoarea() {
        return geoarea;
    }

    public void setGeoarea(String geoarea) {
        this.geoarea = geoarea;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(EnumBlockTable.COLUMN_DIST_ID, this.dsit_code == null ? JSONObject.NULL : this.dsit_code);
        json.put(EnumBlockTable.COLUMN_GEO_AREA, this.geoarea == null ? JSONObject.NULL : this.geoarea);
        json.put(EnumBlockTable.COLUMN_CLUSTER_AREA, this.cluster == null ? JSONObject.NULL : this.cluster);
        return json;
    }


    public static abstract class EnumBlockTable implements BaseColumns {

        public static final String TABLE_NAME = "enumblock";
        public static final String COLUMN_DIST_ID = "dist_id";
        public static final String COLUMN_GEO_AREA = "geoarea";
        public static final String COLUMN_CLUSTER_AREA = "cluster_no";

        //        public static final String _URI = "enumblock.php";
        public static final String _URI = "clusters.php";
    }
}