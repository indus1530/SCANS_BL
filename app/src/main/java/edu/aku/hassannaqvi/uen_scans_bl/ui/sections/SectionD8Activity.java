package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionD8Binding;

public class SectionD8Activity extends AppCompatActivity {

    ActivitySectionD8Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_d8);


    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("d801",
                bi.d801a.isChecked() ? "1" :
                        bi.d801b.isChecked() ? "2" :
                                bi.d801c.isChecked() ? "3" :
                                        bi.d801d.isChecked() ? "4" :
                                                bi.d801e.isChecked() ? "5" :
                                                        "0");


        MainApp.fc.setsInfo(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


}
