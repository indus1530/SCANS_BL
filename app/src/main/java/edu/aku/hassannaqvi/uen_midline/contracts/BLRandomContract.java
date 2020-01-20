package edu.aku.hassannaqvi.uen_midline.contracts;


import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class BLRandomContract {

    private static final String TAG = "BLRandom_CONTRACT";

    private String _ID;
    private String LUID;
    private String subVillageCode; // hh02
    private String structure;  // Structure
    private String extension; // Extension
    private String hh;
    private String hhhead;
    private String randomDT;

    public BLRandomContract() {
    }

    public BLRandomContract(BLRandomContract rnd) {
        this._ID = rnd.get_ID();
        this.LUID = rnd.getLUID();
        this.subVillageCode = rnd.getSubVillageCode();
        this.structure = rnd.getStructure();
        this.extension = rnd.getExtension();
        this.hh = rnd.getHh();
        this.hhhead = rnd.getHhhead();
        this.randomDT = rnd.getRandomDT();
    }

    public BLRandomContract Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(singleChild.COLUMN_ID);
        this.LUID = jsonObject.getString(singleChild.COLUMN_LUID);
        this.subVillageCode = jsonObject.getString(singleChild.COLUMN_SUB_VILLAGE_CODE);
        this.structure = jsonObject.getString(singleChild.COLUMN_STRUCTURE_NO);

        this.structure = String.format("%04d", Integer.valueOf(this.structure));

        this.extension = jsonObject.getString(singleChild.COLUMN_FAMILY_EXT_CODE);
        this.hh = jsonObject.getString(singleChild.COLUMN_STRUCTURE_NO)
                + "-" + jsonObject.getString(singleChild.COLUMN_FAMILY_EXT_CODE);
        this.randomDT = jsonObject.getString(singleChild.COLUMN_RANDOMDT);
        this.hhhead = jsonObject.getString(singleChild.COLUMN_HH_HEAD);

        return this;
    }

    public BLRandomContract Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_ID));
        this.LUID = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_LUID));
        this.subVillageCode = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_SUB_VILLAGE_CODE));
        this.structure = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_STRUCTURE_NO));
        this.extension = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_FAMILY_EXT_CODE));
        this.hh = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_HH));
        this.randomDT = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_RANDOMDT));
        this.hhhead = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_HH_HEAD));

        return this;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String getLUID() {
        return LUID;
    }

    public void setLUID(String LUID) {
        this.LUID = LUID;
    }

    public String getSubVillageCode() {
        return subVillageCode;
    }

    public void setSubVillageCode(String subVillageCode) {
        this.subVillageCode = subVillageCode;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getHh() {
        return structure + "-" + "" + extension;
    }

    public void setHh(String hh) {
        this.hh = hh;
    }

    public String getRandomDT() {
        return randomDT;
    }

    public void setRandomDT(String randomDT) {
        this.randomDT = randomDT;
    }

    public String getHhhead() {
        return hhhead;
    }

    public void setHhhead(String hhhead) {
        this.hhhead = hhhead;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(singleChild.COLUMN_ID, this._ID);
        json.put(singleChild.COLUMN_LUID, this.LUID);
        json.put(singleChild.COLUMN_SUB_VILLAGE_CODE, this.subVillageCode);
        json.put(singleChild.COLUMN_HH, this.hh);
        json.put(singleChild.COLUMN_RANDOMDT, this.randomDT);
        json.put(singleChild.COLUMN_HH_HEAD, this.hhhead);

        return json;
    }

    public static abstract class singleChild implements BaseColumns {

        public static final String TABLE_NAME = "BLRandom";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_RANDOMDT = "randDT";
        public static final String COLUMN_LUID = "UID";
        public static final String COLUMN_SUB_VILLAGE_CODE = "hh02";
        public static final String COLUMN_STRUCTURE_NO = "hh03";
        public static final String COLUMN_FAMILY_EXT_CODE = "hh07";
        public static final String COLUMN_HH = "hh";
        public static final String COLUMN_HH_HEAD = "hh08";
        public static String _URIGET = "bl_random.php";
    }

}