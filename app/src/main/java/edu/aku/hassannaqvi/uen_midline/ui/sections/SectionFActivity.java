package edu.aku.hassannaqvi.uen_midline.ui.sections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionFBinding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;

public class SectionFActivity extends AppCompatActivity {

    ActivitySectionFBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f);
        bi.setCallback(this);

        setUIComponent();
    }

    void setUIComponent() {

        bi.f101.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.f101y.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVf101a, null);
            }
        }));

        bi.f112.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.f112a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVf113, null);
            }
        }));

        bi.f114.setOnCheckedChangeListener((radioGroup, i) -> {

            if (i != bi.f114a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrp1520, null);
            }
        });
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                startActivity(new Intent(SectionFActivity.this, SectionF02Activity.class));
            }

        }
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() throws JSONException {
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionF);

    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }

}
