package edu.aku.hassannaqvi.uen_midline.core;

import android.content.Context;
import android.content.pm.PackageManager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppInfo {

    private String versionName;
    private Long installedOn;
    private int versionCode;

    public AppInfo(Context context) {
        try {
            this.installedOn = context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).lastUpdateTime;
            this.versionCode = context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).versionCode;
            this.versionName = context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
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
}
