package edu.aku.hassannaqvi.uen_midline.ui.sections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionMBinding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;

public class SectionMActivity extends AppCompatActivity {


    ActivitySectionMBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_m);
        bi.setCallback(this);

        setUIComponents();
    }

    private void setUIComponents() {

        bi.m109.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.m109a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVm110, null);
            }
        }));

        bi.m111.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.m111b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVm112, null);
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
//                if (MainApp.childCount > 0) {
//                    finish();
//                    startActivity(new Intent(this, SectionDAActivity.class));
//                } else {
//                    finish();
//                    startActivity(new Intent(this, ChildListActivity.class));
//                }
            }

        }
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() throws JSONException {
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionM);

    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }

}
