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
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionC4Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;
import edu.aku.hassannaqvi.uen_scans_bl.validator.ClearClass;

public class SectionC4Activity extends AppCompatActivity {

    ActivitySectionC4Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c2);
        bi.setCallback(this);

        setlistener();

    }


    private void setlistener() {

        bi.c401.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.c401a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVc402, null);
            }

        }));

        bi.c404.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.c404a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVC401, null);
            }

        }));

        bi.c408.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.c408b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVc409, null);
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
                startActivity(new Intent(this, SectionC5Activity.class));
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

        JSONObject f1 = new JSONObject();

        f1.put("c401",
                bi.c401a.isChecked() ? "1" :
                        bi.c401b.isChecked() ? "2" :
                                "0");

        f1.put("c402a", bi.c402a.isChecked() ? "1" : "0");
        f1.put("c402b", bi.c402b.isChecked() ? "2" : "0");
        f1.put("c402c", bi.c402c.isChecked() ? "3" : "0");
        f1.put("c402d", bi.c402d.isChecked() ? "4" : "0");
        f1.put("c402e", bi.c402e.isChecked() ? "5" : "0");
        f1.put("c402f", bi.c402f.isChecked() ? "6" : "0");
        f1.put("c402g", bi.c402g.isChecked() ? "7" : "0");
        f1.put("c402h", bi.c402h.isChecked() ? "8" : "0");
        f1.put("c402x", bi.c402x.isChecked() ? "96" : "0");
        f1.put("c402xt", bi.c402xt.getText().toString());

        f1.put("c403",
                bi.c403a.isChecked() ? "1" :
                        bi.c403b.isChecked() ? "2" :
                                bi.c403c.isChecked() ? "3" :
                                        bi.c403d.isChecked() ? "4" :
                                                bi.c403x.isChecked() ? "96" :
                                                        "0");

        f1.put("c404",
                bi.c404a.isChecked() ? "1" :
                        bi.c404b.isChecked() ? "2" :
                                "0");

        f1.put("c405a", bi.c405a.getText().toString());

        f1.put("c406a", bi.c406a.getText().toString());

        f1.put("c407", bi.c407.getText().toString());

        f1.put("c408",
                bi.c408a.isChecked() ? "1" :
                        bi.c408b.isChecked() ? "2" :
                                "0");

        f1.put("c409",
                bi.c409a.isChecked() ? "1" :
                        bi.c409b.isChecked() ? "2" :
                                bi.c409c.isChecked() ? "3" :
                                        bi.c409d.isChecked() ? "4" :
                                                bi.c409e.isChecked() ? "5" :
                                                        bi.c409f.isChecked() ? "6" :
                                                                bi.c409g.isChecked() ? "7" :
                                                                        bi.c409h.isChecked() ? "8" :
                                                                                bi.c409x.isChecked() ? "96" :
                                                                                        "0");

        f1.put("c410",
                bi.c410a.isChecked() ? "1" :
                        bi.c410b.isChecked() ? "2" :
                                bi.c410c.isChecked() ? "3" :
                                        bi.c410x.isChecked() ? "96" :
                                                "0");

        f1.put("c411",
                bi.c411a.isChecked() ? "1" :
                        bi.c411b.isChecked() ? "2" :
                                bi.c411c.isChecked() ? "3" :
                                        bi.c411d.isChecked() ? "4" :
                                                bi.c411e.isChecked() ? "5" :
                                                        bi.c411f.isChecked() ? "6" :
                                                                bi.c411g.isChecked() ? "7" :
                                                                        "0");

        f1.put("c412",
                bi.c412a.isChecked() ? "1" :
                        bi.c412b.isChecked() ? "2" :
                                bi.c412c.isChecked() ? "3" :
                                        bi.c412d.isChecked() ? "4" :
                                                bi.c412e.isChecked() ? "5" :
                                                        bi.c412f.isChecked() ? "6" :
                                                                bi.c412g.isChecked() ? "7" :
                                                                        "0");

        f1.put("c413",
                bi.c413a.isChecked() ? "1" :
                        bi.c413b.isChecked() ? "2" :
                                "0");

        f1.put("c414",
                bi.c414a.isChecked() ? "1" :
                        bi.c414b.isChecked() ? "2" :
                                "0");

        f1.put("c415",
                bi.c415a.isChecked() ? "1" :
                        bi.c415b.isChecked() ? "2" :
                                bi.c415c.isChecked() ? "3" :
                                        bi.c415d.isChecked() ? "4" :
                                                bi.c415e.isChecked() ? "5" :
                                                        bi.c415x.isChecked() ? "96" :
                                                                "0");

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionC4);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
