package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionE2Binding;
import edu.aku.hassannaqvi.uen_midline.databinding.ItemDialogBinding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;

public class SectionE2Activity extends AppCompatActivity {

    ActivitySectionE2Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e2);
        bi.setCallback(this);

        setUIComponent();
    }

    private void setUIComponent() {

        bi.e105.setOnCheckedChangeListener(((radioGroup, i) -> {
            MainApp.twinFlag = i == bi.e105c.getId();
        }));

    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (MainApp.twinFlag) {
                if (UpdateDB()) {
                    openDialog();
                }
            } else {
                MainApp.counter++;
                startActivity(new Intent(SectionE2Activity.this, SectionE2Activity.class));
            }


        }
    }

    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.item_dialog, null);
        ItemDialogBinding bin = DataBindingUtil.bind(view.getRootView());
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();
        bin.okBtn.setOnClickListener(view1 -> {
            clearContainer();
            dialog.dismiss();

        });
    }

    private void clearContainer() {
        ClearClass.ClearAllFields(bi.container1, null);
        ClearClass.ClearAllFields(bi.mainContainer2, null);
        bi.container1.requestFocus();
        MainApp.twinFlag = false;

    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() throws JSONException {

        JSONObject e2 = new JSONObject();

        //e2.put("e103", bi.e103.getText().toString());

        e2.put("e104",
                bi.e104a.isChecked() ? "1" :
                        bi.e104b.isChecked() ? "2" :
                                "0");

        e2.put("e105",
                bi.e105a.isChecked() ? "1" :
                        bi.e105b.isChecked() ? "2" :
                                bi.e105c.isChecked() ? "3" :
                                        "0");

        e2.put("e106a", bi.e106a.getText().toString());
        e2.put("e106b", bi.e106b.getText().toString());
        e2.put("e106c", bi.e106c.getText().toString());

        e2.put("e107",
                bi.e107a.isChecked() ? "1" :
                        bi.e107b.isChecked() ? "2" :
                                "0");

        e2.put("e108",
                bi.e108a.isChecked() ? "1" :
                        bi.e108b.isChecked() ? "2" :
                                "0");

        e2.put("e109", bi.e109.getText().toString());

        e2.put("e110a", bi.e110a.getText().toString());
        e2.put("e110b", bi.e110b.getText().toString());
        e2.put("e110c", bi.e110c.getText().toString());

        e2.put("e111",
                bi.e111a.isChecked() ? "1" :
                        bi.e111b.isChecked() ? "2" :
                                bi.e111c.isChecked() ? "3" :
                                        bi.e111d.isChecked() ? "4" :
                                                bi.e111e.isChecked() ? "5" :
                                                        bi.e111f.isChecked() ? "6" :
                                                                bi.e111g.isChecked() ? "7" :
                                                                        bi.e11196.isChecked() ? "96" :
                                                                                "0");
        e2.put("e11196x", bi.e11196x.getText().toString());

        e2.put("e112",
                bi.e112a.isChecked() ? "1" :
                        bi.e112b.isChecked() ? "2" :
                                bi.e112c.isChecked() ? "3" :
                                        bi.e112d.isChecked() ? "4" :
                                                bi.e112e.isChecked() ? "5" :
                                                        "0");

        e2.put("e113", bi.e113.getText().toString());

        e2.put("e114", bi.e114.getText().toString());

        e2.put("e115",
                bi.e115a.isChecked() ? "1" :
                        bi.e115b.isChecked() ? "2" :
                                "0");


    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionE2);

    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }
}
