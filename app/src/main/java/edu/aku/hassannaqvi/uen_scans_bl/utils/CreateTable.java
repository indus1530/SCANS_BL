package edu.aku.hassannaqvi.uen_scans_bl.utils;

import edu.aku.hassannaqvi.uen_scans_bl.contracts.AnthroContract.SingleAnthro;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.BLRandomContract.SingleRandomHH;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.ChildContract.SingleChild;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.EnumBlockContract;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FoodFreqContract.SingleFoodFreq;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.MWRAContract.MWRATable;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.MWRA_PREContract.SingleMWRAPRE;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.UsersContract;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.VersionAppContract;

public final class CreateTable {

    public static final String DATABASE_NAME = "uen_ml20.db";
    public static final String DB_NAME = "uen_ml20_copy.db";
    public static final String PROJECT_NAME = "DMU-UENML2020";
    public static final int DATABASE_VERSION = 1;

    public static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsContract.FormsTable.TABLE_NAME + "("
            + FormsContract.FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsContract.FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_UID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_FORMDATE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_APPVERSION + " TEXT,"
            + FormsContract.FormsTable.COLUMN_CLUSTERCODE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_HHNO + " TEXT,"
            + FormsContract.FormsTable.COLUMN_FORMTYPE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_LUID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_USER + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SINFO + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SA3 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SA4 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SN + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SO + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ISTATUS + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ISTATUS88x + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ENDINGDATETIME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSLAT + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSLNG + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSDATE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSACC + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DEVICEID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DEVICETAGID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED_DATE + " TEXT"
            + " );";

    public static final String SQL_CREATE_USERS = "CREATE TABLE " + UsersContract.SingleUser.TABLE_NAME + "("
            + UsersContract.SingleUser._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersContract.SingleUser.ROW_USERNAME + " TEXT,"
            + UsersContract.SingleUser.ROW_PASSWORD + " TEXT,"
            + UsersContract.SingleUser.DIST_ID + " TEXT"
            + " );";

    public static final String SQL_CREATE_VERSIONAPP = "CREATE TABLE " + VersionAppContract.VersionAppTable.TABLE_NAME + " (" +
            VersionAppContract.VersionAppTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_PATH_NAME + " TEXT " +
            ");";
/*
    public static final String SQL_CREATE_TALUKAS = "CREATE TABLE " + TalukasContract.singleTalukas.TABLE_NAME + "("
            + TalukasContract.singleTalukas._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TalukasContract.singleTalukas.COLUMN_TALUKA_CODE + " TEXT,"
            + TalukasContract.singleTalukas.COLUMN_TALUKA + " TEXT );";


    public static final String SQL_CREATE_UCS = "CREATE TABLE " + UCsContract.singleUCs.TABLE_NAME + "("
            + UCsContract.singleUCs._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UCsContract.singleUCs.COLUMN_UCCODE + " TEXT,"
            + UCsContract.singleUCs.COLUMN_TALUKA_CODE + " TEXT,"
            + UCsContract.singleUCs.COLUMN_UCS + " TEXT );";


    public static final String SQL_CREATE_AREAS = "CREATE TABLE " + AreasContract.singleAreas.TABLE_NAME + "("
            + AreasContract.singleAreas._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + AreasContract.singleAreas.COLUMN_AREACODE + " TEXT,"
            + AreasContract.singleAreas.COLUMN_UC_CODE + " TEXT,"
            + AreasContract.singleAreas.COLUMN_AREA + " TEXT );";*/

    public static final String SQL_CREATE_BL_RANDOM = "CREATE TABLE " + SingleRandomHH.TABLE_NAME + "("
            + SingleRandomHH.COLUMN_ID + " TEXT,"
            + SingleRandomHH.COLUMN_ENUM_BLOCK_CODE + " TEXT,"
            + SingleRandomHH.COLUMN_LUID + " TEXT,"
            + SingleRandomHH.COLUMN_HH + " TEXT,"
            + SingleRandomHH.COLUMN_STRUCTURE_NO + " TEXT,"
            + SingleRandomHH.COLUMN_FAMILY_EXT_CODE + " TEXT,"
            + SingleRandomHH.COLUMN_HH_HEAD + " TEXT,"
            + SingleRandomHH.COLUMN_CONTACT + " TEXT,"
            + SingleRandomHH.COLUMN_HH_SELECTED_STRUCT + " TEXT,"
            + SingleRandomHH.COLUMN_RANDOMDT + " TEXT,"
            + SingleRandomHH.COLUMN_SNO_HH + " TEXT );";

    public static final String SQL_CREATE_PSU_TABLE = "CREATE TABLE " + EnumBlockContract.EnumBlockTable.TABLE_NAME + " (" +
            EnumBlockContract.EnumBlockTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            EnumBlockContract.EnumBlockTable.COLUMN_DIST_ID + " TEXT, " +
            EnumBlockContract.EnumBlockTable.COLUMN_GEO_AREA + " TEXT, " +
            EnumBlockContract.EnumBlockTable.COLUMN_CLUSTER_AREA + " TEXT " +
            ");";

