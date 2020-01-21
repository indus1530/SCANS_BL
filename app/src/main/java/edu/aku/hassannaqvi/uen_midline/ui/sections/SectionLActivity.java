package edu.aku.hassannaqvi.uen_midline.ui.sections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionLBinding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;

public class SectionLActivity extends AppCompatActivity {

    ActivitySectionLBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_l);
        bi.setCallback(this);


        setUIComponent();
    }

    private void setUIComponent() {

        bi.l102.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.l102a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVl103, null);
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
                startActivity(new Intent(this, SectionMActivity.class));
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

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionL);

    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }
}
