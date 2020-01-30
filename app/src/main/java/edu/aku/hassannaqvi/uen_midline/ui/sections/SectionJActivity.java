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

import edu.aku.hassannaqvi.uen_midline.CONSTANTS;
import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.contracts.ChildContract;
import edu.aku.hassannaqvi.uen_midline.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_midline.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionJBinding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;
import kotlin.Pair;

import static edu.aku.hassannaqvi.uen_midline.ui.list_activity.FamilyMembersListActivity.mainVModel;

public class SectionJActivity extends AppCompatActivity {

    ActivitySectionJBinding bi;
    private FamilyMembersContract fmc_child, res_child;
    private Pair<List<Integer>, List<String>> childLst, resList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j);
        bi.setCallback(this);

        setUIComponent();
        setlistener();

    }

    private void setUIComponent() {

        childLst = mainVModel.getAllUnder5();

        List<String> childLst = new ArrayList<String>() {
            {
                add("....");
                addAll(SectionJActivity.this.childLst.getSecond());
            }
        };

        bi.j100.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, childLst));

        bi.j103c.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.j103c.setMinvalue(CONSTANTS.MINYEAR_IM);

        bi.j10401y.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.j10401y.setMinvalue(CONSTANTS.MINYEAR_IM);

        bi.j10402y.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.j10402y.setMinvalue(CONSTANTS.MINYEAR_IM);

        bi.j10403y.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.j10403y.setMinvalue(CONSTANTS.MINYEAR_IM);

        bi.j10404y.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.j10404y.setMinvalue(CONSTANTS.MINYEAR_IM);

        bi.j10405y.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.j10405y.setMinvalue(CONSTANTS.MINYEAR_IM);

        bi.j10406y.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.j10406y.setMinvalue(CONSTANTS.MINYEAR_IM);

        bi.j10407y.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.j10407y.setMinvalue(CONSTANTS.MINYEAR_IM);

        bi.j10408y.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.j10408y.setMinvalue(CONSTANTS.MINYEAR_IM);

    }

    private void populateRespondentSpinner() {
        resList = mainVModel.getAllRespondent();
        List<String> reponList = new ArrayList<String>() {
            {
                add("....");
                addAll(SectionJActivity.this.resList.getSecond());
            }
        };

        bi.j100res.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, reponList));
    }

    private void setlistener() {

        bi.j100.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) return;
                fmc_child = mainVModel.getMemberInfo(childLst.getFirst().get(bi.j100.getSelectedItemPosition() - 1));
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

        bi.j100res.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) return;
                res_child = mainVModel.getMemberInfo(resList.getFirst().get(bi.j100res.getSelectedItemPosition() - 1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bi.j101.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.j101c.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVj102, null);
            }

        }));

        bi.j102.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.j102a.getId() || i == bi.j102b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpSectionJ011, null);
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
                startActivity(new Intent(this, SectionJ02Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesChildColumn(ChildContract.SingleChild.COLUMN_SJ, MainApp.child.getsJ());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();
        json.put("j_fm_uid", fmc_child.getUid());
        json.put("j_fm_serial", fmc_child.getSerialno());
        json.put("j_res_fm_uid", res_child.getUid());
        json.put("j_res_fm_serial", res_child.getSerialno());

        json.put("j101", bi.j101a.isChecked() ? "1" :
                bi.j101b.isChecked() ? "2" :
                        bi.j101c.isChecked() ? "3" : "0");

        json.put("j102", bi.j102a.isChecked() ? "1" :
                bi.j102b.isChecked() ? "2" : "0");

        json.put("j103d", bi.j103d.isChecked() ? "98" : "0");
        json.put("j103a", bi.j103a.getText().toString());
        json.put("j103b", bi.j103b.getText().toString());
        json.put("j103c", bi.j103c.getText().toString());

        json.put("j10401d", bi.j10401d.getText().toString());
        json.put("j10401m", bi.j10401m.getText().toString());
        json.put("j10401y", bi.j10401y.getText().toString());

        json.put("j10401a", bi.j10401aa.isChecked() ? "1" :
                bi.j10401ab.isChecked() ? "2" :
                        bi.j10401ac.isChecked() ? "3" :
                                bi.j10401ad.isChecked() ? "4" :
                                        bi.j10401ae.isChecked() ? "5" :
                                                bi.j10401af.isChecked() ? "6" : "0");

        json.put("j10401b", bi.j10401ba.isChecked() ? "1" :
                bi.j10401bb.isChecked() ? "2" :
                        bi.j10401bc.isChecked() ? "3" :
                                bi.j10401bd.isChecked() ? "4" :
                                        bi.j10401be.isChecked() ? "5" :
                                                bi.j10401bf.isChecked() ? "6" :
                                                        bi.j10401bg.isChecked() ? "7" :
                                                                bi.j10401b96.isChecked() ? "96" : "0");
        json.put("j10401b96x", bi.j10401b96x.getText().toString());

        json.put("j10402d", bi.j10402d.getText().toString());
        json.put("j10402m", bi.j10402m.getText().toString());
        json.put("j10402y", bi.j10402y.getText().toString());

        json.put("j10402a", bi.j10402aa.isChecked() ? "1" :
                bi.j10402ab.isChecked() ? "2" :
                        bi.j10402ac.isChecked() ? "3" :
                                bi.j10402ad.isChecked() ? "4" :
                                        bi.j10402ae.isChecked() ? "5" :
                                                bi.j10402af.isChecked() ? "6" : "0");

        json.put("j10402b", bi.j10402ba.isChecked() ? "1" :
                bi.j10402bb.isChecked() ? "2" :
                        bi.j10402bc.isChecked() ? "3" :
                                bi.j10402bd.isChecked() ? "4" :
                                        bi.j10402be.isChecked() ? "5" :
                                                bi.j10402bf.isChecked() ? "6" :
                                                        bi.j10402bg.isChecked() ? "7" :
                                                                bi.j10402b96.isChecked() ? "96" : "0");
        json.put("j10402b96x", bi.j10402b96x.getText().toString());

        json.put("j10403d", bi.j10403d.getText().toString());
        json.put("j10403m", bi.j10403m.getText().toString());
        json.put("j10403y", bi.j10403y.getText().toString());

        json.put("j10403a", bi.j10403aa.isChecked() ? "1" :
                bi.j10403ab.isChecked() ? "2" :
                        bi.j10403ac.isChecked() ? "3" :
                                bi.j10403ad.isChecked() ? "4" :
                                        bi.j10403ae.isChecked() ? "5" :
                                                bi.j10403af.isChecked() ? "6" : "0");

        json.put("j10403b", bi.j10403ba.isChecked() ? "1" :
                bi.j10403bb.isChecked() ? "2" :
                        bi.j10403bc.isChecked() ? "3" :
                                bi.j10403bd.isChecked() ? "4" :
                                        bi.j10403be.isChecked() ? "5" :
                                                bi.j10403bf.isChecked() ? "6" :
                                                        bi.j10403bg.isChecked() ? "7" :
                                                                bi.j10403b96.isChecked() ? "96" : "0");
        json.put("j10403b96x", bi.j10403b96x.getText().toString());

        json.put("j10404d", bi.j10404d.getText().toString());
        json.put("j10404m", bi.j10404m.getText().toString());
        json.put("j10404y", bi.j10404y.getText().toString());

        json.put("j10404a", bi.j10404aa.isChecked() ? "1" :
                bi.j10404ab.isChecked() ? "2" :
                        bi.j10404ac.isChecked() ? "3" :
                                bi.j10404ad.isChecked() ? "4" :
                                        bi.j10404ae.isChecked() ? "5" :
                                                bi.j10404af.isChecked() ? "6" : "0");

        json.put("j10404b", bi.j10404ba.isChecked() ? "1" :
                bi.j10404bb.isChecked() ? "2" :
                        bi.j10404bc.isChecked() ? "3" :
                                bi.j10404bd.isChecked() ? "4" :
                                        bi.j10404be.isChecked() ? "5" :
                                                bi.j10404bf.isChecked() ? "6" :
                                                        bi.j10404bg.isChecked() ? "7" :
                                                                bi.j10404b96.isChecked() ? "96" : "0");
        json.put("j10404b96x", bi.j10404b96x.getText().toString());

        json.put("j10405d", bi.j10405d.getText().toString());
        json.put("j10405m", bi.j10405m.getText().toString());
        json.put("j10405y", bi.j10405y.getText().toString());

        json.put("j10405a", bi.j10405aa.isChecked() ? "1" :
                bi.j10405ab.isChecked() ? "2" :
                        bi.j10405ac.isChecked() ? "3" :
                                bi.j10405ad.isChecked() ? "4" :
                                        bi.j10405ae.isChecked() ? "5" :
                                                bi.j10405af.isChecked() ? "6" : "0");

        json.put("j10405b", bi.j10405ba.isChecked() ? "1" :
                bi.j10405bb.isChecked() ? "2" :
                        bi.j10405bc.isChecked() ? "3" :
                                bi.j10405bd.isChecked() ? "4" :
                                        bi.j10405be.isChecked() ? "5" :
                                                bi.j10405bf.isChecked() ? "6" :
                                                        bi.j10405bg.isChecked() ? "7" :
                                                                bi.j10405b96.isChecked() ? "96" :
                                                                        "0");
        json.put("j10405b96x", bi.j10405b96x.getText().toString());

        json.put("j10406d", bi.j10406d.getText().toString());
        json.put("j10406m", bi.j10406m.getText().toString());
        json.put("j10406y", bi.j10406y.getText().toString());

        json.put("j10406a",
                bi.j10406aa.isChecked() ? "1" :
                        bi.j10406ab.isChecked() ? "2" :
                                bi.j10406ac.isChecked() ? "3" :
                                        bi.j10406ad.isChecked() ? "4" :
                                                bi.j10406ae.isChecked() ? "5" :
                                                        bi.j10406af.isChecked() ? "6" :
                                                                "0");

        json.put("j10406b",
                bi.j10406ba.isChecked() ? "1" :
                        bi.j10406bb.isChecked() ? "2" :
                                bi.j10406bc.isChecked() ? "3" :
                                        bi.j10406bd.isChecked() ? "4" :
                                                bi.j10406be.isChecked() ? "5" :
                                                        bi.j10406bf.isChecked() ? "6" :
                                                                bi.j10406bg.isChecked() ? "7" :
                                                                        bi.j10406b96.isChecked() ? "96" :
                                                                                "0");
        json.put("j10406b96x", bi.j10406b96x.getText().toString());

        json.put("j10407d", bi.j10407d.getText().toString());
        json.put("j10407m", bi.j10407m.getText().toString());
        json.put("j10407y", bi.j10407y.getText().toString());

        json.put("j10407a",
                bi.j10407aa.isChecked() ? "1" :
                        bi.j10407ab.isChecked() ? "2" :
                                bi.j10407ac.isChecked() ? "3" :
                                        bi.j10407ad.isChecked() ? "4" :
                                                bi.j10407ae.isChecked() ? "5" :
                                                        bi.j10407af.isChecked() ? "6" :
                                                                "0");

        json.put("j10407b",
                bi.j10407ba.isChecked() ? "1" :
                        bi.j10407bb.isChecked() ? "2" :
                                bi.j10407bc.isChecked() ? "3" :
                                        bi.j10407bd.isChecked() ? "4" :
                                                bi.j10407be.isChecked() ? "5" :
                                                        bi.j10407bf.isChecked() ? "6" :
                                                                bi.j10407bg.isChecked() ? "7" :
                                                                        bi.j10407b96.isChecked() ? "96" :
                                                                                "0");
        json.put("j10407b96x", bi.j10407b96x.getText().toString());

        json.put("j10408d", bi.j10408d.getText().toString());
        json.put("j10408m", bi.j10408m.getText().toString());
        json.put("j10408y", bi.j10408y.getText().toString());

        json.put("j10408a",
                bi.j10408aa.isChecked() ? "1" :
                        bi.j10408ab.isChecked() ? "2" :
                                bi.j10408ac.isChecked() ? "3" :
                                        bi.j10408ad.isChecked() ? "4" :
                                                bi.j10408ae.isChecked() ? "5" :
                                                        bi.j10408af.isChecked() ? "6" :
                                                                "0");

        json.put("j10408b",
                bi.j10408ba.isChecked() ? "1" :
                        bi.j10408bb.isChecked() ? "2" :
                                bi.j10408bc.isChecked() ? "3" :
                                        bi.j10408bd.isChecked() ? "4" :
                                                bi.j10408be.isChecked() ? "5" :
                                                        bi.j10408bf.isChecked() ? "6" :
                                                                bi.j10408bg.isChecked() ? "7" :
                                                                        bi.j10408b96.isChecked() ? "96" :
                                                                                "0");
        json.put("j10408b96x", bi.j10408b96x.getText().toString());


        MainApp.child.setsJ(String.valueOf(json));

    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionJ01);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }
}
