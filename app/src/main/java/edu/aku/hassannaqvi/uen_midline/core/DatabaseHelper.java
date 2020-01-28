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

import edu.aku.hassannaqvi.uen_midline.contracts.AreasContract;
import edu.aku.hassannaqvi.uen_midline.contracts.AreasContract.singleAreas;
import edu.aku.hassannaqvi.uen_midline.contracts.BLRandomContract;
import edu.aku.hassannaqvi.uen_midline.contracts.BLRandomContract.SingleRandomHH;
import edu.aku.hassannaqvi.uen_midline.contracts.ChildContract;
import edu.aku.hassannaqvi.uen_midline.contracts.ChildContract.SingleChild;
import edu.aku.hassannaqvi.uen_midline.contracts.EnumBlockContract;
import edu.aku.hassannaqvi.uen_midline.contracts.EnumBlockContract.EnumBlockTable;
import edu.aku.hassannaqvi.uen_midline.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_midline.contracts.FamilyMembersContract.SingleMember;
import edu.aku.hassannaqvi.uen_midline.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_midline.contracts.FormsContract.FormsTable;
import edu.aku.hassannaqvi.uen_midline.contracts.KishMWRAContract;
import edu.aku.hassannaqvi.uen_midline.contracts.KishMWRAContract.SingleKishMWRA;
import edu.aku.hassannaqvi.uen_midline.contracts.MWRAContract;
import edu.aku.hassannaqvi.uen_midline.contracts.MWRAContract.MWRATable;
import edu.aku.hassannaqvi.uen_midline.contracts.MWRA_PREContract;
import edu.aku.hassannaqvi.uen_midline.contracts.MWRA_PREContract.SingleMWRAPRE;
import edu.aku.hassannaqvi.uen_midline.contracts.MortalityContract;
import edu.aku.hassannaqvi.uen_midline.contracts.MortalityContract.SingleMortality;
import edu.aku.hassannaqvi.uen_midline.contracts.TalukasContract;
import edu.aku.hassannaqvi.uen_midline.contracts.UCsContract;
import edu.aku.hassannaqvi.uen_midline.contracts.UsersContract;
import edu.aku.hassannaqvi.uen_midline.contracts.VersionAppContract;
import edu.aku.hassannaqvi.uen_midline.contracts.VillagesContract;
import edu.aku.hassannaqvi.uen_midline.contracts.VillagesContract.SingleVillage;

import static edu.aku.hassannaqvi.uen_midline.utils.CreateTable.DATABASE_NAME;
import static edu.aku.hassannaqvi.uen_midline.utils.CreateTable.DATABASE_VERSION;
import static edu.aku.hassannaqvi.uen_midline.utils.CreateTable.SQL_CREATE_AREAS;
import static edu.aku.hassannaqvi.uen_midline.utils.CreateTable.SQL_CREATE_CHILD_TABLE;
import static edu.aku.hassannaqvi.uen_midline.utils.CreateTable.SQL_CREATE_FAMILY_MEMBERS;
import static edu.aku.hassannaqvi.uen_midline.utils.CreateTable.SQL_CREATE_FORMS;
import static edu.aku.hassannaqvi.uen_midline.utils.CreateTable.SQL_CREATE_KISH_TABLE;
import static edu.aku.hassannaqvi.uen_midline.utils.CreateTable.SQL_CREATE_MORTALITY;
import static edu.aku.hassannaqvi.uen_midline.utils.CreateTable.SQL_CREATE_MWRAPRE_TABLE;
import static edu.aku.hassannaqvi.uen_midline.utils.CreateTable.SQL_CREATE_MWRA_TABLE;
import static edu.aku.hassannaqvi.uen_midline.utils.CreateTable.SQL_CREATE_PSU_TABLE;
import static edu.aku.hassannaqvi.uen_midline.utils.CreateTable.SQL_CREATE_TALUKAS;
import static edu.aku.hassannaqvi.uen_midline.utils.CreateTable.SQL_CREATE_UCS;
import static edu.aku.hassannaqvi.uen_midline.utils.CreateTable.SQL_CREATE_USERS;
import static edu.aku.hassannaqvi.uen_midline.utils.CreateTable.SQL_CREATE_VERSIONAPP;


