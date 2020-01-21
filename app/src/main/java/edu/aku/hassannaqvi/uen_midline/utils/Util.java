package edu.aku.hassannaqvi.uen_midline.utils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import edu.aku.hassannaqvi.uen_midline.R;

public class Util {

    public static String[] permissions = {Manifest.permission.READ_CONTACTS, Manifest.permission.GET_ACCOUNTS,
            Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};

    public static int[] checkPermission(Context context) {

        return new int[]{ContextCompat.checkSelfPermission(context,
                Manifest.permission.READ_CONTACTS), ContextCompat.checkSelfPermission(context,
                Manifest.permission.GET_ACCOUNTS), ContextCompat.checkSelfPermission(context,
                Manifest.permission.READ_PHONE_STATE), ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION), ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_COARSE_LOCATION), ContextCompat.checkSelfPermission(context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE), ContextCompat.checkSelfPermission(context,
                Manifest.permission.CAMERA)};

    }


    public static List<String> getPermissionsList(Context context) {
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (int i = 0; i < checkPermission(context).length; i++) {
            if (checkPermission(context)[i] != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(permissions[i]);

            }
        }
        return listPermissionsNeeded;
    }


    public static void openEndActivity(Activity activity) {
        new AlertDialog.Builder(activity)
                .setTitle("END INTERVIEW")
                .setIcon(R.drawable.ic_power_settings_new_black_24dp)
                .setCancelable(false)
                .setCancelable(false)
                .setMessage("Do you want to End Interview??")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        try {
//                            SaveDraft();
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        if (!UpdateDB()) {
//                            return;
//                        }
//                        MainApp.endActivitySetRouting(SectionBActivity.this, SectionBActivity.this, EndingActivity.class, false, null);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }


}
