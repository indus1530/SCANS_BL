package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionD6Binding;

public class SectionD6Activity extends AppCompatActivity {

    ActivitySectionD6Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_d6);


    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("d601",
                bi.d601a.isChecked() ? "1" :
                        bi.d601b.isChecked() ? "2" :
                                bi.d601c.isChecked() ? "3" :
                                        bi.d601d.isChecked() ? "4" :
                                                bi.d601e.isChecked() ? "5" :
                                                        bi.d601f.isChecked() ? "6" :
                                                                "0");
        json.put("d602",
                bi.d602a.isChecked() ? "1" :
                        bi.d602b.isChecked() ? "2" :
                                bi.d602c.isChecked() ? "3" :
                                        bi.d602d.isChecked() ? "4" :
                                                bi.d602e.isChecked() ? "5" :
                                                        bi.d602f.isChecked() ? "6" :
                                                                "0");
        json.put("d603",
                bi.d603a.isChecked() ? "1" :
                        bi.d603b.isChecked() ? "2" :
                                bi.d603c.isChecked() ? "3" :
                                        bi.d603d.isChecked() ? "4" :
                                                bi.d603e.isChecked() ? "5" :
                                                        bi.d603f.isChecked() ? "6" :
                                                                "0");
        json.put("d604",
                bi.d604a.isChecked() ? "1" :
                        bi.d604b.isChecked() ? "2" :
                                bi.d604c.isChecked() ? "3" :
                                        bi.d604d.isChecked() ? "4" :
                                                bi.d604e.isChecked() ? "5" :
                                                        bi.d604f.isChecked() ? "6" :
                                                                "0");
        json.put("d605",
                bi.d605a.isChecked() ? "1" :
                        bi.d605b.isChecked() ? "2" :
                                bi.d605c.isChecked() ? "3" :
                                        bi.d605d.isChecked() ? "4" :
                                                bi.d605e.isChecked() ? "5" :
                                                        bi.d605f.isChecked() ? "6" :
                                                                "0");
        json.put("d606",
                bi.d606a.isChecked() ? "1" :
                        bi.d606b.isChecked() ? "2" :
                                bi.d606c.isChecked() ? "3" :
                                        bi.d606d.isChecked() ? "4" :
                                                bi.d606e.isChecked() ? "5" :
                                                        "0");
        json.put("d607",
                bi.d607a.isChecked() ? "1" :
                        bi.d607b.isChecked() ? "2" :
                                bi.d607c.isChecked() ? "3" :
                                        bi.d607d.isChecked() ? "4" :
                                                bi.d607e.isChecked() ? "5" :
                                                        "0");


        MainApp.fc.setsInfo(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


}
