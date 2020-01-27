package edu.aku.hassannaqvi.uen_midline.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.provider.Settings;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;

public class AppInfo {

    private String versionName;
    private Long installedOn;
    private int versionCode;
    private String tagName;
    private String deviceID;
    private String appVersion;
    private String dtToday;
    private DatabaseHelper dbHelper;

    public AppInfo(Context context) {
        try {
            installedOn = context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).lastUpdateTime;
            versionCode = context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).versionCode;
            versionName = context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).versionName;
            dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
            deviceID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            appVersion = versionName + "." + versionCode;
            tagName = getTagName(context);
            dbHelper = new DatabaseHelper(context);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String getTagName(Context mContext) {
        SharedPreferences sharedPref = mContext.getSharedPreferences("tagName", MODE_PRIVATE);
        return sharedPref.getString("tagName", null);
    }

    private AppInfo(String versionName, Long installedOn, int versionCode) {
        this.versionName = versionName;
        this.installedOn = installedOn;
        this.versionCode = versionCode;
    }

    public AppInfo getInfo() {
        return new AppInfo(versionName, installedOn, versionCode);
    }

    public String getAppInfo() {
        return "Ver. " + versionName + "." + versionCode + " \r\n( Last Updated: " + new SimpleDateFormat("dd MMM. yyyy").format(new Date(getInfo().installedOn)) + " )";
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Long getInstalledOn() {
        return installedOn;
    }

    public void setInstalledOn(Long installedOn) {
        this.installedOn = installedOn;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDtToday() {
        return dtToday;
    }

    public void setDtToday(String dtToday) {
        this.dtToday = dtToday;
    }

    public DatabaseHelper getDbHelper() {
        return dbHelper;
    }

    public void setDbHelper(DatabaseHelper dbHelper) {
        this.dbHelper = dbHelper;
    }
}
