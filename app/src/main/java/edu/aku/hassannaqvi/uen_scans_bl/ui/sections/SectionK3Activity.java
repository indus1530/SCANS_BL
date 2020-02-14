package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.AnthroContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionK3Binding;
import edu.aku.hassannaqvi.uen_scans_bl.ui.other.AnthroEndingActivity;
import edu.aku.hassannaqvi.uen_scans_bl.utils.JSONUtils;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;
import edu.aku.hassannaqvi.uen_scans_bl.validator.ClearClass;

public class SectionK3Activity extends AppCompatActivity {

    ActivitySectionK3Binding bi;
    Spinner[] userSpinners;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k3);
        bi.setCallback(this);

        setupContent();
        setupSkips();

    }

    private void setupContent() {
        db = new DatabaseHelper(this);
        userSpinners = new Spinner[]{bi.k221b, bi.k222b, bi.k224b, bi.k225b, bi.k226b, bi.k228b};
        for (Spinner singleSpinner : userSpinners) {
            singleSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, db.getUsers()));
        }
    }


    private void setupSkips() {

        bi.k223.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.k223b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVk224, null);
            }
        }));

        bi.k227.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.k227b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVk228, null);
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
                startActivity(new Intent(this, AnthroEndingActivity.class).putExtra("complete", true));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void BtnEnd() {

        Util.openAnthroEndActivity(this);
    }


    private boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesAnthroColumn(AnthroContract.SingleAnthro.COLUMN_SK1, MainApp.anthro.getsK1());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject k2 = new JSONObject();

        k2.put("k221a", bi.k221a.getText().toString());
        k2.put("k221b", bi.k221b.getSelectedItem().toString());

        k2.put("k222a", bi.k222a.getText().toString());
        k2.put("k222b", bi.k222b.getSelectedItem().toString());

        k2.put("k223",
                bi.k223a.isChecked() ? "1" :
                        bi.k223b.isChecked() ? "2" :
                                "0");

        k2.put("k224a", bi.k224a.getText().toString());
        k2.put("k224b", bi.k224b.getSelectedItem().toString());

        k2.put("k225a", bi.k225a.getText().toString());
        k2.put("k225b", bi.k225b.getSelectedItem().toString());

        k2.put("k226a", bi.k226a.getText().toString());
        k2.put("k226b", bi.k226b.getSelectedItem().toString());

        k2.put("k227",
                bi.k227a.isChecked() ? "1" :
                        bi.k227b.isChecked() ? "2" :
                                "0");

        k2.put("k228a", bi.k228a.getText().toString());
        k2.put("k228b", bi.k228b.getSelectedItem().toString());

        try {
            JSONObject s4_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.anthro.getsK1()), k2);

            MainApp.anthro.setsK1(String.valueOf(s4_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionK3);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }


}
