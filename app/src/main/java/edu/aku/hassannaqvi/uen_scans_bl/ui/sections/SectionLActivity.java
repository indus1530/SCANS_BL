package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.HbContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionLBinding;
import edu.aku.hassannaqvi.uen_scans_bl.ui.other.MainActivity;

public class SectionLActivity extends AppCompatActivity {

    ActivitySectionLBinding bi;
    HbContract hb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_l);
        bi.setCallback(this);
        setupSkips();


    }


    private void setupSkips() {

        bi.l102.setOnCheckedChangeListener((group, checkedId) -> {
            if (bi.l102a.isChecked()) {
                bi.fldGrpCVl104.setVisibility(View.VISIBLE);
                bi.fldGrpCVl103.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVl104);
                Clear.clearAllFields(bi.fldGrpCVl103);
                bi.fldGrpCVl104.setVisibility(View.GONE);
                bi.fldGrpCVl103.setVisibility(View.GONE);
            }
        });


        bi.l104.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (bi.l104.getText().toString().trim().length() > 0) {
                    Clear.clearAllFields(bi.fldGrpCVl103);
                    bi.l103a.setEnabled(true);
                    bi.l103b.setEnabled(false);
                    bi.l103c.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (bi.l104.getText().toString().trim().length() <= 0) {
                    Clear.clearAllFields(bi.fldGrpCVl103);
                    bi.l103a.setEnabled(false);
                    bi.l103b.setEnabled(true);
                    bi.l103c.setEnabled(true);

                }
            }
        });

        bi.txtHeadLbl.setText(new StringBuilder(MainApp.indexKishMWRAChild.getName().toUpperCase()).append("\n")
                .append(MainApp.indexKishMWRA.getName().toUpperCase()));

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
        long rowID = db.addHB(hb);
        if (rowID > 0) {
            hb.set_ID(String.valueOf(rowID));
            hb.setUID(hb.getDeviceId() + hb.get_ID());
            db.updatesHBColumn(HbContract.hbTable.COLUMN_UID, hb.getUID(), hb);
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        hb = new HbContract();
        hb.set_UUID(MainApp.indexKishMWRA.getUuid());
        hb.setDeviceId(MainApp.appInfo.getDeviceID());
        hb.setDevicetagID(MainApp.appInfo.getTagName());
        hb.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        hb.setUser(MainApp.userName);

        JSONObject json = new JSONObject();

        json.put("hhno", MainApp.indexKishMWRA.getHhno());
        json.put("cluster_no", MainApp.indexKishMWRA.getClusterno());
        json.put("_luid", MainApp.indexKishMWRA.getLuid());
        json.put("fm_uid", MainApp.indexKishMWRAChild.getUid());
        json.put("fm_serial", MainApp.indexKishMWRAChild.getSerialno());
        json.put("mm_fm_uid", MainApp.indexKishMWRA.getUid());
        json.put("mm_fm_serial", MainApp.indexKishMWRA.getSerialno());

        json.put("l102",
                bi.l102a.isChecked() ? "1" :
                        bi.l102b.isChecked() ? "2" :
                                "0");

        json.put("l103",
                bi.l103a.isChecked() ? "1" :
                        bi.l103b.isChecked() ? "2" :
                                bi.l103c.isChecked() ? "3" :
                                        "0");

        json.put("l104", bi.l104.getText().toString());

        hb.setsE2(String.valueOf(json));
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionL);
    }

}
