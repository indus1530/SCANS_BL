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
import edu.aku.hassannaqvi.uen_midline.contracts.ChildContract;
import edu.aku.hassannaqvi.uen_midline.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionJ03Binding;
import edu.aku.hassannaqvi.uen_midline.utils.JSONUtils;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;

public class SectionJ03Activity extends AppCompatActivity {


    ActivitySectionJ03Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j03);
        bi.setCallback(this);

        setupSkips();
        setlistener();
    }

    private void setupSkips() {

        //j105
        bi.j105.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.j105a.getId()) {
                bi.fldGrpCVj106.setVisibility(View.GONE);
                bi.fldGrpCVj108.setVisibility(View.GONE);
                bi.fldGrpCVj109.setVisibility(View.GONE);
                bi.fldGrpCVj111.setVisibility(View.GONE);
                bi.fldGrpCVj112.setVisibility(View.GONE);
                bi.fldGrpCVj113.setVisibility(View.GONE);
                bi.fldGrpCVj114.setVisibility(View.GONE);
                bi.fldGrpCVj115.setVisibility(View.GONE);
                bi.fldGrpCVj116.setVisibility(View.GONE);
                bi.fldGrpCVj117.setVisibility(View.GONE);
                bi.fldGrpCVj118.setVisibility(View.GONE);
                bi.fldGrpCVj119.setVisibility(View.GONE);
                bi.fldGrpCVj120.setVisibility(View.GONE);
                bi.fldGrpCVj121.setVisibility(View.GONE);
                ClearClass.ClearAllFields(bi.fldGrpCVj106, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj108, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj109, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj111, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj112, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj113, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj114, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj115, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj116, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj117, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj118, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj119, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj120, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj121, null);
            } else {
                bi.fldGrpCVj106.setVisibility(View.VISIBLE);
                bi.fldGrpCVj108.setVisibility(View.VISIBLE);
                bi.fldGrpCVj109.setVisibility(View.VISIBLE);
                bi.fldGrpCVj111.setVisibility(View.VISIBLE);
                bi.fldGrpCVj112.setVisibility(View.VISIBLE);
                bi.fldGrpCVj113.setVisibility(View.VISIBLE);
                bi.fldGrpCVj114.setVisibility(View.VISIBLE);
                bi.fldGrpCVj115.setVisibility(View.VISIBLE);
                bi.fldGrpCVj116.setVisibility(View.VISIBLE);
                bi.fldGrpCVj117.setVisibility(View.VISIBLE);
                bi.fldGrpCVj118.setVisibility(View.VISIBLE);
                bi.fldGrpCVj119.setVisibility(View.VISIBLE);
                bi.fldGrpCVj120.setVisibility(View.VISIBLE);
                bi.fldGrpCVj121.setVisibility(View.VISIBLE);
            }
        });


        /*//h121
        bi.h121.setOnCheckedChangeListener((group, checkedId) -> {

            ClearClass.ClearAllFields(bi.fldGrpCVh122, null);
            ClearClass.ClearAllFields(bi.fldGrpCVh123, null);
            ClearClass.ClearAllFields(bi.fldGrpCVh124, null);
            bi.fldGrpCVh122.setVisibility(View.GONE);
            bi.fldGrpCVh123.setVisibility(View.GONE);
            bi.fldGrpCVh124.setVisibility(View.GONE);

            if (checkedId == bi.h121a.getId()) {
                bi.fldGrpCVh122.setVisibility(View.VISIBLE);
                bi.fldGrpCVh123.setVisibility(View.VISIBLE);
            } else if (checkedId == bi.h121b.getId()) {
                bi.fldGrpCVh124.setVisibility(View.VISIBLE);
            }
        });


        //h12298
        bi.h12298.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                ClearClass.ClearAllFields(bi.h122, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh123, null);
                bi.h122.setVisibility(View.GONE);
                bi.fldGrpCVh123.setVisibility(View.GONE);
            } else {
                bi.h122.setVisibility(View.VISIBLE);
                bi.fldGrpCVh123.setVisibility(View.VISIBLE);
            }
        });


        //h13598
        bi.h13598.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                ClearClass.ClearAllFields(bi.h135check, false);
                bi.h135check.setTag("-1");
            } else {
                ClearClass.ClearAllFields(bi.h135check, true);
                bi.h135check.setTag("0");
            }
        });*/


        //j106
        bi.j106.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.j106a.getId()) {
                bi.fldGrpCVj108.setVisibility(View.VISIBLE);
                bi.fldGrpCVj109.setVisibility(View.VISIBLE);
                bi.fldGrpCVj111.setVisibility(View.VISIBLE);
                bi.fldGrpCVj112.setVisibility(View.VISIBLE);
                bi.fldGrpCVj113.setVisibility(View.VISIBLE);
                bi.fldGrpCVj114.setVisibility(View.VISIBLE);
                bi.fldGrpCVj115.setVisibility(View.VISIBLE);
                bi.fldGrpCVj116.setVisibility(View.VISIBLE);
                bi.fldGrpCVj117.setVisibility(View.VISIBLE);
                bi.fldGrpCVj118.setVisibility(View.VISIBLE);
                bi.fldGrpCVj119.setVisibility(View.VISIBLE);
                bi.fldGrpCVj120.setVisibility(View.VISIBLE);
                bi.fldGrpCVj121.setVisibility(View.VISIBLE);
            } else {
                bi.fldGrpCVj108.setVisibility(View.GONE);
                bi.fldGrpCVj109.setVisibility(View.GONE);
                bi.fldGrpCVj111.setVisibility(View.GONE);
                bi.fldGrpCVj112.setVisibility(View.GONE);
                bi.fldGrpCVj113.setVisibility(View.GONE);
                bi.fldGrpCVj114.setVisibility(View.GONE);
                bi.fldGrpCVj115.setVisibility(View.GONE);
                bi.fldGrpCVj116.setVisibility(View.GONE);
                bi.fldGrpCVj117.setVisibility(View.GONE);
                bi.fldGrpCVj118.setVisibility(View.GONE);
                bi.fldGrpCVj119.setVisibility(View.GONE);
                bi.fldGrpCVj120.setVisibility(View.GONE);
                bi.fldGrpCVj121.setVisibility(View.GONE);
                ClearClass.ClearAllFields(bi.fldGrpCVj108, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj109, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj111, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj112, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj113, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj114, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj115, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj116, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj117, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj118, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj119, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj120, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj121, null);
            }
        });

        /*//j108
        bi.j108.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.j108b.getId()) {
                bi.fldGrpCVj109.setVisibility(View.GONE);
                bi.fldGrpCVj111.setVisibility(View.GONE);
                bi.fldGrpCVj112.setVisibility(View.GONE);
                bi.fldGrpCVj113.setVisibility(View.GONE);
                bi.fldGrpCVj114.setVisibility(View.GONE);
                bi.fldGrpCVj115.setVisibility(View.GONE);
                bi.fldGrpCVj116.setVisibility(View.GONE);
                bi.fldGrpCVj117.setVisibility(View.GONE);
                bi.fldGrpCVj118.setVisibility(View.GONE);
                bi.fldGrpCVj119.setVisibility(View.GONE);
                bi.fldGrpCVj120.setVisibility(View.GONE);
                bi.fldGrpCVj121.setVisibility(View.GONE);
                bi.fldGrpCVj122.setVisibility(View.GONE);
                ClearClass.ClearAllFields(bi.fldGrpCVj109, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj111, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj112, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj113, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj114, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj115, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj116, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj117, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj118, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj119, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj120, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj121, null);
                ClearClass.ClearAllFields(bi.fldGrpCVj122, null);
            } else {
                bi.fldGrpCVj109.setVisibility(View.VISIBLE);
                bi.fldGrpCVj111.setVisibility(View.VISIBLE);
                bi.fldGrpCVj112.setVisibility(View.VISIBLE);
                bi.fldGrpCVj113.setVisibility(View.VISIBLE);
                bi.fldGrpCVj114.setVisibility(View.VISIBLE);
                bi.fldGrpCVj115.setVisibility(View.VISIBLE);
                bi.fldGrpCVj116.setVisibility(View.VISIBLE);
                bi.fldGrpCVj117.setVisibility(View.VISIBLE);
                bi.fldGrpCVj118.setVisibility(View.VISIBLE);
                bi.fldGrpCVj119.setVisibility(View.VISIBLE);
                bi.fldGrpCVj120.setVisibility(View.VISIBLE);
                bi.fldGrpCVj121.setVisibility(View.VISIBLE);
                bi.fldGrpCVj122.setVisibility(View.VISIBLE);
            }
        });*/


    }

    private void setlistener() {

        bi.j108.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.j108b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpSectionJ0301, null);
            }

        }));

        bi.j111.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.j111a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpSectionJ0302, null);
            }

        }));

        bi.j115.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.j115a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVj116, null);
            }

        }));

        bi.j117.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.j117a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVj118, null);
            }

        }));

        bi.j120.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.j120a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVj121, null);
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
                startActivity(new Intent(this, SectionMActivity.class));
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

        json.put("j105",
                bi.j105a.isChecked() ? "1" :
                        bi.j105b.isChecked() ? "2" :
                                "0");

        json.put("j106",
                bi.j106a.isChecked() ? "1" :
                        bi.j106b.isChecked() ? "2" :
                                bi.j106c.isChecked() ? "98" :
                                        "0");

        json.put("j108",
                bi.j108a.isChecked() ? "1" :
                        bi.j108b.isChecked() ? "2" :
                                bi.j108c.isChecked() ? "98" :
                                        "0");

        json.put("j109",
                bi.j109a.isChecked() ? "1" :
                        bi.j109b.isChecked() ? "2" :
                                bi.j109c.isChecked() ? "98" :
                                        "0");

        json.put("j111",
                bi.j111a.isChecked() ? "1" :
                        bi.j111b.isChecked() ? "2" :
                                bi.j111c.isChecked() ? "98" :
                                        "0");

        json.put("j112",
                bi.j112a.isChecked() ? "1" :
                        bi.j112b.isChecked() ? "2" :
                                bi.j112c.isChecked() ? "98" :
                                        "0");

        json.put("j113", bi.j113.getText().toString());

        json.put("j114",
                bi.j114a.isChecked() ? "1" :
                        bi.j114b.isChecked() ? "2" :
                                bi.j114c.isChecked() ? "98" :
                                        "0");

        json.put("j115",
                bi.j115a.isChecked() ? "1" :
                        bi.j115b.isChecked() ? "2" :
                                bi.j115c.isChecked() ? "98" :
                                        "0");

        json.put("j116", bi.j116.getText().toString());

        json.put("j117",
                bi.j117a.isChecked() ? "1" :
                        bi.j117b.isChecked() ? "2" :
                                bi.j117c.isChecked() ? "98" :
                                        "0");

        json.put("j118", bi.j118.getText().toString());

        json.put("j119",
                bi.j119a.isChecked() ? "1" :
                        bi.j119b.isChecked() ? "2" :
                                bi.j119c.isChecked() ? "98" :
                                        "0");

        json.put("j120",
                bi.j120a.isChecked() ? "1" :
                        bi.j120b.isChecked() ? "2" :
                                bi.j120c.isChecked() ? "98" :
                                        "0");

        json.put("j121", bi.j121.getText().toString());

        json.put("j122",
                bi.j122a.isChecked() ? "1" :
                        bi.j122b.isChecked() ? "2" :
//                                bi.j122c.isChecked() ? "98" :
                                        "0");

        json.put("j123a", bi.j123a.isChecked() ? "1" : "0");
        json.put("j123b", bi.j123b.isChecked() ? "2" : "0");
        json.put("j123c", bi.j123c.isChecked() ? "3" : "0");
        json.put("j123d", bi.j123d.isChecked() ? "4" : "0");
        json.put("j123e", bi.j123e.isChecked() ? "5" : "0");
        json.put("j123f", bi.j123f.isChecked() ? "6" : "0");
        json.put("j123g", bi.j123g.isChecked() ? "7" : "0");
        json.put("j123h", bi.j123h.isChecked() ? "8" : "0");
        json.put("j123i", bi.j123i.isChecked() ? "9" : "0");
        json.put("j123j", bi.j123j.isChecked() ? "10" : "0");
        json.put("j123k", bi.j123k.isChecked() ? "11" : "0");
        json.put("j123l", bi.j123l.isChecked() ? "12" : "0");
        json.put("j123m", bi.j123m.isChecked() ? "13" : "0");
        json.put("j123n", bi.j123n.isChecked() ? "14" : "0");
        json.put("j123o", bi.j123o.isChecked() ? "15" : "0");
        json.put("j123p", bi.j123p.isChecked() ? "16" : "0");
        json.put("j123dk", bi.j123dk.isChecked() ? "98" : "0");
        json.put("j12396", bi.j12396.isChecked() ? "96" : "0");
        json.put("j12396x", bi.j12396x.getText().toString());

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.child.getsJ()), json);

            MainApp.child.setsJ(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionJ03);
    }


    public void BtnEnd() {
        Util.openEndActivity(this);
    }

}
