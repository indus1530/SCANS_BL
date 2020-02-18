package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.IndexMWRAContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionB1Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionB1Activity extends AppCompatActivity {

    ActivitySectionB1Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b1);
        bi.setCallback(this);

        setlistener();

        bi.txtHeadLbl.setText(new StringBuilder(MainApp.indexKishMWRA.getName().toUpperCase()));

    }


    private void setlistener() {

        bi.b101.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.b101a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVb102);
            }

        }));

        bi.b103.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.b103a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVb104);
            }
        }));

        bi.b105.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.b105a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVb106);
            }
        }));

        bi.b107.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.b107a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVb108);
            }
        }));

        bi.b109.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.b109a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVb110);
            }
        }));

        bi.b111.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.b111a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVb112);
            }
        }));

        bi.b113.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.b113a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVb114);
            }
        }));

        bi.b115.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.b115a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVb116);
            }
        }));

        bi.b117.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i != bi.b117a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVb118);
            }
        }));

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
                startActivity(new Intent(this, SectionB2Activity.class));
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
        long rowID = db.addMWRA(MainApp.indexMwra);
        if (rowID > 0) {
            MainApp.indexMwra.set_ID(String.valueOf(rowID));
            MainApp.indexMwra.setUID(MainApp.indexMwra.getDeviceId() + MainApp.indexMwra.get_ID());
            db.updatesIndexMWRAColumn(IndexMWRAContract.MWRATable.COLUMN_UID, MainApp.indexMwra.getUID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        MainApp.indexMwra = new IndexMWRAContract();
        MainApp.indexMwra.set_UUID(MainApp.fc.get_UID());
        MainApp.indexMwra.setDeviceId(MainApp.appInfo.getDeviceID());
        MainApp.indexMwra.setDevicetagID(MainApp.appInfo.getTagName());
        MainApp.indexMwra.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        MainApp.indexMwra.setUser(MainApp.userName);

        JSONObject f1 = new JSONObject();

        f1.put("hhno", MainApp.fc.getHhno());
        f1.put("cluster_no", MainApp.fc.getClusterCode());
        f1.put("_luid", MainApp.fc.getLuid());
        f1.put("fm_uid", MainApp.indexKishMWRA.getUid());
        f1.put("fm_serial", MainApp.indexKishMWRA.getSerialno());
        f1.put("fm_name", MainApp.indexKishMWRA.getName());

        f1.put("b101",
                bi.b101a.isChecked() ? "1" :
                        bi.b101b.isChecked() ? "2" :
                                bi.b10198.isChecked() ? "98" :
                                        bi.b10199.isChecked() ? "99" :
                                                "0");

        f1.put("b102",
                bi.b102a.isChecked() ? "1" :
                        bi.b102b.isChecked() ? "2" :
                                bi.b102c.isChecked() ? "3" :
                                        "0");

        f1.put("b103",
                bi.b103a.isChecked() ? "1" :
                        bi.b103b.isChecked() ? "2" :
                                bi.b10398.isChecked() ? "98" :
                                        bi.b10399.isChecked() ? "99" :
                                                "0");

        f1.put("b104",
                bi.b104a.isChecked() ? "1" :
                        bi.b104b.isChecked() ? "2" :
                                bi.b104c.isChecked() ? "3" :
                                        "0");

        f1.put("b105",
                bi.b105a.isChecked() ? "1" :
                        bi.b105b.isChecked() ? "2" :
                                bi.b10598.isChecked() ? "98" :
                                        bi.b10599.isChecked() ? "99" :
                                                "0");

        f1.put("b106",
                bi.b106a.isChecked() ? "1" :
                        bi.b106b.isChecked() ? "2" :
                                bi.b106c.isChecked() ? "3" :
                                        "0");

        f1.put("b107",
                bi.b107a.isChecked() ? "1" :
                        bi.b107b.isChecked() ? "2" :
                                bi.b10798.isChecked() ? "98" :
                                        bi.b10799.isChecked() ? "99" :
                                                "0");

        f1.put("b108",
                bi.b108a.isChecked() ? "1" :
                        bi.b108b.isChecked() ? "2" :
                                bi.b108c.isChecked() ? "3" :
                                        "0");

        f1.put("b109",
                bi.b109a.isChecked() ? "1" :
                        bi.b109b.isChecked() ? "2" :
                                bi.b10998.isChecked() ? "98" :
                                        bi.b10999.isChecked() ? "99" :
                                                "0");

        f1.put("b110",
                bi.b110a.isChecked() ? "1" :
                        bi.b110b.isChecked() ? "2" :
                                bi.b110c.isChecked() ? "3" :
                                        "0");

        f1.put("b111",
                bi.b111a.isChecked() ? "1" :
                        bi.b111b.isChecked() ? "2" :
                                bi.b11198.isChecked() ? "98" :
                                        bi.b11199.isChecked() ? "99" :
                                                "0");

        f1.put("b112",
                bi.b112a.isChecked() ? "1" :
                        bi.b112b.isChecked() ? "2" :
                                bi.b112c.isChecked() ? "3" :
                                        "0");

        f1.put("b113",
                bi.b113a.isChecked() ? "1" :
                        bi.b113b.isChecked() ? "2" :
                                bi.b11398.isChecked() ? "98" :
                                        bi.b11399.isChecked() ? "99" :
                                                "0");

        f1.put("b114",
                bi.b114a.isChecked() ? "1" :
                        bi.b114b.isChecked() ? "2" :
                                bi.b114c.isChecked() ? "3" :
                                        "0");

        f1.put("b115",
                bi.b115a.isChecked() ? "1" :
                        bi.b115b.isChecked() ? "2" :
                                bi.b11598.isChecked() ? "98" :
                                        bi.b11599.isChecked() ? "99" :
                                                "0");

        f1.put("b116",
                bi.b116a.isChecked() ? "1" :
                        bi.b116b.isChecked() ? "2" :
                                bi.b116c.isChecked() ? "3" :
                                        "0");

        f1.put("b117",
                bi.b117a.isChecked() ? "1" :
                        bi.b117b.isChecked() ? "2" :
                                bi.b11798.isChecked() ? "98" :
                                        bi.b11799.isChecked() ? "99" :
                                                "0");

        f1.put("b118",
                bi.b118a.isChecked() ? "1" :
                        bi.b118b.isChecked() ? "2" :
                                bi.b118c.isChecked() ? "3" :
                                        "0");

        MainApp.indexMwra.setsB1(String.valueOf(f1));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionB1);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }


}
