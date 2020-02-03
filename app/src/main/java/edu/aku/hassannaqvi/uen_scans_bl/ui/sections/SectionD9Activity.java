package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionD9Binding;

public class SectionD9Activity extends AppCompatActivity {

    ActivitySectionD9Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_d9);


    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("d902a", bi.d902a.getText().toString());
        json.put("d902b", bi.d902b.getText().toString());
        json.put("d902c", bi.d902c.getText().toString());
        json.put("d902d", bi.d902d.getText().toString());
        json.put("d902e", bi.d902e.getText().toString());
        json.put("d902f", bi.d902f.getText().toString());
        json.put("d902g", bi.d902g.getText().toString());
        json.put("d903a", bi.d903a.getText().toString());
        json.put("d903b", bi.d903b.getText().toString());
        json.put("d903c", bi.d903c.getText().toString());
        json.put("d903d", bi.d903d.getText().toString());
        json.put("d903e", bi.d903e.getText().toString());
        json.put("d903f", bi.d903f.getText().toString());
        json.put("d903g", bi.d903g.getText().toString());
        json.put("d904a", bi.d904a.getText().toString());
        json.put("d904b", bi.d904b.getText().toString());
        json.put("d904c", bi.d904c.getText().toString());
        json.put("d904d", bi.d904d.getText().toString());
        json.put("d904e", bi.d904e.getText().toString());
        json.put("d904f", bi.d904f.getText().toString());
        json.put("d904g", bi.d904g.getText().toString());
        json.put("d905a",
                bi.d905aa.isChecked() ? "0" :
                        bi.d905ab.isChecked() ? "0" :
                                "0");
        json.put("d905aat", bi.d905aat.getText().toString());
        json.put("d905abt", bi.d905abt.getText().toString());
        json.put("d905b",
                bi.d905ba.isChecked() ? "1" :
                        bi.d905bb.isChecked() ? "2" :
                                "0");
        json.put("d905bat", bi.d905bat.getText().toString());
        json.put("d905bbt", bi.d905bbt.getText().toString());
        json.put("d905c",
                bi.d905ca.isChecked() ? "1" :
                        bi.d905cb.isChecked() ? "2" :
                                "0");
        json.put("d905cat", bi.d905cat.getText().toString());
        json.put("d905cbt", bi.d905cbt.getText().toString());
        json.put("d905d",
                bi.d905da.isChecked() ? "1" :
                        bi.d905db.isChecked() ? "2" :
                                "0");
        json.put("d905dat", bi.d905dat.getText().toString());
        json.put("d905dbt", bi.d905dbt.getText().toString());
        json.put("d905e",
                bi.d905ea.isChecked() ? "1" :
                        bi.d905eb.isChecked() ? "2" :
                                "0");
        json.put("d905eat", bi.d905eat.getText().toString());
        json.put("d905ebt", bi.d905ebt.getText().toString());
        json.put("d905f",
                bi.d905fa.isChecked() ? "1" :
                        bi.d905fb.isChecked() ? "2" :
                                "0");
        json.put("d905g",
                bi.d905ga.isChecked() ? "1" :
                        bi.d905gb.isChecked() ? "2" :
                                "0");
        json.put("d906a",
                bi.d906aa.isChecked() ? "1" :
                        bi.d906ab.isChecked() ? "2" :
                                bi.d906ac.isChecked() ? "3" :
                                        "0");
        json.put("d906b",
                bi.d906ba.isChecked() ? "1" :
                        bi.d906bb.isChecked() ? "2" :
                                bi.d906bc.isChecked() ? "3" :
                                        "0");
        json.put("d906c",
                bi.d906ca.isChecked() ? "1" :
                        bi.d906cb.isChecked() ? "2" :
                                bi.d906cc.isChecked() ? "3" :
                                        "0");
        json.put("d906d",
                bi.d906da.isChecked() ? "1" :
                        bi.d906db.isChecked() ? "2" :
                                bi.d906dc.isChecked() ? "3" :
                                        "0");
        json.put("d906e",
                bi.d906ea.isChecked() ? "1" :
                        bi.d906eb.isChecked() ? "2" :
                                bi.d906ec.isChecked() ? "3" :
                                        "0");
        json.put("d906f",
                bi.d906fa.isChecked() ? "1" :
                        bi.d906fb.isChecked() ? "2" :
                                bi.d906fc.isChecked() ? "3" :
                                        "0");
        json.put("d906g",
                bi.d906ga.isChecked() ? "1" :
                        bi.d906gb.isChecked() ? "2" :
                                bi.d906gc.isChecked() ? "3" :
                                        "0");
        json.put("d907",
                "0");
        json.put("d907a",
                bi.d907aa.isChecked() ? "1" :
                        bi.d907ab.isChecked() ? "2" :
                                bi.d907ac.isChecked() ? "3" :
                                        "0");
        json.put("d907b",
                bi.d907ba.isChecked() ? "1" :
                        bi.d907bb.isChecked() ? "2" :
                                bi.d907bc.isChecked() ? "3" :
                                        "0");
        json.put("d907c",
                bi.d907ca.isChecked() ? "1" :
                        bi.d907cb.isChecked() ? "2" :
                                bi.d907cc.isChecked() ? "3" :
                                        "0");
        json.put("d907d",
                bi.d907da.isChecked() ? "1" :
                        bi.d907db.isChecked() ? "2" :
                                bi.d907dc.isChecked() ? "3" :
                                        "0");
        json.put("d907e",
                bi.d907ea.isChecked() ? "1" :
                        bi.d907eb.isChecked() ? "2" :
                                bi.d907ec.isChecked() ? "3" :
                                        "0");
        json.put("d907f",
                bi.d907fa.isChecked() ? "1" :
                        bi.d907fb.isChecked() ? "2" :
                                bi.d907fc.isChecked() ? "3" :
                                        "0");
        json.put("d907g",
                bi.d907ga.isChecked() ? "1" :
                        bi.d907gb.isChecked() ? "2" :
                                bi.d907gc.isChecked() ? "3" :
                                        "0");

        MainApp.fc.setsInfo(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


}
