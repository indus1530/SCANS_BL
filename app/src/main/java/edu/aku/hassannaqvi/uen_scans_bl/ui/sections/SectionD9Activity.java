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
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionD9Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionD9Activity extends AppCompatActivity {

    ActivitySectionD9Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d9);
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
                startActivity(new Intent(this, SectionK1Activity.class));
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

        json.put("d901", bi.d901.getSelectedItem().toString());

        json.put("d9021", bi.d9021.getText().toString());

        json.put("d9031", bi.d9031.getText().toString());

        json.put("d9041", bi.d9041.getText().toString());

        json.put("d9051a", bi.d9051a.getText().toString());
        json.put("d9051b", bi.d9051b.getText().toString());

        json.put("d9061",
                bi.d9061a.isChecked() ? "1" :
                        bi.d9061b.isChecked() ? "2" :
                                bi.d9061c.isChecked() ? "2" :
                                "0");

        json.put("d9071",
                bi.d9071a.isChecked() ? "1" :
                        bi.d9071b.isChecked() ? "2" :
                                bi.d9071c.isChecked() ? "3" :
                                        "0");

        MainApp.fc.setsInfo(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionD9);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }


}
