package edu.aku.hassannaqvi.uen_midline.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

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
}
