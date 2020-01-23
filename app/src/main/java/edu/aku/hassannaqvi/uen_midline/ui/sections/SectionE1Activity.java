package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionE1Binding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;

public class SectionE1Activity extends AppCompatActivity {

    ActivitySectionE1Binding bi;
    List<String> womanNames;
    Map<String, String> womanMap;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e1);
        bi.setCallback(this);

        setUIComponent();
    }

    private void setUIComponent() {

        bi.womanSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MainApp.pragnantWoman));

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
                if (!bi.e101b.isChecked()) {
                    if (MainApp.pragnantWoman.size() > 0) {
                        finish();
                        startActivity(new Intent(SectionE1Activity.this, SectionE2Activity.class));
                        MainApp.pragnantWoman.remove(position);

                    } else {
                        finish();
                        startActivity(new Intent(SectionE1Activity.this, SectionE3Activity.class));
                    }
                } else {
                    if (MainApp.pragnantWoman.size() > 0) {
                        finish();
                        startActivity(new Intent(SectionE1Activity.this, SectionE1Activity.class));
                        MainApp.pragnantWoman.remove(position);
                    } else {
                        finish();
                        startActivity(new Intent(SectionE1Activity.this, SectionE3Activity.class));
                    }

                }

            }


        }
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() throws JSONException {

        JSONObject f1 = new JSONObject();
        f1.put("e101",
                bi.e101a.isChecked() ?"1" :
                        bi.e101b.isChecked() ?"2" :
                                "0");
        f1.put("e102", bi.e102.getText().toString());
        f1.put("e102a",
                bi.e102aa.isChecked() ?"1" :
                        bi.e102ab.isChecked() ?"2" :
                                "0");

    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionE1);

    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }


}
