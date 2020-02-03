package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionA4Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;
import edu.aku.hassannaqvi.uen_scans_bl.validator.ClearClass;

public class SectionA4Activity extends AppCompatActivity {

    ActivitySectionA4Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a4);
        bi.setCallback(this);

        setlistener();

    }


    private void setlistener() {

        //a401
        bi.a401.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.a401a.getId() || checkedId == bi.a401x.getId()) {
                bi.fldGrpCVa01.setVisibility(View.VISIBLE);

            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVa01, null);
                bi.fldGrpCVa01.setVisibility(View.GONE);

            }
        });

        //a403e
        bi.a403e.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                bi.fldGrpCVa02.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVa02, null);
                bi.fldGrpCVa02.setVisibility(View.GONE);
            }
        });

        bi.a404.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.a404b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVa405, null);
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
                startActivity(new Intent(this, SectionB1Activity.class));
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

        f1.put("a401",
                bi.a401a.isChecked() ?"1" :
                        bi.a401b.isChecked() ?"2" :
                                bi.a401c.isChecked() ?"3" :
                                        bi.a401d.isChecked() ?"4" :
                                                bi.a401x.isChecked() ?"96" :
                                                        "0");
        f1.put("a401xt", bi.a401xt.getText().toString());

        f1.put("a402",
                bi.a402a.isChecked() ?"1" :
                        bi.a402b.isChecked() ?"2" :
                                "0");

        f1.put("a403a",bi.a403a.isChecked() ?"1" :"0");
        f1.put("a403b",bi.a403b.isChecked() ?"2" :"0");
        f1.put("a403c",bi.a403c.isChecked() ?"3" :"0");
        f1.put("a403d",bi.a403d.isChecked() ?"4" :"0");
        f1.put("a403e",bi.a403e.isChecked() ?"97" :"0");

        f1.put("a404",
                bi.a404a.isChecked() ?"1" :
                        bi.a404b.isChecked() ?"2" :
                                "0");

        f1.put("a405a",bi.a405a.isChecked() ?"1" :"0");
        f1.put("a405b",bi.a405b.isChecked() ?"2" :"0");
        f1.put("a405c",bi.a405c.isChecked() ?"3" :"0");
        f1.put("a405d",bi.a405d.isChecked() ?"4" :"0");
        f1.put("a405e",bi.a405e.isChecked() ?"97" :"0");

        f1.put("a406a",bi.a406a.isChecked() ?"1" :"0");
        f1.put("a406b",bi.a406b.isChecked() ?"2" :"0");
        f1.put("a406c",bi.a406c.isChecked() ?"3" :"0");
        f1.put("a406d",bi.a406d.isChecked() ?"4" :"0");
        f1.put("a406e",bi.a406e.isChecked() ?"5" :"0");
        f1.put("a406f",bi.a406f.isChecked() ?"6" :"0");
        f1.put("a406g",bi.a406g.isChecked() ?"7" :"0");
        f1.put("a406h",bi.a406h.isChecked() ?"8" :"0");
        f1.put("a406i",bi.a406i.isChecked() ?"97" :"0");

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionA4);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
