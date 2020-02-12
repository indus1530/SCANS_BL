package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FormsContract;
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


    public CheckBox.OnCheckedChangeListener check403 = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (bi.a403a.isChecked() || bi.a403b.isChecked() || bi.a403c.isChecked() || bi.a403d.isChecked()) {
                ClearClass.ClearAllFields(bi.fldGrpCVa02, null);
                bi.fldGrpCVa02.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVa02.setVisibility(View.VISIBLE);
            }
        }
    };

    private void setlistener() {

        //a401
        bi.a401.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.a401a.getId() || checkedId == bi.a40196.getId()) {
                bi.fldGrpCVa01.setVisibility(View.VISIBLE);

            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVa01, null);
                bi.fldGrpCVa01.setVisibility(View.GONE);
                bi.fldGrpCVa02.setVisibility(View.VISIBLE);

            }
        });


        bi.a403a.setOnCheckedChangeListener(check403);
        bi.a403b.setOnCheckedChangeListener(check403);
        bi.a403c.setOnCheckedChangeListener(check403);
        bi.a403d.setOnCheckedChangeListener(check403);

        //a40397
        bi.a40397.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                ClearClass.ClearAllFields(bi.a403check, false);
                bi.a403check.setTag("-1");
                bi.fldGrpCVa02.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.a403check, true);
                bi.a403check.setTag("0");
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
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SA4, MainApp.fc.getsA4());
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
                bi.a401a.isChecked() ? "1" :
                        bi.a401b.isChecked() ? "2" :
                                bi.a401c.isChecked() ? "3" :
                                        bi.a401d.isChecked() ? "4" :
                                                bi.a40196.isChecked() ? "96" :
                                                        "0");
        f1.put("a40196x", bi.a40196x.getText().toString());

        f1.put("a402",
                bi.a402a.isChecked() ? "1" :
                        bi.a402b.isChecked() ? "2" :
                                "0");

        f1.put("a403a", bi.a403a.isChecked() ? "1" : "0");
        f1.put("a403b", bi.a403b.isChecked() ? "2" : "0");
        f1.put("a403c", bi.a403c.isChecked() ? "3" : "0");
        f1.put("a403d", bi.a403d.isChecked() ? "4" : "0");
        f1.put("a40397", bi.a40397.isChecked() ? "97" : "0");

        f1.put("a404",
                bi.a404a.isChecked() ? "1" :
                        bi.a404b.isChecked() ? "2" :
                                "0");

        f1.put("a405a", bi.a405a.isChecked() ? "1" : "0");
        f1.put("a405b", bi.a405b.isChecked() ? "2" : "0");
        f1.put("a405c", bi.a405c.isChecked() ? "3" : "0");
        f1.put("a405d", bi.a405d.isChecked() ? "4" : "0");
        f1.put("a40597", bi.a40597.isChecked() ? "97" : "0");

        f1.put("a406a", bi.a406a.isChecked() ? "1" : "0");
        f1.put("a406b", bi.a406b.isChecked() ? "2" : "0");
        f1.put("a406c", bi.a406c.isChecked() ? "3" : "0");
        f1.put("a406d", bi.a406d.isChecked() ? "4" : "0");
        f1.put("a406e", bi.a406e.isChecked() ? "5" : "0");
        f1.put("a406f", bi.a406f.isChecked() ? "6" : "0");
        f1.put("a406g", bi.a406g.isChecked() ? "7" : "0");
        f1.put("a406h", bi.a406h.isChecked() ? "8" : "0");
        f1.put("a40697", bi.a40697.isChecked() ? "97" : "0");

        MainApp.fc.setsA3(String.valueOf(f1));
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionA4);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
