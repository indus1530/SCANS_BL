package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionHBinding;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;
import edu.aku.hassannaqvi.uen_midline.validator.ValidatorClass;

public class SectionHActivity extends AppCompatActivity {

    ActivitySectionHBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h);
        bi.setCallback(this);

    }


    private void setupSkips() {

        //g102
        bi.g102.setOnCheckedChangeListener((group, checkedId) -> {

            ClearClass.ClearAllFields(bi.fldGrpCVg103, null);
            ClearClass.ClearAllFields(bi.fldGrpCVg104, null);
            ClearClass.ClearAllFields(bi.fldGrpCVg105, null);
            ClearClass.ClearAllFields(bi.fldGrpCVg106, null);
            ClearClass.ClearAllFields(bi.fldGrpCVg107, null);
            bi.fldGrpCVg103.setVisibility(View.GONE);
            bi.fldGrpCVg104.setVisibility(View.GONE);
            bi.fldGrpCVg105.setVisibility(View.GONE);
            bi.fldGrpCVg106.setVisibility(View.GONE);
            bi.fldGrpCVg107.setVisibility(View.GONE);

            if (checkedId == bi.g102a.getId()) {
                bi.fldGrpCVg103.setVisibility(View.VISIBLE);
            } else {
                bi.fldGrpCVg104.setVisibility(View.VISIBLE);
                bi.fldGrpCVg105.setVisibility(View.VISIBLE);
                bi.fldGrpCVg106.setVisibility(View.VISIBLE);
                bi.fldGrpCVg107.setVisibility(View.VISIBLE);
            }
        });


        //g110
        bi.g110.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.g110a.getId()) {
                bi.fldGrpCVg111.setVisibility(View.VISIBLE);
                bi.fldGrpCVg112.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVg111, null);
                ClearClass.ClearAllFields(bi.fldGrpCVg112, null);
                bi.fldGrpCVg111.setVisibility(View.GONE);
                bi.fldGrpCVg112.setVisibility(View.GONE);
            }
        });


        //g111
        bi.g111.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.g111a.getId()) {
                bi.fldGrpCVg112.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVg112, null);
                bi.fldGrpCVg112.setVisibility(View.GONE);
            }
        });


        //g113
        bi.g113.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.g113a.getId()) {
                bi.fldGrpCVg114.setVisibility(View.VISIBLE);
                bi.fldGrpCVg115.setVisibility(View.VISIBLE);
                bi.fldGrpCVg116.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVg114, null);
                ClearClass.ClearAllFields(bi.fldGrpCVg115, null);
                ClearClass.ClearAllFields(bi.fldGrpCVg116, null);
                bi.fldGrpCVg114.setVisibility(View.GONE);
                bi.fldGrpCVg115.setVisibility(View.GONE);
                bi.fldGrpCVg116.setVisibility(View.GONE);
            }
        });


        //g115
        bi.g115.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.g115a.getId()) {
                bi.fldGrpCVg116.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVg116, null);
                bi.fldGrpCVg116.setVisibility(View.GONE);
            }
        });


        //g119
        bi.g119.setOnCheckedChangeListener((group, checkedId) -> {

            ClearClass.ClearAllFields(bi.fldGrpCVg120, null);
            ClearClass.ClearAllFields(bi.fldGrpCVg121, null);
            bi.fldGrpCVg120.setVisibility(View.GONE);
            bi.fldGrpCVg121.setVisibility(View.GONE);

            if (checkedId == bi.g119a.getId()) {
                bi.fldGrpCVg120.setVisibility(View.VISIBLE);
            } else {
                bi.fldGrpCVg121.setVisibility(View.VISIBLE);
            }
        });


        //g122
        bi.g122.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.g122a.getId()) {
                bi.fldGrpCVg123.setVisibility(View.VISIBLE);
                bi.fldGrpCVg124.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVg123, null);
                ClearClass.ClearAllFields(bi.fldGrpCVg124, null);
                bi.fldGrpCVg123.setVisibility(View.GONE);
                bi.fldGrpCVg124.setVisibility(View.GONE);
            }
        });


        //g126
        bi.g126.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.g126a.getId()) {
                bi.fldGrpCVg127.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVg127, null);
                bi.fldGrpCVg127.setVisibility(View.GONE);
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
                startActivity(new Intent(this, SectionIActivity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }


    private boolean UpdateDB() {

        /*DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        return true;
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("h101", bi.h101.getText().toString());

        json.put("h102",
                bi.h102a.isChecked() ? "1" :
                        bi.h102b.isChecked() ? "2" :
                                bi.h10298.isChecked() ? "98" :
                                        "0");

        json.put("h103",
                bi.h103a.isChecked() ? "1" :
                        bi.h103b.isChecked() ? "2" :
                                bi.h10398.isChecked() ? "98" :
                                        "0");

        json.put("h104",
                bi.h104a.isChecked() ? "1" :
                        bi.h104b.isChecked() ? "2" :
                                bi.h104c.isChecked() ? "3" :
                                        bi.h10496.isChecked() ? "96" :
                                                "0");
        json.put("h10496x", bi.h10496x.getText().toString());

        json.put("h105",
                bi.h105a.isChecked() ? "1" :
                        bi.h105b.isChecked() ? "2" :
                                bi.h10598.isChecked() ? "98" :
                                        "0");

        json.put("h106", bi.h106.getText().toString());

        json.put("h107",
                bi.h107a.isChecked() ? "1" :
                        bi.h107b.isChecked() ? "2" :
                                bi.h107c.isChecked() ? "3" :
                                        bi.h107d.isChecked() ? "4" :
                                                "0");

        json.put("h108",
                bi.h108a.isChecked() ? "1" :
                        bi.h108b.isChecked() ? "2" :
                                bi.h108c.isChecked() ? "3" :
                                        bi.h108d.isChecked() ? "4" :
                                                "0");

        json.put("h109",
                bi.h109a.isChecked() ? "1" :
                        bi.h109b.isChecked() ? "2" :
                                bi.h109c.isChecked() ? "3" :
                                        bi.h109d.isChecked() ? "4" :
                                                bi.h109e.isChecked() ? "5" :
                                                        bi.h109f.isChecked() ? "6" :
                                                                bi.h109g.isChecked() ? "7" :
                                                                        bi.h109h.isChecked() ? "8" :
                                                                                "0");

        json.put("h110",
                bi.h110a.isChecked() ? "1" :
                        bi.h110b.isChecked() ? "2" :
                                bi.h11098.isChecked() ? "98" :
                                        "0");

        json.put("h111", bi.h111.getText().toString());
        json.put("h112", bi.h112.getText().toString());

        json.put("h113",
                bi.h113a.isChecked() ? "1" :
                        bi.h113b.isChecked() ? "2" :
                                "0");

        json.put("h114",
                bi.h114a.isChecked() ? "1" :
                        bi.h114b.isChecked() ? "2" :
                                bi.h114c.isChecked() ? "3" :
                                        bi.h114d.isChecked() ? "4" :
                                                bi.h114e.isChecked() ? "5" :
                                                        bi.h114f.isChecked() ? "6" :
                                                                bi.h114g.isChecked() ? "7" :
                                                                        bi.h114h.isChecked() ? "8" :
                                                                                "0");

        json.put("h115a", bi.h115a.isChecked() ? "1" : "0");
        json.put("h115b", bi.h115b.isChecked() ? "2" : "0");
        json.put("h115c", bi.h115c.isChecked() ? "3" : "0");
        json.put("h115d", bi.h115d.isChecked() ? "4" : "0");
        json.put("h115e", bi.h115e.isChecked() ? "5" : "0");
        json.put("h115f", bi.h115f.isChecked() ? "6" : "0");
        json.put("h115g", bi.h115g.isChecked() ? "7" : "0");
        json.put("h115h", bi.h115h.isChecked() ? "8" : "0");

        json.put("h116",
                bi.h116a.isChecked() ? "1" :
                        bi.h116b.isChecked() ? "2" :
                                bi.h116c.isChecked() ? "3" :
                                        "0");

        json.put("h117", bi.h117.getText().toString());

        json.put("h118",
                bi.h118a.isChecked() ? "1" :
                        bi.h118b.isChecked() ? "2" :
                                "0");

        json.put("h119", bi.h119.getText().toString());

        json.put("h120",
                bi.h120a.isChecked() ? "1" :
                        bi.h120b.isChecked() ? "2" :
                                bi.h120c.isChecked() ? "3" :
                                        bi.h120d.isChecked() ? "4" :
                                                bi.h120e.isChecked() ? "5" :
                                                        bi.h12098.isChecked() ? "98" :
                                                                "0");

        json.put("h121",
                bi.h121a.isChecked() ? "1" :
                        bi.h121b.isChecked() ? "2" :
                                "0");

        json.put("h122",
                bi.h12298.isChecked() ? "98" :
                        bi.h122.getText().toString());

        json.put("h123",
                bi.h123a.isChecked() ? "1" :
                        bi.h123b.isChecked() ? "2" :
                                "0");

        json.put("h124",
                bi.h124a.isChecked() ? "1" :
                        bi.h124b.isChecked() ? "2" :
                                bi.h124c.isChecked() ? "3" :
                                        bi.h124d.isChecked() ? "4" :
                                                bi.h124e.isChecked() ? "5" :
                                                        bi.h124f.isChecked() ? "98" :
                                                                "0");
        json.put("h125",
                bi.h125a.isChecked() ? "1" :
                        bi.h125b.isChecked() ? "2" :
                                "0");
        json.put("h126",
                bi.h126a.isChecked() ? "1" :
                        bi.h126b.isChecked() ? "2" :
                                bi.h126c.isChecked() ? "3" :
                                        bi.h126d.isChecked() ? "4" :
                                                bi.h126e.isChecked() ? "98" :
                                                        "0");
        json.put("h127",
                bi.h127a.isChecked() ? "1" :
                        bi.h127b.isChecked() ? "2" :
                                bi.h127c.isChecked() ? "3" :
                                        bi.h127d.isChecked() ? "4" :
                                                "0");
        json.put("h128",
                bi.h128a.isChecked() ? "1" :
                        bi.h128b.isChecked() ? "2" :
                                bi.h128c.isChecked() ? "3" :
                                        bi.h128d.isChecked() ? "4" :
                                                "0");
        json.put("h129a",
                bi.h129aa.isChecked() ? "1" :
                        bi.h129ab.isChecked() ? "2" :
                                bi.h129ac.isChecked() ? "98" :
                                        "0");
        json.put("h129b",
                bi.h129ba.isChecked() ? "1" :
                        bi.h129bb.isChecked() ? "2" :
                                bi.h129bc.isChecked() ? "98" :
                                        "0");
        json.put("h129c",
                bi.h129ca.isChecked() ? "1" :
                        bi.h129cb.isChecked() ? "2" :
                                bi.h129cc.isChecked() ? "98" :
                                        "0");
        json.put("h129d",
                bi.h129da.isChecked() ? "1" :
                        bi.h129db.isChecked() ? "2" :
                                bi.h129dc.isChecked() ? "98" :
                                        "0");
        json.put("h129e",
                bi.h129ea.isChecked() ? "1" :
                        bi.h129eb.isChecked() ? "2" :
                                bi.h129ec.isChecked() ? "98" :
                                        "0");
        json.put("h130",
                bi.h130a.isChecked() ? "1" :
                        bi.h130b.isChecked() ? "2" :
                                "0");
        json.put("h131",
                bi.h131a.isChecked() ? "1" :
                        bi.h131b.isChecked() ? "2" :
                                "0");
        json.put("h132",
                bi.h132a.isChecked() ? "1" :
                        bi.h132b.isChecked() ? "2" :
                                bi.h132c.isChecked() ? "3" :
                                        "0");
        json.put("h133",
                bi.h133a.isChecked() ? "1" :
                        bi.h133b.isChecked() ? "2" :
                                bi.h133c.isChecked() ? "3" :
                                        bi.h133d.isChecked() ? "4" :
                                                bi.h133e.isChecked() ? "5" :
                                                        bi.h133f.isChecked() ? "6" :
                                                                bi.h133g.isChecked() ? "7" :
                                                                        bi.h133h.isChecked() ? "8" :
                                                                                "0");
        json.put("h134",
                bi.h134a.isChecked() ? "1" :
                        bi.h134b.isChecked() ? "2" :
                                "0");
        json.put("h135",
                bi.h135a.isChecked() ? "1" :
                        bi.h135b.isChecked() ? "2" :
                                bi.h135c.isChecked() ? "3" :
                                        bi.h135d.isChecked() ? "4" :
                                                bi.h135e.isChecked() ? "5" :
                                                        bi.h135f.isChecked() ? "6" :
                                                                bi.h135g.isChecked() ? "7" :
                                                                        bi.h135h.isChecked() ? "8" :
                                                                                bi.h135i.isChecked() ? "9" :
                                                                                        bi.h135j.isChecked() ? "98" :
                                                                                                "0");
        json.put("h136",
                bi.h136a.isChecked() ? "1" :
                        bi.h136b.isChecked() ? "2" :
                                bi.h136c.isChecked() ? "3" :
                                        bi.h136d.isChecked() ? "4" :
                                                bi.h136e.isChecked() ? "5" :
                                                        bi.h136f.isChecked() ? "6" :
                                                                "0");
        json.put("h137",
                bi.h137a.isChecked() ? "1" :
                        bi.h137b.isChecked() ? "2" :
                                "0");
        json.put("h137aa",
                bi.h137aaa.isChecked() ? "1" :
                        bi.h137aab.isChecked() ? "2" :
                                bi.h137aac.isChecked() ? "3" :
                                        bi.h137aad.isChecked() ? "4" :
                                                bi.h137aae.isChecked() ? "5" :
                                                        "0");
        json.put("h137bb",
                bi.h137bba.isChecked() ? "1" :
                        bi.h137bbb.isChecked() ? "2" :
                                bi.h137bbc.isChecked() ? "3" :
                                        bi.h137bbd.isChecked() ? "4" :
                                                bi.h137bbe.isChecked() ? "5" :
                                                        bi.h137bbf.isChecked() ? "6" :
                                                                bi.h137bbg.isChecked() ? "7" :
                                                                        bi.h137bbx.isChecked() ? "96" :
                                                                                "0");
        json.put("h201", bi.h201.getText().toString());

        json.put("h202",
                bi.h202a.isChecked() ? "1" :
                        bi.h202b.isChecked() ? "2" :
                                "0");
        json.put("h203", bi.h203.getText().toString());

        json.put("h204",
                bi.h204a.isChecked() ? "1" :
                        bi.h204b.isChecked() ? "2" :
                                bi.h204c.isChecked() ? "3" :
                                        "0");

        json.put("h205",
                bi.h205a.isChecked() ? "1" :
                        bi.h205b.isChecked() ? "2" :
                                bi.h205c.isChecked() ? "3" :
                                        bi.h205d.isChecked() ? "4" :
                                                bi.h205e.isChecked() ? "5" :
                                                        "0");

        json.put("h206",
                bi.h206a.isChecked() ? "1" :
                        bi.h206b.isChecked() ? "2" :
                                "0");

        json.put("h207a", bi.h207a.isChecked() ? "1" : "0");
        json.put("h207b", bi.h207b.isChecked() ? "2" : "0");
        json.put("h207c", bi.h207c.isChecked() ? "3" : "0");
        json.put("h207d", bi.h207d.isChecked() ? "4" : "0");
        json.put("h207e", bi.h207e.isChecked() ? "5" : "0");
        json.put("h207f", bi.h207f.isChecked() ? "6" : "0");
        json.put("h207g", bi.h207g.isChecked() ? "7" : "0");
        json.put("h207h", bi.h207h.isChecked() ? "8" : "0");
        json.put("h207i", bi.h207i.isChecked() ? "98" : "0");
        json.put("h208a", bi.h208a.isChecked() ? "1" : "0");
        json.put("h208b", bi.h208b.isChecked() ? "2" : "0");
        json.put("h208c", bi.h208c.isChecked() ? "3" : "0");
        json.put("h208d", bi.h208d.isChecked() ? "4" : "0");
        json.put("h208e", bi.h208e.isChecked() ? "5" : "0");
        json.put("h208f", bi.h208f.isChecked() ? "6" : "0");
        json.put("h209",
                bi.h209a.isChecked() ? "1" :
                        bi.h209b.isChecked() ? "2" :
                                "0");
        json.put("h210",
                bi.h210a.isChecked() ? "1" :
                        bi.h210b.isChecked() ? "2" :
                                bi.h210c.isChecked() ? "3" :
                                        bi.h210d.isChecked() ? "98" :
                                                "0");
        json.put("h211",
                bi.h211a.isChecked() ? "1" :
                        bi.h211b.isChecked() ? "2" :
                                bi.h211c.isChecked() ? "3" :
                                        bi.h211d.isChecked() ? "4" :
                                                bi.h211e.isChecked() ? "5" :
                                                        bi.h211f.isChecked() ? "6" :
                                                                bi.h211g.isChecked() ? "7" :
                                                                        bi.h211h.isChecked() ? "8" :
                                                                                bi.h211i.isChecked() ? "9" :
                                                                                        "0");
        json.put("h212", bi.h212.getText().toString());
        json.put("h213",
                bi.h213a.isChecked() ? "1" :
                        bi.h213b.isChecked() ? "2" :
                                bi.h213c.isChecked() ? "3" :
                                        "0");
        json.put("h214",
                bi.h214a.isChecked() ? "1" :
                        bi.h214b.isChecked() ? "2" :
                                bi.h214c.isChecked() ? "3" :
                                        bi.h214d.isChecked() ? "4" :
                                                "0");
        json.put("h215",
                bi.h215a.isChecked() ? "1" :
                        bi.h215b.isChecked() ? "2" :
                                bi.h215c.isChecked() ? "3" :
                                        bi.h215d.isChecked() ? "4" :
                                                bi.h215e.isChecked() ? "5" :
                                                        "0");
        json.put("h216",
                bi.h216a.isChecked() ? "1" :
                        bi.h216b.isChecked() ? "2" :
                                bi.h216c.isChecked() ? "3" :
                                        "0");
        json.put("h217",
                bi.h217a.isChecked() ? "1" :
                        bi.h217b.isChecked() ? "2" :
                                bi.h217c.isChecked() ? "3" :
                                        bi.h217d.isChecked() ? "4" :
                                                bi.h217e.isChecked() ? "5" :
                                                        bi.h217f.isChecked() ? "6" :
                                                                bi.h217x.isChecked() ? "96" :
                                                                        "0");
        json.put("h218",
                bi.h218a.isChecked() ? "1" :
                        bi.h218b.isChecked() ? "2" :
                                bi.h218c.isChecked() ? "98" :
                                        "0");
        json.put("h219",
                bi.h219a.isChecked() ? "1" :
                        bi.h219b.isChecked() ? "2" :
                                bi.h219c.isChecked() ? "3" :
                                        bi.h219d.isChecked() ? "4" :
                                                bi.h219e.isChecked() ? "5" :
                                                        bi.h219f.isChecked() ? "6" :
                                                                bi.h219x.isChecked() ? "96" :
                                                                        "0");
        json.put("h219xt", bi.h219xt.getText().toString());

        json.put("h220",
                bi.h220a.isChecked() ? "1" :
                        bi.h220b.isChecked() ? "2" :
                                bi.h220c.isChecked() ? "3" :
                                        bi.h220d.isChecked() ? "4" :
                                                bi.h220e.isChecked() ? "5" :
                                                        bi.h220f.isChecked() ? "6" :
                                                                bi.h220x.isChecked() ? "96" :
                                                                        "0");

        json.put("h221",
                bi.h221a.isChecked() ? "1" :
                        bi.h221b.isChecked() ? "2" :
                                bi.h221c.isChecked() ? "3" :
                                        "0");

        json.put("h222",
                bi.h222a.isChecked() ? "1" :
                        bi.h222b.isChecked() ? "2" :
                                bi.h222c.isChecked() ? "3" :
                                        bi.h222d.isChecked() ? "4" :
                                                "0");
        json.put("h223",
                bi.h223a.isChecked() ? "1" :
                        bi.h223b.isChecked() ? "2" :
                                bi.h223c.isChecked() ? "4" :
                                        bi.h223d.isChecked() ? "5" :
                                                "0");


        MainApp.fc.setsA(String.valueOf(json));

    }


    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.GrpName);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}
