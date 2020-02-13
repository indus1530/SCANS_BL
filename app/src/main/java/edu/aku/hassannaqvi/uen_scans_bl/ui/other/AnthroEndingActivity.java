package edu.aku.hassannaqvi.uen_scans_bl.ui.other;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivityAnthroEndingBinding;
import edu.aku.hassannaqvi.uen_scans_bl.ui.sections.SectionK1Activity;

public class AnthroEndingActivity extends AppCompatActivity {

    ActivityAnthroEndingBinding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_anthro_ending);
        bi.setCallback(this);


        boolean check = getIntent().getExtras().getBoolean("complete");

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
                startActivity(new Intent(this, MainApp.mwraChildren.getFirst().size() > 0 ? SectionK1Activity.class : EndingActivity.class).putExtra("complete", true));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void SaveDraft() {
        MainApp.anthro.setIstatus(bi.k208a.isChecked() ? "1"
                : bi.k208b.isChecked() ? "2"
                : bi.k208c.isChecked() ? "3"
                : "0");
    }

    public boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updateAnthroEnding();
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.anthroEnd);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}
