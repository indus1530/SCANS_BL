package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.uen_scans_bl.CONSTANTS;
import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.AnthroContract;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionK1Binding;
import edu.aku.hassannaqvi.uen_scans_bl.ui.other.AnthroEndingActivity;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

import static edu.aku.hassannaqvi.uen_scans_bl.core.MainApp.anthro;
import static edu.aku.hassannaqvi.uen_scans_bl.core.MainApp.mwraChildren;
import static edu.aku.hassannaqvi.uen_scans_bl.ui.list_activity.FamilyMembersListActivity.mainVModel;

public class SectionK1Activity extends AppCompatActivity implements Util.EndSecAActivity {

    ActivitySectionK1Binding bi;
    FamilyMembersContract fmc_child;
    int position;


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
                Clear.clearAllFields(bi.fldGrpCVk104);
            }

        }));

        List<String> childLst = new ArrayList<String>() {
            {
                add("....");
                addAll(mwraChildren.getSecond());
            }
        };

        bi.k100.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, childLst));

        bi.k100.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
                if (i == 0) return;
                fmc_child = mainVModel.getMemberInfo(mwraChildren.getFirst().get(i - 1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
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
                startActivity(new Intent(this, AnthroEndingActivity.class).putExtra("complete", true));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {
        Util.openEndActivity(this);
    }

    public void BtnAnthroEnd() {
        if (!Validator.emptySpinner(this, bi.k100)) return;
        Util.contextEndActivity(this);
    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addAnthro(anthro);
        anthro.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            anthro.setUID(anthro.getDeviceId() + anthro.get_ID());
            db.updatesAnthroColumn(AnthroContract.SingleAnthro.COLUMN_UID, anthro.getUID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


    private void SaveDraft() throws JSONException {

        anthro = new AnthroContract();
        anthro.set_UUID(MainApp.fc.get_UID());
        anthro.setDeviceId(MainApp.appInfo.getDeviceID());
        anthro.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        anthro.setUser(MainApp.userName);
        anthro.setDevicetagID(MainApp.appInfo.getTagName());
        anthro.setFormType(CONSTANTS.ANTHRO_K1);

        JSONObject json = new JSONObject();
        json.put("fm_uid", fmc_child.getUid());
        json.put("fm_serial", fmc_child.getSerialno());
        json.put("mm_serial", fmc_child.getMother_serial());
        json.put("hhno", MainApp.fc.getHhno());
        json.put("cluster_no", MainApp.fc.getClusterCode());
        json.put("_luid", MainApp.fc.getLuid());

        json.put("k100", bi.k100.getSelectedItem().toString());

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


        anthro.setsK1(String.valueOf(json));

        // Deleting item in list
        mwraChildren.getFirst().remove(position - 1);
        mwraChildren.getSecond().remove(position - 1);

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionK1);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void endSecAActivity(boolean flag) {
        try {
            SaveDraft();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, AnthroEndingActivity.class).putExtra("complete", false));
        }
    }
}
