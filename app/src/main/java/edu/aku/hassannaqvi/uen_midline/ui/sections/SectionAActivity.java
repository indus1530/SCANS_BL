package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionABinding;
import edu.aku.hassannaqvi.uen_midline.ui.list_activity.FamilyMembersListActivity;
import edu.aku.hassannaqvi.uen_midline.utils.Util;

public class SectionAActivity extends AppCompatActivity {

    ActivitySectionABinding bi;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a);
        bi.setCallback(this);

        setUIComponent();
    }


    private void setUIComponent() {
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
                startActivity(new Intent(SectionAActivity.this, FamilyMembersListActivity.class));
            }
        }
    }


    private boolean UpdateDB() {
        return true;
    }


    private void SaveDraft() throws JSONException {

        MainApp.fc = new FormsContract();
        MainApp.fc.setFormDate(dtToday);
        MainApp.fc.setUser(MainApp.userName);
        MainApp.fc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID));
        MainApp.fc.setAppversion(MainApp.appInfo.getVersionName() + "." + MainApp.appInfo.getVersionCode());
        MainApp.fc.setClusterCode(bi.a101.getText().toString());
        MainApp.fc.setHhno(bi.a112.getText().toString());
        MainApp.setGPS(this); // Set GPS

        JSONObject json = new JSONObject();

        json.put("a104", bi.a104.getText().toString());
        json.put("a105", bi.a105.getText().toString());
        json.put("a106", bi.a106.getText().toString());
        json.put("a107", bi.a107.getText().toString());
        json.put("a109", bi.a109.getText().toString());
        json.put("a110", bi.a110.getText().toString());
        json.put("a111", bi.a111.getText().toString());
        json.put("hhheadpresent", bi.checkHHHeadpresent.isChecked() ? "1" : "2");
        //json.put("hhheadpresentnew", bi.newHHheadname.getText().toString());

        MainApp.fc.setsInfo(String.valueOf(json));

    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionA);
    }

    public void BtnEnd() {
        Util.openEndActivity(this);
    }

    public void BtnCheckHH() {

    }
}
