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
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionD1Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionD1Activity extends AppCompatActivity {


    ActivitySectionD1Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c2);
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

        f1.put("d101",
                bi.d101a.isChecked() ? "1" :
                        bi.d101b.isChecked() ? "2" :
                                bi.d101c.isChecked() ? "3" :
                                        "0");

        f1.put("d101_sub",
                bi.d101_suba.isChecked() ? "1" :
                        bi.d101_subb.isChecked() ? "2" :
                                bi.d101_subc.isChecked() ? "3" :
                                        bi.d101_subd.isChecked() ? "4" :
                                                bi.d101_sube.isChecked() ? "5" :
                                                        bi.d101_subf.isChecked() ? "6" :
                                                                bi.d101_subg.isChecked() ? "7" :
                                                                        bi.d101_subh.isChecked() ? "8" :
                                                                                "0");

        f1.put("d102",
                bi.d102a.isChecked() ? "1" :
                        bi.d102b.isChecked() ? "2" :
                                bi.d102c.isChecked() ? "3" :
                                        "0");

        f1.put("d102_sub",
                bi.d102_suba.isChecked() ? "1" :
                        bi.d102_subb.isChecked() ? "2" :
                                bi.d102_subc.isChecked() ? "3" :
                                        bi.d102_subd.isChecked() ? "4" :
                                                bi.d102_sube.isChecked() ? "5" :
                                                        bi.d102_subf.isChecked() ? "6" :
                                                                bi.d102_subg.isChecked() ? "7" :
                                                                        bi.d102_subh.isChecked() ? "8" :
                                                                                "0");

        f1.put("d103",
                bi.d103a.isChecked() ? "1" :
                        bi.d103b.isChecked() ? "2" :
                                "0");

        f1.put("d103_sub",
                bi.d103_suba.isChecked() ? "1" :
                        bi.d103_subb.isChecked() ? "2" :
                                bi.d103_subc.isChecked() ? "3" :
                                        bi.d103_subd.isChecked() ? "4" :
                                                bi.d103_sube.isChecked() ? "5" :
                                                        bi.d103_subf.isChecked() ? "6" :
                                                                bi.d103_subg.isChecked() ? "7" :
                                                                        "0");

        f1.put("d104",
                bi.d104a.isChecked() ? "1" :
                        bi.d104b.isChecked() ? "2" :
                                "0");

        f1.put("d104_sub",
                bi.d104_suba.isChecked() ? "1" :
                        bi.d104_subb.isChecked() ? "2" :
                                bi.d104_subc.isChecked() ? "3" :
                                        bi.d104_subd.isChecked() ? "4" :
                                                bi.d104_sube.isChecked() ? "5" :
                                                        bi.d104_subf.isChecked() ? "6" :
                                                                bi.d104_subg.isChecked() ? "7" :
                                                                        "0");

        f1.put("d105",
                bi.d105a.isChecked() ? "1" :
                        bi.d105b.isChecked() ? "2" :
                                bi.d105c.isChecked() ? "3" :
                                        bi.d150d.isChecked() ? "4" :
                                                "0");

        f1.put("d106",
                bi.d106a.isChecked() ? "1" :
                        bi.d106b.isChecked() ? "2" :
                                "0");

        f1.put("d106_sub",
                bi.d106_suba.isChecked() ? "1" :
                        bi.d106_subb.isChecked() ? "2" :
                                bi.d106_subc.isChecked() ? "3" :
                                        bi.d106_subd.isChecked() ? "4" :
                                                bi.d106_sube.isChecked() ? "5" :
                                                        "0");

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionD1);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
