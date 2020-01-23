package edu.aku.hassannaqvi.uen_midline.ui.sections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionABinding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;

public class SectionAActivity extends AppCompatActivity {

    ActivitySectionABinding bi;
    List<String> tehsils;
    List<String> ucs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a);
        bi.setCallback(this);

        setUIComponent();
    }

    private void setUIComponent() {

        tehsils = new ArrayList<>();
        ucs = new ArrayList<>();

        tehsils.add("----");
        tehsils.add("Test tehsil 1");
        tehsils.add("Test tehsil 2");

        ucs.add("----");
        ucs.add("Test uc 1");
        ucs.add("Test uc 2");

        bi.a106.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tehsils));
        bi.a107.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ucs));


    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                startActivity(new Intent(SectionAActivity.this, SectionDActivity.class));
            }

        }
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() throws JSONException {
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionA);

    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }
}
