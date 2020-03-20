package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

import edu.aku.hassannaqvi.uen_scans_bl.CONSTANTS;
import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.EnumBlockContract;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionInfoBinding;
import edu.aku.hassannaqvi.uen_scans_bl.viewmodel.MainRepository;

import static edu.aku.hassannaqvi.uen_scans_bl.utils.SDCardUtilsExtensionsKt.checkSDCardAvailability;
import static edu.aku.hassannaqvi.uen_scans_bl.utils.SDCardUtilsExtensionsKt.getImageSaveDirectory;

public class SectionInfoActivity extends AppCompatActivity {

    ActivitySectionInfoBinding bi;
    private DatabaseHelper db;
    ArrayList<FamilyMembersContract> famList;
    private int selectedBTN;
    public static File outputDirectory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_info);
        bi.setCallback(this);
        db = MainApp.appInfo.getDbHelper();

        setUIComponent();
    }

    private void setUIComponent() {

        bi.a101.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (bi.a101.getText().hashCode() == s.hashCode()) {
                    Clear.clearAllFields(bi.fldGrpSectionA01);
                    bi.fldGrpSectionA01.setVisibility(View.GONE);
                    bi.btnNext.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        bi.a112.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (Objects.requireNonNull(bi.a112.getText()).hashCode() == s.hashCode()) {
                    bi.btnNext.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        selectedBTN = getIntent().getIntExtra(CONSTANTS.MAIN_INTENT, 0);

    }

    public void BtnContinue() {
        if (selectedBTN == 1) new MainRepository(this, famList);
        else if (selectedBTN == 2) startActivity(new Intent(this, SectionLActivity.class));
        else if (selectedBTN == 3) startActivity(new Intent(this, SectionMActivity.class));
        else storageSelection();
    }

    private void storageSelection() {
        //CheckSDCard and assigning directory name
        boolean value = checkSDCardAvailability(this);
        if (!value) {
            Toast.makeText(this, "Attach SD-Card", Toast.LENGTH_SHORT).show();
            return;
        }
        outputDirectory = getImageSaveDirectory(this, MainApp.indexKishMWRA.getClusterno(), MainApp.indexKishMWRA.getHhno());
//        outputDirectory = getImageSaveDirectory(this, "5901", "0059-001");
        String error_msg = "Can't able to create folder. Kindly contact IT Services.";
        if (outputDirectory == null) {
            Toast.makeText(this, error_msg, Toast.LENGTH_SHORT).show();
            return;
        } else if (!outputDirectory.exists()) {
            Toast.makeText(this, error_msg, Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(new Intent(this, SectionDentalActivity.class));
    }

    public void BtnCheckCluster() {

//        storageSelection();

        if (!Validator.emptyTextBox(this, bi.a101)) return;
        boolean loginFlag;
        int cluster = Integer.parseInt(bi.a101.getText().toString());
        if (cluster <= 5000) {
            loginFlag = !(MainApp.userName.equals("test1234") || MainApp.userName.equals("dmu@aku") || MainApp.userName.substring(0, 4).equals("user"));
        } else {
            loginFlag = MainApp.userName.equals("test1234") || MainApp.userName.equals("dmu@aku") || MainApp.userName.substring(0, 4).equals("user");
        }
        if (!loginFlag) {
            Toast.makeText(this, "Can't proceed test cluster for current user!!", Toast.LENGTH_SHORT).show();
            return;
        }

        EnumBlockContract enumBlockContract = db.getEnumBlock(bi.a101.getText().toString());
        if (enumBlockContract != null) {
            String selected = enumBlockContract.getGeoarea();
            if (!selected.equals("")) {

                String[] selSplit = selected.split("\\|");

                bi.fldGrpSectionA01.setVisibility(View.VISIBLE);
                bi.a104.setText(selSplit[0]);
                bi.a105.setText(selSplit[1].equals("") ? "----" : selSplit[1]);
                bi.a106.setText(selSplit[2].equals("") ? "----" : selSplit[2]);
                bi.a107.setText(selSplit[3]);

            }
        } else {
            Toast.makeText(this, "Sorry cluster not found!!", Toast.LENGTH_SHORT).show();
        }

    }

    public void BtnCheckHH() {
        if (!Validator.emptyTextBox(this, bi.a112)) return;


        if (!MainApp.appInfo.getDbHelper().getExistForm(bi.a101.getText().toString(), bi.a112.getText().toString().toUpperCase())) {
            Toast.makeText(this, "No HH found. Kindly do household collection first!!", Toast.LENGTH_LONG).show();
            return;
        }


        MainApp.indexKishMWRA = db.getFamilyMember(bi.a101.getText().toString(), bi.a112.getText().toString().toUpperCase(), "1", null);
        if (MainApp.indexKishMWRA == null) {
            Toast.makeText(this, "No Household found!", Toast.LENGTH_SHORT).show();
            bi.btnNext.setVisibility(View.GONE);
            return;
        }

        if (selectedBTN == 1) {
            famList = MainApp.appInfo.getDbHelper().getFamilyMemberList(bi.a101.getText().toString(), bi.a112.getText().toString().toUpperCase(), MainApp.indexKishMWRA);
            if (famList.size() == 0) {
                Toast.makeText(this, "No Members found!", Toast.LENGTH_SHORT).show();
                return;
            }
            famList.add(MainApp.indexKishMWRA);
        } else {
            MainApp.indexKishMWRAChild = db.getFamilyMember(bi.a101.getText().toString(), bi.a112.getText().toString().toUpperCase(), "2", MainApp.indexKishMWRA);
        }
        Toast.makeText(this, "Members Found!", Toast.LENGTH_SHORT).show();
        bi.btnNext.setVisibility(View.VISIBLE);
    }
}
