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
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionC6Binding;
import edu.aku.hassannaqvi.uen_scans_bl.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionC6Activity extends AppCompatActivity {

    ActivitySectionC6Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c6);
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
                startActivity(new Intent(this, SectionD1Activity.class));
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
        int updcount = db.updatesKishMWRAColumn(FoodFreqContract.SingleKishMWRA.COLUMN_SK, MainApp.kish.getsK());
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

        f1.put("ca601", bi.ca601.getText().toString());

        f1.put("ca602", bi.ca602.getText().toString());

        f1.put("ca603",
                bi.ca603a.isChecked() ? "1" :
                        bi.ca603b.isChecked() ? "2" :
                                "0");

        f1.put("ca604", bi.ca604.getText().toString());

        f1.put("ca605", bi.ca605.getText().toString());

        f1.put("ca606",
                bi.ca606a.isChecked() ? "1" :
                        bi.ca606b.isChecked() ? "2" :
                                "0");

        f1.put("ca607",
                bi.ca607a.isChecked() ? "1" :
                        bi.ca607b.isChecked() ? "2" :
                                bi.ca607c.isChecked() ? "3" :
                                        bi.ca607d.isChecked() ? "4" :
                                                "0");

        f1.put("cb601", bi.cb601.getText().toString());

        f1.put("cb602", bi.cb602.getText().toString());

        f1.put("cb603",
                bi.cb603a.isChecked() ? "1" :
                        bi.cb603b.isChecked() ? "2" :
                                "0");

        f1.put("cb604",
                bi.cb604a.isChecked() ? "1" :
                        bi.cb604b.isChecked() ? "2" :
                                bi.cb604c.isChecked() ? "3" :
                                        bi.cb604d.isChecked() ? "4" :
                                                "0");

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionC6);

    }


    /*@Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }*/


}
