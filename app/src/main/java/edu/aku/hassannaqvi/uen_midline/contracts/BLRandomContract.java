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
    private String contact;
    private String selStructure;
    private String sno;

    private String rndType;
    private String assignHH;

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
        this.contact = rnd.getContact();
        this.selStructure = rnd.getSelStructure();
        this.sno = rnd.getSno();
    }

    public BLRandomContract Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(SingleRandomHH.COLUMN_ID);
        this.LUID = jsonObject.getString(SingleRandomHH.COLUMN_LUID);
        this.subVillageCode = jsonObject.getString(SingleRandomHH.COLUMN_ENUM_BLOCK_CODE);
        this.structure = jsonObject.getString(SingleRandomHH.COLUMN_STRUCTURE_NO);
        this.structure = String.format("%04d", Integer.valueOf(this.structure));

        this.extension = jsonObject.getString(SingleRandomHH.COLUMN_FAMILY_EXT_CODE);
        this.extension = String.format("%03d", Integer.valueOf(this.extension));

        this.hh = structure + "-" + extension;
        this.randomDT = jsonObject.getString(SingleRandomHH.COLUMN_RANDOMDT);
        this.hhhead = jsonObject.getString(SingleRandomHH.COLUMN_HH_HEAD);
        this.contact = jsonObject.getString(SingleRandomHH.COLUMN_CONTACT);
        this.selStructure = jsonObject.getString(SingleRandomHH.COLUMN_HH_SELECTED_STRUCT);
        this.sno = jsonObject.getString(SingleRandomHH.COLUMN_SNO_HH);

        return this;
    }

    public BLRandomContract hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(SingleRandomHH.COLUMN_ID));
        this.LUID = cursor.getString(cursor.getColumnIndex(SingleRandomHH.COLUMN_LUID));
        this.subVillageCode = cursor.getString(cursor.getColumnIndex(SingleRandomHH.COLUMN_ENUM_BLOCK_CODE));
        this.structure = cursor.getString(cursor.getColumnIndex(SingleRandomHH.COLUMN_STRUCTURE_NO));
        this.extension = cursor.getString(cursor.getColumnIndex(SingleRandomHH.COLUMN_FAMILY_EXT_CODE));
        this.hh = cursor.getString(cursor.getColumnIndex(SingleRandomHH.COLUMN_HH));
        this.randomDT = cursor.getString(cursor.getColumnIndex(SingleRandomHH.COLUMN_RANDOMDT));
        this.hhhead = cursor.getString(cursor.getColumnIndex(SingleRandomHH.COLUMN_HH_HEAD));
        this.contact = cursor.getString(cursor.getColumnIndex(SingleRandomHH.COLUMN_CONTACT));
        this.selStructure = cursor.getString(cursor.getColumnIndex(SingleRandomHH.COLUMN_HH_SELECTED_STRUCT));
        this.sno = cursor.getString(cursor.getColumnIndex(SingleRandomHH.COLUMN_SNO_HH));

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSelStructure() {
        return selStructure;
    }

    public void setSelStructure(String selStructure) {
        this.selStructure = selStructure;
    }

    public String getAssignHH() {
        return assignHH;
    }

    public void setAssignHH(String assignHH) {
        this.assignHH = assignHH;
    }

    public String getRndType() {
        return rndType;
    }

    public void setRndType(String rndType) {
        this.rndType = rndType;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public static abstract class SingleRandomHH implements BaseColumns {

        public static final String TABLE_NAME = "BLRandom";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_RANDOMDT = "randDT";
        public static final String COLUMN_LUID = "UID";
        public static final String COLUMN_ENUM_BLOCK_CODE = "hh02";
        public static final String COLUMN_STRUCTURE_NO = "hh03";
        public static final String COLUMN_FAMILY_EXT_CODE = "hh07";
        public static final String COLUMN_HH = "hh";
        public static final String COLUMN_HH_HEAD = "hh08";
        public static final String COLUMN_CONTACT = "hh09";
        public static final String COLUMN_HH_SELECTED_STRUCT = "hhss";
        public static final String COLUMN_SNO_HH = "sno";

        public static String _URI = "ml_random.php";
    }

}