package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionK2Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;
import edu.aku.hassannaqvi.uen_scans_bl.validator.ClearClass;

public class SectionK2Activity extends AppCompatActivity {

    ActivitySectionK2Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k2);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        bi.k211.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.k211b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVk01, null);
            }

        }));

        bi.k215.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.k215b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVk02, null);
            }
        }));

        bi.k219.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.k219b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVk03, null);
            }
        }));

    }


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionK3Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void BtnEnd() {

        Util.openEndActivity(this);
    }


    private boolean UpdateDB() {

        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesKishMWRAColumn(KishMWRAContract.SingleKishMWRA.COLUMN_SK, MainApp.kish.getsK());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("k201", bi.k201.getSelectedItem().toString());

        json.put("k202",
                bi.k202a.isChecked() ? "1" :
                        bi.k202b.isChecked() ? "2" :
                                "0");

        json.put("k203",
                bi.k203a.isChecked() ? "1" :
                        bi.k203b.isChecked() ? "2" :
                                "0");

        json.put("k204a", bi.k204a.getSelectedItem().toString());
        json.put("k204b", bi.k204b.getText().toString());

        json.put("k205a", bi.k205a.getSelectedItem().toString());
        json.put("k205b", bi.k205b.getText().toString());

        json.put("k206dd", bi.k206dd.getText().toString());
        json.put("k206mm", bi.k206mm.getText().toString());
        json.put("k206yy", bi.k206yy.getText().toString());

        json.put("k207hh", bi.k207hh.getText().toString());
        json.put("k207mm", bi.k207mm.getText().toString());

        json.put("k208",
                bi.k208a.isChecked() ? "1" :
                        bi.k208b.isChecked() ? "2" :
                                bi.k208c.isChecked() ? "3" :
                                        "0");

        json.put("k209a", bi.k209a.getText().toString());
        json.put("k209b", bi.k209b.getSelectedItem().toString());

        json.put("k210a", bi.k210a.getText().toString());
        json.put("k210b", bi.k210b.getSelectedItem().toString());

        json.put("k211",
                bi.k211a.isChecked() ? "1" :
                        bi.k211b.isChecked() ? "2" :
                                "0");

        json.put("k212a", bi.k212a.getText().toString());
        json.put("k212b", bi.k212b.getSelectedItem().toString());

        json.put("k213a", bi.k213a.getText().toString());
        json.put("k213b", bi.k213b.getSelectedItem().toString());

        json.put("k214a", bi.k214a.getText().toString());
        json.put("k214b", bi.k214b.getSelectedItem().toString());

        json.put("k215",
                bi.k215a.isChecked() ? "1" :
                        bi.k215b.isChecked() ? "2" :
                                "0");

        json.put("k216a", bi.k216a.getText().toString());
        json.put("k216b", bi.k216b.getSelectedItem().toString());

        json.put("k217a", bi.k217a.getText().toString());
        json.put("k217b", bi.k217b.getSelectedItem().toString());

        json.put("k218a", bi.k218a.getText().toString());
        json.put("k218b", bi.k218b.getSelectedItem().toString());

        json.put("k219",
                bi.k219a.isChecked() ? "1" :
                        bi.k219b.isChecked() ? "2" :
                                "0");

        json.put("k220a", bi.k220a.getText().toString());
        json.put("k220b", bi.k220b.getSelectedItem().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionK2);

    }


    /*@Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }*/


}
