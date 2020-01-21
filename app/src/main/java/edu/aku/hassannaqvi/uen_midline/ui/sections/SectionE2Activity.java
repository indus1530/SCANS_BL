package edu.aku.hassannaqvi.uen_midline.ui.sections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionE2Binding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;

public class SectionE2Activity extends AppCompatActivity {

    ActivitySectionE2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e2);
        bi.setCallback(this);

        setUIComponent();
    }

    private void setUIComponent() {

        bi.e105.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.e105a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrp0612, null);
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
                startActivity(new Intent(SectionE2Activity.this, SectionFActivity.class));
            }

        }
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() throws JSONException {
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionE2);

    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }
}
