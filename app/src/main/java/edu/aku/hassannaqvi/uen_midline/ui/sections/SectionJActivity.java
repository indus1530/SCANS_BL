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
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionJBinding;

public class SectionJActivity extends AppCompatActivity {

    ActivitySectionJBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j);
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
                startActivity(new Intent(this, SectionJ02Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {
        return true;
    }

    private void SaveDraft() throws JSONException {

        JSONObject j1 = new JSONObject();

        j1.put("j101",
                bi.j101a.isChecked() ? "1" :
                        bi.j101b.isChecked() ? "2" :
                                bi.j101c.isChecked() ? "3" :
                                        "0");

        j1.put("j102",
                bi.j102a.isChecked() ? "1" :
                        bi.j102b.isChecked() ? "2" :
                                "0");

        j1.put("j103a", bi.j103a.getText().toString());
        j1.put("j103b", bi.j103b.getText().toString());
        j1.put("j103c", bi.j103c.getText().toString());

        j1.put("j10401", bi.j10401.getText().toString());

        j1.put("j10401a",
                bi.j10401aa.isChecked() ? "1" :
                        bi.j10401ab.isChecked() ? "2" :
                                bi.j10401ac.isChecked() ? "3" :
                                        bi.j10401ad.isChecked() ? "4" :
                                                bi.j10401ae.isChecked() ? "5" :
                                                        bi.j10401af.isChecked() ? "6" :
                                                                "0");

        j1.put("j10401b",
                bi.j10401ba.isChecked() ? "1" :
                        bi.j10401bb.isChecked() ? "2" :
                                bi.j10401bc.isChecked() ? "3" :
                                        bi.j10401bd.isChecked() ? "4" :
                                                bi.j10401be.isChecked() ? "5" :
                                                        bi.j10401bf.isChecked() ? "6" :
                                                                bi.j10401bg.isChecked() ? "7" :
                                                                        bi.j10401b96.isChecked() ? "96" :
                                                                                "0");
        j1.put("j10401b96x", bi.j10401b96x.getText().toString());

        j1.put("j10402", bi.j10402.getText().toString());

        j1.put("j10402a",
                bi.j10402aa.isChecked() ? "1" :
                        bi.j10402ab.isChecked() ? "2" :
                                bi.j10402ac.isChecked() ? "3" :
                                        bi.j10402ad.isChecked() ? "4" :
                                                bi.j10402ae.isChecked() ? "5" :
                                                        bi.j10402af.isChecked() ? "6" :
                                                                "0");

        j1.put("j10402b",
                bi.j10402ba.isChecked() ? "1" :
                        bi.j10402bb.isChecked() ? "2" :
                                bi.j10402bc.isChecked() ? "3" :
                                        bi.j10402bd.isChecked() ? "4" :
                                                bi.j10402be.isChecked() ? "5" :
                                                        bi.j10402bf.isChecked() ? "6" :
                                                                bi.j10402bg.isChecked() ? "7" :
                                                                        bi.j10402b96.isChecked() ? "96" :
                                                                                "0");
        j1.put("j10402b96x", bi.j10402b96x.getText().toString());

        j1.put("j10403", bi.j10403.getText().toString());

        j1.put("j10403a",
                bi.j10403aa.isChecked() ? "1" :
                        bi.j10403ab.isChecked() ? "2" :
                                bi.j10403ac.isChecked() ? "3" :
                                        bi.j10403ad.isChecked() ? "4" :
                                                bi.j10403ae.isChecked() ? "5" :
                                                        bi.j10403af.isChecked() ? "6" :
                                                                "0");

        j1.put("j10403b",
                bi.j10403ba.isChecked() ? "1" :
                        bi.j10403bb.isChecked() ? "2" :
                                bi.j10403bc.isChecked() ? "3" :
                                        bi.j10403bd.isChecked() ? "4" :
                                                bi.j10403be.isChecked() ? "5" :
                                                        bi.j10403bf.isChecked() ? "6" :
                                                                bi.j10403bg.isChecked() ? "7" :
                                                                        bi.j10403b96.isChecked() ? "96" :
                                                                                "0");
        j1.put("j10403b96x", bi.j10403b96x.getText().toString());

        j1.put("j10404", bi.j10404.getText().toString());

        j1.put("j10404a",
                bi.j10404aa.isChecked() ? "1" :
                        bi.j10404ab.isChecked() ? "2" :
                                bi.j10404ac.isChecked() ? "3" :
                                        bi.j10404ad.isChecked() ? "4" :
                                                bi.j10404ae.isChecked() ? "5" :
                                                        bi.j10404af.isChecked() ? "6" :
                                                                "0");

        j1.put("j10404b",
                bi.j10404ba.isChecked() ? "1" :
                        bi.j10404bb.isChecked() ? "2" :
                                bi.j10404bc.isChecked() ? "3" :
                                        bi.j10404bd.isChecked() ? "4" :
                                                bi.j10404be.isChecked() ? "5" :
                                                        bi.j10404bf.isChecked() ? "6" :
                                                                bi.j10404bg.isChecked() ? "7" :
                                                                        bi.j10405b96.isChecked() ? "96" :
                                                                                "0");
        j1.put("j10405b96x", bi.j10405b96x.getText().toString());

        j1.put("j10405", bi.j10405.getText().toString());

        j1.put("j10405a",
                bi.j10405aa.isChecked() ? "1" :
                        bi.j10405ab.isChecked() ? "2" :
                                bi.j10405ac.isChecked() ? "3" :
                                        bi.j10405ad.isChecked() ? "4" :
                                                bi.j10405ae.isChecked() ? "5" :
                                                        bi.j10405af.isChecked() ? "6" :
                                                                "0");


        j1.put("j10405b",
                bi.j10405ba.isChecked() ? "1" :
                        bi.j10405bb.isChecked() ? "2" :
                                bi.j10405bc.isChecked() ? "3" :
                                        bi.j10405bd.isChecked() ? "4" :
                                                bi.j10405be.isChecked() ? "5" :
                                                        bi.j10405bf.isChecked() ? "6" :
                                                                bi.j10405bg.isChecked() ? "7" :
                                                                        bi.j10405b96.isChecked() ? "96" :
                                                                                "0");
        j1.put("j10405b96x", bi.j10405b96x.getText().toString());

        j1.put("j10406", bi.j10406.getText().toString());
        j1.put("j10406a",
                bi.j10406aa.isChecked() ? "1" :
                        bi.j10406ab.isChecked() ? "2" :
                                bi.j10406ac.isChecked() ? "3" :
                                        bi.j10406ad.isChecked() ? "4" :
                                                bi.j10406ae.isChecked() ? "5" :
                                                        bi.j10406af.isChecked() ? "6" :
                                                                "0");
        j1.put("j10406b",
                bi.j10406ba.isChecked() ? "1" :
                        bi.j10406bb.isChecked() ? "2" :
                                bi.j10406bc.isChecked() ? "3" :
                                        bi.j10406bd.isChecked() ? "4" :
                                                bi.j10406be.isChecked() ? "5" :
                                                        bi.j10406bf.isChecked() ? "6" :
                                                                bi.j10406bg.isChecked() ? "7" :
                                                                        bi.j10406bx.isChecked() ? "96" :
                                                                                "0");
        j1.put("j10407", bi.j10407.getText().toString());
        j1.put("j10407a",
                bi.j10407aa.isChecked() ? "1" :
                        bi.j10407ab.isChecked() ? "2" :
                                bi.j10407ac.isChecked() ? "3" :
                                        bi.j10407ad.isChecked() ? "4" :
                                                bi.j10407ae.isChecked() ? "5" :
                                                        bi.j10407af.isChecked() ? "6" :
                                                                "0");
        j1.put("j10407b",
                bi.j10407ba.isChecked() ? "1" :
                        bi.j10407bb.isChecked() ? "2" :
                                bi.j10407bc.isChecked() ? "3" :
                                        bi.j10407bd.isChecked() ? "4" :
                                                bi.j10407be.isChecked() ? "5" :
                                                        bi.j10407bf.isChecked() ? "6" :
                                                                bi.j10407bg.isChecked() ? "7" :
                                                                        bi.j10407bx.isChecked() ? "96" :
                                                                                "0");
        j1.put("j10408", bi.j10408.getText().toString());
        j1.put("j10408a",
                bi.j10408aa.isChecked() ? "1" :
                        bi.j10408ab.isChecked() ? "2" :
                                bi.j10408ac.isChecked() ? "3" :
                                        bi.j10408ad.isChecked() ? "4" :
                                                bi.j10408ae.isChecked() ? "5" :
                                                        bi.j10408af.isChecked() ? "6" :
                                                                "0");
        j1.put("j10408b",
                bi.j10408ba.isChecked() ? "1" :
                        bi.j10408bb.isChecked() ? "2" :
                                bi.j10408bc.isChecked() ? "3" :
                                        bi.j10408bd.isChecked() ? "4" :
                                                bi.j10408be.isChecked() ? "5" :
                                                        bi.j10408bf.isChecked() ? "6" :
                                                                bi.j10408bg.isChecked() ? "7" :
                                                                        bi.j10408bx.isChecked() ? "96" :
                                                                                "0");
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionJ);
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }
}
