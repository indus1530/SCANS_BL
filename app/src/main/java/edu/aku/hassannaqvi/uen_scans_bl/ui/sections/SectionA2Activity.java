package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionA2Binding;
import edu.aku.hassannaqvi.uen_scans_bl.datecollection.AgeModel;
import edu.aku.hassannaqvi.uen_scans_bl.datecollection.DateRepository;
import edu.aku.hassannaqvi.uen_scans_bl.ui.list_activity.FamilyMembersListActivity;
import edu.aku.hassannaqvi.uen_scans_bl.viewmodel.MainVModel;
import kotlin.Pair;

import static edu.aku.hassannaqvi.uen_scans_bl.CONSTANTS.SERIAL_EXTRA;

public class SectionA2Activity extends AppCompatActivity {

    ActivitySectionA2Binding bi;
    private MainVModel mainVModel;
    private FamilyMembersContract fmc;
    private boolean fmcFLAG = false;
    private int serial = 0;
    private Pair<List<Integer>, List<String>> menSLst;
    private Pair<List<Integer>, List<String>> womenSLst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a2);
        bi.setCallback(this);

        setUIComponent();
        setListeners();
    }

    private void setUIComponent() {
        mainVModel = FamilyMembersListActivity.Companion.getMainVModel();
        serial = getIntent().getIntExtra(SERIAL_EXTRA, 0);
        bi.a201.setText(String.valueOf(serial));
        fmc = mainVModel.getMemberInfo(serial);
        fmcFLAG = fmc == null;

        if (fmcFLAG) {
            bi.fldGrpSectionD01.setVisibility(View.VISIBLE);
            bi.fldGrpSectionD02.setVisibility(View.GONE);
            fmc = new FamilyMembersContract();
        } else {
            bi.a202Name.setText(new StringBuilder(fmc.getName().toUpperCase()).append("\n")
                    .append(getResources().getString(R.string.a201))
                    .append(":")
                    .append(fmc.getSerialno()));
            bi.fldGrpSectionD01.setVisibility(View.GONE);
            bi.fldGrpSectionD02.setVisibility(View.VISIBLE);

            menSLst = mainVModel.getAllMenWomenName(1, Integer.parseInt(fmc.getSerialno()));
            womenSLst = mainVModel.getAllMenWomenName(2, Integer.parseInt(fmc.getSerialno()));

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

            bi.a212.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, menLst));
            bi.a213.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, womenLst));
        }

        if (serial == 1) {
            Clear.clearAllFields(bi.a203, false);
            bi.a203a.setChecked(true);
            bi.a206.setMinvalue(18);
        }

    }

    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (fmcFLAG) {
            setResult(RESULT_OK, new Intent().putExtra(SERIAL_EXTRA, serial));
            finish();
        } else {
            if (UpdateDB()) {
                setResult(RESULT_OK);
                finish();
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addFamilyMember(fmc);
        fmc.set_id(String.valueOf(updcount));
        if (updcount > 0) {
            fmc.setUid(MainApp.deviceId + fmc.get_id());
            db.updatesFamilyMemberColumn(FamilyMembersContract.SingleMember.COLUMN_UID, fmc.getUid(), fmc.get_id());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    private void SaveDraft() throws JSONException {

        if (fmcFLAG) {
            fmc.setUuid(MainApp.fc.get_UID());
            fmc.setLuid(MainApp.fc.getLuid());
            fmc.setClusterno(MainApp.fc.getClusterCode());
            fmc.setHhno(MainApp.fc.getHhno());
            fmc.setSerialno(bi.a201.getText().toString());
            fmc.setName(bi.a202.getText().toString());
            fmc.setRelHH(bi.a203a.isChecked() ? "1" :
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
                                                                                                                            bi.a20396.isChecked() ? "15" : "0");

            fmc.setGender(
                    bi.a204a.isChecked() ? "1" :
                            bi.a204b.isChecked() ? "2" :
                                    bi.a204c.isChecked() ? "3" : "0");

            if (serial == 1) FamilyMembersListActivity.Companion.setGenderFlag(fmc.getGender());

            fmc.setAge("-1");

            // Update in ViewModel
            mainVModel.setFamilyMembers(fmc);
            serial++;
            return;
        }

        fmc.setMarital(
                bi.a207a.isChecked() ? "1" :
                        bi.a207b.isChecked() ? "2" :
                                bi.a207c.isChecked() ? "3" :
                                        bi.a207d.isChecked() ? "4" : "0");

        JSONObject sd = new JSONObject();

        sd.put("formdate", MainApp.fc.getFormDate());
        sd.put("username", MainApp.userName);
        sd.put("deviceid", MainApp.appInfo.getDeviceID());
        sd.put("tagid", MainApp.appInfo.getTagName());
        sd.put("appversion", MainApp.appInfo.getAppVersion());

        FamilyMembersContract motherFMC = null;
//        if (bi.fldGrpCVa212.getVisibility() == View.VISIBLE) {
        sd.put("a212", menSLst.getFirst().size() != 0 && bi.a212.getSelectedItemPosition() != 1
                ? mainVModel.getMemberInfo(menSLst.getFirst().get(bi.a212.getSelectedItemPosition() - 2)).getSerialno() : "97");
        fmc.setfName(bi.a212.getSelectedItem().toString());

        motherFMC = womenSLst.getFirst().size() != 0 && bi.a213.getSelectedItemPosition() != 1
                ? mainVModel.getMemberInfo(womenSLst.getFirst().get(bi.a213.getSelectedItemPosition() - 2)) : null;
        String motherSerial = womenSLst.getFirst().size() != 0 && bi.a213.getSelectedItemPosition() != 1
                ? mainVModel.getMemberInfo(womenSLst.getFirst().get(bi.a213.getSelectedItemPosition() - 2)).getSerialno() : "97";
        fmc.setMother_name(bi.a213.getSelectedItem().toString());
        sd.put("a213", motherSerial);
        fmc.setMother_serial(motherSerial);
        /*} else {
            sd.put("a212", "0");
            sd.put("a213", "0");
        }*/

        sd.put("a205a", bi.a205a.getText().toString());
        sd.put("a205b", bi.a205b.getText().toString());
        sd.put("a205c", bi.a205c.getText().toString());
        sd.put("a206", bi.a206.getText().toString());
        sd.put("a206a", bi.a206a.getText().toString());
        fmc.setAge(bi.a206.getText().toString());

        sd.put("a208", bi.a208a.isChecked() ? "1"
                : bi.a208b.isChecked() ? "2"
                : "0");

        sd.put("a209", bi.a209a.isChecked() ? "0" :
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
                                                                                                                                                                                        bi.a209w.isChecked() ? "97" : "0");
        sd.put("a210", bi.a210a.isChecked() ? "1" :
                bi.a210b.isChecked() ? "2" :
                        bi.a210c.isChecked() ? "3" :
                                bi.a210d.isChecked() ? "4" :
                                        bi.a210e.isChecked() ? "5" :
                                                bi.a210f.isChecked() ? "6" :
                                                        bi.a210g.isChecked() ? "6" :
                                                                bi.a210h.isChecked() ? "8" :
                                                                        bi.a210i.isChecked() ? "9" :
                                                                                bi.a210j.isChecked() ? "10" :
                                                                                        bi.a210k.isChecked() ? "11" :
                                                                                                bi.a210l.isChecked() ? "12" :
                                                                                                        bi.a210m.isChecked() ? "99" : "0");

        sd.put("a211", bi.a211a.isChecked() ? "1" : bi.a211b.isChecked() ? "2" : "0");

        fmc.setAvailable(bi.a211a.isChecked() ? "1" : bi.a211b.isChecked() ? "2" : "0");

        fmc.setsD(String.valueOf(sd));

        // Update in ViewModel
        mainVModel.updateFamilyMembers(fmc);

        if (Integer.parseInt(fmc.getAge()) >= 15 && Integer.parseInt(fmc.getAge()) < 60 && fmc.getGender().equals("2") && !bi.a207b.isChecked())
            mainVModel.setMWRA(fmc);
        else if (Integer.parseInt(fmc.getAge()) >= 5 && Integer.parseInt(fmc.getAge()) < 10) {
            mainVModel.setChildU5to10(fmc);
            if (motherFMC == null) return;
            if (Integer.parseInt(motherFMC.getAge()) >= 15 && Integer.parseInt(motherFMC.getAge()) < 60)
                mainVModel.setMwraChildU5to10(motherFMC);
        }

    }

    private boolean formValidation() {
        if (fmcFLAG) return Validator.emptyCheckingContainer(this, bi.fldGrpSectionD);
        else {
            if (!Validator.emptyCheckingContainer(this, bi.fldGrpSectionD))
                return false;
            return Validator.emptyEditTextPicker(this, bi.a206);
        }
    }

    public void BtnEnd() {
        finish();
    }

    private void setListeners() {
        EditText[] txtListener = new EditText[]{bi.a205a, bi.a205b};
        for (EditText txtItem : txtListener) {

            txtItem.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    bi.a206.setText(null);
                    bi.a206a.setText(null);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

        }

        bi.a205c.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bi.a206.setEnabled(false);
                bi.a206a.setEnabled(false);
                bi.a206.setText(null);
                bi.a206a.setText(null);
                if (bi.a205a.getText().toString().isEmpty() || bi.a205b.getText().toString().isEmpty() || bi.a205c.getText().toString().isEmpty())
                    return;
                if (bi.a205a.getText().toString().equals("98") && bi.a205b.getText().toString().equals("98") && bi.a205c.getText().toString().equals("9998")) {
                    bi.a206.setEnabled(true);
                    bi.a206a.setEnabled(true);
                    return;
                }

                int day = bi.a205a.getText().toString().equals("98") ? 0 : Integer.parseInt(bi.a205a.getText().toString());
                int month = Integer.parseInt(bi.a205b.getText().toString());
                int year = Integer.parseInt(bi.a205c.getText().toString());

                AgeModel age = DateRepository.Companion.getCalculatedAge(year, month, day);
                if (age == null) return;
                bi.a206.setText(String.valueOf(age.getYear()));
                bi.a206a.setText(String.valueOf(age.getMonth()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        bi.a207.setOnCheckedChangeListener((group, checkedId) -> {
            if (fmc.getGender().equals("2") && !bi.a207b.isChecked())
                bi.a210a.setEnabled(true);
            else {
                bi.a210a.setEnabled(false);
                bi.a210a.setChecked(false);
            }
        });

        bi.a206.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (bi.a206.getText().toString().isEmpty()) return;
                int calAge = Integer.parseInt(bi.a206.getText().toString());
                if (Integer.signum(calAge) == -1) return;
                personInfoFunctionality(calAge);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        bi.a208.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.a208a.getId()) {
                bi.fldGrpCVa209.setVisibility(View.VISIBLE);
            } else {
                bi.a209.clearCheck();
                bi.fldGrpCVa209.setVisibility(View.GONE);
            }
        });

        bi.a203.setOnCheckedChangeListener((group, checkedID) -> {
            Clear.clearAllFields(bi.a204, true);
            if (serial == 2) {

                if (checkedID == bi.a203b.getId()) {

                    String gender = FamilyMembersListActivity.Companion.getGenderFlag();
                    if (!gender.equals("3")) Clear.clearAllFields(bi.a204, false);
                    switch (gender) {
                        case "1":
                            bi.a204b.setChecked(true);
                            break;
                        case "2":
                            bi.a204a.setChecked(true);
                            break;
                    }

                }

            }
        });

    }

    private void personInfoFunctionality(int calAge) {

        bi.fldGrpCVa207.setVisibility(View.GONE);
        bi.fldGrpCVa208.setVisibility(View.GONE);
        bi.fldGrpCVa209.setVisibility(View.GONE);
        bi.fldGrpCVa210.setVisibility(View.GONE);
        Clear.clearAllFields(bi.fldGrpSectionD03);

        if (calAge >= 3 && calAge < 10) {
            bi.fldGrpCVa208.setVisibility(View.VISIBLE);
            bi.fldGrpCVa209.setVisibility(View.VISIBLE);
        } else if (calAge == 10) {
            bi.fldGrpCVa210.setVisibility(View.VISIBLE);
        } else if (calAge > 10) {
            bi.fldGrpCVa210.setVisibility(View.VISIBLE);
            bi.fldGrpCVa207.setVisibility(View.VISIBLE);
            bi.fldGrpCVa208.setVisibility(View.VISIBLE);
            bi.fldGrpCVa209.setVisibility(View.VISIBLE);
        }

        /*Clear.clearAllFields(bi.a209, false);
        Clear.clearAllFields(bi.a210, false);

        if (calAge > 0 && calAge <= 2) {
            bi.a209a.setEnabled(true);
            bi.a209b.setEnabled(true);
            bi.a209m.setEnabled(true);
            bi.a210j.setEnabled(true);
            bi.a210g.setEnabled(true);
        }

        if (calAge > 2 && calAge <= 5) {
            bi.a209a.setEnabled(true);
            bi.a209b.setEnabled(true);
            bi.a209c.setEnabled(true);
            bi.a209m.setEnabled(true);
            bi.a210g.setEnabled(true);
            bi.a210j.setEnabled(true);
        }

        if (calAge > 5 && calAge <= 10) {
            bi.a209a.setEnabled(true);
            bi.a209d.setEnabled(true);
            bi.a209e.setEnabled(true);
            bi.a209l.setEnabled(true);
            bi.a209m.setEnabled(true);
            bi.a210g.setEnabled(true);
            bi.a210j.setEnabled(true);

            bi.a209b.setEnabled(true);
            bi.a209c.setEnabled(true);
        }

        if (calAge > 10 && calAge <= 20) {
            bi.a209a.setEnabled(true);
            bi.a209e.setEnabled(true);
            bi.a209f.setEnabled(true);
            bi.a209g.setEnabled(true);
            bi.a209j.setEnabled(true);
            bi.a209k.setEnabled(true);
            bi.a209l.setEnabled(true);
            bi.a209m.setEnabled(true);
            bi.a210a.setEnabled(true);
            bi.a210b.setEnabled(true);
            bi.a210c.setEnabled(true);
            bi.a210d.setEnabled(true);
            bi.a210e.setEnabled(true);
            bi.a210g.setEnabled(true);
            bi.a210h.setEnabled(true);
            bi.a210j.setEnabled(true);

            bi.a209d.setEnabled(true);
            bi.a209b.setEnabled(true);
            bi.a209c.setEnabled(true);
        }

        if (calAge > 20) {
            Clear.clearAllFields(bi.a209, true);
            Clear.clearAllFields(bi.a210, true);
        }*/

        /*bi.fldGrpCVa212.setVisibility(calAge >= 5 && calAge < 10 ? View.VISIBLE : View.GONE);
        bi.fldGrpCVa213.setVisibility(calAge >= 5 && calAge < 10 ? View.VISIBLE : View.GONE);*/

    }

    @Override
    public boolean onSupportNavigateUp() {
        /*if (fmcFLAG) {
            serial--;
            setResult(RESULT_CANCELED, new Intent().putExtra(SERIAL_EXTRA, serial));
            finish();
            return true;
        } else {
            Toast.makeText(this, "You can't go back!!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        setResult(RESULT_CANCELED);
        finish();

        return true;

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Press top back button.", Toast.LENGTH_SHORT).show();
    }
}
