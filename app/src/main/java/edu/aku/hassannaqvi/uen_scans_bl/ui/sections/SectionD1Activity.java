package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FoodFreqContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionD1Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionD1Activity extends AppCompatActivity {

    ActivitySectionD1Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d1);
        bi.setCallback(this);

        bi.txtHeadLbl.setText(new StringBuilder(MainApp.indexKishMWRAChild.getName().toUpperCase()).append("\n")
                .append(MainApp.indexKishMWRA.getMother_name().toUpperCase()));
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
                startActivity(new Intent(this, SectionD2Activity.class));
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
        long rowID = db.addFoodFreq(MainApp.foodFreq);
        if (rowID > 0) {
            MainApp.foodFreq.set_ID(String.valueOf(rowID));
            MainApp.foodFreq.setUID(MainApp.foodFreq.getDeviceId() + MainApp.foodFreq.get_ID());
            db.updatesFoodFreqColumn(FoodFreqContract.SingleFoodFreq.COLUMN_UID, MainApp.foodFreq.getUID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        MainApp.foodFreq = new FoodFreqContract();
        MainApp.foodFreq.set_UUID(MainApp.fc.get_UID());
        MainApp.foodFreq.setDeviceId(MainApp.appInfo.getDeviceID());
        MainApp.foodFreq.setDevicetagID(MainApp.appInfo.getTagName());
        MainApp.foodFreq.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        MainApp.foodFreq.setUser(MainApp.userName);

        JSONObject f1 = new JSONObject();

        f1.put("hhno", MainApp.fc.getHhno());
        f1.put("cluster", MainApp.fc.getClusterCode());
        f1.put("fm_uid", MainApp.indexKishMWRAChild.getUid());
        f1.put("fm_serial", MainApp.indexKishMWRAChild.getSerialno());
        f1.put("mm_fm_uid", MainApp.indexKishMWRA.getUid());
        f1.put("mm_fm_serial", MainApp.indexKishMWRA.getSerialno());


        f1.put("d101",
                bi.d101a.isChecked() ? "1" :
                        bi.d101b.isChecked() ? "2" :
                                bi.d101c.isChecked() ? "3" :
                                        "0");

        f1.put("d101sub",
                bi.d101suba.isChecked() ? "1" :
                        bi.d101subb.isChecked() ? "2" :
                                bi.d101subc.isChecked() ? "3" :
                                        bi.d101subd.isChecked() ? "4" :
                                                bi.d101sube.isChecked() ? "5" :
                                                        bi.d101subf.isChecked() ? "6" :
                                                                bi.d101subg.isChecked() ? "7" :
                                                                        bi.d101subh.isChecked() ? "8" :
                                                                                "0");

        f1.put("d102",
                bi.d102a.isChecked() ? "1" :
                        bi.d102b.isChecked() ? "2" :
                                bi.d102c.isChecked() ? "3" :
                                        "0");

        f1.put("d102sub",
                bi.d102suba.isChecked() ? "1" :
                        bi.d102subb.isChecked() ? "2" :
                                bi.d102subc.isChecked() ? "3" :
                                        bi.d102subd.isChecked() ? "4" :
                                                bi.d102sube.isChecked() ? "5" :
                                                        bi.d102subf.isChecked() ? "6" :
                                                                bi.d102subg.isChecked() ? "7" :
                                                                        bi.d102subh.isChecked() ? "8" :
                                                                                "0");

        f1.put("d103",
                bi.d103a.isChecked() ? "1" :
                        bi.d103b.isChecked() ? "2" :
                                "0");

        f1.put("d103sub",
                bi.d103suba.isChecked() ? "1" :
                        bi.d103subb.isChecked() ? "2" :
                                bi.d103subc.isChecked() ? "3" :
                                        bi.d103subd.isChecked() ? "4" :
                                                bi.d103sube.isChecked() ? "5" :
                                                        bi.d103subf.isChecked() ? "6" :
                                                                bi.d103subg.isChecked() ? "7" :
                                                                        "0");

        f1.put("d104",
                bi.d104a.isChecked() ? "1" :
                        bi.d104b.isChecked() ? "2" :
                                "0");

        f1.put("d104sub",
                bi.d104suba.isChecked() ? "1" :
                        bi.d104subb.isChecked() ? "2" :
                                bi.d104subc.isChecked() ? "3" :
                                        bi.d104subd.isChecked() ? "4" :
                                                bi.d104sube.isChecked() ? "5" :
                                                        bi.d104subf.isChecked() ? "6" :
                                                                bi.d104subg.isChecked() ? "7" :
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

        f1.put("d106sub",
                bi.d106suba.isChecked() ? "1" :
                        bi.d106subb.isChecked() ? "2" :
                                bi.d106subc.isChecked() ? "3" :
                                        bi.d106subd.isChecked() ? "4" :
                                                bi.d106sube.isChecked() ? "5" :
                                                        "0");
        MainApp.foodFreq.setsD1(String.valueOf(f1));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionD1);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }


}
