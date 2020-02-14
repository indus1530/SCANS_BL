package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionK2Binding;
import edu.aku.hassannaqvi.uen_scans_bl.ui.other.AnthroEndingActivity;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;
import edu.aku.hassannaqvi.uen_scans_bl.validator.ClearClass;

import static edu.aku.hassannaqvi.uen_scans_bl.core.MainApp.anthro;
import static edu.aku.hassannaqvi.uen_scans_bl.core.MainApp.mwraChildrenAnthro;

public class SectionK2Activity extends AppCompatActivity implements Util.EndSecAActivity {

    ActivitySectionK2Binding bi;
    Spinner[] userSpinners;
    DatabaseHelper db;
    FamilyMembersContract fmc_child;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k2);
        bi.setCallback(this);
        setupContent();
        setupSkips();
    }

    private void setupContent() {
        db = new DatabaseHelper(this);
        userSpinners = new Spinner[]{bi.k209b, bi.k210b, bi.k212b, bi.k213b, bi.k214b, bi.k216b, bi.k217b, bi.k218b, bi.k220b};
        for (Spinner singleSpinner : userSpinners) {
            singleSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, db.getUsers()));
        }

        List<String> childLst = new ArrayList<String>() {
            {
                add("....");
                addAll(mwraChildrenAnthro.getSecond());
            }
        };

        bi.k201.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, childLst));

        bi.k201.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
                if (i == 0) return;
                fmc_child = mwraChildrenAnthro.getThird().get(i - 1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void setupSkips() {

        bi.k211.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.k211b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVk212, null);
            }

        }));

        bi.k215.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.k215b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVk216, null);
            }
        }));

        bi.k219.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.k219b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVk220, null);
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
                startActivity(new Intent(this, SectionK3Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnAnthroEnd() {
        if (!Validator.emptySpinner(this, bi.k201)) return;
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
        anthro.set_UUID(fmc_child.getUuid());
        anthro.setDeviceId(MainApp.appInfo.getDeviceID());
        anthro.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        anthro.setUser(MainApp.userName);
        anthro.setDevicetagID(MainApp.appInfo.getTagName());
        anthro.setFormType(CONSTANTS.ANTHRO_K2);

        JSONObject json = new JSONObject();
        json.put("fm_uid", fmc_child.getUid());
        json.put("fm_serial", fmc_child.getSerialno());
        json.put("mm_serial", fmc_child.getMother_serial());
        json.put("hhno", fmc_child.getHhno());
        json.put("cluster", fmc_child.getClusterno());

        json.put("k201", bi.k201.getSelectedItem().toString());

        json.put("k202",
                bi.k202a.isChecked() ? "1" :
                        bi.k202b.isChecked() ? "2" :
                                "0");

        json.put("k203",
                bi.k203a.isChecked() ? "1" :
                        bi.k203b.isChecked() ? "2" :
                                "0");

        /*json.put("k208",
                bi.k208a.isChecked() ? "1" :
                        bi.k208b.isChecked() ? "2" :
                                bi.k208c.isChecked() ? "3" :
                                        "0");*/

        json.put("k209a", bi.k209a.getText().toString());
        json.put("k209b", bi.k209b.getSelectedItem().toString());

        json.put("k210a", bi.k210a.getText().toString());
        json.put("k210b", bi.k210b.getSelectedItem().toString());

        json.put("k211",
                bi.k211a.isChecked() ? "1" :
                        bi.k211b.isChecked() ? "2" :
                                "0");

        json.put("k212a", bi.k212a.getText().toString());
        json.put("k212b", bi.k212b.getSelectedItem().toString());

        json.put("k213a", bi.k213a.getText().toString());
        json.put("k213b", bi.k213b.getSelectedItem().toString());

        json.put("k214a", bi.k214a.getText().toString());
        json.put("k214b", bi.k214b.getSelectedItem().toString());

        json.put("k215",
                bi.k215a.isChecked() ? "1" :
                        bi.k215b.isChecked() ? "2" :
                                "0");

        json.put("k216a", bi.k216a.getText().toString());
        json.put("k216b", bi.k216b.getSelectedItem().toString());

        json.put("k217a", bi.k217a.getText().toString());
        json.put("k217b", bi.k217b.getSelectedItem().toString());

        json.put("k218a", bi.k218a.getText().toString());
        json.put("k218b", bi.k218b.getSelectedItem().toString());

        json.put("k219",
                bi.k219a.isChecked() ? "1" :
                        bi.k219b.isChecked() ? "2" :
                                "0");

        json.put("k220a", bi.k220a.getText().toString());
        json.put("k220b", bi.k220b.getSelectedItem().toString());

        anthro.setsK1(String.valueOf(json));

        // Deleting item in list
        mwraChildrenAnthro.getFirst().remove(position - 1);
        mwraChildrenAnthro.getSecond().remove(position - 1);

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionK2);

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
