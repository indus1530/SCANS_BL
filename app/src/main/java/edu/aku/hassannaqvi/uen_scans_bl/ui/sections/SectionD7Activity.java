package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionD7Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionD7Activity extends AppCompatActivity {

    ActivitySectionD7Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d7);
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
                startActivity(new Intent(this, SectionD8Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
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

        json.put("d701",
                bi.d701a.isChecked() ? "1" :
                        bi.d701b.isChecked() ? "2" :
                                bi.d701c.isChecked() ? "3" :
                                        bi.d701d.isChecked() ? "4" :
                                                bi.d701e.isChecked() ? "5" :
                                                        "0");
        json.put("d702",
                bi.d702a.isChecked() ? "1" :
                        bi.d702b.isChecked() ? "2" :
                                bi.d702c.isChecked() ? "3" :
                                        bi.d702d.isChecked() ? "4" :
                                                bi.d702e.isChecked() ? "5" :
                                                        "0");
        json.put("d703",
                bi.d703a.isChecked() ? "1" :
                        bi.d703b.isChecked() ? "2" :
                                bi.d703c.isChecked() ? "3" :
                                        bi.d703d.isChecked() ? "4" :
                                                bi.d703e.isChecked() ? "5" :
                                                        "0");
        json.put("d704",
                bi.d704a.isChecked() ? "1" :
                        bi.d704b.isChecked() ? "2" :
                                bi.d704c.isChecked() ? "3" :
                                        bi.d704d.isChecked() ? "4" :
                                                bi.d704e.isChecked() ? "5" :
                                                        "0");
        json.put("d705",
                bi.d705a.isChecked() ? "1" :
                        bi.d705b.isChecked() ? "2" :
                                bi.d705c.isChecked() ? "3" :
                                        bi.d705d.isChecked() ? "4" :
                                                bi.d705e.isChecked() ? "5" :
                                                        "0");
        json.put("d706",
                bi.d706a.isChecked() ? "1" :
                        bi.d706b.isChecked() ? "2" :
                                bi.d706c.isChecked() ? "3" :
                                        bi.d706d.isChecked() ? "4" :
                                                bi.d706e.isChecked() ? "5" :
                                                        bi.d706f.isChecked() ? "6" :
                                                                "0");
        json.put("d707",
                bi.d707a.isChecked() ? "1" :
                        bi.d707b.isChecked() ? "2" :
                                bi.d707c.isChecked() ? "3" :
                                        bi.d707d.isChecked() ? "4" :
                                                bi.d707e.isChecked() ? "5" :
                                                        "0");
        json.put("d708",
                bi.d708a.isChecked() ? "1" :
                        bi.d708b.isChecked() ? "2" :
                                bi.d708c.isChecked() ? "3" :
                                        bi.d708d.isChecked() ? "4" :
                                                bi.d708e.isChecked() ? "5" :
                                                        "0");
        json.put("d709",
                bi.d709a.isChecked() ? "1" :
                        bi.d709b.isChecked() ? "2" :
                                bi.d709c.isChecked() ? "3" :
                                        bi.d709d.isChecked() ? "4" :
                                                bi.d709e.isChecked() ? "5" :
                                                        "0");
        json.put("d710",
                bi.d710a.isChecked() ? "1" :
                        bi.d710b.isChecked() ? "2" :
                                bi.d710c.isChecked() ? "3" :
                                        bi.d710d.isChecked() ? "4" :
                                                bi.d710e.isChecked() ? "5" :
                                                        "0");
        json.put("d711",
                bi.d711a.isChecked() ? "1" :
                        bi.d711b.isChecked() ? "2" :
                                bi.d711c.isChecked() ? "3" :
                                        bi.d711d.isChecked() ? "4" :
                                                bi.d711e.isChecked() ? "5" :
                                                        "0");


        MainApp.fc.setsInfo(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionD7);

    }

    /*@Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }*/


}
