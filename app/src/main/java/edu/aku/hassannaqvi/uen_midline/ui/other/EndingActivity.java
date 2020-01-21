package edu.aku.hassannaqvi.uen_midline.ui.other;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.validatorcrawler.aliazaz.Validator;

import java.util.concurrent.ExecutionException;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivityEndingBinding;

public class EndingActivity extends AppCompatActivity {

    ActivityEndingBinding bi;
    Forms fc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_ending);
        bi.setCallback(this);


        Boolean check = getIntent().getExtras().getBoolean("complete");

        if (check) {
            bi.istatusa.setEnabled(true);
            bi.istatusb.setEnabled(false);
        } else {
            bi.istatusa.setEnabled(false);
            bi.istatusb.setEnabled(true);
        }

//
    }

    public void BtnEnd() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void SaveDraft() {

    }

    public boolean UpdateDB() {
//        try {
//            Long longID = new CrudOperations(this, FormsDAO.class.getName(), "formsDao", "updateForm", fc).execute().get();
//            return longID == 1;
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        return true;
    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpEnd);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}
