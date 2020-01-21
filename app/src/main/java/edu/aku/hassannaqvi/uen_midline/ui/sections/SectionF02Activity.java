package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionF02Binding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;

public class SectionF02Activity extends AppCompatActivity {


    ActivitySectionF02Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f02);
        bi.setCallback(this);

        setUIComponent();
    }

    private void setUIComponent() {


        bi.f121.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.f121a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrp2223, null);
            }

        }));

        bi.f124.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.f124a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrp2531, null);
            }
        }));

        bi.f129.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.f129a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVf130, null);
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

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionf02);

    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }



}
