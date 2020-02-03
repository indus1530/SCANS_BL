package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionD6Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionD6Activity extends AppCompatActivity {

    ActivitySectionD6Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d6);
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
                //startActivity(new Intent(SectionA3Activity.this, FamilyMembersListActivity.class).putExtra("sno", Integer.valueOf(bl.getSno())));
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
