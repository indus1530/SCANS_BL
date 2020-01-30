package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.contracts.KishMWRAContract;
import edu.aku.hassannaqvi.uen_midline.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionGBinding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;

public class SectionGActivity extends AppCompatActivity {

    ActivitySectionGBinding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g);
        bi.setCallback(this);

        setupSkips();

    }


    private void setupSkips() {

        //g102
        bi.g102.setOnCheckedChangeListener((group, checkedId) -> {
            ClearClass.ClearAllFields(bi.fldGrpCVg103, null);
            ClearClass.ClearAllFields(bi.fldGrpCVg104, null);
            ClearClass.ClearAllFields(bi.fldGrpCVg105, null);
            ClearClass.ClearAllFields(bi.fldGrpCVg106, null);
            ClearClass.ClearAllFields(bi.fldGrpCVg107, null);
            bi.fldGrpCVg103.setVisibility(View.GONE);
            bi.fldGrpCVg104.setVisibility(View.GONE);
            bi.fldGrpCVg105.setVisibility(View.GONE);
            bi.fldGrpCVg106.setVisibility(View.GONE);
            bi.fldGrpCVg107.setVisibility(View.GONE);

            if (checkedId == bi.g102a.getId()) {
                bi.fldGrpCVg103.setVisibility(View.VISIBLE);
            } else {
                bi.fldGrpCVg104.setVisibility(View.VISIBLE);
                bi.fldGrpCVg105.setVisibility(View.VISIBLE);
                bi.fldGrpCVg106.setVisibility(View.VISIBLE);
                bi.fldGrpCVg107.setVisibility(View.VISIBLE);
            }
        });


        //g110
        bi.g110.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.g110a.getId()) {
                bi.fldGrpCVg111.setVisibility(View.VISIBLE);
                bi.fldGrpCVg112.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVg111, null);
                ClearClass.ClearAllFields(bi.fldGrpCVg112, null);
                bi.fldGrpCVg111.setVisibility(View.GONE);
                bi.fldGrpCVg112.setVisibility(View.GONE);
            }
        });


        //g111
        bi.g111.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.g111a.getId()) {
                bi.fldGrpCVg112.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVg112, null);
                bi.fldGrpCVg112.setVisibility(View.GONE);
            }
        });


        //g113
        bi.g113.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.g113a.getId()) {
                bi.fldGrpCVg114.setVisibility(View.VISIBLE);
                bi.fldGrpCVg115.setVisibility(View.VISIBLE);
                bi.fldGrpCVg116.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVg114, null);
                ClearClass.ClearAllFields(bi.fldGrpCVg115, null);
                ClearClass.ClearAllFields(bi.fldGrpCVg116, null);
                bi.fldGrpCVg114.setVisibility(View.GONE);
                bi.fldGrpCVg115.setVisibility(View.GONE);
                bi.fldGrpCVg116.setVisibility(View.GONE);
            }
        });


        //g115
        bi.g115.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.g115a.getId()) {
                bi.fldGrpCVg116.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVg116, null);
                bi.fldGrpCVg116.setVisibility(View.GONE);
            }
        });


        //g119
        bi.g119.setOnCheckedChangeListener((group, checkedId) -> {

            ClearClass.ClearAllFields(bi.fldGrpCVg120, null);
            ClearClass.ClearAllFields(bi.fldGrpCVg121, null);
            bi.fldGrpCVg120.setVisibility(View.GONE);
            bi.fldGrpCVg121.setVisibility(View.GONE);

            if (checkedId == bi.g119a.getId()) {
                bi.fldGrpCVg120.setVisibility(View.VISIBLE);
            } else {
                bi.fldGrpCVg121.setVisibility(View.VISIBLE);
            }
        });


        //g122
        bi.g122.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.g122a.getId()) {
                bi.fldGrpCVg123.setVisibility(View.VISIBLE);
                bi.fldGrpCVg124.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVg123, null);
                ClearClass.ClearAllFields(bi.fldGrpCVg124, null);
                bi.fldGrpCVg123.setVisibility(View.GONE);
                bi.fldGrpCVg124.setVisibility(View.GONE);
            }
        });


        //g126
        bi.g126.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == bi.g126a.getId()) {
                bi.fldGrpCVg127.setVisibility(View.VISIBLE);
            } else {
                ClearClass.ClearAllFields(bi.fldGrpCVg127, null);
                bi.fldGrpCVg127.setVisibility(View.GONE);
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
                finish();
                startActivity(new Intent(this, SectionH1Activity.class));
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
        int updcount = db.updatesKishMWRAColumn(KishMWRAContract.SingleKishMWRA.COLUMN_SG, MainApp.kish.getsG());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("g101", bi.g101a.isChecked() ? "1" :
                bi.g101b.isChecked() ? "2" : "0");

        json.put("g102", bi.g102a.isChecked() ? "1" :
                bi.g102b.isChecked() ? "2" :
                                bi.g102c.isChecked() ? "3" :
                                        bi.g102d.isChecked() ? "4" :
                                                bi.g102e.isChecked() ? "5" : "0");

        json.put("g103a", bi.g103a.isChecked() ? "1" : "0");
        json.put("g103b", bi.g103b.isChecked() ? "2" : "0");
        json.put("g103c", bi.g103c.isChecked() ? "3" : "0");
        json.put("g103d", bi.g103d.isChecked() ? "4" : "0");
        json.put("g103e", bi.g103e.isChecked() ? "5" : "0");
        json.put("g103f", bi.g103f.isChecked() ? "6" : "0");
        json.put("g103g", bi.g103g.isChecked() ? "7" : "0");
        json.put("g103h", bi.g103h.isChecked() ? "8" : "0");
        json.put("g103i", bi.g103i.isChecked() ? "9" : "0");

        json.put("g104", bi.g104a.isChecked() ? "1" :
                bi.g104b.isChecked() ? "2" :
                                bi.g104c.isChecked() ? "3" :
                                        bi.g104d.isChecked() ? "4" :
                                                bi.g104e.isChecked() ? "5" : "0");

        json.put("g105", bi.g105.getText().toString());

        json.put("g106", bi.g106a.isChecked() ? "1" :
                bi.g106b.isChecked() ? "2" :
                                bi.g106c.isChecked() ? "3" :
                                        bi.g106d.isChecked() ? "4" : "0");

        json.put("g107", bi.g107.getText().toString());

        json.put("g108", bi.g108a.isChecked() ? "1" :
                bi.g108b.isChecked() ? "2" : "0");

        json.put("g109", bi.g109a.isChecked() ? "1" :
                bi.g109b.isChecked() ? "2" :
                                bi.g109c.isChecked() ? "3" :
                                        bi.g109d.isChecked() ? "4" : "0");

        json.put("g110", bi.g110a.isChecked() ? "1" :
                bi.g110b.isChecked() ? "2" :
                        bi.g11098.isChecked() ? "98" : "0");

        json.put("g111", bi.g111a.isChecked() ? "1" :
                bi.g111b.isChecked() ? "2" : "0");

        json.put("g112", bi.g112.getText().toString());

        json.put("g113", bi.g113a.isChecked() ? "1" :
                bi.g113b.isChecked() ? "2" :
                        bi.g11398.isChecked() ? "98" : "0");

        json.put("g114", bi.g114a.isChecked() ? "1" :
                bi.g114b.isChecked() ? "2" :
                                bi.g114c.isChecked() ? "3" :
                                        bi.g114d.isChecked() ? "4" :
                                                bi.g114e.isChecked() ? "5" :
                                                        bi.g114f.isChecked() ? "6" :
                                                                bi.g114g.isChecked() ? "7" :
                                                                        bi.g114h.isChecked() ? "8" : "0");

        json.put("g115", bi.g115a.isChecked() ? "1" :
                bi.g115b.isChecked() ? "2" : "0");

        json.put("g116", bi.g116a.isChecked() ? "1" :
                bi.g116b.isChecked() ? "2" :
                                bi.g116c.isChecked() ? "3" :
                                        bi.g116d.isChecked() ? "4" :
                                                bi.g116e.isChecked() ? "5" : "0");

        json.put("g117a", bi.g117a.getText().toString());
        json.put("g117b", bi.g117b.getText().toString());
        json.put("g117c", bi.g117c.getText().toString());

        json.put("g118", bi.g118.getText().toString());

        json.put("g119", bi.g119a.isChecked() ? "1" :
                bi.g119b.isChecked() ? "2" :
                        bi.g119c.isChecked() ? "3" : "0");

        json.put("g120", bi.g120a.isChecked() ? "1" :
                bi.g120b.isChecked() ? "2" :
                                bi.g120c.isChecked() ? "3" :
                                        bi.g120d.isChecked() ? "4" :
                                                bi.g120e.isChecked() ? "5" :
                                                        bi.g120f.isChecked() ? "6" :
                                                                bi.g120g.isChecked() ? "7" :
                                                                        bi.g12096.isChecked() ? "96" : "0");

        json.put("g12096x", bi.g12096x.getText().toString());

        json.put("g121", bi.g121a.isChecked() ? "1" :
                bi.g121b.isChecked() ? "2" :
                                bi.g121c.isChecked() ? "3" :
                                        bi.g121d.isChecked() ? "4" :
                                                bi.g121e.isChecked() ? "5" :
                                                        bi.g121f.isChecked() ? "6" :
                                                                bi.g121g.isChecked() ? "7" :
                                                                        bi.g121h.isChecked() ? "8" :
                                                                                bi.g12196.isChecked() ? "96" : "0");
        json.put("g12196x", bi.g12196x.getText().toString());

        json.put("g122", bi.g122a.isChecked() ? "1" :
                bi.g122b.isChecked() ? "2" : "0");

        json.put("g123a", bi.g123a.isChecked() ? "1" : "0");
        json.put("g123b", bi.g123b.isChecked() ? "2" : "0");
        json.put("g123c", bi.g123c.isChecked() ? "3" : "0");
        json.put("g123d", bi.g123d.isChecked() ? "4" : "0");
        json.put("g123e", bi.g123e.isChecked() ? "5" : "0");
        json.put("g123f", bi.g123f.isChecked() ? "6" : "0");
        json.put("g123g", bi.g123g.isChecked() ? "7" : "0");

        json.put("g124a", bi.g124a.isChecked() ? "1" : "0");
        json.put("g124b", bi.g124b.isChecked() ? "2" : "0");
        json.put("g124c", bi.g124c.isChecked() ? "3" : "0");
        json.put("g124d", bi.g124d.isChecked() ? "4" : "0");
        json.put("g124e", bi.g124e.isChecked() ? "5" : "0");
        json.put("g124f", bi.g124f.isChecked() ? "6" : "0");
        json.put("g124g", bi.g124g.isChecked() ? "7" : "0");
        json.put("g124h", bi.g124h.isChecked() ? "8" : "0");
        json.put("g124i", bi.g124i.isChecked() ? "9" : "0");
        json.put("g124j", bi.g124j.isChecked() ? "10" : "0");
        json.put("g124k", bi.g124k.isChecked() ? "11" : "0");
        json.put("g124l", bi.g124l.isChecked() ? "12" : "0");
        json.put("g124m", bi.g124m.isChecked() ? "13" : "0");

        json.put("g125", bi.g125a.isChecked() ? "1" :
                bi.g125b.isChecked() ? "2" : "0");

        json.put("g126", bi.g126a.isChecked() ? "1" :
                bi.g126b.isChecked() ? "2" :
                        bi.g12697.isChecked() ? "97" : "0");

        json.put("g127", bi.g127a.isChecked() ? "1" :
                bi.g127b.isChecked() ? "2" : "0");

        json.put("g128", bi.g128a.isChecked() ? "1" :
                bi.g128b.isChecked() ? "2" : "0");

        json.put("g129", bi.g129a.isChecked() ? "1" :
                bi.g129b.isChecked() ? "2" : "0");

        MainApp.kish.setsG(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }


}
