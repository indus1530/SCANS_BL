package edu.aku.hassannaqvi.uen_midline.utils;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.Window;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.ui.other.EndingActivity;

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
        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.item_dialog_2);
        dialog.setCancelable(false);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(dialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.show();
        dialog.getWindow().setAttributes(params);

        dialog.findViewById(R.id.btnOk).setOnClickListener(view -> {
            activity.finish();
            activity.startActivity(new Intent(activity, EndingActivity.class).putExtra("complete", false)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        });
        dialog.findViewById(R.id.btnNo).setOnClickListener(view -> dialog.dismiss());

    }


    public static Integer getMemberIcon(int gender, String age) {
        int memAge = age.isEmpty() ? 0 : Integer.valueOf(age);
        if (memAge == 0) return R.drawable.boy;
        else if (memAge > 10) return gender == 1 ? R.drawable.ctr_male : R.drawable.ctr_female;
        else return gender == 1 ? R.drawable.ctr_childboy : R.drawable.ctr_childgirl;
    }


}
