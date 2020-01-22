package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionJ02Binding;

public class SectionJ02Activity extends AppCompatActivity {


    ActivitySectionJ02Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j02);
        bi.setCallback(this);

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
        return true;
    }

    private void SaveDraft() throws JSONException {

        JSONObject j2 = new JSONObject();

        j2.put("j10409", bi.j10409.getText().toString());
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

        j2.put("j10410", bi.j10410.getText().toString());

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

        j2.put("j10411", bi.j10411.getText().toString());

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

        j2.put("j10412", bi.j10412.getText().toString());
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

        j2.put("j10413", bi.j10413.getText().toString());

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

        j2.put("j10414", bi.j10414.getText().toString());

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

        j2.put("j10415", bi.j10415.getText().toString());

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

        j2.put("j10416", bi.j10416.getText().toString());

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

    }

    private boolean formValidation() {

//        re
        return true;
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }
}
