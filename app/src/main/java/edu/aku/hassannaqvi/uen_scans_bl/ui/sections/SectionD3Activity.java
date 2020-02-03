package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionD3Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionD3Activity extends AppCompatActivity {

    ActivitySectionD3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d3);
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


        json.put("d301",
                bi.d301a.isChecked() ? "1" :
                        bi.d301b.isChecked() ? "2" :
                                bi.d301c.isChecked() ? "3" :
                                        "0");
        json.put("d301sub",
                bi.d301suba.isChecked() ? "1" :
                        bi.d301subb.isChecked() ? "2" :
                                bi.d301subc.isChecked() ? "3" :
                                        bi.d301subd.isChecked() ? "4" :
                                                bi.d301sube.isChecked() ? "5" :
                                                        "0");
        json.put("d302",
                bi.d302a.isChecked() ? "1" :
                        bi.d302b.isChecked() ? "2" :
                                bi.d302c.isChecked() ? "3" :
                                        "0");
        json.put("d302sub",
                bi.d302suba.isChecked() ? "1" :
                        bi.d302subb.isChecked() ? "2" :
                                bi.d302subc.isChecked() ? "3" :
                                        bi.d302subd.isChecked() ? "4" :
                                                bi.d302sube.isChecked() ? "5" :
                                                        "0");
        json.put("d303",
                bi.d303a.isChecked() ? "1" :
                        bi.d303b.isChecked() ? "2" :
                                bi.d303c.isChecked() ? "3" :
                                        "0");
        json.put("d303sub",
                bi.d303suba.isChecked() ? "1" :
                        bi.d303subb.isChecked() ? "2" :
                                bi.d303subc.isChecked() ? "3" :
                                        bi.d303subd.isChecked() ? "4" :
                                                bi.d303sube.isChecked() ? "5" :
                                                        "0");
        json.put("d304",
                bi.d304a.isChecked() ? "1" :
                        bi.d304b.isChecked() ? "2" :
                                bi.d304c.isChecked() ? "3" :
                                        "0");
        json.put("d304sub",
                bi.d304suba.isChecked() ? "1" :
                        bi.d304subb.isChecked() ? "2" :
                                bi.d304subc.isChecked() ? "3" :
                                        bi.d304subd.isChecked() ? "4" :
                                                bi.d304sube.isChecked() ? "5" :
                                                        "0");
        json.put("d305",
                bi.d305a.isChecked() ? "1" :
                        bi.d305b.isChecked() ? "2" :
                                bi.d305c.isChecked() ? "3" :
                                        "0");
        json.put("d305sub",
                bi.d305suba.isChecked() ? "1" :
                        bi.d305subb.isChecked() ? "2" :
                                bi.d305subc.isChecked() ? "3" :
                                        bi.d305subd.isChecked() ? "4" :
                                                bi.d305sube.isChecked() ? "5" :
                                                        "0");
        json.put("d306",
                bi.d306a.isChecked() ? "1" :
                        bi.d306b.isChecked() ? "2" :
                                bi.d306c.isChecked() ? "3" :
                                        "0");
        json.put("d306sub",
                bi.d306suba.isChecked() ? "1" :
                        bi.d306subb.isChecked() ? "2" :
                                bi.d306subc.isChecked() ? "3" :
                                        bi.d306subd.isChecked() ? "4" :
                                                bi.d306sube.isChecked() ? "5" :
                                                        "0");
        json.put("d307",
                bi.d307a.isChecked() ? "1" :
                        bi.d307b.isChecked() ? "2" :
                                bi.d307c.isChecked() ? "3" :
                                        "0");
        json.put("d307sub",
                bi.d307suba.isChecked() ? "1" :
                        bi.d307subb.isChecked() ? "2" :
                                bi.d307subc.isChecked() ? "3" :
                                        bi.d307subd.isChecked() ? "4" :
                                                bi.d307sube.isChecked() ? "5" :
                                                        "0");
        json.put("d308",
                bi.d308a.isChecked() ? "1" :
                        bi.d308b.isChecked() ? "2" :
                                bi.d308c.isChecked() ? "3" :
                                        "0");
        json.put("d308sub",
                bi.d308suba.isChecked() ? "1" :
                        bi.d308subb.isChecked() ? "2" :
                                bi.d308subc.isChecked() ? "3" :
                                        bi.d308subd.isChecked() ? "4" :
                                                bi.d308sube.isChecked() ? "5" :
                                                        "0");
        json.put("d309",
                bi.d309a.isChecked() ? "1" :
                        bi.d309b.isChecked() ? "2" :
                                bi.d309c.isChecked() ? "3" :
                                        "0");
        json.put("d309sub",
                bi.d309suba.isChecked() ? "1" :
                        bi.d309subb.isChecked() ? "2" :
                                bi.d309subc.isChecked() ? "3" :
                                        bi.d309subd.isChecked() ? "4" :
                                                bi.d309sube.isChecked() ? "5" :
                                                        "0");
        json.put("d310",
                bi.d310a.isChecked() ? "1" :
                        bi.d310b.isChecked() ? "2" :
                                bi.d310c.isChecked() ? "3" :
                                        "0");
        json.put("d310sub",
                bi.d310suba.isChecked() ? "1" :
                        bi.d310subb.isChecked() ? "2" :
                                bi.d310subc.isChecked() ? "3" :
                                        bi.d310subd.isChecked() ? "4" :
                                                bi.d310sube.isChecked() ? "5" :
                                                        "0");
        json.put("d311",
                bi.d311a.isChecked() ? "1" :
                        bi.d311b.isChecked() ? "2" :
                                bi.d311c.isChecked() ? "3" :
                                        "0");
        json.put("d311sub",
                bi.d311suba.isChecked() ? "1" :
                        bi.d311subb.isChecked() ? "2" :
                                bi.d311subc.isChecked() ? "3" :
                                        bi.d311subd.isChecked() ? "4" :
                                                bi.d311sube.isChecked() ? "5" :
                                                        "0");

        MainApp.fc.setsInfo(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


}
