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
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionC5Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionC5Activity extends AppCompatActivity {


    ActivitySectionC5Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c5);
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
                startActivity(new Intent(this, SectionC6Activity.class));
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

        f1.put("c501",
                bi.c501a.isChecked() ? "1" :
                        bi.c501b.isChecked() ? "2" :
                                bi.c501c.isChecked() ? "3" :
                                        bi.c501d.isChecked() ? "4" :
                                                bi.c501e.isChecked() ? "5" :
                                                        bi.c501f.isChecked() ? "6" :
                                                                bi.c501g.isChecked() ? "7" :
                                                                        "0");

        f1.put("c502",
                bi.c502a.isChecked() ? "1" :
                        bi.c502b.isChecked() ? "2" :
                                bi.c502c.isChecked() ? "3" :
                                        bi.c502d.isChecked() ? "4" :
                                                bi.c502e.isChecked() ? "5" :
                                                        bi.c502f.isChecked() ? "6" :
                                                                bi.c502g.isChecked() ? "7" :
                                                                        "0");

        f1.put("c503",
                bi.c503a.isChecked() ? "1" :
                        bi.c503b.isChecked() ? "2" :
                                bi.c503c.isChecked() ? "3" :
                                        bi.c503d.isChecked() ? "4" :
                                                bi.c503e.isChecked() ? "5" :
                                                        bi.c503f.isChecked() ? "6" :
                                                                bi.c503g.isChecked() ? "7" :
                                                                        "0");

        f1.put("c504",
                bi.c504a.isChecked() ? "1" :
                        bi.c504b.isChecked() ? "2" :
                                bi.c504c.isChecked() ? "3" :
                                        bi.c504d.isChecked() ? "4" :
                                                bi.c504e.isChecked() ? "5" :
                                                        bi.c504f.isChecked() ? "6" :
                                                                bi.c504g.isChecked() ? "7" :
                                                                        "0");

        f1.put("c505",
                bi.c505a.isChecked() ? "1" :
                        bi.c505b.isChecked() ? "2" :
                                bi.c505c.isChecked() ? "3" :
                                        bi.c505d.isChecked() ? "4" :
                                                bi.c505e.isChecked() ? "5" :
                                                        bi.c505f.isChecked() ? "6" :
                                                                bi.c505g.isChecked() ? "7" :
                                                                        "0");

        f1.put("c506",
                bi.c506a.isChecked() ? "1" :
                        bi.c506b.isChecked() ? "2" :
                                bi.c506c.isChecked() ? "3" :
                                        bi.c506d.isChecked() ? "4" :
                                                bi.c506e.isChecked() ? "5" :
                                                        bi.c506f.isChecked() ? "6" :
                                                                bi.c506g.isChecked() ? "7" :
                                                                        "0");

        f1.put("c507",
                bi.c507a.isChecked() ? "1" :
                        bi.c507b.isChecked() ? "2" :
                                bi.c507c.isChecked() ? "3" :
                                        bi.c507d.isChecked() ? "4" :
                                                bi.c507e.isChecked() ? "5" :
                                                        bi.c507f.isChecked() ? "6" :
                                                                bi.c507g.isChecked() ? "7" :
                                                                        "0");

        f1.put("c508",
                bi.c508a.isChecked() ? "1" :
                        bi.c508b.isChecked() ? "2" :
                                bi.c508c.isChecked() ? "3" :
                                        bi.c508d.isChecked() ? "4" :
                                                bi.c508e.isChecked() ? "5" :
                                                        bi.c508f.isChecked() ? "6" :
                                                                bi.c508g.isChecked() ? "7" :
                                                                        bi.c508h.isChecked() ? "8" :
                                                                                "0");

        f1.put("c509",
                bi.c509a.isChecked() ? "1" :
                        bi.c509b.isChecked() ? "2" :
                                bi.c509c.isChecked() ? "3" :
                                        bi.c509d.isChecked() ? "4" :
                                                bi.c509e.isChecked() ? "5" :
                                                        bi.c509f.isChecked() ? "6" :
                                                                bi.c509g.isChecked() ? "7" :
                                                                        "0");

        f1.put("c510",
                bi.c510a.isChecked() ? "1" :
                        bi.c510b.isChecked() ? "2" :
                                bi.c510c.isChecked() ? "3" :
                                        bi.c510d.isChecked() ? "4" :
                                                bi.c510e.isChecked() ? "5" :
                                                        bi.c510f.isChecked() ? "6" :
                                                                bi.c510g.isChecked() ? "7" :
                                                                        "0");

        f1.put("c511",
                bi.c511a.isChecked() ? "1" :
                        bi.c511b.isChecked() ? "2" :
                                bi.c511c.isChecked() ? "3" :
                                        bi.c511d.isChecked() ? "4" :
                                                bi.c511e.isChecked() ? "5" :
                                                        bi.c511f.isChecked() ? "6" :
                                                                bi.c511g.isChecked() ? "7" :
                                                                        "0");

        f1.put("c512",
                bi.c512a.isChecked() ? "1" :
                        bi.c512b.isChecked() ? "2" :
                                bi.c512c.isChecked() ? "3" :
                                        bi.c512d.isChecked() ? "4" :
                                                bi.c512e.isChecked() ? "5" :
                                                        bi.c512f.isChecked() ? "6" :
                                                                bi.c512g.isChecked() ? "7" :
                                                                        bi.c512h.isChecked() ? "8" :
                                                                                "0");

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionC5);

    }


    /*@Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }*/


}