/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String SQL_DELETE_VILLAGES = "DROP TABLE IF EXISTS " + SingleVillage.TABLE_NAME;
    private static final String SQL_DELETE_TALUKAS = "DROP TABLE IF EXISTS " + TalukasContract.singleTalukas.TABLE_NAME;
    private static final String SQL_DELETE_UCS = "DROP TABLE IF EXISTS " + UCsContract.singleUCs.TABLE_NAME;
    private static final String SQL_DELETE_AREAS = "DROP TABLE IF EXISTS " + singleAreas.TABLE_NAME;

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
        db.execSQL(SQL_CREATE_PSU_TABLE);
        db.execSQL(SQL_CREATE_AREAS);
        db.execSQL(SQL_CREATE_VERSIONAPP);
        db.execSQL(SQL_CREATE_FAMILY_MEMBERS);
        db.execSQL(SQL_CREATE_KISH_TABLE);
        db.execSQL(SQL_CREATE_MWRA_TABLE);
        db.execSQL(SQL_CREATE_MWRAPRE_TABLE);
        db.execSQL(SQL_CREATE_CHILD_TABLE);
        db.execSQL(SQL_CREATE_MORTALITY);
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

    public void syncVillages(JSONArray pcList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(SingleVillage.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = pcList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectPSU = jsonArray.getJSONObject(i);

                VillagesContract vc = new VillagesContract();
                vc.sync(jsonObjectPSU);
                Log.i(TAG, "syncVillages: " + jsonObjectPSU.toString());

                ContentValues values = new ContentValues();

                values.put(SingleVillage.COLUMN_AREA_CODE, vc.getAreaCode());
                values.put(SingleVillage.COLUMN_VILLAGE_CODE, vc.getVillagecode());
                values.put(SingleVillage.COLUMN_VILLAGE_NAME, vc.getVillagename());

                db.insert(SingleVillage.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {

        }
    }

    public void syncEnumBlocks(JSONArray Enumlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(EnumBlockContract.EnumBlockTable.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = Enumlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                EnumBlockContract Vc = new EnumBlockContract();
                Vc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(EnumBlockContract.EnumBlockTable.COLUMN_COUNTRY_ID, Vc.getEbcode());
                values.put(EnumBlockContract.EnumBlockTable.COLUMN_GEO_AREA, Vc.getGeoarea());
                values.put(EnumBlockContract.EnumBlockTable.COLUMN_CLUSTER_AREA, Vc.getCluster());

                db.insert(EnumBlockContract.EnumBlockTable.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
        } finally {
            db.close();
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

    public void syncBLRandom(JSONArray BLlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(SingleRandomHH.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = BLlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                BLRandomContract Vc = new BLRandomContract();
                Vc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(SingleRandomHH.COLUMN_ID, Vc.get_ID());
                values.put(SingleRandomHH.COLUMN_LUID, Vc.getLUID());
                values.put(SingleRandomHH.COLUMN_STRUCTURE_NO, Vc.getStructure());
                values.put(SingleRandomHH.COLUMN_FAMILY_EXT_CODE, Vc.getExtension());
                values.put(SingleRandomHH.COLUMN_HH, Vc.getHh());
                values.put(SingleRandomHH.COLUMN_ENUM_BLOCK_CODE, Vc.getSubVillageCode());
                values.put(SingleRandomHH.COLUMN_RANDOMDT, Vc.getRandomDT());
                values.put(SingleRandomHH.COLUMN_HH_HEAD, Vc.getHhhead());
                values.put(SingleRandomHH.COLUMN_CONTACT, Vc.getContact());
                values.put(SingleRandomHH.COLUMN_HH_SELECTED_STRUCT, Vc.getSelStructure());
                values.put(SingleRandomHH.COLUMN_SNO_HH, Vc.getSno());

                db.insert(SingleRandomHH.TABLE_NAME, null, values);
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
                SingleVillage.COLUMN_AREA_CODE,
                SingleVillage.COLUMN_VILLAGE_CODE,
                SingleVillage.COLUMN_VILLAGE_NAME,

        };

        String whereClause = SingleVillage.COLUMN_AREA_CODE + "=?";
        String[] whereArgs = new String[]{String.valueOf(areaCode)};
        String groupBy = null;
        String having = null;

        String orderBy =
                SingleVillage.COLUMN_VILLAGE_NAME + " ASC";

        Collection<VillagesContract> allAC = new ArrayList<>();
        try {
            c = db.query(
                    SingleVillage.TABLE_NAME,  // The table to query
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
        values.put(FormsTable.COLUMN_LUID, fc.getLuid());
        values.put(FormsTable.COLUMN_USER, fc.getUser());
        values.put(FormsTable.COLUMN_ISTATUS, fc.getIstatus());
        values.put(FormsTable.COLUMN_ISTATUS88x, fc.getIstatus88x());
        values.put(FormsTable.COLUMN_ENDINGDATETIME, fc.getEndingdatetime());
        values.put(FormsTable.COLUMN_SINFO, fc.getsInfo());
        values.put(FormsTable.COLUMN_SE, fc.getsE());
        values.put(FormsTable.COLUMN_SM, fc.getsM());
        values.put(FormsTable.COLUMN_SN, fc.getsN());
        values.put(FormsTable.COLUMN_SO, fc.getsO());
        values.put(FormsTable.COLUMN_GPSLAT, fc.getGpsLat());
        values.put(FormsTable.COLUMN_GPSLNG, fc.getGpsLng());
        values.put(FormsTable.COLUMN_GPSDATE, fc.getGpsDT());
        values.put(FormsTable.COLUMN_GPSACC, fc.getGpsAcc());
        values.put(FormsTable.COLUMN_DEVICETAGID, fc.getDevicetagID());
        values.put(FormsTable.COLUMN_DEVICEID, fc.getDeviceID());
        values.put(FormsTable.COLUMN_APPVERSION, fc.getAppversion());
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
        values.put(SingleMember.COLUMN_ID, fmc.get_id());
        values.put(SingleMember.COLUMN_UID, fmc.getUid());
        values.put(SingleMember.COLUMN_UUID, fmc.getUuid());
        values.put(FamilyMembersContract.SingleMember.COLUMN_FORMDATE, fmc.getFormdate());
        values.put(FamilyMembersContract.SingleMember.COLUMN_CLUSTERNO, fmc.getClusterno());
        values.put(FamilyMembersContract.SingleMember.COLUMN_HHNO, fmc.getHhno());
        values.put(FamilyMembersContract.SingleMember.COLUMN_SERIAL_NO, fmc.getSerialno());
        values.put(SingleMember.COLUMN_NAME, fmc.getName());
        values.put(SingleMember.COLUMN_RELATION_HH, fmc.getRelHH());
        values.put(SingleMember.COLUMN_AGE, fmc.getAge());
        values.put(SingleMember.COLUMN_MOTHER_NAME, fmc.getMother_name());
        values.put(SingleMember.COLUMN_MOTHER_SERIAL, fmc.getMother_serial());
        values.put(FamilyMembersContract.SingleMember.COLUMN_GENDER, fmc.getGender());
        values.put(SingleMember.COLUMN_MARITAL, fmc.getMarital());
        values.put(SingleMember.COLUMN_SD, fmc.getsD());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                SingleMember.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addMortality(MortalityContract morc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(SingleMortality.COLUMN__UUID, morc.get_UUID());
        values.put(SingleMortality.COLUMN_DEVICEID, morc.getDeviceId());
        values.put(SingleMortality.COLUMN_DEVICETAGID, morc.getDevicetagID());
        values.put(SingleMortality.COLUMN_FORMDATE, morc.getFormDate());
        values.put(SingleMortality.COLUMN_USER, morc.getUser());
        values.put(SingleMortality.COLUMN_SE3, morc.getsE3());
        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                SingleMortality.TABLE_NAME,
                SingleMortality.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addKishMWRA(KishMWRAContract kishmwra) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(SingleKishMWRA.COLUMN_UID, kishmwra.getUID());

        values.put(SingleKishMWRA.COLUMN__UUID, kishmwra.get_UUID());
        values.put(SingleKishMWRA.COLUMN_DEVICEID, kishmwra.getDeviceId());
        values.put(SingleKishMWRA.COLUMN_FORMDATE, kishmwra.getFormDate());
        values.put(SingleKishMWRA.COLUMN_USER, kishmwra.getUser());
        values.put(SingleKishMWRA.COLUMN_SF, kishmwra.getsF());
        values.put(SingleKishMWRA.COLUMN_SG, kishmwra.getsG());
        values.put(SingleKishMWRA.COLUMN_SH1, kishmwra.getsH1());
        values.put(SingleKishMWRA.COLUMN_SH2, kishmwra.getsH2());
        values.put(SingleKishMWRA.COLUMN_SK, kishmwra.getsK());
        values.put(SingleKishMWRA.COLUMN_SL, kishmwra.getsL());
        values.put(SingleKishMWRA.COLUMN_DEVICETAGID, kishmwra.getDevicetagID());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                SingleKishMWRA.TABLE_NAME,
                SingleKishMWRA.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addMWRA(MWRAContract mwra) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
//        values.put(MWRATable._ID, mwra.get_ID());
        values.put(MWRATable.COLUMN_UUID, mwra.get_UUID());
        values.put(MWRATable.COLUMN_DEVICEID, mwra.getDeviceId());
        values.put(MWRATable.COLUMN_FORMDATE, mwra.getFormDate());
        values.put(MWRATable.COLUMN_USER, mwra.getUser());
        values.put(MWRATable.COLUMN_DEVICETAGID, mwra.getDevicetagID());
        values.put(MWRATable.COLUMN_SE1, mwra.getsE1());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                MWRATable.TABLE_NAME,
                null,
                values);
        return newRowId;
    }

    public Long addChild(ChildContract childContract) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
//        values.put(MWRATable._ID, mwra.get_ID());
        values.put(SingleChild.COLUMN__UUID, childContract.get_UUID());
        values.put(SingleChild.COLUMN_DEVICEID, childContract.get_UUID());
        values.put(SingleChild.COLUMN_FORMDATE, childContract.get_UUID());
        values.put(SingleChild.COLUMN_USER, childContract.get_UUID());
        values.put(SingleChild.COLUMN_SI1, childContract.getsI1());
        values.put(SingleChild.COLUMN_DEVICETAGID, childContract.getDevicetagID());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                SingleChild.TABLE_NAME,
                null,
                values);
        return newRowId;
    }

    public Long addPregnantMWRA(MWRA_PREContract mwra) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
//        values.put(MWRATable._ID, mwra.get_ID());
        values.put(MWRATable.COLUMN_UUID, mwra.get_UUID());
        values.put(MWRATable.COLUMN_DEVICEID, mwra.getDeviceId());
        values.put(MWRATable.COLUMN_FORMDATE, mwra.getFormDate());
        values.put(MWRATable.COLUMN_USER, mwra.getUser());
        values.put(MWRATable.COLUMN_DEVICETAGID, mwra.getDevicetagID());
        values.put(MWRATable.COLUMN_SE1, mwra.getsE2());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                MWRATable.TABLE_NAME,
                MWRATable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public FormsContract isDataExists(String studyId) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = null;

// New value for one column
        String[] columns = {
                FormsTable.COLUMN_LUID,
                FormsTable.COLUMN_ISTATUS,

        };

// Which row to update, based on the ID
        String selection = FormsTable.COLUMN_LUID + " = ? AND "
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
                allFC.setLuid(c.getString(c.getColumnIndex(FormsTable.COLUMN_LUID)));
                allFC.setIstatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
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

    public Collection<FormsContract> getAllForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SINFO,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_APPVERSION,
                FormsTable.COLUMN_CLUSTERCODE,
                FormsTable.COLUMN_HHNO,
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
                FamilyMembersContract.SingleMember.COLUMN_ID,
                SingleMember.COLUMN_UID,
                SingleMember.COLUMN_UUID,
                FamilyMembersContract.SingleMember.COLUMN_FORMDATE,
                FamilyMembersContract.SingleMember.COLUMN_CLUSTERNO,
                SingleMember.COLUMN_HHNO,
                SingleMember.COLUMN_SERIAL_NO,
                SingleMember.COLUMN_NAME,
                SingleMember.COLUMN_RELATION_HH,
                SingleMember.COLUMN_AGE,
                FamilyMembersContract.SingleMember.COLUMN_MOTHER_NAME,
                SingleMember.COLUMN_MOTHER_SERIAL,
                SingleMember.COLUMN_GENDER,
                FamilyMembersContract.SingleMember.COLUMN_MARITAL,
                FamilyMembersContract.SingleMember.COLUMN_SD,
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
                FormsTable.COLUMN_SINFO,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_APPVERSION,
                FormsTable.COLUMN_CLUSTERCODE,
                FormsTable.COLUMN_HHNO,
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
                MWRAContract.MWRATable.COLUMN_SE1,
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
                FormsTable.COLUMN_LUID,
                FormsTable.COLUMN_ENDINGDATETIME,
                FormsTable.COLUMN_SINFO,
                FormsTable.COLUMN_SE,
                FormsTable.COLUMN_SM,
                FormsTable.COLUMN_SN,
                FormsTable.COLUMN_SO,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_APPVERSION,
                FormsTable.COLUMN_CLUSTERCODE,
                FormsTable.COLUMN_HHNO,
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

    public Collection<FormsContract> getTodayForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_LUID,
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
                fc.setLuid(c.getString(c.getColumnIndex(FormsTable.COLUMN_LUID)));
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
//        values.put(FormsTable.COLUMN_SE, MainApp.fc.getsE());
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

    //Get BLRandom data
    public BLRandomContract getHHFromBLRandom(String subAreaCode, String hh) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                SingleRandomHH.COLUMN_ID,
                SingleRandomHH.COLUMN_LUID,
                SingleRandomHH.COLUMN_STRUCTURE_NO,
                SingleRandomHH.COLUMN_FAMILY_EXT_CODE,
                SingleRandomHH.COLUMN_HH,
                SingleRandomHH.COLUMN_ENUM_BLOCK_CODE,
                SingleRandomHH.COLUMN_RANDOMDT,
                SingleRandomHH.COLUMN_HH_SELECTED_STRUCT,
                SingleRandomHH.COLUMN_CONTACT,
                SingleRandomHH.COLUMN_HH_HEAD,
                SingleRandomHH.COLUMN_SNO_HH
        };

        String whereClause = SingleRandomHH.COLUMN_ENUM_BLOCK_CODE + "=? AND " + SingleRandomHH.COLUMN_HH + "=?";
        String[] whereArgs = new String[]{subAreaCode, hh};
        String groupBy = null;
        String having = null;

        String orderBy =
                SingleRandomHH.COLUMN_ID + " ASC";

        BLRandomContract allBL = null;
        try {
            c = db.query(
                    SingleRandomHH.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allBL = new BLRandomContract().hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allBL;
    }

    //Get EnumBlock
    public EnumBlockContract getEnumBlock(String cluster) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                EnumBlockTable._ID,
                EnumBlockTable.COLUMN_COUNTRY_ID,
                EnumBlockTable.COLUMN_GEO_AREA,
                EnumBlockTable.COLUMN_CLUSTER_AREA
        };

        String whereClause = EnumBlockTable.COLUMN_CLUSTER_AREA + " =?";
        String[] whereArgs = new String[]{cluster};
        String groupBy = null;
        String having = null;

        String orderBy = EnumBlockTable._ID + " ASC";
        EnumBlockContract allEB = null;
        try {
            c = db.query(
                    EnumBlockTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allEB = new EnumBlockContract().HydrateEnum(c);
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

    //Generic update FormColumn
    public int updatesFormColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    //Generic update FamilyMemberColumn
    public int updatesFamilyMemberColumn(String column, String value, String valueID) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = SingleMember._ID + " =? ";
        String[] selectionArgs = {String.valueOf(valueID)};

        return db.update(FamilyMembersContract.SingleMember.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    //Generic update MWRAPREColumn
    public int updatesMWRAPREColumn(MWRA_PREContract mwra_pre) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(SingleMWRAPRE.COLUMN_UID, mwra_pre.getUID());

        String selection = SingleMWRAPRE._ID + " =? ";
        String[] selectionArgs = {String.valueOf(mwra_pre.get_ID())};

        return db.update(SingleMWRAPRE.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    //Generic update MortalityColumn
    public int updatesMortalityColumn(String column, String value, MortalityContract mortality) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = SingleMortality._ID + " =? ";
        String[] selectionArgs = {String.valueOf(mortality.get_ID())};

        return db.update(SingleMortality.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    //Generic update KishMWRAColumn
    public int updatesKishMWRAColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = SingleKishMWRA._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.kish.get_ID())};

        return db.update(SingleKishMWRA.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    //Generic update MWRAColumn
    public int updateMWRAUID(MWRAContract mwra) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(MWRATable.COLUMN_UID, mwra.getUID());

        String selection = MWRATable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(mwra.get_ID())};

        return db.update(MWRATable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    //Generic update ChildColumn
    public int updatesChildColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = SingleChild._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.child.get_ID())};

        return db.update(SingleChild.TABLE_NAME,
                values,
                selection,
                selectionArgs);
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