    public static final String SQL_CREATE_KISH_TABLE = "CREATE TABLE " + SingleFoodFreq.TABLE_NAME + "("
            + SingleFoodFreq._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SingleFoodFreq.COLUMN_UID + " TEXT,"
            + SingleFoodFreq.COLUMN__UUID + " TEXT,"
            + SingleFoodFreq.COLUMN_DEVICEID + " TEXT,"
            + SingleFoodFreq.COLUMN_FORMDATE + " TEXT,"
            + SingleFoodFreq.COLUMN_USER + " TEXT,"
            + SingleFoodFreq.COLUMN_SD1 + " TEXT,"
            + SingleFoodFreq.COLUMN_SD2 + " TEXT,"
            + SingleFoodFreq.COLUMN_SD3 + " TEXT,"
            + SingleFoodFreq.COLUMN_SD4 + " TEXT,"
            + SingleFoodFreq.COLUMN_SD5 + " TEXT,"
            + SingleFoodFreq.COLUMN_SD6 + " TEXT,"
            + SingleFoodFreq.COLUMN_SD7 + " TEXT,"
            + SingleFoodFreq.COLUMN_SD8 + " TEXT,"
            + SingleFoodFreq.COLUMN_SD9 + " TEXT,"
            + SingleFoodFreq.COLUMN_DEVICETAGID + " TEXT,"
            + SingleFoodFreq.COLUMN_SYNCED + " TEXT,"
            + SingleFoodFreq.COLUMN_SYNCED_DATE + " TEXT );";

    public static final String SQL_CREATE_MWRA_TABLE = "CREATE TABLE " + MWRATable.TABLE_NAME + "("
            + MWRATable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MWRATable.COLUMN_UID + " TEXT,"
            + MWRATable.COLUMN_UUID + " TEXT,"
            + MWRATable.COLUMN_FORMDATE + " TEXT,"
            + MWRATable.COLUMN_DEVICEID + " TEXT,"
            + MWRATable.COLUMN_USER + " TEXT,"
            + MWRATable.COLUMN_SB1 + " TEXT,"
            + MWRATable.COLUMN_SB2 + " TEXT,"
            + MWRATable.COLUMN_SB3 + " TEXT,"
            + MWRATable.COLUMN_DEVICETAGID + " TEXT,"
            + MWRATable.COLUMN_SYNCED + " TEXT,"
            + MWRATable.COLUMN_SYNCED_DATE + " TEXT );";

    public static final String SQL_CREATE_MWRAPRE_TABLE = "CREATE TABLE " + SingleMWRAPRE.TABLE_NAME + "("
            + SingleMWRAPRE._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SingleMWRAPRE.COLUMN_UID + " TEXT,"
            + SingleMWRAPRE.COLUMN__UUID + " TEXT,"
            + SingleMWRAPRE.COLUMN_FORMDATE + " TEXT,"
            + SingleMWRAPRE.COLUMN_DEVICEID + " TEXT,"
            + SingleMWRAPRE.COLUMN_USER + " TEXT,"
            + SingleMWRAPRE.COLUMN_SE2 + " TEXT,"
            + SingleMWRAPRE.COLUMN_DEVICETAGID + " TEXT,"
            + SingleMWRAPRE.COLUMN_SYNCED + " TEXT,"
            + SingleMWRAPRE.COLUMN_SYNCED_DATE + " TEXT );";

    public static final String SQL_CREATE_CHILD_TABLE = "CREATE TABLE " + SingleChild.TABLE_NAME + "("
            + SingleChild._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SingleChild.COLUMN_UID + " TEXT,"
            + SingleChild.COLUMN__UUID + " TEXT,"
            + SingleChild.COLUMN_DEVICEID + " TEXT,"
            + SingleChild.COLUMN_FORMDATE + " TEXT,"
            + SingleChild.COLUMN_USER + " TEXT,"
            + SingleChild.COLUMN_SC1 + " TEXT,"
            + SingleChild.COLUMN_SC2 + " TEXT,"
            + SingleChild.COLUMN_SC3 + " TEXT,"
            + SingleChild.COLUMN_SC4 + " TEXT,"
            + SingleChild.COLUMN_SC5 + " TEXT,"
            + SingleChild.COLUMN_SC6 + " TEXT,"
            + SingleChild.COLUMN_SL + " TEXT,"
            + SingleChild.COLUMN_SM + " TEXT,"
            + SingleChild.COLUMN_SK1 + " TEXT,"
            + SingleChild.COLUMN_DEVICETAGID + " TEXT,"
            + SingleChild.COLUMN_SYNCED + " TEXT,"
            + SingleChild.COLUMN_SYNCED_DATE + " TEXT );";


    public static final String SQL_CREATE_MORTALITY = "CREATE TABLE " + SingleAnthro.TABLE_NAME + "("
            + SingleAnthro._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SingleAnthro.COLUMN_UID + " TEXT,"
            + SingleAnthro.COLUMN__UUID + " TEXT,"
            + SingleAnthro.COLUMN_DEVICEID + " TEXT,"
            + SingleAnthro.COLUMN_FORMDATE + " TEXT,"
            + SingleAnthro.COLUMN_USER + " TEXT,"
            + SingleAnthro.COLUMN_SK1 + " TEXT,"
            + SingleAnthro.COLUMN_DEVICETAGID + " TEXT,"
            + SingleAnthro.COLUMN_ISTATUS + " TEXT,"
            + SingleAnthro.COLUMN_SYNCED + " TEXT,"
            + SingleAnthro.COLUMN_SYNCED_DATE + " TEXT );";


    public static final String SQL_CREATE_FAMILY_MEMBERS = "CREATE TABLE " + FamilyMembersContract.SingleMember.TABLE_NAME + "("
            + FamilyMembersContract.SingleMember.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FamilyMembersContract.SingleMember.COLUMN_UID + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_UUID + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_FORMDATE + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_CLUSTERNO + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_HHNO + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_SERIAL_NO + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_NAME + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_RELATION_HH + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_AGE + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_MOTHER_NAME + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_MOTHER_SERIAL + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_GENDER + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_MARITAL + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_SD + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_SYNCED + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_SYNCED_DATE + " TEXT"
            + ");";

}
