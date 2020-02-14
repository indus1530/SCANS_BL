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
import edu.aku.hassannaqvi.uen_scans_bl.contracts.ChildContract;
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
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c4);
        bi.setCallback(this);
        setlistener();

    }


    private void setlistener() {

        bi.c401.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.c401a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVc402, null);
            } else if (i == bi.c401b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVc403, null);
                ClearClass.ClearAllFields(bi.fldGrpCVc404, null);
                ClearClass.ClearAllFields(bi.fldGrpCVC401, null);
                ClearClass.ClearAllFields(bi.fldGrpCVc407, null);
                ClearClass.ClearAllFields(bi.fldGrpCVc408, null);
                ClearClass.ClearAllFields(bi.fldGrpCVc409, null);
                ClearClass.ClearAllFields(bi.fldGrpCVc410, null);
                ClearClass.ClearAllFields(bi.fldGrpCVc411, null);
                ClearClass.ClearAllFields(bi.fldGrpCVc412, null);
                ClearClass.ClearAllFields(bi.fldGrpCVc413, null);
                ClearClass.ClearAllFields(bi.fldGrpCVc414, null);
                ClearClass.ClearAllFields(bi.fldGrpCVc415, null);

            }

        }));

        //c402h
        bi.c402h.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                ClearClass.ClearAllFields(bi.c402check, false);
                bi.c402check.setTag("-1");
            } else {
                ClearClass.ClearAllFields(bi.c402check, true);
                bi.c402check.setTag("0");
            }
        });

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
        int updcount = db.updatesChildColumn(ChildContract.SingleChild.COLUMN_SC4, MainApp.child.getsC4());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("c401",
                bi.c401a.isChecked() ? "1" :
                        bi.c401b.isChecked() ? "2" :
                                "0");

        json.put("c402a", bi.c402a.isChecked() ? "1" : "0");
        json.put("c402b", bi.c402b.isChecked() ? "2" : "0");
        json.put("c402c", bi.c402c.isChecked() ? "3" : "0");
        json.put("c402d", bi.c402d.isChecked() ? "4" : "0");
        json.put("c402e", bi.c402e.isChecked() ? "5" : "0");
        json.put("c402f", bi.c402f.isChecked() ? "6" : "0");
        json.put("c402g", bi.c402g.isChecked() ? "7" : "0");
        json.put("c402h", bi.c402h.isChecked() ? "8" : "0");
        json.put("c40296", bi.c40296.isChecked() ? "96" : "0");
        json.put("c40296x", bi.c40296x.getText().toString());

        json.put("c403",
                bi.c403a.isChecked() ? "1" :
                        bi.c403b.isChecked() ? "2" :
                                bi.c403c.isChecked() ? "3" :
                                        bi.c403d.isChecked() ? "4" :
                                                bi.c40396.isChecked() ? "96" :
                                                        "0");
        json.put("c40396x", bi.c40396x.getText().toString());

        json.put("c404",
                bi.c404a.isChecked() ? "1" :
                        bi.c404b.isChecked() ? "2" :
                                "0");

        json.put("c405", bi.c40598.isChecked() ? "98" : bi.c405.getText().toString());

        json.put("c406", bi.c40698.isChecked() ? "98" : bi.c406.getText().toString());

        json.put("c407", bi.c407.getText().toString());

        json.put("c408",
                bi.c408a.isChecked() ? "1" :
                        bi.c408b.isChecked() ? "2" :
                                "0");

        json.put("c409",
                bi.c409a.isChecked() ? "1" :
                        bi.c409b.isChecked() ? "2" :
                                bi.c409c.isChecked() ? "3" :
                                        bi.c409d.isChecked() ? "4" :
                                                bi.c409e.isChecked() ? "5" :
                                                        bi.c409f.isChecked() ? "6" :
                                                                bi.c409g.isChecked() ? "7" :
                                                                        bi.c409h.isChecked() ? "8" :
                                                                                bi.c40996.isChecked() ? "96" :
                                                                                        "0");
        json.put("c40996x", bi.c40996x.getText().toString());

        json.put("c410",
                bi.c410a.isChecked() ? "1" :
                        bi.c410b.isChecked() ? "2" :
                                bi.c410c.isChecked() ? "3" :
                                        bi.c41096.isChecked() ? "96" :
                                                "0");
        json.put("c41096x", bi.c41096x.getText().toString());

        json.put("c411",
                bi.c411a.isChecked() ? "1" :
                        bi.c411b.isChecked() ? "2" :
                                bi.c411c.isChecked() ? "3" :
                                        bi.c411d.isChecked() ? "4" :
                                                bi.c411e.isChecked() ? "5" :
                                                        bi.c411f.isChecked() ? "6" :
                                                                bi.c411g.isChecked() ? "7" :
                                                                        "0");

        json.put("c412",
                bi.c412a.isChecked() ? "1" :
                        bi.c412b.isChecked() ? "2" :
                                bi.c412c.isChecked() ? "3" :
                                        bi.c412d.isChecked() ? "4" :
                                                bi.c412e.isChecked() ? "5" :
                                                        bi.c412f.isChecked() ? "6" :
                                                                bi.c412g.isChecked() ? "7" :
                                                                        "0");

        json.put("c413",
                bi.c413a.isChecked() ? "1" :
                        bi.c413b.isChecked() ? "2" :
                                "0");

        json.put("c414",
                bi.c414a.isChecked() ? "1" :
                        bi.c414b.isChecked() ? "2" :
                                "0");

        json.put("c415",
                bi.c415a.isChecked() ? "1" :
                        bi.c415b.isChecked() ? "2" :
                                bi.c415c.isChecked() ? "3" :
                                        bi.c415d.isChecked() ? "4" :
                                                bi.c415e.isChecked() ? "5" :
                                                        bi.c41596.isChecked() ? "96" :
                                                                "0");
        json.put("c41596x", bi.c41596x.getText().toString());

        MainApp.child.setsC4(String.valueOf(json));
        MainApp.C401 = bi.c401a.isChecked() ? "1" : bi.c401b.isChecked() ? "2" : "0";

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionC4);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }


}
