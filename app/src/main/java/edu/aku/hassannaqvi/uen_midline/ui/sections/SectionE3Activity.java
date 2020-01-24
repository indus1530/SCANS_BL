package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionE3Binding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;

public class SectionE3Activity extends AppCompatActivity {

    ActivitySectionE3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e3);
        bi.setCallback(this);

        setUIComponent();

    }

    private void setUIComponent() {

        bi.e116.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == bi.e116a.getId())
                    Clear.clearAllFields(bi.fldGrpSectionE301);
            }
        });

        bi.e117.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().isEmpty()) {
                    MainApp.deathCount = Integer.parseInt(charSequence.toString());
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
                finish();
                if (!bi.e116b.isChecked()) {
                    startActivity(new Intent(this, SectionE4Activity.class));
                } else {

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
        f1.put("e116",
                bi.e116a.isChecked() ? "1" :
                        bi.e116b.isChecked() ? "2" :
                                "0");
        f1.put("e117", bi.e117.getText().toString());
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionE3);
    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
