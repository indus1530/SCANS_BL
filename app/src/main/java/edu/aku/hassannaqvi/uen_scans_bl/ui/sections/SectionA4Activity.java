package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionA4Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionA4Activity extends AppCompatActivity {

    ActivitySectionA4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a4);
        bi.setCallback(this);


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
                //startActivity(new Intent(SectionA31Activity.this, FamilyMembersListActivity.class).putExtra("sno", Integer.valueOf(bl.getSno())));
            }
        }
    }


    public void BtnEnd() {
        Util.openEndActivity(this);
    }


    private boolean UpdateDB() {
        /*long updcount = db.addForm(MainApp.fc);
        MainApp.fc.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            MainApp.fc.set_UID(MainApp.fc.getDeviceID() + MainApp.fc.get_ID());
            db.updatesFormColumn(FormsContract.FormsTable.COLUMN_UID, MainApp.fc.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        return true;

    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("a401",
                bi.a401a.isChecked() ? "1" :
                        bi.a401b.isChecked() ? "2" :
                                bi.a401c.isChecked() ? "3" :
                                        bi.a401d.isChecked() ? "4" :
                                                bi.a401x.isChecked() ? "96" :
                                                        "0");
        json.put("a401xt", bi.a401xt.getText().toString());
        json.put("a402",
                bi.a402a.isChecked() ? "1" :
                        bi.a402b.isChecked() ? "2" :
                                "0");
        json.put("a403a", bi.a403a.isChecked() ? "1" : "0");
        json.put("a403b", bi.a403b.isChecked() ? "2" : "0");
        json.put("a403c", bi.a403c.isChecked() ? "3" : "0");
        json.put("a403d", bi.a403d.isChecked() ? "4" : "0");
        json.put("a403e", bi.a403e.isChecked() ? "97" : "0");
        json.put("a404",
                bi.a404a.isChecked() ? "1" :
                        bi.a404b.isChecked() ? "2" :
                                "0");
        json.put("a405a", bi.a405a.isChecked() ? "1" : "0");
        json.put("a405b", bi.a405b.isChecked() ? "2" : "0");
        json.put("a405c", bi.a405c.isChecked() ? "3" : "0");
        json.put("a405d", bi.a405d.isChecked() ? "4" : "0");
        json.put("a405e", bi.a405e.isChecked() ? "97" : "0");
        json.put("a406a", bi.a406a.isChecked() ? "1" : "0");
        json.put("a406b", bi.a406b.isChecked() ? "2" : "0");
        json.put("a406c", bi.a406c.isChecked() ? "3" : "0");
        json.put("a406d", bi.a406d.isChecked() ? "4" : "0");
        json.put("a406e", bi.a406e.isChecked() ? "5" : "0");
        json.put("a406f", bi.a406f.isChecked() ? "6" : "0");
        json.put("a406g", bi.a406g.isChecked() ? "7" : "0");
        json.put("a406h", bi.a406h.isChecked() ? "8" : "0");
        json.put("a406i", bi.a406i.isChecked() ? "97" : "0");


        MainApp.fc.setsInfo(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }
}
