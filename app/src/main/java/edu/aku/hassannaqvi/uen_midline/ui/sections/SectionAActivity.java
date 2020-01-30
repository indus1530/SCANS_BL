package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.contracts.BLRandomContract;
import edu.aku.hassannaqvi.uen_midline.contracts.EnumBlockContract;
import edu.aku.hassannaqvi.uen_midline.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_midline.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionABinding;
import edu.aku.hassannaqvi.uen_midline.ui.list_activity.FamilyMembersListActivity;
import edu.aku.hassannaqvi.uen_midline.utils.Util;

public class SectionAActivity extends AppCompatActivity {

    ActivitySectionABinding bi;
    private DatabaseHelper db;
    private BLRandomContract bl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a);
        bi.setCallback(this);
        db = MainApp.appInfo.getDbHelper();

        setUIComponent();
    }


    private void setUIComponent() {
        bi.a101.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.toString().equals("")) {
                    bi.fldGrpSectionA01.setVisibility(View.GONE);
                    bi.fldGrpSectionA02.setVisibility(View.GONE);
//                    Clear.clearAllFields(bi.fldGrpSectionA01);
                }

//
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bi.a112.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.toString().equals("")) {
                    bi.fldGrpSectionA02.setVisibility(View.GONE);
//                    Clear.clearAllFields(bi.fldGrpSectionA02);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

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
                startActivity(new Intent(SectionAActivity.this, FamilyMembersListActivity.class).putExtra("sno", Integer.valueOf(bl.getSno())));
            }
        }
    }


    private boolean UpdateDB() {
        long updcount = db.addForm(MainApp.fc);
        MainApp.fc.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            MainApp.fc.set_UID(MainApp.fc.getDeviceID() + MainApp.fc.get_ID());
            db.updatesFormColumn(FormsContract.FormsTable.COLUMN_UID, MainApp.fc.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() throws JSONException {

        MainApp.fc = new FormsContract();
        MainApp.fc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        MainApp.fc.setUser(MainApp.userName);
        MainApp.fc.setDeviceID(MainApp.appInfo.getDeviceID());
        MainApp.fc.setDevicetagID(MainApp.appInfo.getTagName());
        MainApp.fc.setAppversion(MainApp.appInfo.getAppVersion());
        MainApp.fc.setClusterCode(bi.a101.getText().toString());
//        MainApp.fc.setHhno(bi.a112.getText().toString());
        MainApp.setGPS(this); // Set GPS

        JSONObject json = new JSONObject();

        json.put("imei", MainApp.IMEI);
        json.put("rndid", bl.get_ID());
        json.put("luid", bl.getLUID());
        json.put("randDT", bl.getRandomDT());
        json.put("hh03", bl.getStructure());
        json.put("hh07", bl.getExtension());
        json.put("hhhead", bl.getHhhead());
        json.put("hh09", bl.getContact());
        json.put("hhss", bl.getSelStructure());
        json.put("hhheadpresent", bi.checkHHHeadpresent.isChecked() ? "1" : "2");
        json.put("hhheadpresentnew", bi.newHHheadname.getText().toString());

        json.put("a104", bi.a104.getText().toString());
        json.put("a105", bi.a105.getText().toString());
        json.put("a106", bi.a106.getText().toString());
        json.put("a107", bi.a107.getText().toString());
        json.put("a109", bi.a109.getText().toString());
        json.put("a110", bi.a110.getText().toString());
        json.put("a111", bi.a111.getText().toString());

        MainApp.fc.setsInfo(String.valueOf(json));

    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionA);
    }

    public void BtnEnd() {
        Util.openEndActivity(this);
    }

    public void BtnCheckCluster() {

        if (!Validator.emptyTextBox(this, bi.a101)) return;

        EnumBlockContract enumBlockContract = db.getEnumBlock(bi.a101.getText().toString());
        if (enumBlockContract != null) {
            String selected = enumBlockContract.getGeoarea();
            if (!selected.equals("")) {

                String[] selSplit = selected.split("\\|");

                bi.fldGrpSectionA01.setVisibility(View.VISIBLE);
                bi.a104.setText(selSplit[0]);
                bi.a105.setText(selSplit[1].equals("") ? "----" : selSplit[1]);
                bi.a106.setText(selSplit[2].equals("") ? "----" : selSplit[2]);
                bi.a107.setText(selSplit[3]);

            }
        } else {
            Toast.makeText(this, "Sorry cluster not found!!", Toast.LENGTH_SHORT).show();
        }

    }

    public void BtnCheckHH() {
        if (!Validator.emptyTextBox(this, bi.a112)) return;

        bl = MainApp.appInfo.getDbHelper().getHHFromBLRandom(bi.a101.getText().toString(), bi.a112.getText().toString().toUpperCase());

        if (bl != null) {
            Toast.makeText(this, "Household found!", Toast.LENGTH_SHORT).show();
            bi.hhName.setText(bl.getHhhead().toUpperCase());
            bi.fldGrpSectionA02.setVisibility(View.VISIBLE);

        } else {
            bi.fldGrpSectionA02.setVisibility(View.GONE);
            Toast.makeText(this, "No Household found!", Toast.LENGTH_SHORT).show();
        }

    }
}
