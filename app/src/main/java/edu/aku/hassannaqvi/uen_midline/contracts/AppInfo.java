package edu.aku.hassannaqvi.uen_midline.contracts;

import android.content.Context;
import android.content.pm.PackageManager;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_midline.core.MainApp;

public class AppInfo {

    String packageName;
    String versionName;
    Long installedOn;
    int versionCode;
    Context context;

    public AppInfo() {
    }

    public AppInfo(Context context, String packageName) {
        this.packageName = packageName;
        this.context = context;
    }

    public AppInfo getInfo() {
        AppInfo appInfo = new AppInfo();
        try {
            appInfo.installedOn = this.context.getPackageManager().getPackageInfo(this.packageName, 0).lastUpdateTime;
            appInfo.versionCode = this.context.getPackageManager().getPackageInfo(this.packageName, 0).versionCode;
            appInfo.versionName = this.context.getPackageManager().getPackageInfo(this.packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appInfo;
    }

    public String getAppInfo() {

        MainApp.versionName = getInfo().versionName;
        MainApp.versionCode = getInfo().versionCode;

        return "Ver. " + getInfo().versionName + "." + getInfo().versionCode + " \r\n( Last Updated: " + new SimpleDateFormat("dd MMM. yyyy").format(new Date(getInfo().installedOn)) + " )";


    }
}
