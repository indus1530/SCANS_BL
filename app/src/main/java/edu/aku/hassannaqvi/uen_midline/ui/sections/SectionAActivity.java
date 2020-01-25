package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionABinding;
import edu.aku.hassannaqvi.uen_midline.ui.list_activity.FamilyMembersListActivity;
import edu.aku.hassannaqvi.uen_midline.utils.Util;

public class SectionAActivity extends AppCompatActivity {

    ActivitySectionABinding bi;

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

        JSONObject json = new JSONObject();

        json.put("a101", bi.a101.getText().toString());

        /*json.put("a102",
                bi.a102a.isChecked() ?"1" :
                        bi.a102b.isChecked() ?"2" :
                                "0");

        json.put("a103", bi.a103.getText().toString());

        json.put("a104",
                bi.a104a.isChecked() ?"1" :
                        bi.a104b.isChecked() ?"2" :
                                bi.a104c.isChecked() ?"3" :
                                        "0");

        json.put("a105",
                bi.a105a.isChecked() ?"1" :
                        bi.a105b.isChecked() ?"2" :
                                bi.a105c.isChecked() ?"3" :
                                        bi.a105d.isChecked() ?"4" :
                                                bi.a105e.isChecked() ?"5" :
                                                        bi.a105f.isChecked() ?"6" :
                                                                bi.a105g.isChecked() ?"7" :
                                                                        bi.a105h.isChecked() ?"8" :
                                                                                "0");

        json.put("a106", bi.a106.getText().toString());

        json.put("a107", bi.a107.getText().toString());

        json.put("a108",
                bi.a108a.isChecked() ?"1" :
                        bi.a108b.isChecked() ?"2" :
                                "0");*/

        json.put("a109", bi.a109.getText().toString());
        json.put("a110", bi.a110.getText().toString());
        json.put("a111", bi.a111.getText().toString());
        json.put("a112", bi.a112.getText().toString());

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
