package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivityDentalPhotoBinding;
import edu.aku.hassannaqvi.uen_scans_bl.ui.other.TakePhoto;

public class DentalPhotoActivity extends AppCompatActivity {
    ActivityDentalPhotoBinding bi;
    private int PhotoSerial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dental_photo);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_dental_photo);


        PhotoSerial = 0;
    }

    public void takePhoto(View view) {

        Intent intent = new Intent(this, TakePhoto.class);

        intent.putExtra("picID", MainApp.indexKishMWRA.getClusterno() + "_" + MainApp.indexKishMWRA.getHhno() + "_" + PhotoSerial);
        //intent.putExtra("picID", "901001" + "_" + "A-0001-001" + "_" + "1" + "_");

        //intent.putExtra("childName", "Hassan");
        intent.putExtra("childName", MainApp.indexKishMWRA.getClusterno() + "_" + MainApp.indexKishMWRA.getHhno());


        intent.putExtra("picView", "dental".toUpperCase());
        if (view.getId() == bi.btnSnap1.getId()) {
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
            PhotoSerial++;

            bi.dentalPhotoFile.setText(bi.dentalPhotoFile.getText() + String.valueOf(PhotoSerial) + " - " + fileName + ";\r\n");
        } else {
            Toast.makeText(this, "Photo Cancelled", Toast.LENGTH_SHORT).show();
        }
    }

}
