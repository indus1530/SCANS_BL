package edu.aku.hassannaqvi.uen_midline.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class ChildrenContract {

    private String luid;
    private String formType;
    private String Sa;
    private String Sb;
    private String iStatus;
    private String lhw_code;
    private String caseid;
    private String child_name;
    private String f_name;
    private String ref_date;


    public ChildrenContract() {
    }


    public String getLuid() {
        return luid;
    }

    public String getFormType() {
        return formType;
    }

    public String getSa() {
        return Sa;
    }

    public String getiStatus() {
        return iStatus;
    }

    public String getRef_date() {
        return ref_date;
    }

    public String getLhw_code() {
        return lhw_code;
    }

    public String getCaseid() {
        return caseid;
    }

    public String getChild_name() {
        return child_name;
    }

    public String getF_name() {
        return f_name;
    }

    public ChildrenContract sync(JSONObject jsonObject) throws JSONException {
        this.lhw_code = jsonObject.getString(singleChild.COLUMN_LHW_CODE);
        this.caseid = jsonObject.getString(singleChild.COLUMN_CASEID);
        this.child_name = jsonObject.getString(singleChild.COLUMN_CHILD_NAME);
        this.f_name = jsonObject.getString(singleChild.COLUMN_F_NAME);
        this.ref_date = jsonObject.getString(singleChild.COLUMN_REF_DATE);
        this.luid = jsonObject.getString(singleChild.COLUMN_LUID);

        return this;
    }

    public ChildrenContract hydrate(Cursor cursor) {
        this.lhw_code = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_LHW_CODE));
        this.caseid = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_CASEID));
        this.child_name = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_CHILD_NAME));
        this.f_name = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_F_NAME));
        this.ref_date = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_REF_DATE));
        this.luid = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_LUID));

        return this;
    }


    public ChildrenContract hydrateForm(Cursor cursor) {

        //this.luid = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_UID));
        this.formType = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_FORMTYPE));
        this.iStatus = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_ISTATUS));
        this.lhw_code = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_DSSID));
        this.caseid = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_NEXT_VISIT));
        this.ref_date = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_FORMDATE));

        CrfChild formSa = new Gson().fromJson(cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SA)), CrfChild.class);


        this.child_name = formSa.getPocfa09();

        //this.rep_date = formSa.getKapr09();

        return this;
    }




    /*public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(singleDeceasedChild.COLUMN_LUID, this.luid == null ? JSONObject.NULL : this.luid);
        json.put(singleDeceasedChild.COLUMN_LHW_CODE, this.lhw_code == null ? JSONObject.NULL : this.lhw_code);
        json.put(singleDeceasedChild.COLUMN_CASEID, this.caseid == null ? JSONObject.NULL : this.caseid);
        json.put(singleDeceasedChild.COLUMN_CHILD_NAME, this.child_name == null ? JSONObject.NULL : this.child_name);
        json.put(singleDeceasedChild.COLUMN_F_NAME, this.f_name == null ? JSONObject.NULL : this.f_name);
        json.put(singleDeceasedChild.COLUMN_REP_DATE, this.rep_date == null ? JSONObject.NULL : this.rep_date);

        return json;
    }*/

    public static abstract class singleChild implements BaseColumns {

        public static final String TABLE_NAME = "children";
        public static final String _ID = "_id";
        public static final String COLUMN_LHW_CODE = "lhw_code";
        public static final String COLUMN_CASEID = "caseid";
        public static final String COLUMN_CHILD_NAME = "child_name";
        public static final String COLUMN_F_NAME = "f_name";
        public static final String COLUMN_REF_DATE = "ref_date";
        public static final String COLUMN_LUID = "luid";

        public static final String _URI = "children.php";
    }

    private class CrfChild {
        String pocfa09, pocfb02;

        public String getPocfa09() {
            return pocfa09;
        }

        public void setPocfa09(String pocfa09) {
            this.pocfa09 = pocfa09;
        }

        public String getPocfb02() {
            return pocfb02;
        }

        public void setPocfb02(String pocfb02) {
            this.pocfb02 = pocfb02;
        }

    }
}
