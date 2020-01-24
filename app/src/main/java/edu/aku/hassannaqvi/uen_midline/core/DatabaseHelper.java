package edu.aku.hassannaqvi.uen_midline.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.uen_midline.contracts.AreasContract;
import edu.aku.hassannaqvi.uen_midline.contracts.AreasContract.singleAreas;
import edu.aku.hassannaqvi.uen_midline.contracts.ChildContract;
import edu.aku.hassannaqvi.uen_midline.contracts.ChildContract.singleChild;
import edu.aku.hassannaqvi.uen_midline.contracts.ChildList;
import edu.aku.hassannaqvi.uen_midline.contracts.ChildrenContract;
import edu.aku.hassannaqvi.uen_midline.contracts.DeceasedChildContract;
import edu.aku.hassannaqvi.uen_midline.contracts.DeceasedChildContract.singleDeceasedChild;
import edu.aku.hassannaqvi.uen_midline.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_midline.contracts.FamilyMembersContract.singleMember;
import edu.aku.hassannaqvi.uen_midline.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_midline.contracts.FormsContract.FormsTable;
import edu.aku.hassannaqvi.uen_midline.contracts.MWRAContract;
import edu.aku.hassannaqvi.uen_midline.contracts.MotherContract;
import edu.aku.hassannaqvi.uen_midline.contracts.MotherContract.singleMother;
import edu.aku.hassannaqvi.uen_midline.contracts.ProblemContract;
import edu.aku.hassannaqvi.uen_midline.contracts.ProblemContract.singleProblem;
import edu.aku.hassannaqvi.uen_midline.contracts.TalukasContract;
import edu.aku.hassannaqvi.uen_midline.contracts.UCsContract;
import edu.aku.hassannaqvi.uen_midline.contracts.UsersContract;
import edu.aku.hassannaqvi.uen_midline.contracts.VersionAppContract;
import edu.aku.hassannaqvi.uen_midline.contracts.VillagesContract;
import edu.aku.hassannaqvi.uen_midline.contracts.VillagesContract.singleVillage;


