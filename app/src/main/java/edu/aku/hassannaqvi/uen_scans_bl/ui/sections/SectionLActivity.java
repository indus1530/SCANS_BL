package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionLBinding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;
import edu.aku.hassannaqvi.uen_scans_bl.validator.ClearClass;

public class SectionLActivity extends AppCompatActivity {

    ActivitySectionLBinding bi;


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
                ClearClass.ClearAllFields(bi.fldGrpCVl104, null);
                ClearClass.ClearAllFields(bi.fldGrpCVl103, null);
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
                    ClearClass.ClearAllFields(bi.fldGrpCVl103, null);
                    bi.l103a.setEnabled(true);
                    bi.l103b.setEnabled(false);
                    bi.l103c.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (bi.l104.getText().toString().trim().length() <= 0) {
                    ClearClass.ClearAllFields(bi.fldGrpCVl103, null);
                    bi.l103a.setEnabled(false);
                    bi.l103b.setEnabled(true);
                    bi.l103c.setEnabled(true);

                }
            }
        });

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
                startActivity(new Intent(this, SectionMActivity.class));
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

        MainApp.fc = new FormsContract();
        MainApp.fc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        MainApp.fc.setUser(MainApp.userName);
        MainApp.fc.setDeviceID(MainApp.appInfo.getDeviceID());
        MainApp.fc.setDevicetagID(MainApp.appInfo.getTagName());
        MainApp.fc.setAppversion(MainApp.appInfo.getAppVersion());
//        MainApp.fc.setHhno(bi.a112.getText().toString());
        MainApp.setGPS(this); // Set GPS

        JSONObject json = new JSONObject();

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

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionL);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }


}
