package edu.aku.hassannaqvi.uen_midline.ui.sections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionDBinding;
import edu.aku.hassannaqvi.uen_midline.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_midline.utils.Util;

public class SectionDActivity extends AppCompatActivity {

    ActivitySectionDBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d);
        bi.setCallback(this);

        setUIComponent();
    }

    private void setUIComponent() {

        MainApp.pragnantWoman.add("Test Woman 1");
        MainApp.pragnantWoman.add("Test Woman 2");
    }

    public void BtnContinue() {
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, SectionE1Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
//        if (formValidation()) {
//            try {
//                SaveDraft();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//        }
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() throws JSONException {
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionD);

    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }

}
