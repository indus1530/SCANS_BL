package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.contracts.KishMWRAContract;
import edu.aku.hassannaqvi.uen_midline.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionF02Binding;
import edu.aku.hassannaqvi.uen_midline.utils.JSONUtils;
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
                finish();
                startActivity(new Intent(SectionF02Activity.this, SectionGActivity.class));
            }

        }
    }

    private boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesKishMWRAColumn(KishMWRAContract.SingleKishMWRA.COLUMN_SF, MainApp.kish.getsF());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject f1 = new JSONObject();

        f1.put("f121", bi.f121a.isChecked() ? "1" :
                bi.f121b.isChecked() ? "2" : "0");

        f1.put("f122", bi.f122.getText().toString());

        f1.put("f123a", bi.f123a.isChecked() ? "1" : "0");
        f1.put("f123b", bi.f123b.isChecked() ? "2" : "0");
        f1.put("f123c", bi.f123c.isChecked() ? "3" : "0");
        f1.put("f123d", bi.f123d.isChecked() ? "4" : "0");
        f1.put("f123e", bi.f123e.isChecked() ? "5" : "0");
        f1.put("f123f", bi.f123f.isChecked() ? "6" : "0");
        f1.put("f123g", bi.f123g.isChecked() ? "7" : "0");

        f1.put("f124", bi.f124a.isChecked() ? "1" :
                bi.f124b.isChecked() ? "2" : "0");

        f1.put("f125a", bi.f125a.isChecked() ? "1" : "0");
        f1.put("f125b", bi.f125b.isChecked() ? "2" : "0");
        f1.put("f125c", bi.f125c.isChecked() ? "3" : "0");
        f1.put("f125d", bi.f125d.isChecked() ? "4" : "0");
        f1.put("f125e", bi.f125e.isChecked() ? "5" : "0");
        f1.put("f125f", bi.f125f.isChecked() ? "6" : "0");

        f1.put("f126a", bi.f126a.isChecked() ? "1" : "0");
        f1.put("f126b", bi.f126b.isChecked() ? "2" : "0");
        f1.put("f126c", bi.f126c.isChecked() ? "3" : "0");
        f1.put("f126d", bi.f126d.isChecked() ? "4" : "0");
        f1.put("f126e", bi.f126e.isChecked() ? "5" : "0");
        f1.put("f126f", bi.f126f.isChecked() ? "6" : "0");
        f1.put("f126g", bi.f126g.isChecked() ? "7" : "0");

        f1.put("f127", bi.f127a.isChecked() ? "1" :
                bi.f127b.isChecked() ? "2" :
                        bi.f127c.isChecked() ? "3" : "0");

        f1.put("f128a", bi.f128a.isChecked() ? "1" : "0");
        f1.put("f128b", bi.f128b.isChecked() ? "2" : "0");
        f1.put("f128c", bi.f128c.isChecked() ? "3" : "0");
        f1.put("f128d", bi.f128d.isChecked() ? "4" : "0");
        f1.put("f128e", bi.f128e.isChecked() ? "5" : "0");
        f1.put("f128f", bi.f128f.isChecked() ? "6" : "0");
        f1.put("f128g", bi.f128g.isChecked() ? "7" : "0");

        f1.put("f129", bi.f129a.isChecked() ? "1" :
                bi.f129b.isChecked() ? "2" : "0");

        f1.put("f130a", bi.f130a.isChecked() ? "1" : "0");
        f1.put("f130b", bi.f130b.isChecked() ? "2" : "0");
        f1.put("f130c", bi.f130c.isChecked() ? "3" : "0");
        f1.put("f130d", bi.f130d.isChecked() ? "4" : "0");
        f1.put("f130e", bi.f130e.isChecked() ? "5" : "0");
        f1.put("f130f", bi.f130f.isChecked() ? "6" : "0");
        f1.put("f130g", bi.f130g.isChecked() ? "7" : "0");
        f1.put("f130h", bi.f130h.isChecked() ? "8" : "0");
        f1.put("f130i", bi.f130i.isChecked() ? "9" : "0");

        f1.put("f131", bi.f131a.isChecked() ? "1" :
                bi.f131b.isChecked() ? "2" :
                        bi.f131c.isChecked() ? "3" : "0");

        f1.put("f132", bi.f132a.isChecked() ? "1" :
                bi.f132b.isChecked() ? "2" :
                        bi.f132c.isChecked() ? "3" : "0");

        f1.put("f133", bi.f133a.isChecked() ? "1" :
                bi.f133b.isChecked() ? "2" :
                        bi.f133c.isChecked() ? "3" : "0");

        f1.put("f134a", bi.f134a.isChecked() ? "1" : "0");
        f1.put("f134b", bi.f134b.isChecked() ? "2" : "0");
        f1.put("f134c", bi.f134c.isChecked() ? "3" : "0");
        f1.put("f134d", bi.f134d.isChecked() ? "4" : "0");
        f1.put("f134e", bi.f134e.isChecked() ? "5" : "0");
        f1.put("f134f", bi.f134f.isChecked() ? "6" : "0");
        f1.put("f134g", bi.f134g.isChecked() ? "7" : "0");

        try {
            JSONObject s4_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.kish.getsF()), f1);

            MainApp.kish.setsF(String.valueOf(s4_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionf02);

    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }


}
