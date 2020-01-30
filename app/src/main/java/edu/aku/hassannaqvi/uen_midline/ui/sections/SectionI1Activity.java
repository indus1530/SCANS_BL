package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.contracts.ChildContract;
import edu.aku.hassannaqvi.uen_midline.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_midline.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionI1Binding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;
import kotlin.Pair;

import static edu.aku.hassannaqvi.uen_midline.ui.list_activity.FamilyMembersListActivity.mainVModel;

public class SectionI1Activity extends AppCompatActivity {

    ActivitySectionI1Binding bi;
    private FamilyMembersContract fmc_child, res_child;
    private Pair<List<Integer>, List<String>> childLst, resList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_i1);
        bi.setCallback(this);

        setUIComponent();
        setListener();

    }

    private void setUIComponent() {

        childLst = mainVModel.getAllUnder5();

        List<String> childLst = new ArrayList<String>() {
            {
                add("....");
                addAll(SectionI1Activity.this.childLst.getSecond());
            }
        };

        bi.i100.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, childLst));
    }

    private void populateRespondentSpinner() {
        resList = mainVModel.getAllRespondent();
        List<String> reponList = new ArrayList<String>() {
            {
                add("....");
                addAll(SectionI1Activity.this.resList.getSecond());
            }
        };

        bi.i10res.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, reponList));
    }


    private void setListener() {

        bi.i100.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) return;
                fmc_child = mainVModel.getMemberInfo(childLst.getFirst().get(bi.i100.getSelectedItemPosition() - 1));
                if (fmc_child.getMother_serial().equals("97")) {
                    bi.respondentSpinner.setVisibility(View.VISIBLE);
                    populateRespondentSpinner();
                } else {
                    bi.respondentSpinner.setVisibility(View.GONE);
                    res_child = mainVModel.getMemberInfo(Integer.valueOf(fmc_child.getSerialno()));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bi.i10res.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) return;
                res_child = mainVModel.getMemberInfo(resList.getFirst().get(bi.i10res.getSelectedItemPosition() - 1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bi.i101.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.i101b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpi01, null);
            }

        }));

        bi.i105.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.i105a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVi106, null);
            }
        }));

        bi.i113.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.i113b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpi02, null);
            }
        }));

        bi.i117.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.i117b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpi03, null);
            }
        }));

        bi.i118.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.i118b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVi119, null);
            }
        }));

        bi.i122.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.i122b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpi04, null);
            }
        }));

        bi.i125.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.i125b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVi126, null);
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
                startActivity(new Intent(this, SectionI2Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void BtnEnd() {

        Util.openEndActivity(this);
    }

    private boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long rowID = db.addChild(MainApp.child);
        if (rowID > 0) {
            MainApp.child.set_ID(String.valueOf(rowID));
            MainApp.child.setUID(MainApp.child.getDeviceId() + MainApp.child.get_ID());
            db.updatesChildColumn(ChildContract.SingleChild.COLUMN_UID, MainApp.child.getUID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        MainApp.child = new ChildContract();
        MainApp.child.set_UUID(MainApp.fc.get_UID());
        MainApp.child.setDeviceId(MainApp.appInfo.getDeviceID());
        MainApp.child.setDevicetagID(MainApp.appInfo.getTagName());
        MainApp.child.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        MainApp.child.setUser(MainApp.userName);


        JSONObject json = new JSONObject();

        json.put("hhno", MainApp.fc.getHhno());
        json.put("cluster", MainApp.fc.getClusterCode());
        json.put("i1_fm_uid", fmc_child.getUid());
        json.put("i1_fm_serial", fmc_child.getSerialno());
        json.put("i1_res_fm_uid", res_child.getUid());
        json.put("i1_res_fm_serial", res_child.getSerialno());

        json.put("i100", bi.i100.getSelectedItem().toString());

        json.put("i101", bi.i101a.isChecked() ? "1" :
                bi.i101b.isChecked() ? "2" : "0");

        json.put("i102", bi.i102.getText().toString());

        json.put("i103", bi.i103.getText().toString());

        json.put("i104", bi.i104a.isChecked() ? "1" :
                bi.i104b.isChecked() ? "2" :
                        bi.i104c.isChecked() ? "98" : "0");

        json.put("i105", bi.i105a.isChecked() ? "1" :
                bi.i105b.isChecked() ? "2" : "0");

        json.put("i106", bi.i106a.isChecked() ? "1" :
                bi.i106b.isChecked() ? "2" :
                        bi.i106c.isChecked() ? "3" :
                                bi.i106d.isChecked() ? "4" :
                                        bi.i106e.isChecked() ? "5" :
                                                bi.i106f.isChecked() ? "6" : "0");

        json.put("i107", bi.i107a.isChecked() ? "1" :
                bi.i107b.isChecked() ? "2" :
                        bi.i107c.isChecked() ? "3" : "0");

        json.put("i108", bi.i108a.isChecked() ? "1" :
                bi.i108b.isChecked() ? "2" :
                        bi.i108c.isChecked() ? "3" :
                                bi.i108d.isChecked() ? "4" :
                                        bi.i108e.isChecked() ? "5" :
                                                bi.i108f.isChecked() ? "6" : "0");

        json.put("i109", bi.i109.getText().toString());

        json.put("i110", bi.i110.getText().toString());

        json.put("i111", bi.i111a.isChecked() ? "1" :
                bi.i111b.isChecked() ? "2" :
                        bi.i111c.isChecked() ? "3" :
                                bi.i111d.isChecked() ? "4" :
                                        bi.i111e.isChecked() ? "5" :
                                                bi.i111f.isChecked() ? "6" :
                                                        bi.i111g.isChecked() ? "7" : "0");

        json.put("i112", bi.i112a.isChecked() ? "1" :
                bi.i112b.isChecked() ? "2" :
                        bi.i112c.isChecked() ? "3" :
                                bi.i112d.isChecked() ? "4" :
                                        bi.i112e.isChecked() ? "5" :
                                                bi.i112f.isChecked() ? "6" :
                                                        bi.i112g.isChecked() ? "7" :
                                                                bi.i112h.isChecked() ? "8" :
                                                                        bi.i112i.isChecked() ? "9" :
                                                                                bi.i112j.isChecked() ? "10" :
                                                                                        bi.i112k.isChecked() ? "11" : "0");

        json.put("i113", bi.i113a.isChecked() ? "1" :
                bi.i113b.isChecked() ? "2" : "0");

        json.put("i114", bi.i114a.isChecked() ? "1" :
                bi.i114b.isChecked() ? "2" :
                        bi.i114c.isChecked() ? "3" : "0");

        json.put("i115a", bi.i115a.getText().toString());
        json.put("i115b", bi.i115b.getText().toString());

        json.put("i116a", bi.i116a.isChecked() ? "1" : "0");
        json.put("i116b", bi.i116b.isChecked() ? "2" : "0");
        json.put("i116c", bi.i116c.isChecked() ? "3" : "0");
        json.put("i116d", bi.i116d.isChecked() ? "4" : "0");
        json.put("i116e", bi.i116e.isChecked() ? "5" : "0");
        json.put("i116f", bi.i116f.isChecked() ? "6" : "0");
        json.put("i116g", bi.i116g.isChecked() ? "7" : "0");
        json.put("i116h", bi.i116h.isChecked() ? "8" : "0");

        json.put("i117", bi.i117a.isChecked() ? "1" :
                bi.i117b.isChecked() ? "2" : "0");

        json.put("i118", bi.i118a.isChecked() ? "1" :
                bi.i118b.isChecked() ? "2" : "0");

        json.put("i119", bi.i119a.isChecked() ? "1" :
                bi.i119b.isChecked() ? "2" :
                        bi.i119c.isChecked() ? "3" :
                                bi.i119d.isChecked() ? "4" :
                                        bi.i119e.isChecked() ? "5" :
                                                bi.i119f.isChecked() ? "6" :
                                                        bi.i119g.isChecked() ? "7" :
                                                                bi.i119h.isChecked() ? "8" :
                                                                        bi.i119i.isChecked() ? "9" : "0");

        json.put("i120", bi.i120.getText().toString());

        json.put("i121", bi.i121.getText().toString());

        json.put("i122", bi.i122a.isChecked() ? "1" :
                bi.i122b.isChecked() ? "2" : "0");

        json.put("i123", bi.i123a.isChecked() ? "1" :
                bi.i123b.isChecked() ? "2" :
                        bi.i123c.isChecked() ? "3" :
                                bi.i123d.isChecked() ? "4" :
                                        bi.i123e.isChecked() ? "5" :
                                                bi.i123f.isChecked() ? "6" : "0");

        json.put("i124", bi.i124a.isChecked() ? "1" :
                bi.i124b.isChecked() ? "2" :
                        bi.i124c.isChecked() ? "3" :
                                bi.i124d.isChecked() ? "4" :
                                        bi.i124e.isChecked() ? "5" :
                                                bi.i124f.isChecked() ? "6" :
                                                        bi.i124g.isChecked() ? "7" : "0");

        json.put("i125", bi.i125a.isChecked() ? "1" :
                bi.i125b.isChecked() ? "2" : "0");

        json.put("i126", bi.i126a.isChecked() ? "1" :
                bi.i126b.isChecked() ? "2" :
                        bi.i126c.isChecked() ? "3" :
                                bi.i126d.isChecked() ? "4" :
                                        bi.i126e.isChecked() ? "5" : "0");

        MainApp.child.setsI1(String.valueOf(json));


    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectioni01);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
