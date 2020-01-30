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
import edu.aku.hassannaqvi.uen_scans_bl.contracts.KishMWRAContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
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

        setlistener();

    }


    private void setlistener() {

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

        bi.k223.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.k223b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVk04, null);
            }
        }));

        bi.k227.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.k227b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVk05, null);
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
                startActivity(new Intent(this, SectionLActivity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void BtnEnd() {

        Util.openEndActivity(this);
    }


    private boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesKishMWRAColumn(KishMWRAContract.SingleKishMWRA.COLUMN_SK, MainApp.kish.getsK());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject k2 = new JSONObject();

        k2.put("k201", bi.k201.getText().toString());

        k2.put("k202",
                bi.k202a.isChecked() ? "1" :
                        bi.k202b.isChecked() ? "2" :
                                "0");

        k2.put("k203",
                bi.k203a.isChecked() ? "1" :
                        bi.k203b.isChecked() ? "2" :
                                "0");

        k2.put("k204", bi.k204.getText().toString());
        k2.put("k204a", bi.k204a.getText().toString());

        k2.put("k205", bi.k205.getText().toString());
        k2.put("k205a", bi.k205a.getText().toString());

        k2.put("k206dd", bi.k206dd.getText().toString());
        k2.put("k206mm", bi.k206mm.getText().toString());
        k2.put("k206yy", bi.k206yy.getText().toString());

        k2.put("k207hh", bi.k207hh.getText().toString());
        k2.put("k207mm", bi.k207mm.getText().toString());

        k2.put("k208",
                bi.k208a.isChecked() ? "1" :
                        bi.k208b.isChecked() ? "2" :
                                bi.k208c.isChecked() ? "3" :
                                        "0");

        k2.put("k209", bi.k209.getText().toString());
        k2.put("k209a", bi.k209a.getText().toString());

        //k2.put("k210", bi.k210.getText().toString());
        k2.put("k210a", bi.k210a.getText().toString());

        k2.put("k211",
                bi.k211a.isChecked() ? "1" :
                        bi.k211b.isChecked() ? "2" :
                                "0");

        k2.put("k212", bi.k212.getText().toString());
        k2.put("k212a", bi.k212a.getText().toString());

        k2.put("k213", bi.k213.getText().toString());
        k2.put("k213a", bi.k213a.getText().toString());

        k2.put("k214", bi.k214.getText().toString());
        k2.put("k214a", bi.k214a.getText().toString());

        k2.put("k215",
                bi.k215a.isChecked() ? "1" :
                        bi.k215b.isChecked() ? "2" :
                                "0");

        k2.put("k216", bi.k216.getText().toString());
        k2.put("k216a", bi.k216a.getText().toString());

        k2.put("k217", bi.k217.getText().toString());
        k2.put("k217a", bi.k217a.getText().toString());

        k2.put("k218", bi.k218.getText().toString());
        k2.put("k218a", bi.k218a.getText().toString());

        k2.put("k219",
                bi.k219a.isChecked() ? "1" :
                        bi.k219b.isChecked() ? "2" :
                                "0");

        k2.put("k220", bi.k220.getText().toString());
        k2.put("k220a", bi.k220a.getText().toString());

        k2.put("k221", bi.k221.getText().toString());
        k2.put("k221a", bi.k221a.getText().toString());

        k2.put("k222", bi.k222.getText().toString());
        k2.put("k222a", bi.k222a.getText().toString());

        k2.put("k223",
                bi.k223a.isChecked() ? "1" :
                        bi.k223b.isChecked() ? "2" :
                                "0");

        k2.put("k224", bi.k224.getText().toString());
        k2.put("k224a", bi.k224a.getText().toString());

        k2.put("k225", bi.k225.getText().toString());
        k2.put("k225a", bi.k225a.getText().toString());

        k2.put("k226", bi.k226.getText().toString());
        k2.put("k226a", bi.k226a.getText().toString());

        k2.put("k227",
                bi.k227a.isChecked() ? "1" :
                        bi.k227b.isChecked() ? "2" :
                                "0");

        k2.put("k228", bi.k228.getText().toString());
        k2.put("k228a", bi.k228a.getText().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionK2);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
