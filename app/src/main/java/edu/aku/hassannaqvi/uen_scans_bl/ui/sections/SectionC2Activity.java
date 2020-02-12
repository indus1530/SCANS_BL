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
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionC2Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;
import edu.aku.hassannaqvi.uen_scans_bl.validator.ClearClass;

public class SectionC2Activity extends AppCompatActivity {

    ActivitySectionC2Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c2);
        bi.setCallback(this);

        setlistener();

    }


    private void setlistener() {

        bi.c201.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.c20197.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVc202, null);
            }

        }));

        bi.c207.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.c20797.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVC201, null);
            }
        }));

        bi.c210.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.c210b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVC202, null);
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
                startActivity(new Intent(this, SectionC3Activity.class));
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
        int updcount = db.updatesChildColumn(ChildContract.SingleChild.COLUMN_SC2, MainApp.child.getsC2());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject f1 = new JSONObject();

        f1.put("c201",
                bi.c201a.isChecked() ? "1" :
                        bi.c201b.isChecked() ? "2" :
                                bi.c201c.isChecked() ? "3" :
                                        bi.c201d.isChecked() ? "4" :
                                                bi.c201e.isChecked() ? "5" :
                                                        bi.c201f.isChecked() ? "6" :
                                                                bi.c20197.isChecked() ? "97" :
                                                                        "0");

        f1.put("c202",
                bi.c202a.isChecked() ? "1" :
                        bi.c202b.isChecked() ? "2" :
                                bi.c202c.isChecked() ? "3" :
                                        bi.c20296.isChecked() ? "96" :
                                                "0");
        f1.put("c20296x", bi.c20296x.getText().toString());

        f1.put("c203a", bi.c203a.isChecked() ? "1" : "0");
        f1.put("c203b", bi.c203b.isChecked() ? "2" : "0");
        f1.put("c203c", bi.c203c.isChecked() ? "3" : "0");
        f1.put("c203d", bi.c203d.isChecked() ? "4" : "0");
        f1.put("c20397", bi.c20397.isChecked() ? "97" : "0");

        f1.put("c204",
                bi.c204a.isChecked() ? "1" :
                        bi.c204b.isChecked() ? "2" :
                                bi.c204c.isChecked() ? "3" :
                                        bi.c204d.isChecked() ? "4" :
                                                bi.c204e.isChecked() ? "5" :
                                                        bi.c20498.isChecked() ? "98" :
                                                                "0");

        f1.put("c205a", bi.c205a.isChecked() ? "1" : "0");
        f1.put("c205b", bi.c205b.isChecked() ? "2" : "0");
        f1.put("c205c", bi.c205c.isChecked() ? "3" : "0");
        f1.put("c205d", bi.c205d.isChecked() ? "4" : "0");
        f1.put("c205e", bi.c205e.isChecked() ? "5" : "0");
        f1.put("c205f", bi.c205f.isChecked() ? "6" : "0");
        f1.put("c205g", bi.c205g.isChecked() ? "7" : "0");

        f1.put("c206",
                bi.c206a.isChecked() ? "1" :
                        bi.c206b.isChecked() ? "2" :
                                bi.c206c.isChecked() ? "3" :
                                        bi.c20697.isChecked() ? "97" :
                                                bi.c20698.isChecked() ? "98" :
                                                        "0");

        f1.put("c207",
                bi.c207a.isChecked() ? "1" :
                        bi.c207b.isChecked() ? "2" :
                                bi.c207c.isChecked() ? "3" :
                                        bi.c207d.isChecked() ? "4" :
                                                bi.c20797.isChecked() ? "97" :
                                                        bi.c20798.isChecked() ? "98" :
                                                                "0");

        f1.put("c208",
                bi.c208a.isChecked() ? "1" :
                        bi.c208b.isChecked() ? "2" :
                                bi.c208c.isChecked() ? "3" :
                                        bi.c208d.isChecked() ? "4" :
                                                bi.c20898.isChecked() ? "98" :
                                                        bi.c20896.isChecked() ? "96" :
                                                                "0");
        f1.put("c20896x", bi.c20896x.getText().toString());

        f1.put("c209",
                bi.c209a.isChecked() ? "1" :
                        bi.c209b.isChecked() ? "2" :
                                bi.c209c.isChecked() ? "3" :
                                        bi.c209d.isChecked() ? "4" :
                                                bi.c209e.isChecked() ? "5" :
                                                        bi.c209f.isChecked() ? "6" :
                                                                bi.c20998.isChecked() ? "98" :
                                                                        bi.c20996.isChecked() ? "96" :
                                                                                "0");
        f1.put("c20996x", bi.c20996x.getText().toString());

        f1.put("c210",
                bi.c210a.isChecked() ? "1" :
                        bi.c210b.isChecked() ? "2" :
                                bi.c21098.isChecked() ? "98" :
                                        "0");

        f1.put("c211",
                bi.c211a.isChecked() ? "1" :
                        bi.c211b.isChecked() ? "2" :
                                bi.c211c.isChecked() ? "3" :
                                        bi.c211d.isChecked() ? "4" :
                                                bi.c211e.isChecked() ? "5" :
                                                        bi.c211f.isChecked() ? "6" :
                                                                bi.c211g.isChecked() ? "7" :
                                                                        bi.c21198.isChecked() ? "98" :
                                                                                bi.c21196.isChecked() ? "96" :
                                                                                        "0");
        f1.put("c21196x", bi.c21196x.getText().toString());

        f1.put("c212",
                bi.c212a.isChecked() ? "1" :
                        bi.c212b.isChecked() ? "2" :
                                bi.c212c.isChecked() ? "3" :
                                        bi.c212d.isChecked() ? "4" :
                                                bi.c21298.isChecked() ? "98" :
                                                        bi.c21296.isChecked() ? "96" :
                                                                "0");
        f1.put("c21296x", bi.c21296x.getText().toString());

        f1.put("c213a", bi.c213a.isChecked() ? "1" : "0");
        f1.put("c213b", bi.c213b.isChecked() ? "2" : "0");
        f1.put("c213c", bi.c213c.isChecked() ? "3" : "0");
        f1.put("c213d", bi.c213d.isChecked() ? "4" : "0");
        f1.put("c213e", bi.c213e.isChecked() ? "5" : "0");
        f1.put("c213f", bi.c213f.isChecked() ? "6" : "0");
        f1.put("c213g", bi.c213g.isChecked() ? "7" : "0");
        f1.put("c213h", bi.c213h.isChecked() ? "8" : "0");
        f1.put("c21397", bi.c21397.isChecked() ? "97" : "0");

        MainApp.child.setsC2(String.valueOf(f1));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionC2);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }


}
