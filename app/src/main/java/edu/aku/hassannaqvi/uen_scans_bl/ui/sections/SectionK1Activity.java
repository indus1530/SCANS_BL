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
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionK1Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;
import edu.aku.hassannaqvi.uen_scans_bl.validator.ClearClass;

import static edu.aku.hassannaqvi.uen_scans_bl.ui.list_activity.FamilyMembersListActivity.mainVModel;

public class SectionK1Activity extends AppCompatActivity {


    ActivitySectionK1Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k1);
        bi.setCallback(this);
        setlistener();

    }


    private void setlistener() {

        bi.k103.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.k103b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVk104, null);
            }

        }));

        /*bi.k105.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.k105aac.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVk106, null);
            }
        }));*/

        bi.txtHeadLbl.setText(new StringBuilder(MainApp.indexKishMWRAChild.getName().toUpperCase()).append("\n")
                .append(MainApp.indexKishMWRA.getMother_name().toUpperCase()));

    }


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

                MainApp.mwraChildren = mainVModel.getAllChildrenPairOfSelMWRA(Integer.valueOf(MainApp.indexKishMWRA.getSerialno()));

                finish();
                startActivity(new Intent(this, SectionK2Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void BtnEnd() {

        Util.openEndActivity(this);
    }


    private boolean UpdateDB() {

        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesKishMWRAColumn(FoodFreqContract.SingleFoodFreq.COLUMN_SD5, MainApp.foodFreq.getsD5());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("k101",
                bi.k101a.isChecked() ? "1" :
                        bi.k101b.isChecked() ? "2" :
                                bi.k101c.isChecked() ? "3" :
                                        "0");

        json.put("k102",
                bi.k102a.isChecked() ? "1" :
                        bi.k102b.isChecked() ? "2" :
                                bi.k102c.isChecked() ? "3" :
                                        "0");

        json.put("k103",
                bi.k103a.isChecked() ? "1" :
                        bi.k103b.isChecked() ? "2" :
                                bi.k103c.isChecked() ? "3" :
                                        "0");

        json.put("k104", bi.k10498.isChecked() ? "98" :
                bi.k104.getText().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionK1);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
