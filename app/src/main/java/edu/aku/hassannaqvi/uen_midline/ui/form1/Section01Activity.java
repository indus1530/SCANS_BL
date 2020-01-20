package edu.aku.hassannaqvi.uen_midline.ui.form1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_midline.contracts.ChildList;
import edu.aku.hassannaqvi.uen_midline.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_midline.validator.ValidatorClass;
import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivityF1Section01Binding;

public class Section01Activity extends AppCompatActivity {

    ActivityF1Section01Binding bi;
    ChildList childData;
    private String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_f1_section01);
        bi.setCallback(this);

        setupViews();
    }

    private void setupViews() {


    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
//                if (bi.RS16a.isChecked()) {
//                    finish();
//                    startActivity(new Intent(this, EndingActivity.class));
//                } else {
//                    Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
//                }
            }
        }
    }


    public void BtnEnd() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }


    }


    private boolean UpdateDB() {

//        DatabaseHelper db = new DatabaseHelper(this);
//        long updcount = db.addForm(MainApp.fc);
//
//        MainApp.fc.set_ID(String.valueOf(updcount));
//        if (updcount != 0) {
//            MainApp.fc.set_UID(
//                    (MainApp.fc.getDeviceID() + MainApp.fc.get_ID()));
//            db.updateFormID();
//            return true;
//        } else {
//            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
//            return false;
//        }

        return true;
    }


    private void SaveDraft() throws JSONException {


    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.ll01);
    }

}

