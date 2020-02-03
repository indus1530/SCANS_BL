package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionA3Binding;

public class SectionA3Activity extends AppCompatActivity {

    ActivitySectionA3Binding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_a3);

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
                //startActivity(new Intent(SectionA3Activity.this, FamilyMembersListActivity.class).putExtra("sno", Integer.valueOf(bl.getSno())));
            }
        }
    }


    private boolean UpdateDB() {
        long updcount = db.addForm(MainApp.fc);
        MainApp.fc.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            MainApp.fc.set_UID(MainApp.fc.getDeviceID() + MainApp.fc.get_ID());
            db.updatesFormColumn(FormsContract.FormsTable.COLUMN_UID, MainApp.fc.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    private void SaveDraft() throws JSONException {

        JSONObject f1 = new JSONObject();
        f1.put("a301",
                bi.a301a.isChecked() ? "1" :
                        bi.a301b.isChecked() ? "2" :
                                bi.a301c.isChecked() ? "3" :
                                        bi.a301d.isChecked() ? "4" :
                                                bi.a301e.isChecked() ? "5" :
                                                        bi.a301f.isChecked() ? "6" :
                                                                bi.a301g.isChecked() ? "7" :
                                                                        bi.a301h.isChecked() ? "8" :
                                                                                bi.a301i.isChecked() ? "9" :
                                                                                        bi.a301j.isChecked() ? "10" :
                                                                                                bi.a301x.isChecked() ? "96" :
                                                                                                        "0");
        f1.put("a301xt", bi.a301xt.getText().toString());
        f1.put("a302",
                bi.a302a.isChecked() ? "1" :
                        bi.a302b.isChecked() ? "2" :
                                bi.a302c.isChecked() ? "3" :
                                        bi.a302d.isChecked() ? "4" :
                                                bi.a302x.isChecked() ? "96" :
                                                        "0");
        f1.put("a302xt", bi.a302xt.getText().toString());
        f1.put("a303",
                bi.a303a.isChecked() ? "1" :
                        bi.a303b.isChecked() ? "2" :
                                bi.a303c.isChecked() ? "3" :
                                        bi.a303d.isChecked() ? "4" :
                                                bi.a303e.isChecked() ? "5" :
                                                        bi.a303f.isChecked() ? "6" :
                                                                bi.a303g.isChecked() ? "7" :
                                                                        bi.a303h.isChecked() ? "8" :
                                                                                bi.a303i.isChecked() ? "9" :
                                                                                        bi.a303j.isChecked() ? "10" :
                                                                                                bi.a303k.isChecked() ? "11" :
                                                                                                        bi.a303x.isChecked() ? "96" :
                                                                                                                "0");
        f1.put("a303xt", bi.a303xt.getText().toString());
        f1.put("a304",
                bi.a304a.isChecked() ? "1" :
                        bi.a304b.isChecked() ? "2" :
                                bi.a304c.isChecked() ? "3" :
                                        bi.a304d.isChecked() ? "4" :
                                                bi.a304e.isChecked() ? "5" :
                                                        bi.a304f.isChecked() ? "6" :
                                                                bi.a304g.isChecked() ? "7" :
                                                                        bi.a304h.isChecked() ? "8" :
                                                                                bi.a304i.isChecked() ? "9" :
                                                                                        bi.a304j.isChecked() ? "10" :
                                                                                                bi.a304k.isChecked() ? "11" :
                                                                                                        bi.a304l.isChecked() ? "12" :
                                                                                                                bi.a304m.isChecked() ? "13" :
                                                                                                                        bi.a304n.isChecked() ? "14" :
                                                                                                                                bi.a304o.isChecked() ? "15" :
                                                                                                                                        bi.a304x.isChecked() ? "96" :
                                                                                                                                                "0");
        f1.put("a304xt", bi.a304xt.getText().toString());
        f1.put("a305",
                bi.a305a.isChecked() ? "1" :
                        bi.a305b.isChecked() ? "2" :
                                bi.a305c.isChecked() ? "3" :
                                        bi.a305d.isChecked() ? "4" :
                                                bi.a305e.isChecked() ? "5" :
                                                        bi.a305f.isChecked() ? "6" :
                                                                bi.a305g.isChecked() ? "7" :
                                                                        bi.a305h.isChecked() ? "8" :
                                                                                bi.a305i.isChecked() ? "9" :
                                                                                        bi.a305j.isChecked() ? "10" :
                                                                                                bi.a305k.isChecked() ? "11" :
                                                                                                        bi.a305l.isChecked() ? "12" :
                                                                                                                bi.a305m.isChecked() ? "13" :
                                                                                                                        bi.a305n.isChecked() ? "14" :
                                                                                                                                bi.a305o.isChecked() ? "15" :
                                                                                                                                        bi.a305p.isChecked() ? "16" :
                                                                                                                                                bi.a305x.isChecked() ? "96" :
                                                                                                                                                        "0");
        f1.put("a305xt", bi.a305xt.getText().toString());
        f1.put("a306",
                bi.a306a.isChecked() ? "1" :
                        bi.a306b.isChecked() ? "2" :
                                bi.a306c.isChecked() ? "3" :
                                        bi.a306d.isChecked() ? "4" :
                                                bi.a306e.isChecked() ? "5" :
                                                        bi.a306f.isChecked() ? "6" :
                                                                bi.a306g.isChecked() ? "7" :
                                                                        bi.a306h.isChecked() ? "8" :
                                                                                bi.a306i.isChecked() ? "9" :
                                                                                        bi.a306j.isChecked() ? "10" :
                                                                                                bi.a306k.isChecked() ? "11" :
                                                                                                        bi.a306l.isChecked() ? "12" :
                                                                                                                bi.a306m.isChecked() ? "13" :
                                                                                                                        bi.a306n.isChecked() ? "14" :
                                                                                                                                bi.a306x.isChecked() ? "96" :
                                                                                                                                        "0");
        f1.put("a306xt", bi.a306xt.getText().toString());
        f1.put("a306aa",
                bi.a306aaa.isChecked() ? "1" :
                        bi.a306aab.isChecked() ? "2" :
                                "0");
        f1.put("a307",
                bi.a307a.isChecked() ? "1" :
                        bi.a307b.isChecked() ? "2" :
                                bi.a307c.isChecked() ? "3" :
                                        bi.a307d.isChecked() ? "4" :
                                                bi.a307e.isChecked() ? "5" :
                                                        bi.a307f.isChecked() ? "6" :
                                                                bi.a307g.isChecked() ? "7" :
                                                                        bi.a307h.isChecked() ? "8" :
                                                                                bi.a307i.isChecked() ? "9" :
                                                                                        bi.a307j.isChecked() ? "10" :
                                                                                                bi.a307k.isChecked() ? "11" :
                                                                                                        bi.a307l.isChecked() ? "12" :
                                                                                                                bi.a307m.isChecked() ? "13" :
                                                                                                                        bi.a307n.isChecked() ? "14" :
                                                                                                                                bi.a307x.isChecked() ? "96" :
                                                                                                                                        "0");
        f1.put("a307xt", bi.a307xt.getText().toString());
        f1.put("a307aa",
                bi.a307aaa.isChecked() ? "1" :
                        bi.a307aab.isChecked() ? "2" :
                                "0");
        f1.put("a308",
                bi.a308a.isChecked() ? "1" :
                        bi.a308b.isChecked() ? "2" :
                                bi.a308c.isChecked() ? "3" :
                                        "0");
        f1.put("a309", bi.a309a.getText().toString());
        f1.put("a310",
                bi.a310a.isChecked() ? "1" :
                        bi.a310b.isChecked() ? "2" :
                                bi.a310c.isChecked() ? "3" :
                                        bi.a310d.isChecked() ? "4" :
                                                bi.a310e.isChecked() ? "5" :
                                                        "0");
        f1.put("a311",
                bi.a311a.isChecked() ? "1" :
                        bi.a311b.isChecked() ? "2" :
                                "0");
        f1.put("a312",
                bi.a312a.isChecked() ? "1" :
                        bi.a312b.isChecked() ? "2" :
                                bi.a312c.isChecked() ? "96" :
                                        "0");
        f1.put("a313",
                bi.a313a.isChecked() ? "1" :
                        bi.a313b.isChecked() ? "2" :
                                bi.a313c.isChecked() ? "98" :
                                        "0");
        f1.put("a314",
                bi.a314a.isChecked() ? "1" :
                        bi.a314b.isChecked() ? "2" :
                                bi.a314c.isChecked() ? "3" :
                                        bi.a314d.isChecked() ? "4" :
                                                bi.a314e.isChecked() ? "5" :
                                                        bi.a314f.isChecked() ? "6" :
                                                                bi.a314x.isChecked() ? "96" :
                                                                        "0");
        f1.put("a314xt", bi.a314xt.getText().toString());
        f1.put("a315", bi.a315.getText().toString());
        f1.put("a316",
                bi.a316a.isChecked() ? "1" :
                        bi.a316b.isChecked() ? "2" :
                                bi.a316x.isChecked() ? "96" :
                                        "0");
        f1.put("a316xt", bi.a316xt.getText().toString());
        f1.put("a317",
                bi.a317a.isChecked() ? "1" :
                        bi.a317b.isChecked() ? "2" :
                                bi.a317c.isChecked() ? "3" :
                                        bi.a317d.isChecked() ? "4" :
                                                bi.a317x.isChecked() ? "96" :
                                                        "0");
        f1.put("a317xt", bi.a317xt.getText().toString());
        f1.put("a318",
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
        f1.put("a318xt", bi.a318xt.getText().toString());
        f1.put("a319a",
                bi.a319aa.isChecked() ? "1" :
                        bi.a319ab.isChecked() ? "2" :
                                "0");
        f1.put("a319b",
                bi.a319ba.isChecked() ? "1" :
                        bi.a319bb.isChecked() ? "2" :
                                "0");
        f1.put("a319c",
                bi.a319ca.isChecked() ? "1" :
                        bi.a319cb.isChecked() ? "2" :
                                "0");
        f1.put("a319d",
                bi.a319da.isChecked() ? "1" :
                        bi.a319db.isChecked() ? "2" :
                                "0");
        f1.put("a319e",
                bi.a319ea.isChecked() ? "1" :
                        bi.a319eb.isChecked() ? "2" :
                                "0");
        f1.put("a319f",
                bi.a319fa.isChecked() ? "1" :
                        bi.a319fb.isChecked() ? "2" :
                                "0");
        f1.put("a319g",
                bi.a319ga.isChecked() ? "1" :
                        bi.a319gb.isChecked() ? "2" :
                                "0");
        f1.put("a319h",
                bi.a319ha.isChecked() ? "1" :
                        bi.a319hb.isChecked() ? "2" :
                                "0");
        f1.put("a319i",
                bi.a319ia.isChecked() ? "1" :
                        bi.a319ib.isChecked() ? "2" :
                                "0");
        f1.put("a319j",
                bi.a319ja.isChecked() ? "1" :
                        bi.a319jb.isChecked() ? "2" :
                                "0");
        f1.put("a319k",
                bi.a319ka.isChecked() ? "1" :
                        bi.a319kb.isChecked() ? "2" :
                                "0");
        f1.put("a319l",
                bi.a319la.isChecked() ? "1" :
                        bi.a319lb.isChecked() ? "2" :
                                "0");
        f1.put("a319m",
                bi.a319ma.isChecked() ? "1" :
                        bi.a319mb.isChecked() ? "2" :
                                "0");
        f1.put("a319n",
                bi.a319na.isChecked() ? "1" :
                        bi.a319nb.isChecked() ? "2" :
                                "0");
        f1.put("a319o",
                bi.a319oa.isChecked() ? "1" :
                        bi.a319ob.isChecked() ? "2" :
                                "0");
        f1.put("a319p",
                bi.a319pa.isChecked() ? "1" :
                        bi.a319pb.isChecked() ? "2" :
                                "0");
        f1.put("a319q",
                bi.a319qa.isChecked() ? "1" :
                        bi.a319qb.isChecked() ? "2" :
                                "0");
        f1.put("a319r",
                bi.a319ra.isChecked() ? "1" :
                        bi.a319rb.isChecked() ? "2" :
                                "0");
        f1.put("a320",
                bi.a320a.isChecked() ? "1" :
                        bi.a320b.isChecked() ? "2" :
                                "0");
        f1.put("a321a",
                bi.a321aa.isChecked() ? "1" :
                        bi.a321ab.isChecked() ? "2" :
                                "0");
        f1.put("a321b",
                bi.a321ba.isChecked() ? "1" :
                        bi.a321bb.isChecked() ? "2" :
                                "0");
        f1.put("a321c",
                bi.a321ca.isChecked() ? "1" :
                        bi.a321cb.isChecked() ? "2" :
                                "0");
        f1.put("a321d",
                bi.a321da.isChecked() ? "1" :
                        bi.a321db.isChecked() ? "2" :
                                "0");
        f1.put("a321e",
                bi.a321ea.isChecked() ? "1" :
                        bi.a321eb.isChecked() ? "2" :
                                "0");
        f1.put("a321f",
                bi.a321fa.isChecked() ? "1" :
                        bi.a321fb.isChecked() ? "2" :
                                "0");
        f1.put("a321g",
                bi.a321ga.isChecked() ? "1" :
                        bi.a321gb.isChecked() ? "2" :
                                "0");
        f1.put("a321h",
                bi.a321ha.isChecked() ? "1" :
                        bi.a321hb.isChecked() ? "2" :
                                "0");
        f1.put("a321i",
                bi.a321ia.isChecked() ? "1" :
                        bi.a321ib.isChecked() ? "2" :
                                "0");
        f1.put("a322",
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
        f1.put("a322xt", bi.a322xt.getText().toString());
        f1.put("a323",
                bi.a323a.isChecked() ? "1" :
                        bi.a323b.isChecked() ? "2" :
                                bi.a323c.isChecked() ? "98" :
                                        "0");
        f1.put("a324",
                bi.a324a.isChecked() ? "1" :
                        bi.a324b.isChecked() ? "2" :
                                "0");
        f1.put("a325",
                bi.a325a.isChecked() ? "1" :
                        bi.a325b.isChecked() ? "2" :
                                bi.a325x.isChecked() ? "98" :
                                        "0");
        f1.put("a326",
                bi.a326a.isChecked() ? "1" :
                        bi.a326b.isChecked() ? "2" :
                                bi.a326c.isChecked() ? "98" :
                                        "0");
        f1.put("a327a", bi.a327a.getText().toString());
        f1.put("a327b", bi.a327b.getText().toString());
        f1.put("a328",
                bi.a328a.isChecked() ? "1" :
                        bi.a328b.isChecked() ? "2" :
                                bi.a328c.isChecked() ? "98" :
                                        "0");
        f1.put("a329a", bi.a329a.getText().toString());
        f1.put("a329b", bi.a329b.getText().toString());
        f1.put("a329c", bi.a329c.getText().toString());
        f1.put("a329d", bi.a329d.getText().toString());
        f1.put("a329e", bi.a329e.getText().toString());
        f1.put("a329f", bi.a329f.getText().toString());
        f1.put("a330",
                bi.a330a.isChecked() ? "1" :
                        bi.a330b.isChecked() ? "2" :
                                bi.a330c.isChecked() ? "98" :
                                        "0");
        f1.put("a331",
                bi.a331a.isChecked() ? "1" :
                        bi.a331b.isChecked() ? "2" :
                                bi.a331c.isChecked() ? "98" :
                                        "0");
        f1.put("a332a", bi.a332a.isChecked() ? "1" : "0");
        f1.put("a332b", bi.a332b.isChecked() ? "2" : "0");
        f1.put("a332c", bi.a332c.isChecked() ? "3" : "0");
        f1.put("a332d", bi.a332d.isChecked() ? "4" : "0");
        f1.put("a332e", bi.a332e.isChecked() ? "97" : "0");
        f1.put("a332x", bi.a332x.isChecked() ? "96" : "0");
        f1.put("a332xt", bi.a332xt.getText().toString());
        f1.put("a333a", bi.a333a.isChecked() ? "1" : "0");
        f1.put("a333b", bi.a333b.isChecked() ? "2" : "0");
        f1.put("a333c", bi.a333c.isChecked() ? "3" : "0");
        f1.put("a333x", bi.a333x.isChecked() ? "96" : "0");
        f1.put("a333xt", bi.a333xt.getText().toString());


    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


}

