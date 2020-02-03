package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionA32Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionA32Activity extends AppCompatActivity {

    ActivitySectionA32Binding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a32);
        bi.setCallback(this);


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
                //startActivity(new Intent(SectionA31Activity.this, FamilyMembersListActivity.class).putExtra("sno", Integer.valueOf(bl.getSno())));
            }
        }
    }


    public void BtnEnd() {
        Util.openEndActivity(this);
    }


    private boolean UpdateDB() {
        /*long updcount = db.addForm(MainApp.fc);
        MainApp.fc.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            MainApp.fc.set_UID(MainApp.fc.getDeviceID() + MainApp.fc.get_ID());
            db.updatesFormColumn(FormsContract.FormsTable.COLUMN_UID, MainApp.fc.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        return true;

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
                                                                                                        bi.a318x.isChecked() ? "96" :
                                                                                                                "0");
        json.put("a318xt", bi.a318xt.getText().toString());
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
                                                                                                bi.a322l.isChecked() ? "11" :
                                                                                                        bi.a322x.isChecked() ? "96" :
                                                                                                                "0");
        json.put("a322xt", bi.a322xt.getText().toString());
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
                                bi.a325x.isChecked() ? "98" :
                                        "0");
        json.put("a326",
                bi.a326a.isChecked() ? "1" :
                        bi.a326b.isChecked() ? "2" :
                                bi.a326c.isChecked() ? "98" :
                                        "0");
        json.put("a327a", bi.a327a.getText().toString());
        json.put("a327b", bi.a327b.getText().toString());
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
                                bi.a330c.isChecked() ? "98" :
                                        "0");
        json.put("a331",
                bi.a331a.isChecked() ? "1" :
                        bi.a331b.isChecked() ? "2" :
                                bi.a331c.isChecked() ? "98" :
                                        "0");
        json.put("a332a", bi.a332a.isChecked() ? "1" : "0");
        json.put("a332b", bi.a332b.isChecked() ? "2" : "0");
        json.put("a332c", bi.a332c.isChecked() ? "3" : "0");
        json.put("a332d", bi.a332d.isChecked() ? "4" : "0");
        json.put("a332e", bi.a332e.isChecked() ? "97" : "0");
        json.put("a332x", bi.a332x.isChecked() ? "96" : "0");
        json.put("a332xt", bi.a332xt.getText().toString());
        json.put("a333a", bi.a333a.isChecked() ? "1" : "0");
        json.put("a333b", bi.a333b.isChecked() ? "2" : "0");
        json.put("a333c", bi.a333c.isChecked() ? "3" : "0");
        json.put("a333x", bi.a333x.isChecked() ? "96" : "0");
        json.put("a333xt", bi.a333xt.getText().toString());


    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


}

