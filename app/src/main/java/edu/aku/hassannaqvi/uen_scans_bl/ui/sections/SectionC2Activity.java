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
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionC2Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;
import edu.aku.hassannaqvi.uen_scans_bl.validator.ClearClass;

public class SectionC2Activity extends AppCompatActivity {

    ActivitySectionC2Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c2);
        bi.setCallback(this);

        setlistener();

    }


    private void setlistener() {

        bi.c201.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.c201g.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVc202, null);
            }

        }));

        bi.c207.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.c207e.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVC201, null);
            }
        }));

        bi.c210.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.c210a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVC202, null);
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
                startActivity(new Intent(this, SectionC3Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void BtnEnd() {

        Util.openEndActivity(this);
    }


    private boolean UpdateDB() {

        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesKishMWRAColumn(KishMWRAContract.SingleKishMWRA.COLUMN_SK, MainApp.kish.getsK());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }


    private void SaveDraft() throws JSONException {

        JSONObject f1 = new JSONObject();

        f1.put("c201",
                bi.c201a.isChecked() ? "1" :
                        bi.c201b.isChecked() ? "2" :
                                bi.c201c.isChecked() ? "3" :
                                        bi.c201d.isChecked() ? "4" :
                                                bi.c201e.isChecked() ? "5" :
                                                        bi.c201f.isChecked() ? "6" :
                                                                bi.c201g.isChecked() ? "97" :
                                                                        "0");

        f1.put("c202",
                bi.c202a.isChecked() ? "1" :
                        bi.c202b.isChecked() ? "2" :
                                bi.c202c.isChecked() ? "3" :
                                        bi.c202x.isChecked() ? "96" :
                                                "0");

        f1.put("c203",
                bi.c203a.isChecked() ? "1" :
                        bi.c203b.isChecked() ? "2" :
                                bi.c203c.isChecked() ? "3" :
                                        bi.c203d.isChecked() ? "4" :
                                                bi.c203e.isChecked() ? "97" :
                                                        "0");

        f1.put("c204",
                bi.c204a.isChecked() ? "1" :
                        bi.c204b.isChecked() ? "2" :
                                bi.c204c.isChecked() ? "3" :
                                        bi.c204d.isChecked() ? "4" :
                                                bi.c204e.isChecked() ? "5" :
                                                        bi.c204f.isChecked() ? "98" :
                                                                "0");

        f1.put("c205a", bi.c205a.isChecked() ? "1" : "0");
        f1.put("c205b", bi.c205b.isChecked() ? "2" : "0");
        f1.put("c205c", bi.c205c.isChecked() ? "3" : "0");
        f1.put("c205d", bi.c205d.isChecked() ? "4" : "0");
        f1.put("c205e", bi.c205e.isChecked() ? "5" : "0");
        f1.put("c205f", bi.c205f.isChecked() ? "6" : "0");
        f1.put("c205g", bi.c205g.isChecked() ? "7" : "0");

        f1.put("c206",
                bi.c206a.isChecked() ? "1" :
                        bi.c206b.isChecked() ? "2" :
                                bi.c206c.isChecked() ? "3" :
                                        bi.c206d.isChecked() ? "97" :
                                                bi.c206e.isChecked() ? "98" :
                                                        "0");

        f1.put("c207",
                bi.c207a.isChecked() ? "1" :
                        bi.c207b.isChecked() ? "2" :
                                bi.c207c.isChecked() ? "3" :
                                        bi.c207d.isChecked() ? "4" :
                                                bi.c207e.isChecked() ? "97" :
                                                        bi.c207f.isChecked() ? "98" :
                                                                "0");

        f1.put("c208",
                bi.c208a.isChecked() ? "1" :
                        bi.c208b.isChecked() ? "2" :
                                bi.c208c.isChecked() ? "3" :
                                        bi.c208d.isChecked() ? "4" :
                                                bi.c208e.isChecked() ? "5" :
                                                        bi.c208x.isChecked() ? "96" :
                                                                "0");

        f1.put("c209",
                bi.c209a.isChecked() ? "1" :
                        bi.c209b.isChecked() ? "2" :
                                bi.c209c.isChecked() ? "3" :
                                        bi.c209d.isChecked() ? "4" :
                                                bi.c209e.isChecked() ? "5" :
                                                        bi.c209f.isChecked() ? "6" :
                                                                bi.c209g.isChecked() ? "98" :
                                                                        bi.c209x.isChecked() ? "96" :
                                                                                "0");

        f1.put("c210",
                bi.c210a.isChecked() ? "1" :
                        bi.c210b.isChecked() ? "2" :
                                bi.c210c.isChecked() ? "98" :
                                        "0");

        f1.put("c211",
                bi.c211a.isChecked() ? "1" :
                        bi.c211b.isChecked() ? "2" :
                                bi.c211c.isChecked() ? "3" :
                                        bi.c211d.isChecked() ? "4" :
                                                bi.c211e.isChecked() ? "5" :
                                                        bi.c211f.isChecked() ? "6" :
                                                                bi.c211g.isChecked() ? "7" :
                                                                        bi.c211h.isChecked() ? "98" :
                                                                                bi.c211x.isChecked() ? "96" :
                                                                                        "0");

        f1.put("c212",
                bi.c212a.isChecked() ? "1" :
                        bi.c212b.isChecked() ? "2" :
                                bi.c212c.isChecked() ? "3" :
                                        bi.c212d.isChecked() ? "4" :
                                                bi.c212e.isChecked() ? "98" :
                                                        bi.c212x.isChecked() ? "96" :
                                                                "0");

        f1.put("c213a", bi.c213a.isChecked() ? "1" : "0");
        f1.put("c213b", bi.c213b.isChecked() ? "2" : "0");
        f1.put("c213c", bi.c213c.isChecked() ? "3" : "0");
        f1.put("c213d", bi.c213d.isChecked() ? "4" : "0");
        f1.put("c213e", bi.c213e.isChecked() ? "5" : "0");
        f1.put("c213f", bi.c213f.isChecked() ? "6" : "0");
        f1.put("c213g", bi.c213g.isChecked() ? "7" : "0");
        f1.put("c213h", bi.c213h.isChecked() ? "8" : "0");
        f1.put("c213i", bi.c213i.isChecked() ? "97" : "0");

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionC2);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
