package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionEBinding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;

public class SectionEActivity extends AppCompatActivity {

    ActivitySectionEBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e);
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
                startActivity(new Intent(SectionEActivity.this, SectionE2Activity.class));
            }

        }
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() throws JSONException {

        JSONObject e1 = new JSONObject();

        e1.put("e101",
                bi.e101a.isChecked() ? "1" :
                        bi.e101b.isChecked() ? "2" :
                                "0");

        e1.put("e102", bi.e102.getText().toString());

        e1.put("e102a",
                bi.e102aa.isChecked() ? "1" :
                        bi.e102ab.isChecked() ? "2" :
                                "0");

    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionE);

    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }


}
