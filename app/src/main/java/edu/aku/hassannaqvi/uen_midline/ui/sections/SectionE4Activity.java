package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_midline.CONSTANTS;
import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionE4Binding;
import edu.aku.hassannaqvi.uen_midline.utils.DateUtils;
import edu.aku.hassannaqvi.uen_midline.utils.Util;

public class SectionE4Activity extends AppCompatActivity {

    ActivitySectionE4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e4);
        bi.setCallback(this);

        setListeners();


    }

    private void setListeners() {
        bi.e119c.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bi.e120.setEnabled(false);
                bi.e120.setText(null);
                if (bi.e119c.getText().toString().isEmpty()) return;
                if (bi.e119c.getText().toString().equals("00")) {
                    bi.e120.setEnabled(true);
                    return;
                }

                int day = bi.e119a.getText().toString().isEmpty() ? 0 : Integer.valueOf(bi.e119a.getText().toString());
                int month = bi.e119b.getText().toString().isEmpty() ? 0 : Integer.valueOf(bi.e119b.getText().toString());
                int year = bi.e119c.getText().toString().isEmpty() ? 0 : Integer.valueOf(bi.e119c.getText().toString());

                bi.e120.setText(DateUtils.ageInYears(day, month, year));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        bi.e120.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (bi.e120.getText().toString().isEmpty()) return;
                int calAge = Integer.valueOf(bi.e120.getText().toString());
                if (Integer.signum(calAge) == -1) return;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        bi.e119c.setMaxvalue(CONSTANTS.MAXYEAR);
        bi.e119c.setMinvalue(CONSTANTS.MINYEAR);

    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                if (MainApp.deathCount > 0) {
                    finish();
                    startActivity(new Intent(this, SectionE4Activity.class));
                } else {
                    finish();
                    startActivity(new Intent(this, SectionFActivity.class));
                }


            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() throws JSONException {

        JSONObject f1 = new JSONObject();
        f1.put("e118", bi.e118.getText().toString());
        f1.put("e119a", bi.e119a.getText().toString());
        f1.put("e119b", bi.e119b.getText().toString());
        f1.put("e119c", bi.e119c.getText().toString());
        f1.put("e120", bi.e120.getText().toString());
        f1.put("e121",
                bi.e121a.isChecked() ? "1" :
                        bi.e121b.isChecked() ? "2" :
                                bi.e121c.isChecked() ? "3" :
                                        bi.e121d.isChecked() ? "4" :
                                                bi.e121e.isChecked() ? "5" :
                                                        bi.e121f.isChecked() ? "6" :
                                                                bi.e121g.isChecked() ? "7" :
                                                                        bi.e121h.isChecked() ? "98" :
                                                                                bi.e12196.isChecked() ? "96" :
                                                                                        "0");
        f1.put("e12196x", bi.e12196x.getText().toString());
        f1.put("e122",
                bi.e122a.isChecked() ? "1" :
                        bi.e122b.isChecked() ? "2" :
                                bi.e122c.isChecked() ? "3" :
                                        bi.e122d.isChecked() ? "4" :
                                                bi.e122e.isChecked() ? "5" :
                                                        "0");


        --MainApp.deathCount;
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionE4);
    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
