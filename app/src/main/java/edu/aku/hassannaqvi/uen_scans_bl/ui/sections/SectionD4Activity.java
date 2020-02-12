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
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FoodFreqContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionD4Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionD4Activity extends AppCompatActivity {

    ActivitySectionD4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d4);
        bi.setCallback(this);


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
                startActivity(new Intent(this, SectionD6Activity.class));
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
        int updcount = db.updatesFoodFreqColumn(FoodFreqContract.SingleFoodFreq.COLUMN_SD4, MainApp.foodFreq.getsD4());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("d401",
                bi.d401a.isChecked() ? "1" :
                        bi.d401b.isChecked() ? "2" :
                                bi.d401c.isChecked() ? "3" :
                                        bi.d401d.isChecked() ? "4" :
                                                bi.d401e.isChecked() ? "5" :
                                                        "0");
        json.put("d402",
                bi.d402a.isChecked() ? "1" :
                        bi.d402b.isChecked() ? "2" :
                                bi.d402c.isChecked() ? "3" :
                                        bi.d402d.isChecked() ? "4" :
                                                bi.d402e.isChecked() ? "5" :
                                                        "0");
        json.put("d403",
                bi.d403a.isChecked() ? "1" :
                        bi.d403b.isChecked() ? "2" :
                                bi.d403c.isChecked() ? "3" :
                                        bi.d403d.isChecked() ? "4" :
                                                bi.d403e.isChecked() ? "5" :
                                                        "0");
        json.put("d404",
                bi.d404a.isChecked() ? "1" :
                        bi.d404b.isChecked() ? "2" :
                                bi.d404c.isChecked() ? "3" :
                                        bi.d404d.isChecked() ? "4" :
                                                bi.d404e.isChecked() ? "5" :
                                                        "0");
        json.put("d405",
                bi.d405a.isChecked() ? "1" :
                        bi.d405b.isChecked() ? "2" :
                                bi.d405c.isChecked() ? "3" :
                                        bi.d405d.isChecked() ? "4" :
                                                bi.d405e.isChecked() ? "5" :
                                                        "0");

        MainApp.foodFreq.setsD4(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionD4);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }


}
