package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionA2Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionA2Activity extends AppCompatActivity {

    ActivitySectionA2Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a2);
        bi.setCallback(this);

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
                startActivity(new Intent(this, SectionA31Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void BtnEnd() {

        Util.openEndActivity(this);
    }


    private boolean UpdateDB() {

        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesKishMWRAColumn(KishMWRAContract.SingleKishMWRA.COLUMN_SK, MainApp.kish.getsK());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }


    private void SaveDraft() throws JSONException {

        JSONObject f1 = new JSONObject();

        f1.put("a201", bi.a201.getText().toString());

        f1.put("a202", bi.a202.getText().toString());

        f1.put("a203",
                bi.a203a.isChecked() ? "1" :
                        bi.a203b.isChecked() ? "2" :
                                bi.a203c.isChecked() ? "3" :
                                        bi.a203d.isChecked() ? "4" :
                                                bi.a203e.isChecked() ? "5" :
                                                        bi.a203f.isChecked() ? "6" :
                                                                bi.a203g.isChecked() ? "7" :
                                                                        bi.a203h.isChecked() ? "8" :
                                                                                bi.a203i.isChecked() ? "9" :
                                                                                        bi.a203j.isChecked() ? "10" :
                                                                                                bi.a203k.isChecked() ? "11" :
                                                                                                        bi.a203l.isChecked() ? "12" :
                                                                                                                bi.a203m.isChecked() ? "13" :
                                                                                                                        bi.a203n.isChecked() ? "14" :
                                                                                                                                bi.a203x.isChecked() ? "96" :
                                                                                                                                        "0");
        f1.put("a203xt", bi.a203xt.getText().toString());

        f1.put("a204",
                bi.a204a.isChecked() ? "1" :
                        bi.a204b.isChecked() ? "2" :
                                bi.a204c.isChecked() ? "3" :
                                        "0");

        f1.put("a205dd", bi.a205dd.getText().toString());
        f1.put("a205mm", bi.a205mm.getText().toString());
        f1.put("a205yy", bi.a205yy.getText().toString());

        f1.put("a206dd", bi.a206dd.getText().toString());
        f1.put("a206mm", bi.a206mm.getText().toString());
        f1.put("a206yy", bi.a206yy.getText().toString());
        f1.put("a207",

                bi.a207a.isChecked() ? "1" :
                        bi.a207b.isChecked() ? "2" :
                                bi.a207c.isChecked() ? "3" :
                                        bi.a207d.isChecked() ? "4" :
                                                "0");

        f1.put("a208",
                bi.a208a.isChecked() ? "1" :
                        bi.a208b.isChecked() ? "2" :
                                "0");

        f1.put("a209",
                bi.a209a.isChecked() ? "0" :
                        bi.a209b.isChecked() ? "1" :
                                bi.a209c.isChecked() ? "2" :
                                        bi.a209d.isChecked() ? "3" :
                                                bi.a209e.isChecked() ? "4" :
                                                        bi.a209f.isChecked() ? "5" :
                                                                bi.a209g.isChecked() ? "6" :
                                                                        bi.a209h.isChecked() ? "7" :
                                                                                bi.a209i.isChecked() ? "8" :
                                                                                        bi.a209j.isChecked() ? "9" :
                                                                                                bi.a209k.isChecked() ? "10" :
                                                                                                        bi.a209l.isChecked() ? "11" :
                                                                                                                bi.a209m.isChecked() ? "12" :
                                                                                                                        bi.a209n.isChecked() ? "13" :
                                                                                                                                bi.a209o.isChecked() ? "14" :
                                                                                                                                        bi.a209p.isChecked() ? "15" :
                                                                                                                                                bi.a209q.isChecked() ? "16" :
                                                                                                                                                        bi.a209r.isChecked() ? "17" :
                                                                                                                                                                bi.a209s.isChecked() ? "18" :
                                                                                                                                                                        bi.a209t.isChecked() ? "19" :
                                                                                                                                                                                bi.a209u.isChecked() ? "20" :
                                                                                                                                                                                        bi.a209v.isChecked() ? "98" :
                                                                                                                                                                                                bi.a209w.isChecked() ? "97" :
                                                                                                                                                                                                        "0");

        f1.put("a210",
                bi.a210a.isChecked() ? "1" :
                        bi.a210b.isChecked() ? "2" :
                                bi.a210c.isChecked() ? "3" :
                                        bi.a210d.isChecked() ? "4" :
                                                bi.a210e.isChecked() ? "5" :
                                                        bi.a210f.isChecked() ? "6" :
                                                                bi.a210g.isChecked() ? "7" :
                                                                        bi.a210h.isChecked() ? "8" :
                                                                                bi.a210i.isChecked() ? "9" :
                                                                                        bi.a210j.isChecked() ? "10" :
                                                                                                bi.a210k.isChecked() ? "11" :
                                                                                                        bi.a210l.isChecked() ? "12" :
                                                                                                                bi.a210m.isChecked() ? "97" :
                                                                                                                        "0");

        f1.put("a211",
                bi.a211a.isChecked() ? "1" :
                        bi.a211b.isChecked() ? "2" :
                                "0");

        f1.put("a212", bi.a212.getText().toString());
        f1.put("a213", bi.a213.getText().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
