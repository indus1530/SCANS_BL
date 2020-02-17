package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.VisionContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionMBinding;
import edu.aku.hassannaqvi.uen_scans_bl.ui.other.MainActivity;
import edu.aku.hassannaqvi.uen_scans_bl.validator.ClearClass;

public class SectionMActivity extends AppCompatActivity {

    ActivitySectionMBinding bi;
    VisionContract vc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_m);
        bi.setCallback(this);
        setupSkips();

        bi.txtHeadLbl.setText(new StringBuilder(MainApp.indexKishMWRAChild.getName().toUpperCase()).append("\n")
                .append(MainApp.indexKishMWRA.getName().toUpperCase()));

    }


    private void setupSkips() {

        bi.m101.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.m101a.getId()) {
                bi.fldGrpCVm102.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVm102, null);
                bi.fldGrpCVm102.setVisibility(View.GONE);
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
                startActivity(new Intent(this, MainActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long rowID = db.addVision(vc);
        if (rowID > 0) {
            vc.set_ID(String.valueOf(rowID));
            vc.setUID(vc.getDeviceId() + vc.get_ID());
            db.updatesVisionColumn(VisionContract.visionTable.COLUMN_UID, vc.getUID(), vc);
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        vc = new VisionContract();
        vc.set_UUID(MainApp.indexKishMWRA.getUuid());
        vc.setDeviceId(MainApp.appInfo.getDeviceID());
        vc.setDevicetagID(MainApp.appInfo.getTagName());
        vc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        vc.setUser(MainApp.userName);

        JSONObject json = new JSONObject();

        json.put("hhno", MainApp.indexKishMWRA.getHhno());
        json.put("cluster_no", MainApp.indexKishMWRA.getClusterno());
        json.put("_luid", MainApp.indexKishMWRA.getLuid());
        json.put("fm_uid", MainApp.indexKishMWRAChild.getUid());
        json.put("fm_serial", MainApp.indexKishMWRAChild.getSerialno());
        json.put("mm_fm_uid", MainApp.indexKishMWRA.getUid());
        json.put("mm_fm_serial", MainApp.indexKishMWRA.getSerialno());

        json.put("m101",
                bi.m101a.isChecked() ? "1" :
                        bi.m101b.isChecked() ? "2" :
                                "0");

        json.put("m102a", bi.m102a.getText().toString());
        json.put("m102b", bi.m102b.getText().toString());

        vc.setsE2(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionM);

    }


}
