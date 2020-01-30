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
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionH1Binding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;

public class SectionH1Activity extends AppCompatActivity {

    ActivitySectionH1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h1);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        //h102
        bi.h102.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId != bi.h102a.getId()) {
                bi.fldGrpCVh103.setVisibility(View.VISIBLE);
                bi.fldGrpCVh104.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVh103, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh104, null);
                bi.fldGrpCVh103.setVisibility(View.GONE);
                bi.fldGrpCVh104.setVisibility(View.GONE);
            }
        });


        //h103
        bi.h103.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h103a.getId()) {
                bi.fldGrpCVh104.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVh104, null);
                bi.fldGrpCVh104.setVisibility(View.GONE);
            }
        });


        //h105
        bi.h105.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h105a.getId()) {
                bi.fldGrpCVh106.setVisibility(View.VISIBLE);
                bi.fldGrpCVh107.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVh106, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh107, null);
                bi.fldGrpCVh106.setVisibility(View.GONE);
                bi.fldGrpCVh107.setVisibility(View.GONE);
            }
        });


        //h110
        bi.h110.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h110a.getId()) {
                bi.fldGrpCVh111.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVh111, null);
                bi.fldGrpCVh111.setVisibility(View.GONE);
            }
        });


        //h113
        bi.h113.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h113a.getId()) {
                bi.fldGrpCVh114.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVh114, null);
                bi.fldGrpCVh114.setVisibility(View.GONE);
            }
        });


        //h116
        bi.h116.setOnCheckedChangeListener((group, checkedId) -> {

            ClearClass.ClearAllFields(bi.fldGrpCVh117, null);
            ClearClass.ClearAllFields(bi.fldGrpCVh118, null);
            ClearClass.ClearAllFields(bi.fldGrpCVh119, null);
            bi.fldGrpCVh117.setVisibility(View.GONE);
            bi.fldGrpCVh118.setVisibility(View.GONE);
            bi.fldGrpCVh119.setVisibility(View.GONE);

            if (checkedId == bi.h116a.getId()) {
                bi.fldGrpCVh117.setVisibility(View.VISIBLE);
            } else if (checkedId == bi.h116b.getId()) {
                bi.fldGrpCVh118.setVisibility(View.VISIBLE);
            }
        });


        //h118
        bi.h118.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h118a.getId()) {
                bi.fldGrpCVh119.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVh119, null);
                bi.fldGrpCVh119.setVisibility(View.GONE);
            }
        });


        //h121
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
                //ClearClass.ClearAllFields(bi.h122, null);
                bi.h122.setText("");
                ClearClass.ClearAllFields(bi.fldGrpCVh123, null);
                bi.h122.setVisibility(View.GONE);
                bi.fldGrpCVh123.setVisibility(View.GONE);
            } else {
                bi.h122.setVisibility(View.VISIBLE);
                bi.fldGrpCVh123.setVisibility(View.VISIBLE);
            }
        });


        //h123
        bi.h123.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h123b.getId()) {
                bi.fldGrpCVh124.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVh124, null);
                bi.fldGrpCVh124.setVisibility(View.GONE);
            }
        });


        //h125
        bi.h125.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h125a.getId()) {
                bi.fldGrpCVh126.setVisibility(View.VISIBLE);
                bi.fldGrpCVh127.setVisibility(View.VISIBLE);
                bi.fldGrpCVh128.setVisibility(View.VISIBLE);
                bi.fldGrpCVh129a.setVisibility(View.VISIBLE);
                bi.fldGrpCVh129b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh129c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh129d.setVisibility(View.VISIBLE);
                bi.fldGrpCVh129e.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVh126, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh127, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh128, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh129a, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh129b, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh129c, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh129d, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh129e, null);
                bi.fldGrpCVh126.setVisibility(View.GONE);
                bi.fldGrpCVh127.setVisibility(View.GONE);
                bi.fldGrpCVh128.setVisibility(View.GONE);
                bi.fldGrpCVh129a.setVisibility(View.GONE);
                bi.fldGrpCVh129b.setVisibility(View.GONE);
                bi.fldGrpCVh129c.setVisibility(View.GONE);
                bi.fldGrpCVh129d.setVisibility(View.GONE);
                bi.fldGrpCVh129e.setVisibility(View.GONE);
            }
        });


        //h132
        bi.h132.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h132a.getId()) {
                bi.fldGrpCVh133.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVh133, null);
                bi.fldGrpCVh133.setVisibility(View.GONE);
            }
        });


        //h134
        bi.h134.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h134a.getId()) {
                bi.fldGrpCVh135.setVisibility(View.VISIBLE);
                bi.fldGrpCVh136.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVh135, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh136, null);
                bi.fldGrpCVh135.setVisibility(View.GONE);
                bi.fldGrpCVh136.setVisibility(View.GONE);
            }
        });


        //h137
        bi.h137.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.h137a.getId()) {
                bi.fldGrpCVh137aa.setVisibility(View.VISIBLE);
                bi.fldGrpCVh137bb.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVh137aa, null);
                ClearClass.ClearAllFields(bi.fldGrpCVh137bb, null);
                bi.fldGrpCVh137aa.setVisibility(View.GONE);
                bi.fldGrpCVh137bb.setVisibility(View.GONE);
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
                startActivity(new Intent(this, SectionH2Activity.class));
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
        int updcount = db.updatesKishMWRAColumn(KishMWRAContract.SingleKishMWRA.COLUMN_SH1, MainApp.kish.getsH1());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("h101", bi.h101.getText().toString());

        json.put("h102", bi.h102a.isChecked() ? "1" :
                bi.h102b.isChecked() ? "2" :
                        bi.h10298.isChecked() ? "98" : "0");

        json.put("h103", bi.h103a.isChecked() ? "1" :
                bi.h103b.isChecked() ? "2" :
                        bi.h10398.isChecked() ? "98" : "0");

        json.put("h104", bi.h104a.isChecked() ? "1" :
                bi.h104b.isChecked() ? "2" :
                                bi.h104c.isChecked() ? "3" :
                                        bi.h10496.isChecked() ? "96" : "0");
        json.put("h10496x", bi.h10496x.getText().toString());

        json.put("h105", bi.h105a.isChecked() ? "1" :
                bi.h105b.isChecked() ? "2" :
                        bi.h10598.isChecked() ? "98" : "0");

        json.put("h106", bi.h106.getText().toString());

        json.put("h107", bi.h107a.isChecked() ? "1" :
                bi.h107b.isChecked() ? "2" :
                                bi.h107c.isChecked() ? "3" :
                                        bi.h107d.isChecked() ? "4" : "0");

        json.put("h108", bi.h108a.isChecked() ? "1" :
                bi.h108b.isChecked() ? "2" :
                                bi.h108c.isChecked() ? "3" :
                                        bi.h108d.isChecked() ? "4" : "0");

        json.put("h109", bi.h109a.isChecked() ? "1" :
                bi.h109b.isChecked() ? "2" :
                                bi.h109c.isChecked() ? "3" :
                                        bi.h109d.isChecked() ? "4" :
                                                bi.h109e.isChecked() ? "5" :
                                                        bi.h109f.isChecked() ? "6" :
                                                                bi.h109g.isChecked() ? "7" :
                                                                        bi.h109h.isChecked() ? "8" : "0");

        json.put("h110", bi.h110a.isChecked() ? "1" :
                bi.h110b.isChecked() ? "2" :
                        bi.h11098.isChecked() ? "98" : "0");

        json.put("h111", bi.h111.getText().toString());
        json.put("h112", bi.h112.getText().toString());

        json.put("h113", bi.h113a.isChecked() ? "1" :
                bi.h113b.isChecked() ? "2" : "0");

        json.put("h114", bi.h114a.isChecked() ? "1" :
                bi.h114b.isChecked() ? "2" :
                                bi.h114c.isChecked() ? "3" :
                                        bi.h114d.isChecked() ? "4" :
                                                bi.h114e.isChecked() ? "5" :
                                                        bi.h114f.isChecked() ? "6" :
                                                                bi.h114g.isChecked() ? "7" :
                                                                        bi.h114h.isChecked() ? "8" : "0");

        json.put("h115a", bi.h115a.isChecked() ? "1" : "0");
        json.put("h115b", bi.h115b.isChecked() ? "2" : "0");
        json.put("h115c", bi.h115c.isChecked() ? "3" : "0");
        json.put("h115d", bi.h115d.isChecked() ? "4" : "0");
        json.put("h115e", bi.h115e.isChecked() ? "5" : "0");
        json.put("h115f", bi.h115f.isChecked() ? "6" : "0");
        json.put("h115g", bi.h115g.isChecked() ? "7" : "0");
        json.put("h115h", bi.h115h.isChecked() ? "8" : "0");

        json.put("h116", bi.h116a.isChecked() ? "1" :
                bi.h116b.isChecked() ? "2" :
                        bi.h116c.isChecked() ? "3" : "0");

        json.put("h117", bi.h117.getText().toString());

        json.put("h118", bi.h118a.isChecked() ? "1" :
                bi.h118b.isChecked() ? "2" : "0");

        json.put("h119", bi.h119.getText().toString());

        json.put("h120", bi.h120a.isChecked() ? "1" :
                bi.h120b.isChecked() ? "2" :
                                bi.h120c.isChecked() ? "3" :
                                        bi.h120d.isChecked() ? "4" :
                                                bi.h120e.isChecked() ? "5" :
                                                        bi.h12098.isChecked() ? "98" : "0");

        json.put("h121", bi.h121a.isChecked() ? "1" :
                bi.h121b.isChecked() ? "2" : "0");

        json.put("h122", bi.h12298.isChecked() ? "98" :
                bi.h122.getText().toString());

        json.put("h123", bi.h123a.isChecked() ? "1" :
                bi.h123b.isChecked() ? "2" : "0");

        json.put("h124", bi.h124a.isChecked() ? "1" :
                bi.h124b.isChecked() ? "2" :
                                bi.h124c.isChecked() ? "3" :
                                        bi.h124d.isChecked() ? "4" :
                                                bi.h124e.isChecked() ? "5" :
                                                        bi.h12498.isChecked() ? "98" : "0");

        json.put("h125", bi.h125a.isChecked() ? "1" :
                bi.h125b.isChecked() ? "2" : "0");

        json.put("h126", bi.h126a.isChecked() ? "1" :
                bi.h126b.isChecked() ? "2" :
                                bi.h126c.isChecked() ? "3" :
                                        bi.h126d.isChecked() ? "4" :
                                                bi.h12698.isChecked() ? "98" : "0");

        json.put("h127", bi.h127a.isChecked() ? "1" :
                bi.h127b.isChecked() ? "2" :
                                bi.h127c.isChecked() ? "3" :
                                        bi.h127d.isChecked() ? "4" : "0");

        json.put("h128", bi.h128a.isChecked() ? "1" :
                bi.h128b.isChecked() ? "2" :
                                bi.h128c.isChecked() ? "3" :
                                        bi.h128d.isChecked() ? "4" :
                                                bi.h128e.isChecked() ? "5" :
                                                        bi.h128f.isChecked() ? "6" : "0");

        json.put("h129a", bi.h129aa.isChecked() ? "1" :
                bi.h129ab.isChecked() ? "2" :
                        bi.h129a98.isChecked() ? "98" : "0");

        json.put("h129b", bi.h129ba.isChecked() ? "1" :
                bi.h129bb.isChecked() ? "2" :
                        bi.h129b98.isChecked() ? "98" : "0");

        json.put("h129c", bi.h129ca.isChecked() ? "1" :
                bi.h129cb.isChecked() ? "2" :
                        bi.h129c98.isChecked() ? "98" : "0");

        json.put("h129d", bi.h129da.isChecked() ? "1" :
                bi.h129db.isChecked() ? "2" :
                        bi.h129d98.isChecked() ? "98" : "0");

        json.put("h129e", bi.h129ea.isChecked() ? "1" :
                bi.h129eb.isChecked() ? "2" :
                        bi.h129e98.isChecked() ? "98" : "0");

        json.put("h130", bi.h130a.isChecked() ? "1" :
                bi.h130b.isChecked() ? "2" : "0");

        json.put("h131", bi.h131a.isChecked() ? "1" :
                bi.h131b.isChecked() ? "2" : "0");

        json.put("h132", bi.h132a.isChecked() ? "1" :
                bi.h132b.isChecked() ? "2" :
                        bi.h132c.isChecked() ? "3" : "0");

        json.put("h133", bi.h133a.isChecked() ? "1" :
                bi.h133b.isChecked() ? "2" :
                                bi.h133c.isChecked() ? "3" :
                                        bi.h133d.isChecked() ? "4" :
                                                bi.h133e.isChecked() ? "5" :
                                                        bi.h133f.isChecked() ? "6" :
                                                                bi.h133g.isChecked() ? "7" :
                                                                        bi.h133h.isChecked() ? "8" : "0");

        json.put("h134", bi.h134a.isChecked() ? "1" :
                bi.h134b.isChecked() ? "2" : "0");

        json.put("h135a", bi.h135a.isChecked() ? "1" : "0");
        json.put("h135b", bi.h135b.isChecked() ? "2" : "0");
        json.put("h135c", bi.h135c.isChecked() ? "3" : "0");
        json.put("h135d", bi.h135d.isChecked() ? "4" : "0");
        json.put("h135e", bi.h135e.isChecked() ? "5" : "0");
        json.put("h135f", bi.h135f.isChecked() ? "6" : "0");
        json.put("h135g", bi.h135g.isChecked() ? "7" : "0");
        json.put("h135h", bi.h135h.isChecked() ? "8" : "0");
        json.put("h135i", bi.h135i.isChecked() ? "9" : "0");
        json.put("h13598", bi.h13598.isChecked() ? "98" : "0");

        json.put("h136a", bi.h136a.isChecked() ? "1" : "0");
        json.put("h136b", bi.h136b.isChecked() ? "2" : "0");
        json.put("h136c", bi.h136c.isChecked() ? "3" : "0");
        json.put("h136d", bi.h136d.isChecked() ? "4" : "0");
        json.put("h136e", bi.h136e.isChecked() ? "5" : "0");
        json.put("h136f", bi.h136f.isChecked() ? "6" : "0");

        json.put("h137", bi.h137a.isChecked() ? "1" :
                bi.h137b.isChecked() ? "2" : "0");

        json.put("h137aa", bi.h137aaa.isChecked() ? "1" :
                bi.h137aab.isChecked() ? "2" :
                        bi.h137aac.isChecked() ? "3" :
                                bi.h137aad.isChecked() ? "4" :
                                        bi.h137aae.isChecked() ? "5" : "0");

        json.put("h137bb", bi.h137bba.isChecked() ? "1" :
                bi.h137bbb.isChecked() ? "2" :
                        bi.h137bbc.isChecked() ? "3" :
                                bi.h137bbd.isChecked() ? "4" :
                                        bi.h137bbe.isChecked() ? "5" :
                                                bi.h137bbf.isChecked() ? "6" :
                                                        bi.h137bbg.isChecked() ? "7" :
                                                                bi.h137bb96.isChecked() ? "96" : "0");
        json.put("h137bb96x", bi.h137bb96x.getText().toString());

        MainApp.kish.setsH1(String.valueOf(json));
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}
