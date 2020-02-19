package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.BLRandomContract;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.EnumBlockContract;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionA1Binding;
import edu.aku.hassannaqvi.uen_scans_bl.ui.list_activity.FamilyMembersListActivity;
import edu.aku.hassannaqvi.uen_scans_bl.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionA1Activity extends AppCompatActivity implements Util.EndSecAActivity {

    ActivitySectionA1Binding bi;
    private DatabaseHelper db;
    private BLRandomContract bl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a1);
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
                if (bi.a101.getText().hashCode() == s.hashCode()) {
                    Clear.clearAllFields(bi.fldGrpSectionA01);
                    Clear.clearAllFields(bi.fldGrpSectionA02);
                    bi.fldGrpSectionA01.setVisibility(View.GONE);
                    bi.fldGrpSectionA02.setVisibility(View.GONE);
                    bi.btnNext.setVisibility(View.GONE);
                    bi.btnEnd.setVisibility(View.GONE);
                }
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
                if (Objects.requireNonNull(bi.a112.getText()).hashCode() == s.hashCode()) {
                    Clear.clearAllFields(bi.fldGrpSectionA02);
                    bi.fldGrpSectionA02.setVisibility(View.GONE);
                    bi.btnNext.setVisibility(View.GONE);
                    bi.btnEnd.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        bi.a113.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.a113a.getId()) {
                bi.fldGrpCVa114.setVisibility(View.VISIBLE);
                bi.fldGrpCVa115.setVisibility(View.VISIBLE);
                bi.fldGrpCVa116.setVisibility(View.VISIBLE);
                bi.fldGrpCVa117.setVisibility(View.VISIBLE);
                bi.fldGrpCVa118.setVisibility(View.VISIBLE);
                bi.btnNext.setVisibility(View.VISIBLE);
                bi.btnEnd.setVisibility(View.GONE);
            } else if (i == bi.a113b.getId()) {
                Clear.clearAllFields(bi.fldGrpCVa114);
                Clear.clearAllFields(bi.fldGrpCVa115);
                Clear.clearAllFields(bi.fldGrpCVa116);
                Clear.clearAllFields(bi.fldGrpCVa117);
                Clear.clearAllFields(bi.fldGrpCVa118);
                bi.fldGrpCVa114.setVisibility(View.GONE);
                bi.fldGrpCVa115.setVisibility(View.GONE);
                bi.fldGrpCVa116.setVisibility(View.GONE);
                bi.fldGrpCVa117.setVisibility(View.GONE);
                bi.fldGrpCVa118.setVisibility(View.GONE);
                bi.btnNext.setVisibility(View.GONE);
                bi.btnEnd.setVisibility(View.VISIBLE);
            }

        }));


        bi.a115.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (Objects.requireNonNull(bi.a115.getText()).hashCode() == s.hashCode()) {
                    if (bi.a115.getText().toString().trim().length() > 0 && Integer.parseInt(bi.a115.getText().toString().trim()) > 17) {
                        bi.fldGrpCVa116.setVisibility(View.VISIBLE);
                        bi.fldGrpCVa117.setVisibility(View.VISIBLE);
                        bi.fldGrpCVa118.setVisibility(View.VISIBLE);
                        bi.btnNext.setVisibility(View.VISIBLE);
                        bi.btnEnd.setVisibility(View.GONE);
                    } else {
                        Clear.clearAllFields(bi.fldGrpCVa116);
                        Clear.clearAllFields(bi.fldGrpCVa117);
                        Clear.clearAllFields(bi.fldGrpCVa118);
                        bi.fldGrpCVa116.setVisibility(View.GONE);
                        bi.fldGrpCVa117.setVisibility(View.GONE);
                        bi.fldGrpCVa118.setVisibility(View.GONE);
                        bi.btnNext.setVisibility(View.GONE);
                        bi.btnEnd.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        bi.a116.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.a116a.getId()) {
                bi.fldGrpCVa117.setVisibility(View.VISIBLE);
                bi.fldGrpCVa118.setVisibility(View.VISIBLE);
                bi.btnNext.setVisibility(View.VISIBLE);
                bi.btnEnd.setVisibility(View.GONE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVa117);
                Clear.clearAllFields(bi.fldGrpCVa118);
                bi.fldGrpCVa117.setVisibility(View.GONE);
                bi.fldGrpCVa118.setVisibility(View.GONE);
                bi.btnNext.setVisibility(View.GONE);
                bi.btnEnd.setVisibility(View.VISIBLE);
            }

        }));


        bi.a117.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.a117b.getId()) {
                bi.fldGrpCVa118.setVisibility(View.VISIBLE);
                bi.btnNext.setVisibility(View.VISIBLE);
                bi.btnEnd.setVisibility(View.GONE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVa118);
                bi.fldGrpCVa118.setVisibility(View.GONE);
                bi.btnNext.setVisibility(View.GONE);
                bi.btnEnd.setVisibility(View.VISIBLE);
            }

        }));


        bi.a118.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.a118b.getId()) {
                bi.btnNext.setVisibility(View.VISIBLE);
                bi.btnEnd.setVisibility(View.GONE);
            } else {
                bi.btnNext.setVisibility(View.GONE);
                bi.btnEnd.setVisibility(View.VISIBLE);
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
                    startActivity(new Intent(this, FamilyMembersListActivity.class).putExtra("sno", Integer.valueOf(bl.getSno())));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
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
        MainApp.fc.setHhno(bi.a112.getText().toString());
        MainApp.fc.setLuid(bl.getLUID());
        MainApp.setGPS(this); // Set GPS

        JSONObject json = new JSONObject();

        json.put("imei", MainApp.IMEI);
        json.put("rndid", bl.get_ID());
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

        /*json.put("a109", bi.a109.getText().toString());
        json.put("a110", bi.a110.getText().toString());
        json.put("a111", bi.a111.getText().toString());*/

        json.put("a113", bi.a113a.isChecked() ? "1"
                : bi.a113b.isChecked() ? "2"
                : "0");

        json.put("a114", bi.a114.getText().toString());

        json.put("a115", bi.a115.getText().toString());

        json.put("a116", bi.a116a.isChecked() ? "1"
                : bi.a116b.isChecked() ? "2"
                : "0");

        json.put("a117", bi.a117a.isChecked() ? "1"
                : bi.a117b.isChecked() ? "2"
                : "0");

        json.put("a118", bi.a118a.isChecked() ? "1"
                : bi.a118b.isChecked() ? "2"
                : "0");

        MainApp.fc.setsInfo(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        if (formValidation()) {
            Util.contextEndActivity(this);
        }
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

    @Override
    public void endSecAActivity(boolean flag) {
        if (!flag) return;

        try {
            SaveDraft();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }

    }
}
