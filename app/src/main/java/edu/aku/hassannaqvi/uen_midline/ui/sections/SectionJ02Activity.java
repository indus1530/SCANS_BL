package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_midline.CONSTANTS;
import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.contracts.ChildContract;
import edu.aku.hassannaqvi.uen_midline.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionJ02Binding;
import edu.aku.hassannaqvi.uen_midline.utils.JSONUtils;
import edu.aku.hassannaqvi.uen_midline.utils.Util;

public class SectionJ02Activity extends AppCompatActivity {


    ActivitySectionJ02Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j02);
        bi.setCallback(this);

        setUIComponent();

    }

    private void setUIComponent() {

        bi.j10409y.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.j10409y.setMinvalue(CONSTANTS.MINYEAR_IM);

        bi.j10410y.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.j10410y.setMinvalue(CONSTANTS.MINYEAR_IM);

        bi.j10411y.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.j10411y.setMinvalue(CONSTANTS.MINYEAR_IM);

        bi.j10412y.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.j10412y.setMinvalue(CONSTANTS.MINYEAR_IM);

        bi.j10413y.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.j10413y.setMinvalue(CONSTANTS.MINYEAR_IM);

        bi.j10414y.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.j10414y.setMinvalue(CONSTANTS.MINYEAR_IM);

        bi.j10415y.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.j10415y.setMinvalue(CONSTANTS.MINYEAR_IM);

        bi.j10416y.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.j10416y.setMinvalue(CONSTANTS.MINYEAR_IM);

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
                startActivity(new Intent(this, SectionJ03Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);
        int updcount = db.updatesChildColumn(ChildContract.SingleChild.COLUMN_SJ, MainApp.child.getsJ());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject j2 = new JSONObject();

        j2.put("j10409d", bi.j10409d.getText().toString());
        j2.put("j10409m", bi.j10409m.getText().toString());
        j2.put("j10409y", bi.j10409y.getText().toString());
        j2.put("j10409a",
                bi.j10409aa.isChecked() ? "1" :
                        bi.j10409ab.isChecked() ? "2" :
                                bi.j10409ac.isChecked() ? "3" :
                                        bi.j10409ad.isChecked() ? "4" :
                                                bi.j10409ae.isChecked() ? "5" :
                                                        bi.j10409af.isChecked() ? "6" :
                                                                "0");
        j2.put("j10409b",
                bi.j10409ba.isChecked() ? "1" :
                        bi.j10409bb.isChecked() ? "2" :
                                bi.j10409bc.isChecked() ? "3" :
                                        bi.j10409bd.isChecked() ? "4" :
                                                bi.j10409be.isChecked() ? "5" :
                                                        bi.j10409bf.isChecked() ? "6" :
                                                                bi.j10409bg.isChecked() ? "7" :
                                                                        bi.j10409b96.isChecked() ? "96" :
                                                                                "0");
        j2.put("j10409b96x", bi.j10409b96x.getText().toString());

        j2.put("j10410d", bi.j10410d.getText().toString());
        j2.put("j10410m", bi.j10410m.getText().toString());
        j2.put("j10410y", bi.j10410y.getText().toString());

        j2.put("j10410a",
                bi.j10410aa.isChecked() ? "1" :
                        bi.j10410ab.isChecked() ? "2" :
                                bi.j10410ac.isChecked() ? "3" :
                                        bi.j10410ad.isChecked() ? "4" :
                                                bi.j10410ae.isChecked() ? "5" :
                                                        bi.j10410af.isChecked() ? "6" :
                                                                "0");
        j2.put("j10410b",
                bi.j10410ba.isChecked() ? "1" :
                        bi.j10410bb.isChecked() ? "2" :
                                bi.j10410bc.isChecked() ? "3" :
                                        bi.j10410bd.isChecked() ? "4" :
                                                bi.j10410be.isChecked() ? "5" :
                                                        bi.j10410bf.isChecked() ? "6" :
                                                                bi.j10410bg.isChecked() ? "7" :
                                                                        bi.j10410b96.isChecked() ? "96" :
                                                                                "0");
        j2.put("j10410b96x", bi.j10410b96x.getText().toString());

        j2.put("j10411d", bi.j10411d.getText().toString());
        j2.put("j10411m", bi.j10411m.getText().toString());
        j2.put("j10411y", bi.j10411y.getText().toString());

        j2.put("j10411a",
                bi.j10411aa.isChecked() ? "1" :
                        bi.j10411ab.isChecked() ? "2" :
                                bi.j10411ac.isChecked() ? "3" :
                                        bi.j10411ad.isChecked() ? "4" :
                                                bi.j10411ae.isChecked() ? "5" :
                                                        bi.j10411af.isChecked() ? "6" :
                                                                "0");
        j2.put("j10411b",
                bi.j10411ba.isChecked() ? "1" :
                        bi.j10411bb.isChecked() ? "2" :
                                bi.j10411bc.isChecked() ? "3" :
                                        bi.j10411bd.isChecked() ? "4" :
                                                bi.j10411be.isChecked() ? "5" :
                                                        bi.j10411bf.isChecked() ? "6" :
                                                                bi.j10411bg.isChecked() ? "7" :
                                                                        bi.j10411b96.isChecked() ? "96" :
                                                                                "0");
        j2.put("j10411b96x", bi.j10411b96x.getText().toString());

        j2.put("j10412d", bi.j10412d.getText().toString());
        j2.put("j10412m", bi.j10412m.getText().toString());
        j2.put("j10412y", bi.j10412y.getText().toString());

        j2.put("j10412a",
                bi.j10412aa.isChecked() ? "1" :
                        bi.j10412ab.isChecked() ? "2" :
                                bi.j10412ac.isChecked() ? "3" :
                                        bi.j10412ad.isChecked() ? "4" :
                                                bi.j10412ae.isChecked() ? "5" :
                                                        bi.j10412af.isChecked() ? "6" :
                                                                "0");
        j2.put("j10412b",
                bi.j10412ba.isChecked() ? "1" :
                        bi.j10412bb.isChecked() ? "2" :
                                bi.j10412bc.isChecked() ? "3" :
                                        bi.j10412bd.isChecked() ? "4" :
                                                bi.j10412be.isChecked() ? "5" :
                                                        bi.j10412bf.isChecked() ? "6" :
                                                                bi.j10412bg.isChecked() ? "7" :
                                                                        bi.j10412b96.isChecked() ? "96" :
                                                                                "0");
        j2.put("j10412b96x", bi.j10412b96x.getText().toString());

        j2.put("j10413d", bi.j10413d.getText().toString());
        j2.put("j10413m", bi.j10413m.getText().toString());
        j2.put("j10413y", bi.j10413y.getText().toString());

        j2.put("j10413a",
                bi.j10413aa.isChecked() ? "1" :
                        bi.j10413ab.isChecked() ? "2" :
                                bi.j10413ac.isChecked() ? "3" :
                                        bi.j10413ad.isChecked() ? "4" :
                                                bi.j10413ae.isChecked() ? "5" :
                                                        bi.j10413af.isChecked() ? "6" :
                                                                "0");
        j2.put("j10413b",
                bi.j10413ba.isChecked() ? "1" :
                        bi.j10413bb.isChecked() ? "2" :
                                bi.j10413bc.isChecked() ? "3" :
                                        bi.j10413bd.isChecked() ? "4" :
                                                bi.j10413be.isChecked() ? "5" :
                                                        bi.j10413bf.isChecked() ? "6" :
                                                                bi.j10413bg.isChecked() ? "7" :
                                                                        bi.j10413b96.isChecked() ? "96" :
                                                                                "0");
        j2.put("j10413b96x", bi.j10413b96x.getText().toString());

        j2.put("j10414d", bi.j10414d.getText().toString());
        j2.put("j10414m", bi.j10414m.getText().toString());
        j2.put("j10414y", bi.j10414y.getText().toString());

        j2.put("j10414a",
                bi.j10414aa.isChecked() ? "1" :
                        bi.j10414ab.isChecked() ? "2" :
                                bi.j10414ac.isChecked() ? "3" :
                                        bi.j10414ad.isChecked() ? "4" :
                                                bi.j10414ae.isChecked() ? "5" :
                                                        bi.j10414af.isChecked() ? "6" :
                                                                "0");
        j2.put("j10414b",
                bi.j10414ba.isChecked() ? "1" :
                        bi.j10414bb.isChecked() ? "2" :
                                bi.j10414bc.isChecked() ? "3" :
                                        bi.j10414bd.isChecked() ? "4" :
                                                bi.j10414be.isChecked() ? "5" :
                                                        bi.j10414bf.isChecked() ? "6" :
                                                                bi.j10414bg.isChecked() ? "7" :
                                                                        bi.j10414b96.isChecked() ? "96" :
                                                                                "0");
        j2.put("j10414b96x", bi.j10414b96x.getText().toString());

        j2.put("j10415d", bi.j10415d.getText().toString());
        j2.put("j10415m", bi.j10415m.getText().toString());
        j2.put("j10415y", bi.j10415y.getText().toString());

        j2.put("j10415a",
                bi.j10415aa.isChecked() ? "1" :
                        bi.j10415ab.isChecked() ? "2" :
                                bi.j10415ac.isChecked() ? "3" :
                                        bi.j10415ad.isChecked() ? "4" :
                                                bi.j10415ae.isChecked() ? "5" :
                                                        bi.j10415af.isChecked() ? "6" :
                                                                "0");
        j2.put("j10415b",
                bi.j10415ba.isChecked() ? "1" :
                        bi.j10415bb.isChecked() ? "2" :
                                bi.j10415bc.isChecked() ? "3" :
                                        bi.j10415bd.isChecked() ? "4" :
                                                bi.j10415be.isChecked() ? "5" :
                                                        bi.j10415bf.isChecked() ? "6" :
                                                                bi.j10415bg.isChecked() ? "7" :
                                                                        bi.j10415b96.isChecked() ? "96" :
                                                                                "0");
        j2.put("j10415b96x", bi.j10415b96x.getText().toString());

        j2.put("j10416d", bi.j10416d.getText().toString());
        j2.put("j10416m", bi.j10416m.getText().toString());
        j2.put("j10416y", bi.j10416y.getText().toString());

        j2.put("j10416a",
                bi.j10416aa.isChecked() ? "1" :
                        bi.j10416ab.isChecked() ? "2" :
                                bi.j10416ac.isChecked() ? "3" :
                                        bi.j10416ad.isChecked() ? "4" :
                                                bi.j10416ae.isChecked() ? "5" :
                                                        bi.j10416af.isChecked() ? "6" :
                                                                "0");
        j2.put("j10416b",
                bi.j10416ba.isChecked() ? "1" :
                        bi.j10416bb.isChecked() ? "2" :
                                bi.j10416bc.isChecked() ? "3" :
                                        bi.j10416bd.isChecked() ? "4" :
                                                bi.j10416be.isChecked() ? "5" :
                                                        bi.j10416bf.isChecked() ? "6" :
                                                                bi.j10416bg.isChecked() ? "7" :
                                                                        bi.j10416b96.isChecked() ? "96" :
                                                                                "0");
        j2.put("j10416b96x", bi.j10416b96x.getText().toString());

        try {
            JSONObject s4_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.child.getsJ()), j2);

            MainApp.child.setsJ(String.valueOf(s4_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionJ02);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }
}
