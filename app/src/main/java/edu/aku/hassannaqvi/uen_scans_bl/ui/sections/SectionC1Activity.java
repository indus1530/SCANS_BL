package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.ChildContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionC1Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionC1Activity extends AppCompatActivity {

    ActivitySectionC1Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c1);
        bi.setCallback(this);

        bi.txtHeadLbl.setText(new StringBuilder(MainApp.indexKishMWRAChild.getName().toUpperCase()).append("\n")
                .append(MainApp.indexKishMWRA.getMother_name().toUpperCase()));

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
                startActivity(new Intent(this, SectionC2Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void BtnEnd() {

        Util.openEndActivity(this);
    }


    private boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long rowID = db.addChild(MainApp.child);
        if (rowID > 0) {
            MainApp.child.set_ID(String.valueOf(rowID));
            MainApp.child.setUID(MainApp.child.getDeviceId() + MainApp.child.get_ID());
            db.updatesChildColumn(ChildContract.SingleChild.COLUMN_UID, MainApp.child.getUID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        MainApp.child = new ChildContract();
        MainApp.child.set_UUID(MainApp.fc.get_UID());
        MainApp.child.setDeviceId(MainApp.appInfo.getDeviceID());
        MainApp.child.setDevicetagID(MainApp.appInfo.getTagName());
        MainApp.child.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        MainApp.child.setUser(MainApp.userName);

        JSONObject f1 = new JSONObject();

        f1.put("hhno", MainApp.fc.getHhno());
        f1.put("cluster", MainApp.fc.getClusterCode());
        f1.put("fm_uid", MainApp.indexKishMWRAChild.getUid());
        f1.put("fm_serial", MainApp.indexKishMWRAChild.getSerialno());
        f1.put("mm_fm_uid", MainApp.indexKishMWRA.getUid());
        f1.put("mm_fm_serial", MainApp.indexKishMWRA.getSerialno());

        f1.put("c101aa", bi.c101aa.getText().toString());
        f1.put("c101ab", bi.c101ab.getText().toString());
        f1.put("c101ba", bi.c101ba.getText().toString());
        f1.put("c101bb", bi.c101bb.getText().toString());

        f1.put("c102",
                bi.c102a.isChecked() ? "1" :
                        bi.c102b.isChecked() ? "2" :
                                bi.c102c.isChecked() ? "3" :
                                        bi.c102d.isChecked() ? "4" :
                                                bi.c102e.isChecked() ? "5" :
                                                        "0");

        f1.put("c103",
                bi.c103a.isChecked() ? "1" :
                        bi.c103b.isChecked() ? "2" :
                                bi.c103c.isChecked() ? "3" :
                                        bi.c103d.isChecked() ? "4" :
                                                bi.c103e.isChecked() ? "5" :
                                                        "0");

        f1.put("c104",
                bi.c104a.isChecked() ? "1" :
                        bi.c104b.isChecked() ? "2" :
                                bi.c104c.isChecked() ? "3" :
                                        bi.c104d.isChecked() ? "4" :
                                                bi.c104e.isChecked() ? "5" :
                                                        "0");

        f1.put("c105",
                bi.c105a.isChecked() ? "1" :
                        bi.c105b.isChecked() ? "2" :
                                bi.c105c.isChecked() ? "3" :
                                        bi.c105d.isChecked() ? "4" :
                                                bi.c105e.isChecked() ? "5" :
                                                        "0");

        f1.put("c106",
                bi.c106a.isChecked() ? "1" :
                        bi.c106b.isChecked() ? "2" :
                                bi.c106c.isChecked() ? "3" :
                                        bi.c106d.isChecked() ? "4" :
                                                bi.c106e.isChecked() ? "5" :
                                                        "0");

        f1.put("c107",
                bi.c107a.isChecked() ? "1" :
                        bi.c107b.isChecked() ? "2" :
                                bi.c107c.isChecked() ? "3" :
                                        bi.c107d.isChecked() ? "4" :
                                                bi.c107e.isChecked() ? "5" :
                                                        "0");

        f1.put("c108",
                bi.c108a.isChecked() ? "1" :
                        bi.c108b.isChecked() ? "2" :
                                bi.c108c.isChecked() ? "3" :
                                        bi.c108d.isChecked() ? "4" :
                                                bi.c108e.isChecked() ? "5" :
                                                        "0");

        f1.put("c109",
                bi.c109a.isChecked() ? "1" :
                        bi.c109b.isChecked() ? "2" :
                                bi.c109c.isChecked() ? "3" :
                                        bi.c109d.isChecked() ? "4" :
                                                bi.c109e.isChecked() ? "5" :
                                                        "0");

        f1.put("c110",
                bi.c110a.isChecked() ? "1" :
                        bi.c110b.isChecked() ? "2" :
                                bi.c110c.isChecked() ? "3" :
                                        bi.c110d.isChecked() ? "4" :
                                                bi.c110e.isChecked() ? "5" :
                                                        "0");

        f1.put("c111",
                bi.c111a.isChecked() ? "1" :
                        bi.c111b.isChecked() ? "2" :
                                bi.c111c.isChecked() ? "3" :
                                        bi.c111d.isChecked() ? "4" :
                                                bi.c111e.isChecked() ? "5" :
                                                        "0");

        f1.put("c112",
                bi.c112a.isChecked() ? "1" :
                        bi.c112b.isChecked() ? "2" :
                                bi.c112c.isChecked() ? "3" :
                                        bi.c112d.isChecked() ? "4" :
                                                bi.c112e.isChecked() ? "5" :
                                                        "0");

        f1.put("c113",
                bi.c113a.isChecked() ? "1" :
                        bi.c113b.isChecked() ? "2" :
                                bi.c113c.isChecked() ? "3" :
                                        bi.c114d.isChecked() ? "4" :
                                                "0");

        MainApp.child.setsC1(String.valueOf(f1));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionC1);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }


}
