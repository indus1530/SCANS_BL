package edu.aku.hassannaqvi.uen_midline.utils;

import edu.aku.hassannaqvi.uen_midline.contracts.AreasContract;
import edu.aku.hassannaqvi.uen_midline.contracts.ChildContract.SingleChild;
import edu.aku.hassannaqvi.uen_midline.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_midline.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_midline.contracts.KishMWRAContract.SingleKishMWRA;
import edu.aku.hassannaqvi.uen_midline.contracts.MWRAContract.MWRATable;
import edu.aku.hassannaqvi.uen_midline.contracts.MWRA_PREContract.SingleMWRAPRE;
import edu.aku.hassannaqvi.uen_midline.contracts.MortalityContract.SingleMortality;
import edu.aku.hassannaqvi.uen_midline.contracts.MotherContract;
import edu.aku.hassannaqvi.uen_midline.contracts.TalukasContract;
import edu.aku.hassannaqvi.uen_midline.contracts.UCsContract;
import edu.aku.hassannaqvi.uen_midline.contracts.UsersContract;
import edu.aku.hassannaqvi.uen_midline.contracts.VersionAppContract;
import edu.aku.hassannaqvi.uen_midline.contracts.VillagesContract;

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
            + FormsContract.FormsTable.COLUMN_DSSID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_USER + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SINFO + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SM + " TEXT,"
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

    public static final String SQL_CREATE_USERS = "CREATE TABLE " + UsersContract.singleUser.TABLE_NAME + "("
            + UsersContract.singleUser._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersContract.singleUser.ROW_USERNAME + " TEXT,"
            + UsersContract.singleUser.ROW_PASSWORD + " TEXT,"
            + UsersContract.singleUser.FULL_NAME + " TEXT"
            + " );";

    public static final String SQL_CREATE_VERSIONAPP = "CREATE TABLE " + VersionAppContract.VersionAppTable.TABLE_NAME + " (" +
            VersionAppContract.VersionAppTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_PATH_NAME + " TEXT " +
            ");";

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
            + AreasContract.singleAreas.COLUMN_AREA + " TEXT );";


    public static final String SQL_CREATE_PSU_TABLE = "CREATE TABLE " + VillagesContract.singleVillage.TABLE_NAME + " (" +
            VillagesContract.singleVillage._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            VillagesContract.singleVillage.COLUMN_AREA_CODE + " TEXT, " +
            VillagesContract.singleVillage.COLUMN_VILLAGE_CODE + " TEXT, " +
            VillagesContract.singleVillage.COLUMN_VILLAGE_NAME + " TEXT " +
            ");";


    public static final String SQL_CREATE__MOTHER_TABLE = "CREATE TABLE " + MotherContract.singleMother.TABLE_NAME + "("
            + MotherContract.singleMother._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MotherContract.singleMother.COLUMN_luid + " TEXT,"
            + MotherContract.singleMother.COLUMN_UID + " TEXT,"
            + MotherContract.singleMother.COLUMN_MOTHER_ID + " TEXT,"
            + MotherContract.singleMother.COLUMN_SERIAL_NO + " TEXT,"
            + MotherContract.singleMother.COLUMN_DA + " TEXT,"
            + MotherContract.singleMother.COLUMN_FORMDATE + " TEXT,"
            + MotherContract.singleMother.COLUMN_USER + " TEXT,"
            + MotherContract.singleMother.COLUMN_DEVICEID + " TEXT,"
            + MotherContract.singleMother.COLUMN_DEVICETAGID + " TEXT,"
            + MotherContract.singleMother.COLUMN_SYNCED + " TEXT,"
            + MotherContract.singleMother.COLUMN_SYNCED_DATE + " TEXT );";


    public static final String SQL_CREATE__KISH_TABLE = "CREATE TABLE " + SingleKishMWRA.TABLE_NAME + "("
            + SingleKishMWRA._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SingleKishMWRA.COLUMN_UID + " TEXT,"
            + SingleKishMWRA.COLUMN__UUID + " TEXT,"
            + SingleKishMWRA.COLUMN_DEVICEID + " TEXT,"
            + SingleKishMWRA.COLUMN_FORMDATE + " TEXT,"
            + SingleKishMWRA.COLUMN_USER + " TEXT,"
            + SingleKishMWRA.COLUMN_SF + " TEXT,"
            + SingleKishMWRA.COLUMN_SG + " TEXT,"
            + SingleKishMWRA.COLUMN_SH1 + " TEXT,"
            + SingleKishMWRA.COLUMN_SH2 + " TEXT,"
            + SingleKishMWRA.COLUMN_SK + " TEXT,"
            + SingleKishMWRA.COLUMN_SL + " TEXT,"
            + SingleKishMWRA.COLUMN_DEVICETAGID + " TEXT,"
            + SingleKishMWRA.COLUMN_SYNCED + " TEXT,"
            + SingleKishMWRA.COLUMN_SYNCED_DATE + " TEXT );";

    public static final String SQL_CREATE_MWRA_TABLE = "CREATE TABLE " + MWRATable.TABLE_NAME + "("
            + MWRATable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MWRATable.COLUMN_UID + " TEXT,"
            + MWRATable.COLUMN_UUID + " TEXT,"
            + MWRATable.COLUMN_FORMDATE + " TEXT,"
            + MWRATable.COLUMN_DEVICEID + " TEXT,"
            + MWRATable.COLUMN_USER + " TEXT,"
            + MWRATable.COLUMN_SD + " TEXT,"
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
            + SingleChild.COLUMN_SI1 + " TEXT,"
            + SingleChild.COLUMN_SI2 + " TEXT,"
            + SingleChild.COLUMN_SJ + " TEXT,"
            + SingleChild.COLUMN_DEVICETAGID + " TEXT,"
            + SingleChild.COLUMN_SYNCED + " TEXT,"
            + SingleChild.COLUMN_SYNCED_DATE + " TEXT );";


    public static final String SQL_CREATE__MORTALITY = "CREATE TABLE " + SingleMortality.TABLE_NAME + "("
            + SingleMortality._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SingleMortality.COLUMN_UID + " TEXT,"
            + SingleMortality.COLUMN__UUID + " TEXT,"
            + SingleMortality.COLUMN_DEVICEID + " TEXT,"
            + SingleMortality.COLUMN_FORMDATE + " TEXT,"
            + SingleMortality.COLUMN_USER + " TEXT,"
            + SingleMortality.COLUMN_SE3 + " TEXT,"
            + SingleMortality.COLUMN_DEVICETAGID + " TEXT,"
            + SingleMortality.COLUMN_SYNCED + " TEXT,"
            + SingleMortality.COLUMN_SYNCED_DATE + " TEXT );";


    public static final String SQL_CREATE_FAMILY_MEMBERS = "CREATE TABLE " + FamilyMembersContract.singleMember.TABLE_NAME + "("
            + FamilyMembersContract.singleMember.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FamilyMembersContract.singleMember.COLUMN_UID + " TEXT," +
            FamilyMembersContract.singleMember.COLUMN_UUID + " TEXT," +
            FamilyMembersContract.singleMember.COLUMN_FORMDATE + " TEXT," +
            FamilyMembersContract.singleMember.COLUMN_CLUSTERNO + " TEXT," +
            FamilyMembersContract.singleMember.COLUMN_HHNO + " TEXT," +
            FamilyMembersContract.singleMember.COLUMN_SERIAL_NO + " TEXT," +
            FamilyMembersContract.singleMember.COLUMN_NAME + " TEXT," +
            FamilyMembersContract.singleMember.COLUMN_RELATION_HH + " TEXT," +
            FamilyMembersContract.singleMember.COLUMN_AGE + " TEXT," +
            FamilyMembersContract.singleMember.COLUMN_MOTHER_NAME + " TEXT," +
            FamilyMembersContract.singleMember.COLUMN_MOTHER_SERIAL + " TEXT," +
            FamilyMembersContract.singleMember.COLUMN_GENDER + " TEXT," +
            FamilyMembersContract.singleMember.COLUMN_MARITAL + " TEXT," +
            FamilyMembersContract.singleMember.COLUMN_SD + " TEXT" + ");";

}