/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_USERS = "CREATE TABLE " + UsersContract.singleUser.TABLE_NAME + "("
            + UsersContract.singleUser._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersContract.singleUser.ROW_USERNAME + " TEXT,"
            + UsersContract.singleUser.ROW_PASSWORD + " TEXT,"
            + UsersContract.singleUser.FULL_NAME + " TEXT"
            + " );";
    public static final String DATABASE_NAME = "rsvStudy.db";
    public static final String DB_NAME = "rsvStudy_copy.db";
    public static final String PROJECT_NAME = "DMU-RSVSTUDY";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsTable.TABLE_NAME + "("
            + FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsTable.COLUMN_UID + " TEXT,"
            + FormsTable.COLUMN_TALUKA_CODE + " TEXT,"
            + FormsTable.COLUMN_UC_CODE + " TEXT,"
            + FormsTable.COLUMN_AREA_CODE + " TEXT,"
            + FormsTable.COLUMN_VILLAGE_CODE + " TEXT," +
            FormsTable.COLUMN_FORMDATE + " TEXT," +
            FormsTable.COLUMN_APPVERSION + " TEXT," +
            FormsTable.COLUMN_STATUS + " TEXT," +
            FormsTable.COLUMN_CLUSTERCODE + " TEXT," +
            FormsTable.COLUMN_HHNO + " TEXT," +
            FormsTable.COLUMN_FORMTYPE + " TEXT," +
            FormsTable.COLUMN_DSSID + " TEXT," +
            FormsTable.COLUMN_NEXT_VISIT + " TEXT," +
            FormsTable.COLUMN_USER + " TEXT," +
            FormsTable.COLUMN_SA + " TEXT," +
            FormsTable.COLUMN_ISTATUS + " TEXT," +
            FormsTable.COLUMN_ISTATUS88x + " TEXT," +
            FormsTable.COLUMN_ENDINGDATETIME + " TEXT," +
            FormsTable.COLUMN_GPSLAT + " TEXT," +
            FormsTable.COLUMN_GPSLNG + " TEXT," +
            FormsTable.COLUMN_GPSDATE + " TEXT," +
            FormsTable.COLUMN_GPSACC + " TEXT," +
            FormsTable.COLUMN_DEVICEID + " TEXT," +
            FormsTable.COLUMN_DEVICETAGID + " TEXT," +
            FormsTable.COLUMN_SYNCED + " TEXT," +
            FormsTable.COLUMN_SYNCED_DATE + " TEXT"
            + " );";
    private static final String SQL_DELETE_CHILDREN = "DROP TABLE IF EXISTS " + ChildrenContract.singleChild.TABLE_NAME;
    private static final String SQL_DELETE_CHILDLIST = "DROP TABLE IF EXISTS " + ChildList.singleChildList.TABLE_NAME;
    private static final String SQL_DELETE_VILLAGES = "DROP TABLE IF EXISTS " + singleVillage.TABLE_NAME;
    private static final String SQL_DELETE_TALUKAS = "DROP TABLE IF EXISTS " + TalukasContract.singleTalukas.TABLE_NAME;
    private static final String SQL_DELETE_UCS = "DROP TABLE IF EXISTS " + UCsContract.singleUCs.TABLE_NAME;
    private static final String SQL_DELETE_AREAS = "DROP TABLE IF EXISTS " + singleAreas.TABLE_NAME;

    private final String SQL_CREATE_VERSIONAPP = "CREATE TABLE " + VersionAppContract.VersionAppTable.TABLE_NAME + " (" +
            VersionAppContract.VersionAppTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_PATH_NAME + " TEXT " +
            ");";

    private final String SQL_CREATE_TALUKAS = "CREATE TABLE " + TalukasContract.singleTalukas.TABLE_NAME + "("
            + TalukasContract.singleTalukas._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TalukasContract.singleTalukas.COLUMN_TALUKA_CODE + " TEXT,"
            + TalukasContract.singleTalukas.COLUMN_TALUKA + " TEXT );";
    private final String SQL_CREATE_UCS = "CREATE TABLE " + UCsContract.singleUCs.TABLE_NAME + "("
            + UCsContract.singleUCs._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UCsContract.singleUCs.COLUMN_UCCODE + " TEXT,"
            + UCsContract.singleUCs.COLUMN_TALUKA_CODE + " TEXT,"
            + UCsContract.singleUCs.COLUMN_UCS + " TEXT );";
    private final String SQL_CREATE_AREAS = "CREATE TABLE " + singleAreas.TABLE_NAME + "("
            + singleAreas._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleAreas.COLUMN_AREACODE + " TEXT,"
            + singleAreas.COLUMN_UC_CODE + " TEXT,"
            + singleAreas.COLUMN_AREA + " TEXT );";


    private final String SQL_CREATE_CHILDREN = "CREATE TABLE " + ChildrenContract.singleChild.TABLE_NAME + "("
            + ChildrenContract.singleChild._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ChildrenContract.singleChild.COLUMN_LHW_CODE + " TEXT,"
            + ChildrenContract.singleChild.COLUMN_CASEID + " TEXT,"
            + ChildrenContract.singleChild.COLUMN_CHILD_NAME + " TEXT, "
            + ChildrenContract.singleChild.COLUMN_F_NAME + " TEXT,"
            + ChildrenContract.singleChild.COLUMN_REF_DATE + " TEXT, "
            + ChildrenContract.singleChild.COLUMN_LUID + " TEXT );";

    private final String SQL_CREATE_PSU_TABLE = "CREATE TABLE " + singleVillage.TABLE_NAME + " (" +
            singleVillage._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            singleVillage.COLUMN_AREA_CODE + " TEXT, " +
            singleVillage.COLUMN_VILLAGE_CODE + " TEXT, " +
            singleVillage.COLUMN_VILLAGE_NAME + " TEXT " +
            ");";

    private final String SQL_CREATE_DECEASED_CHILD = "CREATE TABLE " + DeceasedChildContract.singleDeceasedChild.TABLE_NAME + "("
            + singleDeceasedChild._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleDeceasedChild.COLUMN_luid + " TEXT,"
            + singleDeceasedChild.COLUMN_UID + " TEXT,"
            + singleDeceasedChild.COLUMN_UUID + " TEXT,"
            + singleDeceasedChild.COLUMN_MUID + " TEXT,"
            + singleDeceasedChild.COLUMN_MOTHER_ID + " TEXT,"
            + singleDeceasedChild.COLUMN_SERIAL_NO + " TEXT,"
            + singleDeceasedChild.COLUMN_DA + " TEXT,"
            + singleDeceasedChild.COLUMN_FORMDATE + " TEXT,"
            + singleDeceasedChild.COLUMN_USER + " TEXT,"
            + singleDeceasedChild.COLUMN_DEVICEID + " TEXT,"
            + singleDeceasedChild.COLUMN_DEVICETAGID + " TEXT,"
            + singleDeceasedChild.COLUMN_SYNCED + " TEXT,"
            + singleDeceasedChild.COLUMN_SYNCED_DATE + " TEXT );";


    private final String SQL_CREATE__CHILD_TABLE = "CREATE TABLE " + singleChild.TABLE_NAME + "("
            + singleChild._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleChild.COLUMN_luid + " TEXT,"
            + singleChild.COLUMN_UID + " TEXT,"
            + singleChild.COLUMN_UUID + " TEXT,"
            + singleChild.COLUMN_MOTHER_ID + " TEXT,"
            + singleChild.COLUMN_SERIAL_NO + " TEXT,"
            + singleChild.COLUMN_DA + " TEXT,"
            + singleChild.COLUMN_FORMDATE + " TEXT,"
            + singleChild.COLUMN_USER + " TEXT,"
            + singleChild.COLUMN_DEVICEID + " TEXT,"
            + singleChild.COLUMN_DEVICETAGID + " TEXT,"
            + singleChild.COLUMN_SYNCED + " TEXT,"
            + singleChild.COLUMN_SYNCED_DATE + " TEXT );";


    private final String SQL_CREATE__MOTHER_TABLE = "CREATE TABLE " + singleMother.TABLE_NAME + "("
            + singleMother._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleMother.COLUMN_luid + " TEXT,"
            + singleMother.COLUMN_UID + " TEXT,"
            + singleMother.COLUMN_MOTHER_ID + " TEXT,"
            + singleMother.COLUMN_SERIAL_NO + " TEXT,"
            + singleMother.COLUMN_DA + " TEXT,"
            + singleMother.COLUMN_FORMDATE + " TEXT,"
            + singleMother.COLUMN_USER + " TEXT,"
            + singleMother.COLUMN_DEVICEID + " TEXT,"
            + singleMother.COLUMN_DEVICETAGID + " TEXT,"
            + singleMother.COLUMN_SYNCED + " TEXT,"
            + singleMother.COLUMN_SYNCED_DATE + " TEXT );";

    private final String SQL_CREATE__PROBLEM_TABLE = "CREATE TABLE " + singleProblem.TABLE_NAME + "("
            + singleProblem._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleProblem.COLUMN_UID + " TEXT,"
            + singleProblem.COLUMN_UUID + " TEXT,"
            + singleProblem.COLUMN_CUID + " TEXT,"
            + singleProblem.COLUMN_PROBLEM_TYPE + " TEXT,"
            + singleProblem.COLUMN_DA + " TEXT,"
            + singleProblem.COLUMN_FORMDATE + " TEXT,"
            + singleProblem.COLUMN_USER + " TEXT,"
            + singleProblem.COLUMN_DEVICEID + " TEXT,"
            + singleProblem.COLUMN_DEVICETAGID + " TEXT,"
            + singleProblem.COLUMN_SYNCED + " TEXT,"
            + singleProblem.COLUMN_SYNCED_DATE + " TEXT );";


    private final String SQL_CREATE_CHILDLIST = "CREATE TABLE " + ChildList.singleChildList.TABLE_NAME + "("
            + ChildList.singleChildList._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ChildList.singleChildList.COLUMN_DSSID + " TEXT,"
            + ChildList.singleChildList.COLUMN_MOTHER_NAME + " TEXT,"
            + ChildList.singleChildList.COLUMN_FATHER_NAME + " TEXT, "
            + ChildList.singleChildList.COLUMN_HHHEAD + " TEXT,"
            + ChildList.singleChildList.COLUMN_DOB + " TEXT,"
            + ChildList.singleChildList.COLUMN_GENDER + " TEXT,"
            + ChildList.singleChildList.COLUMN_AREACODE + " TEXT,"
            + ChildList.singleChildList.COLUMN_STUDY_ID + " TEXT );";

    private final String SQL_CREATE_FAMILY_MEMBERS = "CREATE TABLE " + singleMember.TABLE_NAME + "("
            + singleMember.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            singleMember.COLUMN_UID + " TEXT," +
            singleMember.COLUMN_UUID + " TEXT," +
            singleMember.COLUMN_FORMDATE + " TEXT," +
            singleMember.COLUMN_CLUSTERNO + " TEXT," +
            singleMember.COLUMN_HHNO + " TEXT," +
            singleMember.COLUMN_SERIAL_NO + " TEXT," +
            singleMember.COLUMN_NAME + " TEXT," +
            singleMember.COLUMN_RELATION_HH + " TEXT," +
            singleMember.COLUMN_AGE + " TEXT," +
            singleMember.COLUMN_MOTHER_NAME + " TEXT," +
            singleMember.COLUMN_MOTHER_SERIAL + " TEXT," +
            singleMember.COLUMN_GENDER + " TEXT," +
            singleMember.COLUMN_MARITAL + " TEXT," +
            singleMember.COLUMN_SD + " TEXT" + ");";

    private final String TAG = "DatabaseHelper";

    public String spDateT = new SimpleDateFormat("dd-MM-yy").format(new Date().getTime());

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_FORMS);
        db.execSQL(SQL_CREATE_TALUKAS);
        db.execSQL(SQL_CREATE_UCS);
        db.execSQL(SQL_CREATE_CHILDREN);
        db.execSQL(SQL_CREATE_CHILDLIST);
        db.execSQL(SQL_CREATE_DECEASED_CHILD);
        db.execSQL(SQL_CREATE_PSU_TABLE);
        db.execSQL(SQL_CREATE_AREAS);
        db.execSQL(SQL_CREATE_VERSIONAPP);
        db.execSQL(SQL_CREATE_FAMILY_MEMBERS);
        db.execSQL(SQL_CREATE__CHILD_TABLE);
        db.execSQL(SQL_CREATE__PROBLEM_TABLE);
        db.execSQL(SQL_CREATE__MOTHER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        db.execSQL(SQL_DELETE_USERS);
//        db.execSQL(SQL_DELETE_FORMS);
//        db.execSQL("DROP TABLE IF EXISTS " + LHWContract.lhwEntry.TABLE_NAME);
//        db.execSQL(SQL_DELETE_CHILDREN);
//        db.execSQL(SQL_DELETE_CHILDLIST);
//        db.execSQL(SQL_DELETE_VILLAGES);
//        db.execSQL(SQL_DELETE_TALUKAS);
//        db.execSQL(SQL_DELETE_UCS);
//        db.execSQL(SQL_DELETE_AREAS);


    }

    public void syncChildren(JSONArray pcList) {
        SQLiteDatabase db = this.getWritableDatabase();


        try {
            JSONArray jsonArray = pcList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                ChildrenContract cc = new ChildrenContract();
                cc.sync(jsonObjectCC);
                Log.i(TAG, "syncChildren: " + jsonObjectCC.toString());

                ContentValues values = new ContentValues();

                values.put(ChildrenContract.singleChild.COLUMN_LHW_CODE, cc.getLhw_code());
                values.put(ChildrenContract.singleChild.COLUMN_CASEID, cc.getCaseid());
                values.put(ChildrenContract.singleChild.COLUMN_CHILD_NAME, cc.getChild_name());
                values.put(ChildrenContract.singleChild.COLUMN_F_NAME, cc.getF_name());
                values.put(ChildrenContract.singleChild.COLUMN_REF_DATE, cc.getRef_date());
                values.put(ChildrenContract.singleChild.COLUMN_LUID, cc.getLuid());

                db.insert(ChildrenContract.singleChild.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {

        }
    }

    public void syncChildlist(JSONArray cList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ChildList.singleChildList.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = cList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCL = jsonArray.getJSONObject(i);

                ChildList cl = new ChildList();
                cl.sync(jsonObjectCL);
                Log.i(TAG, "syncChildlist: " + jsonObjectCL.toString());

                ContentValues values = new ContentValues();

                values.put(ChildList.singleChildList.COLUMN_DSSID, cl.getDssid());
                values.put(ChildList.singleChildList.COLUMN_MOTHER_NAME, cl.getMother_name());
                values.put(ChildList.singleChildList.COLUMN_FATHER_NAME, cl.getFather_name());
                values.put(ChildList.singleChildList.COLUMN_HHHEAD, cl.getHhhead());
                values.put(ChildList.singleChildList.COLUMN_STUDY_ID, cl.getStudy_id());
                values.put(ChildList.singleChildList.COLUMN_DOB, cl.getDob());
                values.put(ChildList.singleChildList.COLUMN_GENDER, cl.getGender());
                values.put(ChildList.singleChildList.COLUMN_AREACODE, cl.getAreacode());

                db.insert(ChildList.singleChildList.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {

        }
    }

    public void syncVillages(JSONArray pcList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VillagesContract.singleVillage.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = pcList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectPSU = jsonArray.getJSONObject(i);

                VillagesContract vc = new VillagesContract();
                vc.sync(jsonObjectPSU);
                Log.i(TAG, "syncVillages: " + jsonObjectPSU.toString());

                ContentValues values = new ContentValues();

                values.put(singleVillage.COLUMN_AREA_CODE, vc.getAreaCode());
                values.put(singleVillage.COLUMN_VILLAGE_CODE, vc.getVillagecode());
                values.put(singleVillage.COLUMN_VILLAGE_NAME, vc.getVillagename());

                db.insert(VillagesContract.singleVillage.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {

        }
    }

    public void syncTalukas(JSONArray Talukaslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TalukasContract.singleTalukas.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = Talukaslist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                TalukasContract Vc = new TalukasContract();
                Vc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(TalukasContract.singleTalukas.COLUMN_TALUKA_CODE, Vc.getTalukacode());
                values.put(TalukasContract.singleTalukas.COLUMN_TALUKA, Vc.getTaluka());

                db.insert(TalukasContract.singleTalukas.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }

    public void syncUCs(JSONArray UCslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UCsContract.singleUCs.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = UCslist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                UCsContract Vc = new UCsContract();
                Vc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(UCsContract.singleUCs.COLUMN_UCCODE, Vc.getUccode());
                values.put(UCsContract.singleUCs.COLUMN_UCS, Vc.getUcs());
                values.put(UCsContract.singleUCs.COLUMN_TALUKA_CODE, Vc.getTaluka_code());

                db.insert(UCsContract.singleUCs.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }

    public void syncAreas(JSONArray Areaslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(singleAreas.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = Areaslist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                AreasContract Vc = new AreasContract();
                Vc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(singleAreas.COLUMN_AREACODE, Vc.getAreacode());
                values.put(singleAreas.COLUMN_AREA, Vc.getArea());
                values.put(singleAreas.COLUMN_UC_CODE, Vc.getUc_code());

                db.insert(singleAreas.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }

    public Collection<TalukasContract> getAllTalukas() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                TalukasContract.singleTalukas.COLUMN_TALUKA_CODE,
                TalukasContract.singleTalukas.COLUMN_TALUKA
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                TalukasContract.singleTalukas.COLUMN_TALUKA + " ASC";

        Collection<TalukasContract> allDC = new ArrayList<>();
        try {
            c = db.query(
                    TalukasContract.singleTalukas.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                TalukasContract dc = new TalukasContract();
                allDC.add(dc.HydrateTalukas(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }

    public ChildrenContract getChildById(String lhw_code, String caseid) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ChildrenContract.singleChild._ID,
                ChildrenContract.singleChild.COLUMN_LHW_CODE,
                ChildrenContract.singleChild.COLUMN_CASEID,
                ChildrenContract.singleChild.COLUMN_CHILD_NAME,
                ChildrenContract.singleChild.COLUMN_F_NAME,
                ChildrenContract.singleChild.COLUMN_REF_DATE,
                ChildrenContract.singleChild.COLUMN_LUID,
        };

        String whereClause = ChildrenContract.singleChild.COLUMN_LHW_CODE + " =? AND " + ChildrenContract.singleChild.COLUMN_CASEID + " =?";
        String[] whereArgs = {lhw_code, caseid};
        String groupBy = null;
        String having = null;

        String orderBy = ChildrenContract.singleChild.COLUMN_LHW_CODE + " ASC";

        ChildrenContract allEB = null;

        try {
            c = db.query(
                    ChildrenContract.singleChild.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allEB = new ChildrenContract().hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allEB;
    }

    public ChildrenContract getChildById(String sType, String codeLhw, String refId) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable.COLUMN_FORMTYPE,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_DSSID,
                FormsTable.COLUMN_NEXT_VISIT,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_SA,
        };

        String whereClause = FormsTable.COLUMN_FORMTYPE + " =? AND " + FormsTable.COLUMN_DSSID + " =? AND " + FormsTable.COLUMN_NEXT_VISIT + "=? AND " + FormsTable.COLUMN_ISTATUS + "=?";
        String[] whereArgs = {sType, codeLhw, refId, "1"};
        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_FORMTYPE + " ASC";

        ChildrenContract allEB = null;

        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allEB = new ChildrenContract().hydrateForm(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allEB;
    }

    public Collection<UCsContract> getAllUCs(String talukaCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                UCsContract.singleUCs.COLUMN_UCCODE,
                UCsContract.singleUCs.COLUMN_UCS,
                UCsContract.singleUCs.COLUMN_TALUKA_CODE
        };

        String whereClause = UCsContract.singleUCs.COLUMN_TALUKA_CODE + "=?";
        String[] whereArgs = new String[]{talukaCode};
        String groupBy = null;
        String having = null;

        String orderBy =
                UCsContract.singleUCs.COLUMN_UCS + " ASC";

        Collection<UCsContract> allDC = new ArrayList<>();
        try {
            c = db.query(
                    UCsContract.singleUCs.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                UCsContract dc = new UCsContract();
                allDC.add(dc.HydrateUCs(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }

    public List<ChildList> getChildList(String areaCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ChildList.singleChildList.COLUMN_DSSID,
                ChildList.singleChildList.COLUMN_GENDER,
                ChildList.singleChildList.COLUMN_STUDY_ID,
                ChildList.singleChildList.COLUMN_DOB,
                ChildList.singleChildList.COLUMN_FATHER_NAME,
                ChildList.singleChildList.COLUMN_MOTHER_NAME,
                ChildList.singleChildList.COLUMN_AREACODE,
                ChildList.singleChildList.COLUMN_HHHEAD,

        };


        String whereClause = ChildList.singleChildList.COLUMN_AREACODE + " = ? ";
        String[] whereArgs = new String[]{areaCode};
        String groupBy = null;
        String having = null;
        String orderBy = null;

        List<ChildList> allDC = new ArrayList<>();
        try {
            c = db.query(
                    ChildList.singleChildList.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ChildList dc = new ChildList();
                allDC.add(dc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }

    public List<ChildList> getList(String areaCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ChildList.singleChildList.COLUMN_DSSID,
                ChildList.singleChildList.COLUMN_GENDER,
                ChildList.singleChildList.COLUMN_STUDY_ID,
                ChildList.singleChildList.COLUMN_DOB,
                ChildList.singleChildList.COLUMN_FATHER_NAME,
                ChildList.singleChildList.COLUMN_MOTHER_NAME,
                ChildList.singleChildList.COLUMN_AREACODE,
                ChildList.singleChildList.COLUMN_HHHEAD,

        };


        String whereClause = ChildList.singleChildList.COLUMN_AREACODE + " = ? ";
        String[] whereArgs = new String[]{areaCode};
        String groupBy = null;
        String having = null;
        String orderBy = null;

        List<ChildList> allDC = new ArrayList<>();
        try {
            c = db.query(
                    ChildList.singleChildList.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ChildList dc = new ChildList();
                allDC.add(dc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }

    public Collection<AreasContract> getAllAreas(int UCCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleAreas.COLUMN_AREACODE,
                singleAreas.COLUMN_AREA,
                singleAreas.COLUMN_UC_CODE
        };

        String whereClause = singleAreas.COLUMN_UC_CODE + "=?";
        String[] whereArgs = new String[]{String.valueOf(UCCode)};
        String groupBy = null;
        String having = null;

        String orderBy =
                singleAreas.COLUMN_AREA + " ASC";

        Collection<AreasContract> allAC = new ArrayList<>();
        try {
            c = db.query(
                    singleAreas.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                AreasContract dc = new AreasContract();
                allAC.add(dc.HydrateUCs(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allAC;
    }

    public Collection<VillagesContract> getVillages(String areaCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleVillage.COLUMN_AREA_CODE,
                singleVillage.COLUMN_VILLAGE_CODE,
                singleVillage.COLUMN_VILLAGE_NAME,

        };

        String whereClause = singleVillage.COLUMN_AREA_CODE + "=?";
        String[] whereArgs = new String[]{String.valueOf(areaCode)};
        String groupBy = null;
        String having = null;

        String orderBy =
                singleVillage.COLUMN_VILLAGE_NAME + " ASC";

        Collection<VillagesContract> allAC = new ArrayList<>();
        try {
            c = db.query(
                    singleVillage.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                VillagesContract dc = new VillagesContract();
                allAC.add(dc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allAC;
    }

    public void syncVersionApp(JSONArray Versionlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VersionAppContract.VersionAppTable.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = Versionlist;
            JSONObject jsonObjectCC = jsonArray.getJSONObject(0);

            VersionAppContract Vc = new VersionAppContract();
            Vc.Sync(jsonObjectCC);

            ContentValues values = new ContentValues();

            values.put(VersionAppContract.VersionAppTable.COLUMN_PATH_NAME, Vc.getPathname());
            values.put(VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE, Vc.getVersioncode());
            values.put(VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME, Vc.getVersionname());

            db.insert(VersionAppContract.VersionAppTable.TABLE_NAME, null, values);
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }

    public VersionAppContract getVersionApp() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                VersionAppContract.VersionAppTable._ID,
                VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE,
                VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME,
                VersionAppContract.VersionAppTable.COLUMN_PATH_NAME
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = null;

        VersionAppContract allVC = new VersionAppContract();
        try {
            c = db.query(
                    VersionAppContract.VersionAppTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allVC.hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allVC;
    }

    public void syncUser(JSONArray userlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersContract.singleUser.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = userlist;
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                UsersContract user = new UsersContract();
                user.Sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(UsersContract.singleUser.ROW_USERNAME, user.getUserName());
                values.put(UsersContract.singleUser.ROW_PASSWORD, user.getPassword());
                values.put(UsersContract.singleUser.FULL_NAME, user.getFULL_NAME());
//                values.put(singleUser.REGION_DSS, user.getREGION_DSS());
                db.insert(UsersContract.singleUser.TABLE_NAME, null, values);
            }


        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
        } finally {
            db.close();
        }
    }

    public boolean Login(String username, String password) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.rawQuery("SELECT * FROM " + UsersContract.singleUser.TABLE_NAME + " WHERE " + UsersContract.singleUser.ROW_USERNAME + "=? AND " + UsersContract.singleUser.ROW_PASSWORD + "=?", new String[]{username, password});
        if (mCursor != null) {
            return mCursor.getCount() > 0;
        }
        return false;
    }

    public Long addForm(FormsContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_PROJECT_NAME, fc.getProjectName());
        values.put(FormsTable.COLUMN_UID, fc.get_UID());
        values.put(FormsTable.COLUMN_FORMDATE, fc.getFormDate());
        values.put(FormsTable.COLUMN_DSSID, fc.getLuid());
        values.put(FormsTable.COLUMN_NEXT_VISIT, fc.getNextVisit());
        values.put(FormsTable.COLUMN_USER, fc.getUser());
        values.put(FormsTable.COLUMN_ISTATUS, fc.getIstatus());
        values.put(FormsTable.COLUMN_ISTATUS88x, fc.getIstatus88x());
        values.put(FormsTable.COLUMN_ENDINGDATETIME, fc.getEndingdatetime());
        values.put(FormsTable.COLUMN_SA, fc.getsA());
        values.put(FormsTable.COLUMN_TALUKA_CODE, fc.getTalukdaCode());
        values.put(FormsTable.COLUMN_UC_CODE, fc.getUc());
        values.put(FormsTable.COLUMN_AREA_CODE, fc.getAreaCode());
        values.put(FormsTable.COLUMN_VILLAGE_CODE, fc.getVillage());
        values.put(FormsTable.COLUMN_GPSLAT, fc.getGpsLat());
        values.put(FormsTable.COLUMN_GPSLNG, fc.getGpsLng());
        values.put(FormsTable.COLUMN_GPSDATE, fc.getGpsDT());
        values.put(FormsTable.COLUMN_GPSACC, fc.getGpsAcc());
        values.put(FormsTable.COLUMN_DEVICETAGID, fc.getDevicetagID());
        values.put(FormsTable.COLUMN_DEVICEID, fc.getDeviceID());
        values.put(FormsTable.COLUMN_APPVERSION, fc.getAppversion());
        values.put(FormsTable.COLUMN_STATUS, fc.getStatus());
        values.put(FormsTable.COLUMN_CLUSTERCODE, fc.getClusterCode());
        values.put(FormsTable.COLUMN_HHNO, fc.getHhno());
        values.put(FormsTable.COLUMN_FORMTYPE, fc.getFormType());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addFamilyMember(FamilyMembersContract fmc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(singleMember.COLUMN_ID, fmc.get_id());
        values.put(singleMember.COLUMN_UID, fmc.getUid());
        values.put(singleMember.COLUMN_UUID, fmc.getUuid());
        values.put(singleMember.COLUMN_FORMDATE, fmc.getFormdate());
        values.put(singleMember.COLUMN_CLUSTERNO, fmc.getClusterno());
        values.put(singleMember.COLUMN_HHNO, fmc.getHhno());
        values.put(singleMember.COLUMN_SERIAL_NO, fmc.getSerialno());
        values.put(singleMember.COLUMN_NAME, fmc.getName());
        values.put(singleMember.COLUMN_RELATION_HH, fmc.getRelHH());
        values.put(singleMember.COLUMN_AGE, fmc.getAge());
        values.put(singleMember.COLUMN_MOTHER_NAME, fmc.getMother_name());
        values.put(singleMember.COLUMN_MOTHER_SERIAL, fmc.getMother_serial());
        values.put(singleMember.COLUMN_GENDER, fmc.getGender());
        values.put(singleMember.COLUMN_MARITAL, fmc.getMarital());
        values.put(singleMember.COLUMN_SD, fmc.getsD());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addChildDeceaseForm(DeceasedChildContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(DeceasedChildContract.singleDeceasedChild.COLUMN_luid, fc.getLuid());
        values.put(singleDeceasedChild.COLUMN_DA, fc.getdA());
        values.put(singleDeceasedChild.COLUMN_FORMDATE, fc.getFormdate());
        values.put(singleDeceasedChild.COLUMN_MOTHER_ID, fc.getMotherId());
        values.put(singleDeceasedChild.COLUMN_SERIAL_NO, fc.getSerialNo());
        values.put(singleDeceasedChild.COLUMN_USER, fc.getUser());
        values.put(singleDeceasedChild.COLUMN_DEVICEID, fc.getDeviceID());
        values.put(singleDeceasedChild.COLUMN_DEVICETAGID, fc.getDevicetagID());
        values.put(singleDeceasedChild.COLUMN_UUID, fc.getUuid());
        values.put(singleDeceasedChild.COLUMN_MUID, fc.getMuid());
        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                DeceasedChildContract.singleDeceasedChild.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addChildForm(ChildContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(singleChild.COLUMN_luid, fc.getLuid());
        values.put(singleChild.COLUMN_DA, fc.getdA());
        values.put(singleChild.COLUMN_FORMDATE, fc.getFormdate());
        values.put(singleChild.COLUMN_MOTHER_ID, fc.getMotherId());
        values.put(singleChild.COLUMN_SERIAL_NO, fc.getSerialNo());
        values.put(singleChild.COLUMN_USER, fc.getUser());
        values.put(singleChild.COLUMN_DEVICEID, fc.getDeviceID());
        values.put(singleChild.COLUMN_DEVICETAGID, fc.getDevicetagID());
        values.put(singleChild.COLUMN_UUID, fc.getUuid());
        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                singleChild.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addMotherForm(MotherContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(singleMother.COLUMN_luid, fc.getLuid());
        values.put(singleMother.COLUMN_DA, fc.getdA());
        values.put(singleMother.COLUMN_FORMDATE, fc.getFormdate());
//        values.put(singleMother.COLUMN_RELATION_HH, fc.getMotherId());
        values.put(singleMother.COLUMN_SERIAL_NO, fc.getSerialNo());
        values.put(singleMother.COLUMN_USER, fc.getUser());
        values.put(singleMother.COLUMN_DEVICEID, fc.getDeviceID());
        values.put(singleMother.COLUMN_DEVICETAGID, fc.getDevicetagID());
//        values.put(singleMother.COLUMN_UUID, fc.getUuid());
        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                singleMother.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addProblems(ProblemContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(singleProblem.COLUMN_UUID, fc.getUuid());
        values.put(singleProblem.COLUMN_CUID, fc.getCuid());
        values.put(singleProblem.COLUMN_FORMDATE, fc.getFormdate());
        values.put(singleProblem.COLUMN_DA, fc.getdA());
        values.put(singleProblem.COLUMN_PROBLEM_TYPE, fc.getProblemType());
        values.put(singleProblem.COLUMN_USER, fc.getUser());
        values.put(singleProblem.COLUMN_DEVICEID, fc.getDeviceID());
        values.put(singleProblem.COLUMN_DEVICETAGID, fc.getDevicetagID());
        values.put(singleProblem.COLUMN_UUID, fc.getUuid());
        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                singleProblem.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public FormsContract isDataExists(String studyId) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = null;

// New value for one column
        String[] columns = {
                FormsTable.COLUMN_DSSID,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_STATUS,

        };

// Which row to update, based on the ID
        String selection = FormsTable.COLUMN_DSSID + " = ? AND "
                + FormsTable.COLUMN_ISTATUS + " = ?";
        String[] selectionArgs = new String[]{studyId, "1"};

        FormsContract allFC = new FormsContract();
        try {
            c = db.query(FormsTable.TABLE_NAME, //Table to query
                    columns,                    //columns to return
                    selection,                  //columns for the WHERE clause
                    selectionArgs,              //The values for the WHERE clause
                    null,                       //group the rows
                    null,                       //filter by row groups
                    null);                   // The sort order

            while (c.moveToNext()) {
                allFC.setLuid(c.getString(c.getColumnIndex(FormsTable.COLUMN_DSSID)));
                allFC.setIstatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
                allFC.setStatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_STATUS)));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;


    }

    public void updateSyncedForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SYNCED, true);
        values.put(FormsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedChildForm(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(singleChild.COLUMN_SYNCED, true);
        values.put(singleChild.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = singleChild._ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                singleChild.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedProblemsForm(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(singleProblem.COLUMN_SYNCED, true);
        values.put(singleProblem.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = singleProblem._ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                singleProblem.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedDeceasedChildForm(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(singleDeceasedChild.COLUMN_SYNCED, true);
        values.put(singleDeceasedChild.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = singleDeceasedChild._ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                singleDeceasedChild.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateMWRAs(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MWRAContract.MWRATable.COLUMN_SYNCED, true);
        values.put(MWRAContract.MWRATable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = MWRAContract.MWRATable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                MWRAContract.MWRATable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public int updateFormID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_UID, MainApp.fc.get_UID());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateChildDeceaseFormID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(singleDeceasedChild.COLUMN_UID, MainApp.dcc.getUid());

// Which row to update, based on the ID
        String selection = singleDeceasedChild._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.dcc.get_id())};

        int count = db.update(singleDeceasedChild.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateChildFormID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(singleChild.COLUMN_UID, MainApp.cc.getUid());

// Which row to update, based on the ID
        String selection = singleChild._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.cc.get_id())};

        int count = db.update(singleChild.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateMotherFormID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(singleMother.COLUMN_UID, MainApp.mc.getUid());

// Which row to update, based on the ID
        String selection = singleMother._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.mc.get_id())};

        int count = db.update(singleMother.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateProblemFormID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(singleProblem.COLUMN_UID, MainApp.pc.getUid());

// Which row to update, based on the ID
        String selection = singleProblem._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.pc.get_id())};

        int count = db.update(singleProblem.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public Collection<FormsContract> getAllForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SA,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_APPVERSION,
                FormsTable.COLUMN_CLUSTERCODE,
                FormsTable.COLUMN_HHNO,
                FormsTable.COLUMN_STATUS,
                FormsTable.COLUMN_FORMTYPE,

        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<FamilyMembersContract> getAllFamilyMembersForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleMember.COLUMN_ID,
                singleMember.COLUMN_UID,
                singleMember.COLUMN_UUID,
                singleMember.COLUMN_FORMDATE,
                singleMember.COLUMN_CLUSTERNO,
                singleMember.COLUMN_HHNO,
                singleMember.COLUMN_SERIAL_NO,
                singleMember.COLUMN_NAME,
                singleMember.COLUMN_RELATION_HH,
                singleMember.COLUMN_AGE,
                singleMember.COLUMN_MOTHER_NAME,
                singleMember.COLUMN_MOTHER_SERIAL,
                singleMember.COLUMN_GENDER,
                singleMember.COLUMN_MARITAL,
                singleMember.COLUMN_SD,
        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<FamilyMembersContract> allFC = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FamilyMembersContract fc = new FamilyMembersContract();
                allFC.add(fc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<FormsContract> checkFormExist() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SA,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_APPVERSION,
                FormsTable.COLUMN_CLUSTERCODE,
                FormsTable.COLUMN_HHNO,
                FormsTable.COLUMN_STATUS,
                FormsTable.COLUMN_FORMTYPE,

        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<MWRAContract> getUnsyncedMWRA() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                MWRAContract.MWRATable.COLUMN_ID,
                MWRAContract.MWRATable.COLUMN_UID,
                MWRAContract.MWRATable.COLUMN_UUID,
                MWRAContract.MWRATable.COLUMN_FORMDATE,
                MWRAContract.MWRATable.COLUMN_USER,
                MWRAContract.MWRATable.COLUMN_SD,
                MWRAContract.MWRATable.COLUMN_DEVICEID,
                MWRAContract.MWRATable.COLUMN_DEVICETAGID
        };
        String whereClause = MWRAContract.MWRATable.COLUMN_SYNCED + " is null";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                MWRAContract.MWRATable.COLUMN_ID + " ASC";

        Collection<MWRAContract> allMC = new ArrayList<MWRAContract>();
        try {
            c = db.query(
                    MWRAContract.MWRATable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                MWRAContract mc = new MWRAContract();
                allMC.add(mc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allMC;
    }

    public Collection<FormsContract> getUnsyncedForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_ISTATUS88x,
                FormsTable.COLUMN_DSSID,
                FormsTable.COLUMN_NEXT_VISIT,
                FormsTable.COLUMN_ENDINGDATETIME,
                FormsTable.COLUMN_SA,
                FormsTable.COLUMN_TALUKA_CODE,
                FormsTable.COLUMN_UC_CODE,
                FormsTable.COLUMN_AREA_CODE,
                FormsTable.COLUMN_VILLAGE_CODE,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_APPVERSION,
                FormsTable.COLUMN_CLUSTERCODE,
                FormsTable.COLUMN_HHNO,
                FormsTable.COLUMN_STATUS,
                FormsTable.COLUMN_FORMTYPE
        };


        String whereClause = FormsTable.COLUMN_SYNCED + " is null";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<ChildContract> getUnsyncedChildForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleChild._ID,
                singleChild.COLUMN_UID,
                singleChild.COLUMN_UUID,
                singleChild.COLUMN_luid,
                singleChild.COLUMN_SERIAL_NO,
                singleChild.COLUMN_MOTHER_ID,
                singleChild.COLUMN_DA,
                singleChild.COLUMN_FORMDATE,
                singleChild.COLUMN_SYNCED,
                singleChild.COLUMN_SYNCED_DATE,
                singleChild.COLUMN_USER,
                singleChild.COLUMN_DEVICEID,
                singleChild.COLUMN_DEVICETAGID,

        };


        String whereClause = singleChild.COLUMN_SYNCED + " is null";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy =
                singleChild._ID + " ASC";

        Collection<ChildContract> allFC = new ArrayList<ChildContract>();
        try {
            c = db.query(
                    singleChild.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ChildContract fc = new ChildContract();
                allFC.add(fc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<ProblemContract> getUnsyncedProblemForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleProblem._ID,
                singleProblem.COLUMN_UID,
                singleProblem.COLUMN_UUID,
                singleProblem.COLUMN_CUID,
                singleProblem.COLUMN_PROBLEM_TYPE,
                singleProblem.COLUMN_SYNCED,
                singleProblem.COLUMN_SYNCED_DATE,
                singleProblem.COLUMN_DA,
                singleProblem.COLUMN_FORMDATE,
                singleProblem.COLUMN_USER,
                singleProblem.COLUMN_DEVICEID,
                singleProblem.COLUMN_DEVICETAGID,


        };


        String whereClause = singleProblem.COLUMN_SYNCED + " is null";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy =
                singleProblem._ID + " ASC";

        Collection<ProblemContract> allFC = new ArrayList<ProblemContract>();
        try {
            c = db.query(
                    singleProblem.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ProblemContract fc = new ProblemContract();
                allFC.add(fc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<DeceasedChildContract> getUnsyncedDeceasedChildForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleDeceasedChild._ID,
                singleDeceasedChild.COLUMN_luid,
                singleDeceasedChild.COLUMN_UID,
                singleDeceasedChild.COLUMN_SERIAL_NO,
                singleDeceasedChild.COLUMN_DA,
                singleDeceasedChild.COLUMN_FORMDATE,
                singleDeceasedChild.COLUMN_SYNCED,
                singleDeceasedChild.COLUMN_SYNCED_DATE,
                singleDeceasedChild.COLUMN_MOTHER_ID,
                singleDeceasedChild.COLUMN_USER,
                singleDeceasedChild.COLUMN_DEVICEID,
                singleDeceasedChild.COLUMN_DEVICETAGID,
                singleDeceasedChild.COLUMN_UUID,
                singleDeceasedChild.COLUMN_MUID,


        };


        String whereClause = singleDeceasedChild.COLUMN_SYNCED + " is null";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy =
                singleProblem._ID + " ASC";

        Collection<DeceasedChildContract> allFC = new ArrayList<DeceasedChildContract>();
        try {
            c = db.query(
                    singleDeceasedChild.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                DeceasedChildContract fc = new DeceasedChildContract();
                allFC.add(fc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<FormsContract> getTodayForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_DSSID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsTable.COLUMN_FORMDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                fc.set_ID(c.getString(c.getColumnIndex(FormsTable.COLUMN_ID)));
                fc.setLuid(c.getString(c.getColumnIndex(FormsTable.COLUMN_DSSID)));
                fc.setFormDate(c.getString(c.getColumnIndex(FormsTable.COLUMN_FORMDATE)));
                fc.setIstatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public int updateEnding() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_ISTATUS, MainApp.fc.getIstatus());
        values.put(FormsTable.COLUMN_ISTATUS88x, MainApp.fc.getIstatus88x());
//        values.put(FormsTable.COLUMN_NEXT_VISIT, MainApp.fc.getNextVisit());
//        values.put(FormsTable.COLUMN_STATUS, MainApp.fc.getStatus());
        values.put(FormsTable.COLUMN_ENDINGDATETIME, MainApp.fc.getEndingdatetime());


// Which row to update, based on the ID
        String selection = FormsTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updatesSA() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SA, MainApp.fc.getsA());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    // ANDROID DATABASE MANAGER
    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }
}