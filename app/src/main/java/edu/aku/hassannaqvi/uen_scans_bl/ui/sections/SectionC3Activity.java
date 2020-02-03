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
import edu.aku.hassannaqvi.uen_scans_bl.contracts.KishMWRAContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionC3Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;
import edu.aku.hassannaqvi.uen_scans_bl.validator.ClearClass;

public class SectionC3Activity extends AppCompatActivity {

    ActivitySectionC3Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c3);
        bi.setCallback(this);

        setlistener();

    }


    private void setlistener() {

        bi.c312.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.c312a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVC301, null);
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
                startActivity(new Intent(this, SectionC4Activity.class));
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
        int updcount = db.updatesKishMWRAColumn(KishMWRAContract.SingleKishMWRA.COLUMN_SK, MainApp.kish.getsK());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject f1 = new JSONObject();

        f1.put("c301",
                bi.c301a.isChecked() ? "1" :
                        bi.c301b.isChecked() ? "2" :
                                bi.c301c.isChecked() ? "3" :
                                        bi.c301d.isChecked() ? "4" :
                                                bi.c301e.isChecked() ? "5" :
                                                        bi.c301f.isChecked() ? "6" :
                                                                bi.c301g.isChecked() ? "7" :
                                                                        bi.c301h.isChecked() ? "8" :
                                                                                "0");

        f1.put("c302",
                bi.c302a.isChecked() ? "1" :
                        bi.c302b.isChecked() ? "2" :
                                bi.c302c.isChecked() ? "3" :
                                        bi.c302d.isChecked() ? "4" :
                                                bi.c302e.isChecked() ? "5" :
                                                        bi.c302f.isChecked() ? "6" :
                                                                bi.c302g.isChecked() ? "7" :
                                                                        bi.c302h.isChecked() ? "8" :
                                                                                "0");

        f1.put("c303",
                bi.c303a.isChecked() ? "1" :
                        bi.c303b.isChecked() ? "2" :
                                bi.c303c.isChecked() ? "3" :
                                        bi.c303d.isChecked() ? "4" :
                                                bi.c303e.isChecked() ? "5" :
                                                        bi.c303f.isChecked() ? "6" :
                                                                bi.c303g.isChecked() ? "7" :
                                                                        bi.c303h.isChecked() ? "8" :
                                                                                "0");

        f1.put("c304a",
                bi.c304aa.isChecked() ? "1" :
                        bi.c304ab.isChecked() ? "2" :
                                bi.c304ac.isChecked() ? "3" :
                                        bi.c304ad.isChecked() ? "4" :
                                                bi.c304ae.isChecked() ? "5" :
                                                        bi.c304af.isChecked() ? "6" :
                                                                "0");

        f1.put("c304b",
                bi.c304ba.isChecked() ? "1" :
                        bi.c304bb.isChecked() ? "2" :
                                bi.c304bc.isChecked() ? "3" :
                                        bi.c304bd.isChecked() ? "4" :
                                                bi.c304be.isChecked() ? "5" :
                                                        bi.c304bf.isChecked() ? "6" :
                                                                "0");

        f1.put("c304c",
                bi.c304ca.isChecked() ? "1" :
                        bi.c304cb.isChecked() ? "2" :
                                bi.c304cc.isChecked() ? "3" :
                                        bi.c304cd.isChecked() ? "4" :
                                                bi.c304ce.isChecked() ? "5" :
                                                        bi.c304cf.isChecked() ? "6" :
                                                                "0");

        f1.put("c305",
                bi.c305a.isChecked() ? "1" :
                        bi.c305b.isChecked() ? "2" :
                                bi.c305c.isChecked() ? "3" :
                                        "0");

        f1.put("c306",
                bi.c306a.isChecked() ? "1" :
                        bi.c306b.isChecked() ? "2" :
                                bi.c306c.isChecked() ? "3" :
                                        "0");

        f1.put("c307",
                bi.c307a.isChecked() ? "1" :
                        bi.c307b.isChecked() ? "2" :
                                bi.c307c.isChecked() ? "3" :
                                        "0");

        f1.put("c308",
                bi.c308a.isChecked() ? "1" :
                        bi.c308b.isChecked() ? "2" :
                                bi.c308c.isChecked() ? "3" :
                                        "0");

        f1.put("c309",
                bi.c309a.isChecked() ? "1" :
                        bi.c309b.isChecked() ? "2" :
                                bi.c309c.isChecked() ? "3" :
                                        "0");

        f1.put("c310",
                bi.c310a.isChecked() ? "1" :
                        bi.c310b.isChecked() ? "2" :
                                bi.c310c.isChecked() ? "3" :
                                        "0");

        f1.put("c311",
                bi.c311a.isChecked() ? "1" :
                        bi.c311b.isChecked() ? "2" :
                                bi.c311c.isChecked() ? "3" :
                                        "0");

        f1.put("c312",
                bi.c312a.isChecked() ? "1" :
                        bi.c312b.isChecked() ? "2" :
                                bi.c312c.isChecked() ? "98" :
                                        "0");

        f1.put("c313",
                bi.c313a.isChecked() ? "1" :
                        bi.c313b.isChecked() ? "2" :
                                "0");

        f1.put("c314",
                bi.c314a.isChecked() ? "1" :
                        bi.c314b.isChecked() ? "2" :
                                bi.c314c.isChecked() ? "3" :
                                        bi.c314d.isChecked() ? "4" :
                                                "0");

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionC3);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}
