package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.DentalContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivityDentalPhotoBinding;
import edu.aku.hassannaqvi.uen_scans_bl.ui.other.MainActivity;
import edu.aku.hassannaqvi.uen_scans_bl.ui.other.TakePhoto;

public class DentalPhotoActivity extends AppCompatActivity {
    ActivityDentalPhotoBinding bi;
    private int PhotoSerial;
    private DentalContract dental;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dental_photo);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_dental_photo);
        bi.setCallback(this);

        PhotoSerial = 1;
    }

    public void TakePhoto(int id) {

        Intent intent = new Intent(this, TakePhoto.class);

        //intent.putExtra("picID", MainApp.indexKishMWRA.getClusterno() + "_" + MainApp.indexKishMWRA.getHhno() + "_" + PhotoSerial);
//        intent.putExtra("picID", "901001" + "_" + "A-0001-001" + "_" + "1" + "_");
        intent.putExtra("picID", MainApp.indexKishMWRAChild.getClusterno() + "_" + MainApp.indexKishMWRAChild.getHhno() + "_" + PhotoSerial + "_");

        intent.putExtra("childName", MainApp.indexKishMWRAChild.getName());
        //intent.putExtra("childName", MainApp.indexKishMWRA.getClusterno() + "_" + MainApp.indexKishMWRA.getHhno());


        intent.putExtra("picView", "dental".toUpperCase());
        if (id == 1) {
            intent.putExtra("viewFacing", "1");
        } else {
            intent.putExtra("viewFacing", "2");
        }

        startActivityForResult(intent, 1); // Activity is started with requestCode 1 = Front

    }

     /* onActivityResult(resultCode) 0= Photo Cancel, 1=Photo Taken
        if resultCode = 1 than also returns -> Intent Extra (FileName)*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        // Toast.makeText(this, requestCode + "_" + resultCode, Toast.LENGTH_SHORT).show();
        if (resultCode == 1) {
            Toast.makeText(this, "Photo Taken", Toast.LENGTH_SHORT).show();
            String fileName = data.getStringExtra("FileName");
            bi.fileName.setText(bi.fileName.getText() + String.valueOf(PhotoSerial) + " - " + fileName + ";\r\n");
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                PhotoSerial++;
            }

        } else {
            Toast.makeText(this, "Photo Cancelled", Toast.LENGTH_SHORT).show();
        }
    }

    public void BtnNext() {
        finish();
        startActivity(new Intent(this, MainActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addDental(dental);
        dental.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            dental.setUID(dental.getDeviceId() + dental.get_ID());
            db.updatesDentalColumn(DentalContract.DentalTable.COLUMN_UID, dental.getUID(), dental);
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    private void SaveDraft() throws JSONException {

        dental = new DentalContract();
        dental.set_UUID(MainApp.indexKishMWRAChild.getUuid());
        dental.setDeviceId(MainApp.appInfo.getDeviceID());
        dental.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        dental.setUser(MainApp.userName);
        dental.setDevicetagID(MainApp.appInfo.getTagName());

        JSONObject json = new JSONObject();
        json.put("hhno", MainApp.indexKishMWRAChild.getHhno());
        json.put("cluster_no", MainApp.indexKishMWRAChild.getClusterno());
        json.put("_luid", MainApp.indexKishMWRAChild.getLuid());
        json.put("fm_uid", MainApp.indexKishMWRAChild.getUid());
        json.put("fm_serial", MainApp.indexKishMWRAChild.getSerialno());
        json.put("mm_serial", MainApp.indexKishMWRAChild.getMother_serial());
        json.put("appversion", MainApp.appInfo.getAppVersion());

        json.put("f01", bi.fileName.getText().toString());

        dental.setsE2(String.valueOf(json));

    }

}
