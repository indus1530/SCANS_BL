package edu.aku.hassannaqvi.uen_scans_bl.ui.other;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivityAnthroEndingBinding;

public class AnthroEndingActivity extends AppCompatActivity {

    ActivityAnthroEndingBinding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_anthro_ending);
        bi.setCallback(this);


        Boolean check = getIntent().getExtras().getBoolean("complete");

        if (check) {
            bi.k208a.setEnabled(true);
            bi.k208b.setEnabled(false);
            bi.k208c.setEnabled(false);
        } else {
            bi.k208a.setEnabled(false);
            bi.k208a.setEnabled(true);
            bi.k208c.setEnabled(true);
        }

//
    }

    public void BtnEnd() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void SaveDraft() {

        MainApp.fc.setIstatus(bi.k208a.isChecked() ? "1"
                : bi.k208b.isChecked() ? "2"
                : bi.k208c.isChecked() ? "3"
                : "0");

        MainApp.fc.setEndingdatetime(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
    }

    public boolean UpdateDB() {

        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updateEnding();
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;

    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.anthroEnd);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}
