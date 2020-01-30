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
import edu.aku.hassannaqvi.uen_midline.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_midline.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionMBinding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;

public class SectionMActivity extends AppCompatActivity {


    ActivitySectionMBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_m);
        bi.setCallback(this);

        setUIComponents();
    }

    private void setUIComponents() {

        bi.m109.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.m109b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVm110, null);
            }
        }));

        bi.m111.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.m111b.getId()) {
                ClearClass.ClearAllFields(bi.fldGrpCVm112, null);
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
                startActivity(new Intent(this, SectionNActivity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SM, MainApp.fc.getsM());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();
        json.put("m101",
                bi.m101a.isChecked() ? "1" :
                        bi.m101b.isChecked() ? "2" :
                                bi.m101c.isChecked() ? "3" :
                                        "0");
        json.put("m102",
                bi.m102a.isChecked() ? "1" :
                        bi.m102b.isChecked() ? "2" :
                                "0");
        json.put("m103",
                bi.m103a.isChecked() ? "1" :
                        bi.m103b.isChecked() ? "2" :
                                bi.m103c.isChecked() ? "3" :
                                        bi.m103d.isChecked() ? "4" :
                                                bi.m103e.isChecked() ? "5" :
                                                        bi.m103f.isChecked() ? "6" :
                                                                bi.m103g.isChecked() ? "7" :
                                                                        bi.m103h.isChecked() ? "8" :
                                                                                bi.m103i.isChecked() ? "9" :
                                                                                        bi.m103j.isChecked() ? "10" :
                                                                                                bi.m103k.isChecked() ? "11" :
                                                                                                        bi.m103l.isChecked() ? "12" :
                                                                                                                bi.m103m.isChecked() ? "13" :
                                                                                                                        bi.m103n.isChecked() ? "14" :
                                                                                                                                "0");
        json.put("m104",
                bi.m104a.isChecked() ? "1" :
                        bi.m104b.isChecked() ? "2" :
                                bi.m104c.isChecked() ? "3" :
                                        bi.m104d.isChecked() ? "4" :
                                                bi.m104e.isChecked() ? "5" :
                                                        bi.m104f.isChecked() ? "6" :
                                                                bi.m104g.isChecked() ? "7" :
                                                                        bi.m104h.isChecked() ? "8" :
                                                                                bi.m104i.isChecked() ? "9" :
                                                                                        bi.m104j.isChecked() ? "10" :
                                                                                                bi.m104k.isChecked() ? "11" :
                                                                                                        bi.m104l.isChecked() ? "12" :
                                                                                                                bi.m104m.isChecked() ? "13" :
                                                                                                                        bi.m104n.isChecked() ? "14" :
                                                                                                                                bi.m104o.isChecked() ? "15" :
                                                                                                                                        "0");
        json.put("m105",
                bi.m105a.isChecked() ? "1" :
                        bi.m105b.isChecked() ? "2" :
                                bi.m105c.isChecked() ? "3" :
                                        bi.m105d.isChecked() ? "4" :
                                                bi.m105e.isChecked() ? "5" :
                                                        bi.m105f.isChecked() ? "6" :
                                                                bi.m105g.isChecked() ? "7" :
                                                                        bi.m105h.isChecked() ? "8" :
                                                                                bi.m105i.isChecked() ? "9" :
                                                                                        bi.m105j.isChecked() ? "10" :
                                                                                                bi.m105k.isChecked() ? "11" :
                                                                                                        bi.m105l.isChecked() ? "12" :
                                                                                                                bi.m105m.isChecked() ? "13" :
                                                                                                                        bi.m105n.isChecked() ? "14" :
                                                                                                                                bi.m105o.isChecked() ? "15" :
                                                                                                                                        bi.m105p.isChecked() ? "16" :
                                                                                                                                                bi.m105q.isChecked() ? "17" :
                                                                                                                                                        bi.m105r.isChecked() ? "18" :
                                                                                                                                                                bi.m105s.isChecked() ? "19" :
                                                                                                                                                                        bi.m105t.isChecked() ? "20" :
                                                                                                                                                                                bi.m105u.isChecked() ? "21" :
                                                                                                                                                                                        "0");
        json.put("m106", bi.m106.getText().toString());
        json.put("m107a",
                bi.m107aa.isChecked() ? "1" :
                        bi.m107ab.isChecked() ? "2" :
                                "0");
        json.put("m107b",
                bi.m107ba.isChecked() ? "1" :
                        bi.m107bb.isChecked() ? "2" :
                                "0");
        json.put("m107c",
                bi.m107ca.isChecked() ? "1" :
                        bi.m107cb.isChecked() ? "2" :
                                "0");
        json.put("m107d",
                bi.m107da.isChecked() ? "1" :
                        bi.m107db.isChecked() ? "2" :
                                "0");
        json.put("m107e",
                bi.m108ea.isChecked() ? "1" :
                        bi.m108eb.isChecked() ? "2" :
                                "0");
        json.put("m107f",
                bi.m107fa.isChecked() ? "1" :
                        bi.m107fb.isChecked() ? "2" :
                                "0");
        json.put("m107g",
                bi.m107ga.isChecked() ? "1" :
                        bi.m107gb.isChecked() ? "2" :
                                "0");
        json.put("m107h",
                bi.m107ha.isChecked() ? "1" :
                        bi.m107hb.isChecked() ? "2" :
                                "0");
        json.put("m107i",
                bi.m107ia.isChecked() ? "1" :
                        bi.m107ib.isChecked() ? "2" :
                                "0");
        json.put("m108",
                bi.m108a.isChecked() ? "1" :
                        bi.m108b.isChecked() ? "2" :
                                "0");
        json.put("m109",
                bi.m109a.isChecked() ? "1" :
                        bi.m109b.isChecked() ? "2" :
                                "0");
        json.put("m110",
                bi.m110a.isChecked() ? "1" :
                        bi.m110b.isChecked() ? "2" :
                                bi.m110c.isChecked() ? "98" :
                                        "0");
        json.put("m110at", bi.m110at.getText().toString());
        json.put("m110bt", bi.m110bt.getText().toString());
        json.put("m111",
                bi.m111a.isChecked() ? "1" :
                        bi.m111b.isChecked() ? "2" :
                                "0");
        json.put("m112a", bi.m112a.getText().toString());
        json.put("m112b", bi.m112b.getText().toString());
        json.put("m112c", bi.m112c.getText().toString());
        json.put("m112d", bi.m112d.getText().toString());
        json.put("m112e", bi.m112e.getText().toString());
        json.put("m112f", bi.m112f.getText().toString());
        json.put("m112g", bi.m112g.getText().toString());
        json.put("m113",
                bi.m113a.isChecked() ? "1" :
                        bi.m113b.isChecked() ? "2" :
                                "0");
        json.put("m114a",
                bi.m114aa.isChecked() ? "1" :
                        bi.m114ab.isChecked() ? "2" :
                                "0");
        json.put("m114b",
                bi.m114ba.isChecked() ? "1" :
                        bi.m114bb.isChecked() ? "2" :
                                "0");
        json.put("m114c",
                bi.m114ca.isChecked() ? "1" :
                        bi.m114cb.isChecked() ? "2" :
                                "0");
        json.put("m114d",
                bi.m114da.isChecked() ? "1" :
                        bi.m114db.isChecked() ? "2" :
                                "0");
        json.put("m114e",
                bi.m114ea.isChecked() ? "1" :
                        bi.m114eb.isChecked() ? "2" :
                                "0");
        json.put("m114f",
                bi.m114fa.isChecked() ? "1" :
                        bi.m114fb.isChecked() ? "2" :
                                "0");
        json.put("m114g",
                bi.m114ga.isChecked() ? "1" :
                        bi.m114gb.isChecked() ? "2" :
                                "0");
        json.put("m114h",
                bi.m114ha.isChecked() ? "1" :
                        bi.m114hb.isChecked() ? "2" :
                                "0");
        json.put("m114i",
                bi.m114ia.isChecked() ? "1" :
                        bi.m114ib.isChecked() ? "2" :
                                "0");
        json.put("m114j",
                bi.m114ja.isChecked() ? "1" :
                        bi.m114jb.isChecked() ? "2" :
                                "0");
        json.put("m114k",
                bi.m114ka.isChecked() ? "1" :
                        bi.m114kb.isChecked() ? "2" :
                                "0");
        json.put("m114l",
                bi.m114la.isChecked() ? "1" :
                        bi.m114lb.isChecked() ? "2" :
                                "0");
        json.put("m114m",
                bi.m114ma.isChecked() ? "1" :
                        bi.m114mb.isChecked() ? "2" :
                                "0");
        json.put("m114n",
                bi.m114na.isChecked() ? "1" :
                        bi.m114nb.isChecked() ? "2" :
                                "0");
        json.put("m114o",
                bi.m114oa.isChecked() ? "1" :
                        bi.m114ob.isChecked() ? "2" :
                                "0");
        json.put("m114p",
                bi.m114pa.isChecked() ? "1" :
                        bi.m114pb.isChecked() ? "2" :
                                "0");
        json.put("m114q",
                bi.m114qa.isChecked() ? "1" :
                        bi.m114qb.isChecked() ? "2" :
                                "0");
        json.put("m114r",
                bi.m114ra.isChecked() ? "1" :
                        bi.m114rb.isChecked() ? "2" :
                                "0");
        json.put("m115",
                bi.m115a.isChecked() ? "1" :
                        bi.m115b.isChecked() ? "2" :
                                bi.m115c.isChecked() ? "3" :
                                        bi.m115d.isChecked() ? "4" :
                                                bi.m115e.isChecked() ? "5" :
                                                        bi.m115f.isChecked() ? "6" :
                                                                bi.m115g.isChecked() ? "7" :
                                                                        bi.m115h.isChecked() ? "8" :
                                                                                bi.m115i.isChecked() ? "9" :
                                                                                        bi.m115j.isChecked() ? "10" :
                                                                                                bi.m115k.isChecked() ? "11" :
                                                                                                        "0");
        json.put("m116",
                bi.m116a.isChecked() ? "1" :
                        bi.m116b.isChecked() ? "2" :
                                bi.m116c.isChecked() ? "3" :
                                        bi.m116d.isChecked() ? "4" :
                                                bi.m116e.isChecked() ? "5" :
                                                        bi.m116f.isChecked() ? "6" :
                                                                bi.m116g.isChecked() ? "7" :
                                                                        bi.m116h.isChecked() ? "8" :
                                                                                "0");

        MainApp.fc.setsM(String.valueOf(json));

    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionM);

    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}
