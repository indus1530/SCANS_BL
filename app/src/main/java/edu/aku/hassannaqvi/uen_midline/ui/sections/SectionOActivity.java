package edu.aku.hassannaqvi.uen_midline.ui.sections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionOBinding;
import edu.aku.hassannaqvi.uen_midline.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;

public class SectionOActivity extends AppCompatActivity {

    ActivitySectionOBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_o);
        bi.setCallback(this);

        setUIComponent();
    }

    private void setUIComponent() {

        bi.o101.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.o101b.getId() || i == bi.o101c.getId()) {
                ClearClass.ClearAllFields(bi.fldGrp102103, null);
            }
        }));

        bi.o103.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.o103a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVo104, null);
            }
        }));

        bi.o105.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.o105b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrp060708, null);
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
                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
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

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionO);

    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }
}
