package edu.aku.hassannaqvi.uen_midline.ui.sections;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionDBinding;
import edu.aku.hassannaqvi.uen_midline.ui.list_activity.FamilyMembersListActivity;
import edu.aku.hassannaqvi.uen_midline.utils.DateUtils;
import edu.aku.hassannaqvi.uen_midline.viewmodel.MainVModel;
import kotlin.Pair;

import static edu.aku.hassannaqvi.uen_midline.CONSTANTS.SERIAL_EXTRA;

public class SectionDActivity extends AppCompatActivity {

    ActivitySectionDBinding bi;
    private MainVModel mainVModel;
    private FamilyMembersContract fmc;
    private boolean fmcFLAG = false;
    private int serial = 0;
    private Pair<List<Integer>, List<String>> menSLst;
    private Pair<List<Integer>, List<String>> womenSLst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d);
        bi.setCallback(this);

        setUIComponent();
        setListeners();
    }

    private void setUIComponent() {
//        mainVModel = ViewModelProviders.of(FamilyMembersListActivity.Companion.getContext()).get(MainVModel.class);
        mainVModel = FamilyMembersListActivity.Companion.getMainVModel();

        serial = getIntent().getIntExtra(SERIAL_EXTRA, 0);
        bi.d101.setText(String.valueOf(serial));
        fmc = mainVModel.getMemberInfo(serial);
        fmcFLAG = fmc == null;

        if (fmcFLAG) {
            bi.fldGrpSectionD01.setVisibility(View.VISIBLE);
            bi.fldGrpSectionD02.setVisibility(View.GONE);
            fmc = new FamilyMembersContract();
        } else {
            bi.fldGrpSectionD01.setVisibility(View.GONE);
            bi.fldGrpSectionD02.setVisibility(View.VISIBLE);

            menSLst = mainVModel.getAllMenWomenName02(1, Integer.valueOf(fmc.getSerialno()));
            womenSLst = mainVModel.getAllMenWomenName02(2, Integer.valueOf(fmc.getSerialno()));

            List<String> menLst = new ArrayList<String>() {
                {
                    add("....");
                    add("NA");
                    if (menSLst != null) addAll(menSLst.getSecond());
                }
            };
            List<String> womenLst = new ArrayList<String>() {
                {
                    add("....");
                    add("NA");
                    if (womenSLst != null) addAll(womenSLst.getSecond());
                }
            };

            /*List<FamilyMembersContract> allMen = mainVModel.getAllMenWomen(1);
            List<FamilyMembersContract> allWomen = mainVModel.getAllMenWomen(2);*/

            bi.d106.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, menLst));
            bi.d107.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, womenLst));
        }

        if (serial == 1) {
            Clear.clearAllFields(bi.d103, false);
            bi.d103a.setChecked(true);
            bi.d109.setMinvalue(15);
        }

    }

    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            setResult(RESULT_OK);
            finish();
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() throws JSONException {

        if (fmcFLAG) {
            fmc.setSerialno(bi.d101.getText().toString());
            fmc.setName(bi.d102.getText().toString());
            fmc.setName(bi.d102.getText().toString());
            fmc.setRelHH(bi.d103a.isChecked() ? "1" :
                    bi.d103b.isChecked() ? "2" :
                            bi.d103c.isChecked() ? "3" :
                                    bi.d103d.isChecked() ? "4" :
                                            bi.d103e.isChecked() ? "5" :
                                                    bi.d103f.isChecked() ? "6" :
                                                            bi.d103g.isChecked() ? "7" :
                                                                    bi.d103h.isChecked() ? "8" :
                                                                            bi.d103i.isChecked() ? "9" :
                                                                                    bi.d103j.isChecked() ? "10" :
                                                                                            bi.d103k.isChecked() ? "11" :
                                                                                                    bi.d103l.isChecked() ? "12" :
                                                                                                            bi.d103m.isChecked() ? "13" :
                                                                                                                    bi.d103n.isChecked() ? "14" :
                                                                                                                            bi.d103o.isChecked() ? "15" : "0");
            fmc.setGender(
                    bi.d104a.isChecked() ? "1" :
                            bi.d104b.isChecked() ? "2" : "0");

            fmc.setAge("0");

            // Update in ViewModel
            mainVModel.setFamilyMembers(fmc);
            return;
        }

        fmc.setMarital(
                bi.d105a.isChecked() ? "1" :
                        bi.d105b.isChecked() ? "2" :
                                bi.d105c.isChecked() ? "3" :
                                        bi.d105d.isChecked() ? "4" :
                                                "0");

        JSONObject sd = new JSONObject();

        sd.put("d106", menSLst.getFirst().size() != 0 && bi.d106.getSelectedItemPosition() != 1 ? mainVModel.getMemberInfo(menSLst.getFirst().get(bi.d106.getSelectedItemPosition() - 2)) : "97");
        fmc.setmName(bi.d106.getSelectedItem().toString());
        sd.put("d107", womenSLst.getFirst().size() != 0 && bi.d107.getSelectedItemPosition() != 1 ? mainVModel.getMemberInfo(womenSLst.getFirst().get(bi.d107.getSelectedItemPosition() - 2)) : "97");
        fmc.setfName(bi.d107.getSelectedItem().toString());
        sd.put("d108a", bi.d108a.getText().toString());
        sd.put("d108b", bi.d108b.getText().toString());
        sd.put("d108c", bi.d108c.getText().toString());
        sd.put("d109", bi.d109.getText().toString());
        fmc.setAge(bi.d109.getText().toString());
        sd.put("d110",
                bi.d110a.isChecked() ? "0" :
                        bi.d110b.isChecked() ? "1" :
                                bi.d110c.isChecked() ? "2" :
                                        bi.d110d.isChecked() ? "3" :
                                                bi.d110e.isChecked() ? "4" :
                                                        bi.d110f.isChecked() ? "5" :
                                                                bi.d110g.isChecked() ? "6" :
                                                                        bi.d110h.isChecked() ? "7" :
                                                                                bi.d110i.isChecked() ? "8" :
                                                                                        bi.d110j.isChecked() ? "9" :
                                                                                                bi.d110k.isChecked() ? "10" :
                                                                                                        bi.d110l.isChecked() ? "98" :
                                                                                                                bi.d110m.isChecked() ? "99" :
                                                                                                                        "0");
        sd.put("d111",
                bi.d111a.isChecked() ? "1" :
                        bi.d111b.isChecked() ? "2" :
                                bi.d111c.isChecked() ? "3" :
                                        bi.d111d.isChecked() ? "4" :
                                                bi.d111e.isChecked() ? "5" :
                                                        bi.d111f.isChecked() ? "6" :
                                                                bi.d111g.isChecked() ? "6" :
                                                                        bi.d111h.isChecked() ? "8" :
                                                                                bi.d111i.isChecked() ? "9" :
                                                                                        bi.d111j.isChecked() ? "99" :
                                                                                                "0");
        fmc.setsD(String.valueOf(sd));

        // Update in ViewModel
        mainVModel.updateFamilyMembers(fmc);

        if (Integer.valueOf(fmc.getAge()) > 15 && Integer.valueOf(fmc.getAge()) < 49 && fmc.getGender().equals("2") && !bi.d105b.isChecked())
            mainVModel.setMWRA(fmc);
        else if (Integer.valueOf(fmc.getAge()) < 5)
            mainVModel.setChildU5(fmc);

    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionD);
    }

    public void BtnEnd() {
        finish();
    }

    private void setListeners() {
        bi.d108c.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bi.d109.setEnabled(false);
                bi.d109.setText(null);
                if (bi.d108c.getText().toString().isEmpty()) return;
                if (bi.d108c.getText().toString().equals("00")) {
                    bi.d109.setEnabled(true);
                    return;
                }

                int day = bi.d108a.getText().toString().isEmpty() ? 0 : Integer.valueOf(bi.d108a.getText().toString());
                int month = bi.d108b.getText().toString().isEmpty() ? 0 : Integer.valueOf(bi.d108b.getText().toString());
                int year = bi.d108c.getText().toString().isEmpty() ? 0 : Integer.valueOf(bi.d108c.getText().toString());

                bi.d109.setText(DateUtils.ageInYears(day, month, year));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        bi.d105.setOnCheckedChangeListener((group, checkedId) -> {
            if (fmc.getGender().equals("2") && !bi.d105b.isChecked())
                bi.d111a.setEnabled(true);
            else {
                bi.d111a.setEnabled(false);
                bi.d111a.setChecked(false);
            }
        });

        bi.d109.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (bi.d109.getText().toString().isEmpty()) return;
                int calAge = Integer.valueOf(bi.d109.getText().toString());
                if (Integer.signum(calAge) == -1) return;
                personInfoFunctionality(calAge);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void personInfoFunctionality(int calAge) {
        if (calAge > 2) bi.fldGrpSectionD03.setVisibility(View.VISIBLE);
        else bi.fldGrpSectionD03.setVisibility(View.GONE);
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (fmcFLAG) {
            serial--;
            super.onBackPressed();
            return true;
        } else {
            Toast.makeText(this, "You can't go back!!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Press top back button.", Toast.LENGTH_SHORT).show();
    }
}
