package edu.aku.hassannaqvi.uen_midline.ui.sections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionNBinding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;

public class SectionNActivity extends AppCompatActivity {

    ActivitySectionNBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_n);
        bi.setCallback(this);


        setUIComponent();
    }

    private void setUIComponent() {

        bi.n103.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.n103c.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVn104, null);
            }

        }));

        bi.n108.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.n108a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVn109, null);
            }
        }));

        bi.n111.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.n111a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrp1213, null);
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
                startActivity(new Intent(this, SectionOActivity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() throws JSONException {
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionN);

    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }
}
