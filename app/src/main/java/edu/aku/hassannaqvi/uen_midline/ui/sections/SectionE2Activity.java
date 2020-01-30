package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_midline.CONSTANTS;
import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.contracts.MWRAContract;
import edu.aku.hassannaqvi.uen_midline.contracts.MWRA_PREContract;
import edu.aku.hassannaqvi.uen_midline.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionE2Binding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;

public class SectionE2Activity extends AppCompatActivity {

    ActivitySectionE2Binding bi;
    private MWRAContract mwraContract;
    MWRA_PREContract mwraPre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e2);
        bi.setCallback(this);

        setUIComponent();
    }

    private void setUIComponent() {

        mwraContract = getIntent().getParcelableExtra(CONSTANTS.MWRA_INFO);

        bi.e105.setOnCheckedChangeListener(((radioGroup, i) -> {

            MainApp.twinFlag = i == bi.e105c.getId();
            if (i == bi.e105e.getId()) {
                bi.container1.setVisibility(View.GONE);
                bi.container2.setVisibility(View.GONE);
            } else {
                bi.container1.setVisibility(View.VISIBLE);
                bi.container2.setVisibility(View.VISIBLE);
            }


        }));


        bi.e107.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.e107b.getId()) {
                bi.mainContainer2.setVisibility(View.VISIBLE);
            } else {
                bi.mainContainer2.setVisibility(View.GONE);
                ClearClass.ClearAllFields(bi.mainContainer2, null);
            }
        }));

        bi.e106c.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.e106c.setMinvalue(CONSTANTS.MINYEAR);

        bi.e110c.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.e110c.setMinvalue(CONSTANTS.MINYEAR);

        bi.e113y.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.e113y.setMinvalue(CONSTANTS.MINYEAR);

    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                if (MainApp.twinFlag) {
                    openDialog();
                } else {
                    if (MainApp.noOfPragnencies > 0) {
                        finish();
                        startActivity(new Intent(SectionE2Activity.this, SectionE2Activity.class)
                                .putExtra(CONSTANTS.MWRA_INFO, mwraContract));
                    } else {
                        if (MainApp.pragnantWoman.getFirst().size() > 0) {
                            finish();
                            startActivity(new Intent(SectionE2Activity.this, SectionE1Activity.class));
                        } else {
                            finish();
                            startActivity(new Intent(SectionE2Activity.this, SectionE3Activity.class));
                        }
                    }

                }
            }

        }
    }

    private void openDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.item_dialog);
        dialog.setCancelable(false);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(dialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();
        dialog.getWindow().setAttributes(params);

        dialog.findViewById(R.id.btnOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearContainer();
                dialog.dismiss();

            }
        });

    }

    private void clearContainer() {
        ClearClass.ClearAllFields(bi.container1, null);
        ClearClass.ClearAllFields(bi.mainContainer2, null);
        ClearClass.ClearAllFields(bi.e104015, false);
        bi.e104b.setChecked(true);
        bi.e105c.setChecked(true);
        bi.container1.requestFocus();
        MainApp.twinFlag = false;

    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long rowID = db.addPregnantMWRA(mwraPre);
        if (rowID > 0) {
            mwraPre.set_ID(String.valueOf(rowID));
            mwraPre.setUID(mwraPre.getDeviceId() + mwraPre.get_ID());
            db.updatesMWRAPREColumn(mwraPre);
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {


        mwraPre = new MWRA_PREContract();
        mwraPre.set_UUID(MainApp.fc.get_UID());
        mwraPre.setDeviceId(MainApp.appInfo.getDeviceID());
        mwraPre.setDevicetagID(MainApp.appInfo.getTagName());
        mwraPre.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        JSONObject e2 = new JSONObject();
        e2.put("mw_uid", mwraContract.getUID());
        e2.put("fm_serial", mwraContract.getFm_serial());
        e2.put("fm_uid", mwraContract.getFmuid());
        e2.put("hhno", MainApp.fc.getHhno());
        e2.put("cluster", MainApp.fc.getClusterCode());
        e2.put("counter", MainApp.noOfPragnencies);

        e2.put("e104", bi.e104a.isChecked() ? "1" :
                bi.e104b.isChecked() ? "2" : "0");

        e2.put("e105", bi.e105a.isChecked() ? "1" :
                bi.e105b.isChecked() ? "2" :
                        bi.e105c.isChecked() ? "3" : "0");

        e2.put("e106a", bi.e106a.getText().toString());
        e2.put("e106b", bi.e106b.getText().toString());
        e2.put("e106c", bi.e106c.getText().toString());

        e2.put("e107", bi.e107a.isChecked() ? "1" :
                bi.e107b.isChecked() ? "2" : "0");

        e2.put("e108", bi.e108a.isChecked() ? "1" :
                bi.e108b.isChecked() ? "2" : "0");

        e2.put("e109", bi.e109.getText().toString());

        e2.put("e110a", bi.e110a.getText().toString());
        e2.put("e110b", bi.e110b.getText().toString());
        e2.put("e110c", bi.e110c.getText().toString());

        e2.put("e111", bi.e111a.isChecked() ? "1" :
                bi.e111b.isChecked() ? "2" :
                        bi.e111c.isChecked() ? "3" :
                                bi.e111d.isChecked() ? "4" :
                                        bi.e111e.isChecked() ? "5" :
                                                bi.e111f.isChecked() ? "6" :
                                                        bi.e111g.isChecked() ? "7" :
                                                                bi.e11196.isChecked() ? "96" : "0");
        e2.put("e11196x", bi.e11196x.getText().toString());

        e2.put("e112", bi.e112a.isChecked() ? "1" :
                bi.e112b.isChecked() ? "2" :
                        bi.e112c.isChecked() ? "3" :
                                bi.e112d.isChecked() ? "4" :
                                        bi.e112e.isChecked() ? "5" : "0");

        e2.put("e113m", bi.e113m.getText().toString());
        e2.put("e113y", bi.e113y.getText().toString());

        e2.put("e114", bi.e114.getText().toString());

        e2.put("e115", bi.e115a.isChecked() ? "1" :
                bi.e115b.isChecked() ? "2" : "0");

        mwraPre.setsE2(String.valueOf(e2));

        --MainApp.noOfPragnencies;


    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionE2);

    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
