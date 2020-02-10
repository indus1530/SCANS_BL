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
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionB3Binding;
import edu.aku.hassannaqvi.uen_scans_bl.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionB3Activity extends AppCompatActivity {

    ActivitySectionB3Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b3);
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
                startActivity(new Intent(this, SectionC1Activity.class));
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

        f1.put("b301a", bi.b301a.isChecked() ? "1" : "0");
        f1.put("b301b", bi.b301b.isChecked() ? "2" : "0");
        f1.put("b301c", bi.b301c.isChecked() ? "3" : "0");
        f1.put("b301d", bi.b301d.isChecked() ? "4" : "0");
        f1.put("b301e", bi.b301e.isChecked() ? "5" : "0");
        f1.put("b301f", bi.b301f.isChecked() ? "6" : "0");
        f1.put("b301g", bi.b301g.isChecked() ? "7" : "0");
        f1.put("b301h", bi.b301h.isChecked() ? "8" : "0");
        f1.put("b301x", bi.b30196.isChecked() ? "96" : "0");
        f1.put("b301xt", bi.b30196x.getText().toString());

        f1.put("b302a", bi.b302a.isChecked() ? "1" : "0");
        f1.put("b302b", bi.b302b.isChecked() ? "2" : "0");
        f1.put("b302c", bi.b302c.isChecked() ? "3" : "0");
        f1.put("b302d", bi.b302d.isChecked() ? "4" : "0");
        f1.put("b302e", bi.b302e.isChecked() ? "5" : "0");
        f1.put("b302f", bi.b302f.isChecked() ? "6" : "0");
        f1.put("b302g", bi.b302g.isChecked() ? "7" : "0");
        f1.put("b302h", bi.b302h.isChecked() ? "8" : "0");
        f1.put("b302x", bi.b30296.isChecked() ? "96" : "0");
        f1.put("b302xt", bi.b30296x.getText().toString());

        f1.put("b303a", bi.b303a.isChecked() ? "1" : "0");
        f1.put("b303b", bi.b303b.isChecked() ? "2" : "0");
        f1.put("b303c", bi.b303c.isChecked() ? "3" : "0");
        f1.put("b303d", bi.b303d.isChecked() ? "4" : "0");
        f1.put("b303e", bi.b303e.isChecked() ? "5" : "0");
        f1.put("b303f", bi.b303f.isChecked() ? "6" : "0");
        f1.put("b303g", bi.b303g.isChecked() ? "7" : "0");
        f1.put("b303h", bi.b303h.isChecked() ? "8" : "0");
        f1.put("b303x", bi.b30396.isChecked() ? "96" : "0");
        f1.put("b303xt", bi.b30396x.getText().toString());

        f1.put("b304a", bi.b304a.isChecked() ? "1" : "0");
        f1.put("b304b", bi.b304b.isChecked() ? "2" : "0");
        f1.put("b304c", bi.b304c.isChecked() ? "3" : "0");
        f1.put("b304d", bi.b304d.isChecked() ? "4" : "0");
        f1.put("b304e", bi.b304e.isChecked() ? "5" : "0");
        f1.put("b304f", bi.b304f.isChecked() ? "6" : "0");
        f1.put("b304g", bi.b304g.isChecked() ? "7" : "0");
        f1.put("b304h", bi.b304h.isChecked() ? "8" : "0");
        f1.put("b304x", bi.b30496.isChecked() ? "96" : "0");
        f1.put("b304xt", bi.b30496x.getText().toString());

        f1.put("b305a", bi.b305a.isChecked() ? "1" : "0");
        f1.put("b305b", bi.b305b.isChecked() ? "2" : "0");
        f1.put("b305c", bi.b305c.isChecked() ? "3" : "0");
        f1.put("b305d", bi.b305d.isChecked() ? "4" : "0");
        f1.put("b305e", bi.b305e.isChecked() ? "5" : "0");
        f1.put("b305f", bi.b305f.isChecked() ? "6" : "0");
        f1.put("b305g", bi.b305g.isChecked() ? "7" : "0");
        f1.put("b305h", bi.b305h.isChecked() ? "8" : "0");
        f1.put("b305x", bi.b30596.isChecked() ? "96" : "0");
        f1.put("b305xt", bi.b30596x.getText().toString());

        f1.put("b306a", bi.b306a.isChecked() ? "1" : "0");
        f1.put("b306b", bi.b306b.isChecked() ? "2" : "0");
        f1.put("b306c", bi.b306c.isChecked() ? "3" : "0");
        f1.put("b306d", bi.b306d.isChecked() ? "4" : "0");
        f1.put("b306e", bi.b306e.isChecked() ? "5" : "0");
        f1.put("b306f", bi.b306f.isChecked() ? "6" : "0");
        f1.put("b306g", bi.b306g.isChecked() ? "7" : "0");
        f1.put("b306h", bi.b306h.isChecked() ? "8" : "0");
        f1.put("b306x", bi.b30696.isChecked() ? "96" : "0");
        f1.put("b306xt", bi.b30696x.getText().toString());

        f1.put("b307a", bi.b307a.isChecked() ? "1" : "0");
        f1.put("b307b", bi.b307b.isChecked() ? "2" : "0");
        f1.put("b307c", bi.b307c.isChecked() ? "3" : "0");
        f1.put("b307d", bi.b307d.isChecked() ? "4" : "0");
        f1.put("b307e", bi.b307e.isChecked() ? "5" : "0");
        f1.put("b307f", bi.b307f.isChecked() ? "6" : "0");
        f1.put("b307g", bi.b307g.isChecked() ? "7" : "0");
        f1.put("b307h", bi.b307h.isChecked() ? "8" : "0");
        f1.put("b307x", bi.b30796.isChecked() ? "96" : "0");
        f1.put("b307xt", bi.b30796x.getText().toString());

        f1.put("b308a", bi.b308a.isChecked() ? "1" : "0");
        f1.put("b308b", bi.b308b.isChecked() ? "2" : "0");
        f1.put("b308c", bi.b308c.isChecked() ? "3" : "0");
        f1.put("b308d", bi.b308d.isChecked() ? "4" : "0");
        f1.put("b308e", bi.b308e.isChecked() ? "5" : "0");
        f1.put("b308f", bi.b308f.isChecked() ? "6" : "0");
        f1.put("b308g", bi.b308g.isChecked() ? "7" : "0");
        f1.put("b308h", bi.b308h.isChecked() ? "8" : "0");
        f1.put("b308x", bi.b30896.isChecked() ? "96" : "0");
        f1.put("b308xt", bi.b30896x.getText().toString());

        f1.put("b309a", bi.b309a.isChecked() ? "1" : "0");
        f1.put("b309b", bi.b309b.isChecked() ? "2" : "0");
        f1.put("b309c", bi.b309c.isChecked() ? "3" : "0");
        f1.put("b309d", bi.b309d.isChecked() ? "4" : "0");
        f1.put("b309e", bi.b309e.isChecked() ? "5" : "0");
        f1.put("b309f", bi.b309f.isChecked() ? "6" : "0");
        f1.put("b309g", bi.b309g.isChecked() ? "7" : "0");
        f1.put("b309h", bi.b309h.isChecked() ? "8" : "0");
        f1.put("b309x", bi.b30996.isChecked() ? "96" : "0");
        f1.put("b309xt", bi.b30996x.getText().toString());

        f1.put("b310a", bi.b310a.isChecked() ? "1" : "0");
        f1.put("b310b", bi.b310b.isChecked() ? "2" : "0");
        f1.put("b310c", bi.b310c.isChecked() ? "3" : "0");
        f1.put("b310d", bi.b310d.isChecked() ? "4" : "0");
        f1.put("b310e", bi.b310e.isChecked() ? "5" : "0");
        f1.put("b310f", bi.b310f.isChecked() ? "6" : "0");
        f1.put("b310g", bi.b310g.isChecked() ? "7" : "0");
        f1.put("b310h", bi.b310h.isChecked() ? "8" : "0");
        f1.put("b310x", bi.b31096.isChecked() ? "96" : "0");
        f1.put("b310xt", bi.b31096x.getText().toString());

        f1.put("b311a", bi.b311a.isChecked() ? "1" : "0");
        f1.put("b311b", bi.b311b.isChecked() ? "2" : "0");
        f1.put("b311c", bi.b311c.isChecked() ? "3" : "0");
        f1.put("b311d", bi.b311d.isChecked() ? "4" : "0");
        f1.put("b311e", bi.b311e.isChecked() ? "5" : "0");
        f1.put("b311f", bi.b311f.isChecked() ? "6" : "0");
        f1.put("b311g", bi.b311g.isChecked() ? "7" : "0");
        f1.put("b311h", bi.b311h.isChecked() ? "8" : "0");
        f1.put("b311x", bi.b31196.isChecked() ? "96" : "0");
        f1.put("b311xt", bi.b31196x.getText().toString());

        f1.put("b312a", bi.b312a.isChecked() ? "1" : "0");
        f1.put("b312b", bi.b312b.isChecked() ? "2" : "0");
        f1.put("b312c", bi.b312c.isChecked() ? "3" : "0");
        f1.put("b312d", bi.b312d.isChecked() ? "4" : "0");
        f1.put("b312e", bi.b312e.isChecked() ? "5" : "0");
        f1.put("b312f", bi.b312f.isChecked() ? "6" : "0");
        f1.put("b312g", bi.b312g.isChecked() ? "7" : "0");
        f1.put("b312h", bi.b312h.isChecked() ? "8" : "0");
        f1.put("b312x", bi.b31296.isChecked() ? "96" : "0");
        f1.put("b312xt", bi.b31296x.getText().toString());

        f1.put("b313a", bi.b313a.isChecked() ? "1" : "0");
        f1.put("b313b", bi.b313b.isChecked() ? "2" : "0");
        f1.put("b313c", bi.b313c.isChecked() ? "3" : "0");
        f1.put("b313d", bi.b313d.isChecked() ? "4" : "0");
        f1.put("b313e", bi.b313e.isChecked() ? "5" : "0");
        f1.put("b313f", bi.b313f.isChecked() ? "6" : "0");
        f1.put("b313g", bi.b313g.isChecked() ? "7" : "0");
        f1.put("b313h", bi.b313h.isChecked() ? "8" : "0");
        f1.put("b313x", bi.b31396.isChecked() ? "96" : "0");
        f1.put("b313xt", bi.b31396x.getText().toString());

        f1.put("b314a", bi.b314a.isChecked() ? "1" : "0");
        f1.put("b314b", bi.b314b.isChecked() ? "2" : "0");
        f1.put("b314c", bi.b314c.isChecked() ? "3" : "0");
        f1.put("b314d", bi.b314d.isChecked() ? "4" : "0");
        f1.put("b314e", bi.b314e.isChecked() ? "5" : "0");
        f1.put("b314f", bi.b314f.isChecked() ? "6" : "0");
        f1.put("b314g", bi.b314g.isChecked() ? "7" : "0");
        f1.put("b314h", bi.b314h.isChecked() ? "8" : "0");
        f1.put("b314x", bi.b31496.isChecked() ? "96" : "0");
        f1.put("b314xt", bi.b31496x.getText().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionB3);

    }


    /*@Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }*/


}
