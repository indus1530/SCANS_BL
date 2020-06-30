package edu.aku.hassannaqvi.uen_scans_bl.utils;

import edu.aku.hassannaqvi.uen_scans_bl.contracts.AnthroContract.SingleAnthro;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.BLRandomContract.SingleRandomHH;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.ChildContract;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.ChildContract.ChildTable;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.DentalContract;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.EnumBlockContract;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FoodFreqContract.SingleFoodFreq;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.HbContract.hbTable;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.IndexMWRAContract.MWRATable;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.UsersContract;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.VersionAppContract;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.VisionContract;

public final class CreateTable {

    public static final String DATABASE_NAME = "scans20.db";
    public static final String DB_NAME = "scans20_copy.db";
    public static final String PROJECT_NAME = "DMU-UENSCANS2020";
    public static final int DATABASE_VERSION = 2;

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

    public static final String SQL_CREATE_HB = "CREATE TABLE " + hbTable.TABLE_NAME + "("
            + hbTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + hbTable.COLUMN_UID + " TEXT,"
            + hbTable.COLUMN__UUID + " TEXT,"
            + hbTable.COLUMN_FORMDATE + " TEXT,"
            + hbTable.COLUMN_DEVICEID + " TEXT,"
            + hbTable.COLUMN_USER + " TEXT,"
            + hbTable.COLUMN_SE2 + " TEXT,"
            + hbTable.COLUMN_DEVICETAGID + " TEXT,"
            + hbTable.COLUMN_SYNCED + " TEXT,"
            + hbTable.COLUMN_SYNCED_DATE + " TEXT );";

    public static final String SQL_CREATE_CHILD_TABLE = "CREATE TABLE " + ChildTable.TABLE_NAME + "("
            + ChildContract.ChildTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ChildTable.COLUMN_UID + " TEXT,"
            + ChildTable.COLUMN__UUID + " TEXT,"
            + ChildTable.COLUMN_DEVICEID + " TEXT,"
            + ChildTable.COLUMN_FORMDATE + " TEXT,"
            + ChildContract.ChildTable.COLUMN_USER + " TEXT,"
            + ChildContract.ChildTable.COLUMN_SC1 + " TEXT,"
            + ChildTable.COLUMN_SC2 + " TEXT,"
            + ChildTable.COLUMN_SC3 + " TEXT,"
            + ChildTable.COLUMN_SC4 + " TEXT,"
            + ChildTable.COLUMN_SC5 + " TEXT,"
            + ChildTable.COLUMN_SC6 + " TEXT,"
            + ChildTable.COLUMN_SL + " TEXT,"
            + ChildTable.COLUMN_SM + " TEXT,"
            + ChildTable.COLUMN_SK1 + " TEXT,"
            + ChildTable.COLUMN_DEVICETAGID + " TEXT,"
            + ChildTable.COLUMN_SYNCED + " TEXT,"
            + ChildTable.COLUMN_SYNCED_DATE + " TEXT );";


    public static final String SQL_CREATE_ANTHRO = "CREATE TABLE " + SingleAnthro.TABLE_NAME + "("
            + SingleAnthro._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SingleAnthro.COLUMN_UID + " TEXT,"
            + SingleAnthro.COLUMN__UUID + " TEXT,"
            + SingleAnthro.COLUMN_DEVICEID + " TEXT,"
            + SingleAnthro.COLUMN_FORMDATE + " TEXT,"
            + SingleAnthro.COLUMN_USER + " TEXT,"
            + SingleAnthro.COLUMN_SK1 + " TEXT,"
            + SingleAnthro.COLUMN_FORMTYPE + " TEXT,"
            + SingleAnthro.COLUMN_DEVICETAGID + " TEXT,"
            + SingleAnthro.COLUMN_ISTATUS + " TEXT,"
            + SingleAnthro.COLUMN_SYNCED + " TEXT,"
            + SingleAnthro.COLUMN_SYNCED_DATE + " TEXT );";


    public static final String SQL_CREATE_FAMILY_MEMBERS = "CREATE TABLE " + FamilyMembersContract.SingleMember.TABLE_NAME + "("
            + FamilyMembersContract.SingleMember.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FamilyMembersContract.SingleMember.COLUMN_UID + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_UUID + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_LUID + " TEXT," +
            FamilyMembersContract.SingleMember.COLUMN_KISH_SELECTED + " TEXT," +
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


    public static final String SQL_CREATE_VISION = "CREATE TABLE " + VisionContract.visionTable.TABLE_NAME + "("
            + VisionContract.visionTable.COLUMN__ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + VisionContract.visionTable.COLUMN_UID + " TEXT,"
            + VisionContract.visionTable.COLUMN__UUID + " TEXT,"
            + VisionContract.visionTable.COLUMN_DEVICEID + " TEXT,"
            + VisionContract.visionTable.COLUMN_FORMDATE + " TEXT,"
            + VisionContract.visionTable.COLUMN_USER + " TEXT,"
            + VisionContract.visionTable.COLUMN_SE2 + " TEXT,"
            + VisionContract.visionTable.COLUMN_DEVICETAGID + " TEXT,"
            + VisionContract.visionTable.COLUMN_SYNCED + " TEXT,"
            + VisionContract.visionTable.COLUMN_SYNCED_DATE + " TEXT );";


    public static final String SQL_CREATE_DENTAL = "CREATE TABLE " + DentalContract.DentalTable.TABLE_NAME + "("
            + DentalContract.DentalTable.COLUMN__ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + DentalContract.DentalTable.COLUMN_UID + " TEXT,"
            + DentalContract.DentalTable.COLUMN_UUID + " TEXT,"
            + DentalContract.DentalTable.COLUMN_DEVICEID + " TEXT,"
            + DentalContract.DentalTable.COLUMN_FORMDATE + " TEXT,"
            + DentalContract.DentalTable.COLUMN_USER + " TEXT,"
            + DentalContract.DentalTable.COLUMN_SE2 + " TEXT,"
            + DentalContract.DentalTable.COLUMN_DEVICETAGID + " TEXT,"
            + DentalContract.DentalTable.COLUMN_SYNCED + " TEXT,"
            + DentalContract.DentalTable.COLUMN_SYNCED_DATE + " TEXT );";

}
