package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionD4Binding;

public class SectionD4Activity extends AppCompatActivity {

    ActivitySectionD4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_d4);


    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("d401",
                bi.d401a.isChecked() ? "1" :
                        bi.d401b.isChecked() ? "2" :
                                bi.d401c.isChecked() ? "3" :
                                        bi.d401d.isChecked() ? "4" :
                                                bi.d401e.isChecked() ? "5" :
                                                        "0");
        json.put("d402",
                bi.d402a.isChecked() ? "1" :
                        bi.d402b.isChecked() ? "2" :
                                bi.d402c.isChecked() ? "3" :
                                        bi.d402d.isChecked() ? "4" :
                                                bi.d402e.isChecked() ? "5" :
                                                        "0");
        json.put("d403",
                bi.d403a.isChecked() ? "1" :
                        bi.d403b.isChecked() ? "2" :
                                bi.d403c.isChecked() ? "3" :
                                        bi.d403d.isChecked() ? "4" :
                                                bi.d403e.isChecked() ? "5" :
                                                        "0");
        json.put("d404",
                bi.d404a.isChecked() ? "1" :
                        bi.d404b.isChecked() ? "2" :
                                bi.d404c.isChecked() ? "3" :
                                        bi.d404d.isChecked() ? "4" :
                                                bi.d404e.isChecked() ? "5" :
                                                        "0");
        json.put("d405",
                bi.d405a.isChecked() ? "1" :
                        bi.d405b.isChecked() ? "2" :
                                bi.d405c.isChecked() ? "3" :
                                        bi.d405d.isChecked() ? "4" :
                                                bi.d405e.isChecked() ? "5" :
                                                        "0");


        MainApp.fc.setsInfo(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


}
