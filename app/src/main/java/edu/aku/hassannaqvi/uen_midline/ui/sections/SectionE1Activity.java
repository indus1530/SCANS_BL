package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import java.util.Map;

import edu.aku.hassannaqvi.uen_midline.CONSTANTS;
import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_midline.contracts.MWRAContract;
import edu.aku.hassannaqvi.uen_midline.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionE1Binding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;

import static edu.aku.hassannaqvi.uen_midline.ui.list_activity.FamilyMembersListActivity.mainVModel;

public class SectionE1Activity extends AppCompatActivity {

    ActivitySectionE1Binding bi;
    List<String> womanNames;
    Map<String, String> womanMap;
    int position;
    private MWRAContract mwra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e1);
        bi.setCallback(this);

        setUIComponent();
    }

    private void setUIComponent() {

        List<String> womenLst = new ArrayList<String>() {
            {
                add("....");
                addAll(MainApp.pragnantWoman.getSecond());
            }
        };

        bi.womanSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, womenLst));

        bi.womanSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        bi.e102.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().isEmpty()) {
                    MainApp.noOfPragnencies = Integer.parseInt(charSequence.toString());

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

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
                Intent next;
                if (bi.e101a.isChecked()) {
                    next = new Intent(SectionE1Activity.this, SectionE2Activity.class);
                    next.putExtra(CONSTANTS.MWRA_INFO, mwra);
                } else {
                    if (MainApp.pragnantWoman.getFirst().size() > 0) {
                        next = new Intent(SectionE1Activity.this, SectionE1Activity.class);
                    } else {
                        next = new Intent(SectionE1Activity.this, SectionE3Activity.class);
                    }
                }
                finish();
                startActivity(next);
            }
        }
    }

    private boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long rowID = db.addMWRA(mwra);
        if (rowID > 0) {
            mwra.set_ID(String.valueOf(rowID));
            mwra.setUID(mwra.getDeviceId() + mwra.get_ID());
            db.updateMWRAUID(mwra);
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    private void SaveDraft() throws JSONException {

        mwra = new MWRAContract();
        mwra.set_UUID(MainApp.fc.get_UID());
        mwra.setDeviceId(MainApp.appInfo.getDeviceID());
        mwra.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        mwra.setUser(MainApp.userName);
        mwra.setDevicetagID(MainApp.appInfo.getTagName());

        JSONObject json = new JSONObject();
        FamilyMembersContract selMWRA = mainVModel.getMemberInfo(MainApp.pragnantWoman.getFirst().get(bi.womanSpinner.getSelectedItemPosition() - 1));
        mwra.setFmuid(selMWRA.getUid());
        json.put("fmuid", selMWRA.getUid());
        mwra.setFm_serial(selMWRA.getSerialno());
        json.put("fm_serial", selMWRA.getSerialno());
        json.put("hhno", MainApp.fc.getHhno());
        json.put("cluster", MainApp.fc.getClusterCode());

        json.put("e100", bi.womanSpinner.getSelectedItem().toString());

        json.put("e101",
                bi.e101a.isChecked() ? "1" :
                        bi.e101b.isChecked() ? "2" : "0");

        json.put("e102", bi.e102.getText().toString());

        json.put("e102a", bi.e102aa.isChecked() ? "1" :
                bi.e102ab.isChecked() ? "2" : "0");


        // Deleting item in list
        MainApp.pragnantWoman.getFirst().remove(position - 1);
        MainApp.pragnantWoman.getSecond().remove(position - 1);

        mwra.setsE1(String.valueOf(json));

    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionE1);
    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}
