package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.contracts.KishMWRAContract;
import edu.aku.hassannaqvi.uen_midline.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionH2Binding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;

public class SectionH2Activity extends AppCompatActivity {

    ActivitySectionH2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h2);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        //h202
        bi.h202.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h202a.getId()) {
                bi.fldGrpCVh203.setVisibility(View.VISIBLE);
                bi.fldGrpCVh204.setVisibility(View.VISIBLE);
                bi.fldGrpCVh205.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVh203, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh204, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh205, null);
                bi.fldGrpCVh203.setVisibility(View.GONE);
                bi.fldGrpCVh204.setVisibility(View.GONE);
                bi.fldGrpCVh205.setVisibility(View.GONE);
            }
        });


        //h206
        bi.h206.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h206a.getId()) {
                bi.fldGrpCVh207.setVisibility(View.VISIBLE);
                bi.fldGrpCVh208.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVh207, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh208, null);
                bi.fldGrpCVh207.setVisibility(View.GONE);
                bi.fldGrpCVh208.setVisibility(View.GONE);
            }
        });


        //h209
        bi.h209.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h209a.getId()) {
                bi.fldGrpCVh210.setVisibility(View.VISIBLE);
                bi.fldGrpCVh211.setVisibility(View.VISIBLE);
                bi.fldGrpCVh212.setVisibility(View.VISIBLE);
                bi.fldGrpCVh213.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVh210, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh211, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh212, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh213, null);
                bi.fldGrpCVh210.setVisibility(View.GONE);
                bi.fldGrpCVh211.setVisibility(View.GONE);
                bi.fldGrpCVh212.setVisibility(View.GONE);
                bi.fldGrpCVh213.setVisibility(View.GONE);
            }
        });


        //h218
        bi.h218.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h218a.getId()) {
                bi.fldGrpCVh219.setVisibility(View.VISIBLE);
                bi.fldGrpCVh220.setVisibility(View.VISIBLE);
                bi.fldGrpCVh221.setVisibility(View.VISIBLE);
                bi.fldGrpCVh222.setVisibility(View.VISIBLE);
                bi.fldGrpCVh223.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVh219, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh220, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh221, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh222, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh223, null);
                bi.fldGrpCVh219.setVisibility(View.GONE);
                bi.fldGrpCVh220.setVisibility(View.GONE);
                bi.fldGrpCVh221.setVisibility(View.GONE);
                bi.fldGrpCVh222.setVisibility(View.GONE);
                bi.fldGrpCVh223.setVisibility(View.GONE);
            }
        });

        //h20798
        bi.h20798.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                ClearClass.ClearAllFields(bi.h207check, false);
                bi.h207check.setTag("-1");
            } else {
                ClearClass.ClearAllFields(bi.h207check, true);
                bi.h207check.setTag("0");
            }
        });


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
                startActivity(new Intent(this, SectionKActivity.class));
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
        int updcount = db.updatesKishMWRAColumn(KishMWRAContract.SingleKishMWRA.COLUMN_SH2, MainApp.kish.getsH2());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("h201", bi.h201a.isChecked() ? "1" :
                bi.h201b.isChecked() ? "2" :
                        bi.h201c.isChecked() ? "3" : "0");
        json.put("h201x", bi.h201x.getText().toString());

        json.put("h202", bi.h202a.isChecked() ? "1" :
                bi.h202b.isChecked() ? "2" : "0");

        json.put("h203", bi.h203a.isChecked() ? "1" :
                bi.h203b.isChecked() ? "2" :
                        bi.h203c.isChecked() ? "3" : "0");
        json.put("h203x", bi.h203x.getText().toString());

        json.put("h204", bi.h204a.isChecked() ? "1" :
                bi.h204b.isChecked() ? "2" :
                        bi.h204c.isChecked() ? "3" : "0");

        json.put("h205", bi.h205a.isChecked() ? "1" :
                bi.h205b.isChecked() ? "2" :
                                bi.h205c.isChecked() ? "3" :
                                        bi.h205d.isChecked() ? "4" :
                                                bi.h205e.isChecked() ? "5" : "0");

        json.put("h206", bi.h206a.isChecked() ? "1" :
                bi.h206b.isChecked() ? "2" : "0");

        json.put("h207a", bi.h207a.isChecked() ? "1" : "0");
        json.put("h207b", bi.h207b.isChecked() ? "2" : "0");
        json.put("h207c", bi.h207c.isChecked() ? "3" : "0");
        json.put("h207d", bi.h207d.isChecked() ? "4" : "0");
        json.put("h207e", bi.h207e.isChecked() ? "5" : "0");
        json.put("h207f", bi.h207f.isChecked() ? "6" : "0");
        json.put("h207g", bi.h207g.isChecked() ? "7" : "0");
        json.put("h207h", bi.h207h.isChecked() ? "8" : "0");
        json.put("h207i", bi.h20798.isChecked() ? "98" : "0");

        json.put("h208a", bi.h208a.isChecked() ? "1" : "0");
        json.put("h208b", bi.h208b.isChecked() ? "2" : "0");
        json.put("h208c", bi.h208c.isChecked() ? "3" : "0");
        json.put("h208d", bi.h208d.isChecked() ? "4" : "0");
        json.put("h208e", bi.h208e.isChecked() ? "5" : "0");
        json.put("h208f", bi.h208f.isChecked() ? "6" : "0");

        json.put("h209", bi.h209a.isChecked() ? "1" :
                bi.h209b.isChecked() ? "2" : "0");

        json.put("h210", bi.h210a.isChecked() ? "1" :
                bi.h210b.isChecked() ? "2" :
                                bi.h210c.isChecked() ? "3" :
                                        bi.h21098.isChecked() ? "98" : "0");

        json.put("h211", bi.h211a.isChecked() ? "1" :
                bi.h211b.isChecked() ? "2" :
                                bi.h211c.isChecked() ? "3" :
                                        bi.h211d.isChecked() ? "4" :
                                                bi.h211e.isChecked() ? "5" :
                                                        bi.h211f.isChecked() ? "6" :
                                                                bi.h211g.isChecked() ? "7" :
                                                                        bi.h211h.isChecked() ? "8" :
                                                                                bi.h211i.isChecked() ? "9" : "0");

        json.put("h212", bi.h212.getText().toString());

        json.put("h213", bi.h213a.isChecked() ? "1" :
                bi.h213b.isChecked() ? "2" :
                        bi.h213c.isChecked() ? "3" : "0");

        json.put("h214", bi.h214a.isChecked() ? "1" :
                bi.h214b.isChecked() ? "2" :
                                bi.h214c.isChecked() ? "3" :
                                        bi.h214d.isChecked() ? "4" : "0");

        json.put("h215", bi.h215a.isChecked() ? "1" :
                bi.h215b.isChecked() ? "2" :
                                bi.h215c.isChecked() ? "3" :
                                        bi.h215d.isChecked() ? "4" :
                                                bi.h215e.isChecked() ? "5" : "0");

        json.put("h216", bi.h216a.isChecked() ? "1" :
                bi.h216b.isChecked() ? "2" :
                        bi.h216c.isChecked() ? "3" : "0");

        json.put("h217", bi.h217a.isChecked() ? "1" :
                bi.h217b.isChecked() ? "2" :
                                bi.h217c.isChecked() ? "3" :
                                        bi.h217d.isChecked() ? "4" :
                                                bi.h217e.isChecked() ? "5" :
                                                        bi.h217f.isChecked() ? "6" :
                                                                bi.h21796.isChecked() ? "96" : "0");
        json.put("h21796x", bi.h21796x.getText().toString());

        json.put("h218", bi.h218a.isChecked() ? "1" :
                bi.h218b.isChecked() ? "2" :
                        bi.h21898.isChecked() ? "98" : "0");

        json.put("h219", bi.h219a.isChecked() ? "1" :
                bi.h219b.isChecked() ? "2" :
                                bi.h219c.isChecked() ? "3" :
                                        bi.h219d.isChecked() ? "4" :
                                                bi.h219e.isChecked() ? "5" :
                                                        bi.h219f.isChecked() ? "6" :
                                                                bi.h21996.isChecked() ? "96" : "0");
        json.put("h21996x", bi.h21996x.getText().toString());

        json.put("h220", bi.h220a.isChecked() ? "1" :
                bi.h220b.isChecked() ? "2" :
                                bi.h220c.isChecked() ? "3" :
                                        bi.h220d.isChecked() ? "4" :
                                                bi.h220e.isChecked() ? "5" :
                                                        bi.h220f.isChecked() ? "6" :
                                                                bi.h22096.isChecked() ? "96" : "0");
        json.put("h22096x", bi.h22096x.getText().toString());

        json.put("h221", bi.h221a.isChecked() ? "1" :
                bi.h221b.isChecked() ? "2" :
                        bi.h221c.isChecked() ? "3" : "0");

        json.put("h222", bi.h222a.isChecked() ? "1" :
                bi.h222b.isChecked() ? "2" :
                                bi.h222c.isChecked() ? "3" :
                                        bi.h222d.isChecked() ? "4" :
                                                bi.h22296.isChecked() ? "96" : "0");
        json.put("h22296x", bi.h22296x.getText().toString());

        json.put("h223", bi.h223a.isChecked() ? "1" :
                bi.h223b.isChecked() ? "2" :
                                bi.h223c.isChecked() ? "4" :
                                        bi.h223d.isChecked() ? "5" : "0");

        MainApp.kish.setsH2(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}
