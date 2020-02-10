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
import edu.aku.hassannaqvi.uen_scans_bl.ui.other.EndingActivity;
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
                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
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
                                bi.d9061c.isChecked() ? "3" :
                                "0");

        json.put("d9071",
                bi.d9071a.isChecked() ? "1" :
                        bi.d9071b.isChecked() ? "2" :
                                bi.d9071c.isChecked() ? "3" :
                                        "0");


        json.put("d9022", bi.d9022.getText().toString());

        json.put("d9032", bi.d9032.getText().toString());

        json.put("d9042", bi.d9042.getText().toString());

        json.put("d9052a", bi.d9052a.getText().toString());
        json.put("d9052b", bi.d9052b.getText().toString());

        json.put("d9062",
                bi.d9062a.isChecked() ? "1" :
                        bi.d9062b.isChecked() ? "2" :
                                bi.d9062c.isChecked() ? "3" :
                                        "0");

        json.put("d9072",
                bi.d9072a.isChecked() ? "1" :
                        bi.d9072b.isChecked() ? "2" :
                                bi.d9072c.isChecked() ? "3" :
                                        "0");


        json.put("d9023", bi.d9023.getText().toString());

        json.put("d9033", bi.d9033.getText().toString());

        json.put("d9043", bi.d9043.getText().toString());

        json.put("d9053a", bi.d9053a.getText().toString());
        json.put("d9053b", bi.d9053b.getText().toString());

        json.put("d9063",
                bi.d9063a.isChecked() ? "1" :
                        bi.d9063b.isChecked() ? "2" :
                                bi.d9063c.isChecked() ? "3" :
                                        "0");

        json.put("d9073",
                bi.d9073a.isChecked() ? "1" :
                        bi.d9073b.isChecked() ? "2" :
                                bi.d9073c.isChecked() ? "3" :
                                        "0");


        json.put("d9024", bi.d9024.getText().toString());

        json.put("d9034", bi.d9034.getText().toString());

        json.put("d9044", bi.d9044.getText().toString());

        json.put("d9054a", bi.d9054a.getText().toString());
        json.put("d9054b", bi.d9054b.getText().toString());

        json.put("d9064",
                bi.d9064a.isChecked() ? "1" :
                        bi.d9064b.isChecked() ? "2" :
                                bi.d9064c.isChecked() ? "3" :
                                        "0");

        json.put("d9074",
                bi.d9074a.isChecked() ? "1" :
                        bi.d9074b.isChecked() ? "2" :
                                bi.d9074c.isChecked() ? "3" :
                                        "0");


        json.put("d9025", bi.d9025.getText().toString());

        json.put("d9035", bi.d9035.getText().toString());

        json.put("d9045", bi.d9045.getText().toString());

        json.put("d9055a", bi.d9055a.getText().toString());
        json.put("d9055b", bi.d9055b.getText().toString());

        json.put("d9065",
                bi.d9065a.isChecked() ? "1" :
                        bi.d9065b.isChecked() ? "2" :
                                bi.d9065c.isChecked() ? "3" :
                                        "0");

        json.put("d9075",
                bi.d9075a.isChecked() ? "1" :
                        bi.d9075b.isChecked() ? "2" :
                                bi.d9075c.isChecked() ? "3" :
                                        "0");


        json.put("d9026", bi.d9026.getText().toString());

        json.put("d9036", bi.d9036.getText().toString());

        json.put("d9046", bi.d9046.getText().toString());

        json.put("d9056a", bi.d9056a.getText().toString());
        json.put("d9056b", bi.d9056b.getText().toString());

        json.put("d9066",
                bi.d9066a.isChecked() ? "1" :
                        bi.d9066b.isChecked() ? "2" :
                                bi.d9066c.isChecked() ? "3" :
                                        "0");

        json.put("d9076",
                bi.d9076a.isChecked() ? "1" :
                        bi.d9076b.isChecked() ? "2" :
                                bi.d9076c.isChecked() ? "3" :
                                        "0");


        json.put("d9027", bi.d9027.getText().toString());

        json.put("d9037", bi.d9037.getText().toString());

        json.put("d9047", bi.d9047.getText().toString());

        json.put("d9057a", bi.d9057a.getText().toString());
        json.put("d9057b", bi.d9057b.getText().toString());

        json.put("d9067",
                bi.d9067a.isChecked() ? "1" :
                        bi.d9067b.isChecked() ? "2" :
                                bi.d9067c.isChecked() ? "3" :
                                        "0");

        json.put("d9077",
                bi.d9077a.isChecked() ? "1" :
                        bi.d9077b.isChecked() ? "2" :
                                bi.d9077c.isChecked() ? "3" :
                                        "0");

        MainApp.fc.setsInfo(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionD9);

    }

    /*@Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }*/


}
