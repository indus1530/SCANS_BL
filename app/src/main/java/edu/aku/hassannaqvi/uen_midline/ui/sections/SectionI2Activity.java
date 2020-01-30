package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.contracts.ChildContract;
import edu.aku.hassannaqvi.uen_midline.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_midline.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionI2Binding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;
import kotlin.Pair;

import static edu.aku.hassannaqvi.uen_midline.ui.list_activity.FamilyMembersListActivity.mainVModel;

public class SectionI2Activity extends AppCompatActivity {

    ActivitySectionI2Binding bi;
    private FamilyMembersContract fmc_child, res_child;
    private Pair<List<Integer>, List<String>> childLst, resList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_i2);
        bi.setCallback(this);

        setUIComponent();
        setlistener();
    }

    private void setUIComponent() {

        childLst = mainVModel.getAllUnder5();

        List<String> childLst = new ArrayList<String>() {
            {
                add("....");
                addAll(SectionI2Activity.this.childLst.getSecond());
            }
        };

        bi.i200.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, childLst));
    }

    private void populateRespondentSpinner() {
        resList = mainVModel.getAllRespondent();
        List<String> reponList = new ArrayList<String>() {
            {
                add("....");
                addAll(SectionI2Activity.this.resList.getSecond());
            }
        };

        bi.i20res.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, reponList));
    }

    private void setlistener() {

        bi.i200.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) return;
                fmc_child = mainVModel.getMemberInfo(childLst.getFirst().get(bi.i200.getSelectedItemPosition() - 1));
                if (fmc_child.getMother_serial().equals("97")) {
                    bi.respondentSpinner.setVisibility(View.VISIBLE);
                    populateRespondentSpinner();
                } else {
                    bi.respondentSpinner.setVisibility(View.GONE);
                    res_child = mainVModel.getMemberInfo(Integer.valueOf(fmc_child.getSerialno()));
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bi.i20res.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) return;
                res_child = mainVModel.getMemberInfo(resList.getFirst().get(bi.i20res.getSelectedItemPosition() - 1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bi.i201.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.i201b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVi202, null);
            }

        }));

        bi.i203.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.i203b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpi021, null);
            }
        }));

        bi.i207.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.i207a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVi208, null);
            }
        }));

        bi.i207.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.i207b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpi025, null);
            }
        }));

        bi.i209.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.i209a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpi023, null);
            }
        }));

        bi.i214.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.i214b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpi024, null);
            }
        }));

        bi.i222.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.i222b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpi022, null);
            }
        }));

        bi.i225.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.i225b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVi226, null);
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
                startActivity(new Intent(this, SectionJActivity.class));
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
        int updcount = db.updatesChildColumn(ChildContract.SingleChild.COLUMN_SI2, MainApp.child.getsI2());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject f1 = new JSONObject();

        f1.put("i2_fm_uid", fmc_child.getUid());
        f1.put("i2_fm_serial", fmc_child.getSerialno());
        f1.put("i2_res_fm_uid", res_child.getUid());
        f1.put("i2_res_fm_serial", res_child.getSerialno());
        JSONObject f2 = new JSONObject();

        f2.put("i201", bi.i201a.isChecked() ? "1" :
                bi.i201b.isChecked() ? "2" : "0");

        f2.put("i202", bi.i202.getText().toString());

        f2.put("i203", bi.i203a.isChecked() ? "1" :
                bi.i203b.isChecked() ? "2" : "0");

        f2.put("i204", bi.i204.getText().toString());

        f2.put("i205", bi.i205a.isChecked() ? "1" :
                bi.i205b.isChecked() ? "2" :
                        bi.i205c.isChecked() ? "98" : "0");

        f2.put("i206", bi.i206.getText().toString());

        f2.put("i207", bi.i207a.isChecked() ? "1" :
                bi.i207b.isChecked() ? "2" : "0");

        f2.put("i208", bi.i208a.isChecked() ? "1" :
                bi.i208b.isChecked() ? "2" :
                        bi.i208c.isChecked() ? "3" :
                                bi.i208d.isChecked() ? "4" :
                                        bi.i208e.isChecked() ? "5" :
                                                bi.i208f.isChecked() ? "6" :
                                                        bi.i208g.isChecked() ? "7" :
                                                                bi.i208h.isChecked() ? "8" : "0");

        f2.put("i209", bi.i209a.isChecked() ? "1" :
                bi.i209b.isChecked() ? "2" :
                        bi.i209c.isChecked() ? "3" :
                                bi.i209d.isChecked() ? "4" : "0");

        f2.put("i210", bi.i210a.isChecked() ? "1" :
                bi.i210b.isChecked() ? "2" :
                                bi.i210c.isChecked() ? "3" :
                                        bi.i210d.isChecked() ? "4" :
                                                bi.i210e.isChecked() ? "5" :
                                                        bi.i210f.isChecked() ? "6" :
                                                                bi.i210g.isChecked() ? "7" :
                                                                        bi.i210h.isChecked() ? "8" : "0");

        f2.put("i211", bi.i211.getText().toString());

        f2.put("i212", bi.i212.getText().toString());

        f2.put("i213", bi.i213a.isChecked() ? "1" :
                bi.i213b.isChecked() ? "2" :
                        bi.i213c.isChecked() ? "3" :
                                bi.i213d.isChecked() ? "4" :
                                        bi.i213e.isChecked() ? "5" : "0");

        f2.put("i214", bi.i214a.isChecked() ? "1" :
                bi.i214b.isChecked() ? "2" : "0");

        f2.put("i215", bi.i215a.isChecked() ? "1" :
                bi.i215b.isChecked() ? "2" :
                        bi.i215c.isChecked() ? "3" : "0");

        f2.put("i216", bi.i216.getText().toString());

        f2.put("i217", bi.i217a.isChecked() ? "1" :
                bi.i217b.isChecked() ? "2" :
                        bi.i217c.isChecked() ? "98" : "0");

        f2.put("i218a", bi.i218a.isChecked() ? "1" : "0");
        f2.put("i218b", bi.i218b.isChecked() ? "2" : "0");
        f2.put("i218c", bi.i218c.isChecked() ? "3" : "0");
        f2.put("i218d", bi.i218d.isChecked() ? "4" : "0");
        f2.put("i218e", bi.i218e.isChecked() ? "5" : "0");
        f2.put("i218f", bi.i218f.isChecked() ? "6" : "0");
        f2.put("i218g", bi.i218g.isChecked() ? "7" : "0");
        f2.put("i218h", bi.i218h.isChecked() ? "8" : "0");
        f2.put("i218i", bi.i218i.isChecked() ? "9" : "0");
        f2.put("i218j", bi.i218j.isChecked() ? "10" : "0");
        f2.put("i218k", bi.i218k.isChecked() ? "11" : "0");
        f2.put("i218l", bi.i218l.isChecked() ? "12" : "0");
        f2.put("i218m", bi.i218m.isChecked() ? "13" : "0");
        f2.put("i218n", bi.i218n.isChecked() ? "14" : "0");

        f2.put("i219", bi.i219a.isChecked() ? "1" :
                bi.i219b.isChecked() ? "2" : "0");

        f2.put("i220", bi.i220a.isChecked() ? "1" :
                bi.i220b.isChecked() ? "2" : "0");

        f2.put("i221", bi.i221.getText().toString());

        f2.put("i222", bi.i222a.isChecked() ? "1" :
                bi.i222b.isChecked() ? "2" : "0");

        f2.put("i223", bi.i223a.isChecked() ? "1" :
                bi.i223b.isChecked() ? "2" :
                        bi.i223c.isChecked() ? "3" :
                                bi.i223d.isChecked() ? "4" :
                                        bi.i223e.isChecked() ? "5" :
                                                bi.i223f.isChecked() ? "6" :
                                                        bi.i223g.isChecked() ? "7" : "0");

        f2.put("i224a", bi.i224a.isChecked() ? "1" : "0");
        f2.put("i224b", bi.i224b.isChecked() ? "2" : "0");
        f2.put("i224c", bi.i224c.isChecked() ? "3" : "0");
        f2.put("i224d", bi.i224d.isChecked() ? "4" : "0");
        f2.put("i224e", bi.i224e.isChecked() ? "5" : "0");
        f2.put("i224f", bi.i224f.isChecked() ? "6" : "0");

        f2.put("i225", bi.i225a.isChecked() ? "1" :
                bi.i225b.isChecked() ? "2" : "0");

        f2.put("i226", bi.i226a.isChecked() ? "1" :
                bi.i226b.isChecked() ? "2" :
                        bi.i226c.isChecked() ? "3" :
                                bi.i226d.isChecked() ? "4" :
                                        bi.i226e.isChecked() ? "5" :
                                                bi.i226f.isChecked() ? "6" : "0");

        MainApp.child.setsI2(String.valueOf(f2));
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectioni02);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
