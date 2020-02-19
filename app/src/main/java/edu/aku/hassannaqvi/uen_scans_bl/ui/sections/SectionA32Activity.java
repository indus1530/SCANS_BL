package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionA32Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.JSONUtils;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionA32Activity extends AppCompatActivity {

    ActivitySectionA32Binding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a32);
        bi.setCallback(this);
        setupSkips();


    }


    private void setupSkips() {

        bi.a322.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.a322k.getId()) {
                bi.fldGrpCVa323.setVisibility(View.VISIBLE);
                bi.fldGrpCVa324.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVa323);
                Clear.clearAllFields(bi.fldGrpCVa324);
                bi.fldGrpCVa323.setVisibility(View.GONE);
                bi.fldGrpCVa324.setVisibility(View.GONE);
            }

        }));

        bi.a323.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.a323b.getId()) {
                bi.fldGrpCVa324.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVa324);
                bi.fldGrpCVa324.setVisibility(View.GONE);
            }
        }));

        bi.a326.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.a326a.getId()) {
                bi.fldGrpCVa327.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVa327);
                bi.fldGrpCVa327.setVisibility(View.GONE);
            }
        }));

        bi.a328.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.a328a.getId()) {
                bi.fldGrpCVa329.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVa329);
                bi.fldGrpCVa329.setVisibility(View.GONE);
            }
        }));

        //a33297
        bi.a33297.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                Clear.clearAllFields(bi.a332check, false);
                bi.a332check.setTag("-1");
                Clear.clearAllFields(bi.fldGrpCVa333);
                bi.fldGrpCVa333.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVa333.setVisibility(View.VISIBLE);
                Clear.clearAllFields(bi.a332check, true);
                bi.a332check.setTag("0");
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
                startActivity(new Intent(this, SectionA4Activity.class));
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
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SA3, MainApp.fc.getsA3());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("a318",
                bi.a318a.isChecked() ? "1" :
                        bi.a318b.isChecked() ? "2" :
                                bi.a318c.isChecked() ? "3" :
                                        bi.a318d.isChecked() ? "4" :
                                                bi.a318e.isChecked() ? "5" :
                                                        bi.a318f.isChecked() ? "6" :
                                                                bi.a318g.isChecked() ? "7" :
                                                                        bi.a318h.isChecked() ? "8" :
                                                                                bi.a318i.isChecked() ? "9" :
                                                                                        bi.a318j.isChecked() ? "10" :
                                                                                                bi.a318k.isChecked() ? "11" :
                                                                                                        bi.a31896.isChecked() ? "96" :
                                                                                                                "0");
        json.put("a31896x", bi.a31896x.getText().toString());
        json.put("a319a",
                bi.a319aa.isChecked() ? "1" :
                        bi.a319ab.isChecked() ? "2" :
                                "0");
        json.put("a319b",
                bi.a319ba.isChecked() ? "1" :
                        bi.a319bb.isChecked() ? "2" :
                                "0");
        json.put("a319c",
                bi.a319ca.isChecked() ? "1" :
                        bi.a319cb.isChecked() ? "2" :
                                "0");
        json.put("a319d",
                bi.a319da.isChecked() ? "1" :
                        bi.a319db.isChecked() ? "2" :
                                "0");
        json.put("a319e",
                bi.a319ea.isChecked() ? "1" :
                        bi.a319eb.isChecked() ? "2" :
                                "0");
        json.put("a319f",
                bi.a319fa.isChecked() ? "1" :
                        bi.a319fb.isChecked() ? "2" :
                                "0");
        json.put("a319g",
                bi.a319ga.isChecked() ? "1" :
                        bi.a319gb.isChecked() ? "2" :
                                "0");
        json.put("a319h",
                bi.a319ha.isChecked() ? "1" :
                        bi.a319hb.isChecked() ? "2" :
                                "0");
        json.put("a319i",
                bi.a319ia.isChecked() ? "1" :
                        bi.a319ib.isChecked() ? "2" :
                                "0");
        json.put("a319j",
                bi.a319ja.isChecked() ? "1" :
                        bi.a319jb.isChecked() ? "2" :
                                "0");
        json.put("a319k",
                bi.a319ka.isChecked() ? "1" :
                        bi.a319kb.isChecked() ? "2" :
                                "0");
        json.put("a319l",
                bi.a319la.isChecked() ? "1" :
                        bi.a319lb.isChecked() ? "2" :
                                "0");
        json.put("a319m",
                bi.a319ma.isChecked() ? "1" :
                        bi.a319mb.isChecked() ? "2" :
                                "0");
        json.put("a319n",
                bi.a319na.isChecked() ? "1" :
                        bi.a319nb.isChecked() ? "2" :
                                "0");
        json.put("a319o",
                bi.a319oa.isChecked() ? "1" :
                        bi.a319ob.isChecked() ? "2" :
                                "0");
        json.put("a319p",
                bi.a319pa.isChecked() ? "1" :
                        bi.a319pb.isChecked() ? "2" :
                                "0");
        json.put("a319q",
                bi.a319qa.isChecked() ? "1" :
                        bi.a319qb.isChecked() ? "2" :
                                "0");
        json.put("a319r",
                bi.a319ra.isChecked() ? "1" :
                        bi.a319rb.isChecked() ? "2" :
                                "0");
        json.put("a320",
                bi.a320a.isChecked() ? "1" :
                        bi.a320b.isChecked() ? "2" :
                                "0");
        json.put("a321a",
                bi.a321aa.isChecked() ? "1" :
                        bi.a321ab.isChecked() ? "2" :
                                "0");
        json.put("a321b",
                bi.a321ba.isChecked() ? "1" :
                        bi.a321bb.isChecked() ? "2" :
                                "0");
        json.put("a321c",
                bi.a321ca.isChecked() ? "1" :
                        bi.a321cb.isChecked() ? "2" :
                                "0");
        json.put("a321d",
                bi.a321da.isChecked() ? "1" :
                        bi.a321db.isChecked() ? "2" :
                                "0");
        json.put("a321e",
                bi.a321ea.isChecked() ? "1" :
                        bi.a321eb.isChecked() ? "2" :
                                "0");
        json.put("a321f",
                bi.a321fa.isChecked() ? "1" :
                        bi.a321fb.isChecked() ? "2" :
                                "0");
        json.put("a321g",
                bi.a321ga.isChecked() ? "1" :
                        bi.a321gb.isChecked() ? "2" :
                                "0");
        json.put("a321h",
                bi.a321ha.isChecked() ? "1" :
                        bi.a321hb.isChecked() ? "2" :
                                "0");
        json.put("a321i",
                bi.a321ia.isChecked() ? "1" :
                        bi.a321ib.isChecked() ? "2" :
                                "0");
        json.put("a322",
                bi.a322a.isChecked() ? "1" :
                        bi.a322b.isChecked() ? "2" :
                                bi.a322c.isChecked() ? "3" :
                                        bi.a322d.isChecked() ? "4" :
                                                bi.a322e.isChecked() ? "5" :
                                                        bi.a322f.isChecked() ? "6" :
                                                                bi.a322g.isChecked() ? "7" :
                                                                        bi.a322h.isChecked() ? "8" :
                                                                                bi.a322i.isChecked() ? "9" :
                                                                                        bi.a322j.isChecked() ? "10" :
                                                                                                bi.a322k.isChecked() ? "11" :
                                                                                                        bi.a32296.isChecked() ? "96" :
                                                                                                                "0");
        json.put("a32296x", bi.a32296x.getText().toString());

        json.put("a323",
                bi.a323a.isChecked() ? "1" :
                        bi.a323b.isChecked() ? "2" :
                                bi.a323c.isChecked() ? "98" :
                                        "0");
        json.put("a324",
                bi.a324a.isChecked() ? "1" :
                        bi.a324b.isChecked() ? "2" :
                                "0");

        json.put("a325",
                bi.a325a.isChecked() ? "1" :
                        bi.a325b.isChecked() ? "2" :
                                bi.a32598.isChecked() ? "98" :
                                        "0");

        json.put("a326",
                bi.a326a.isChecked() ? "1" :
                        bi.a326b.isChecked() ? "2" :
                                bi.a326c.isChecked() ? "98" :
                                        "0");

        json.put("a327",
                bi.a327a.isChecked() ? "1" :
                        bi.a327b.isChecked() ? "2" :
                                bi.a32798.isChecked() ? "98" :
                                        "0");
        json.put("a327x", bi.a327x.getText().toString());

        json.put("a328",
                bi.a328a.isChecked() ? "1" :
                        bi.a328b.isChecked() ? "2" :
                                bi.a328c.isChecked() ? "98" :
                                        "0");

        json.put("a329a", bi.a329a.getText().toString());
        json.put("a329b", bi.a329b.getText().toString());
        json.put("a329c", bi.a329c.getText().toString());
        json.put("a329d", bi.a329d.getText().toString());
        json.put("a329e", bi.a329e.getText().toString());
        json.put("a329f", bi.a329f.getText().toString());

        json.put("a330",
                bi.a330a.isChecked() ? "1" :
                        bi.a330b.isChecked() ? "2" :
                                bi.a33098.isChecked() ? "98" :
                                        "0");
        json.put("a331",
                bi.a331a.isChecked() ? "1" :
                        bi.a331b.isChecked() ? "2" :
                                bi.a33198.isChecked() ? "98" :
                                        "0");
        json.put("a331x", bi.a331x.getText().toString());

        json.put("a332a", bi.a332a.isChecked() ? "1" : "0");
        json.put("a332b", bi.a332b.isChecked() ? "2" : "0");
        json.put("a332c", bi.a332c.isChecked() ? "3" : "0");
        json.put("a332d", bi.a332d.isChecked() ? "4" : "0");
        json.put("a33297", bi.a33297.isChecked() ? "97" : "0");
        json.put("a33296", bi.a33296.isChecked() ? "96" : "0");
        json.put("a33296x", bi.a33296x.getText().toString());

        json.put("a333a", bi.a333a.isChecked() ? "1" : "0");
        json.put("a333b", bi.a333b.isChecked() ? "2" : "0");
        json.put("a333c", bi.a333c.isChecked() ? "3" : "0");
        json.put("a333x", bi.a33396.isChecked() ? "96" : "0");
        json.put("a333xt", bi.a33396x.getText().toString());

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsA3()), json);

            MainApp.fc.setsA3(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }


}

