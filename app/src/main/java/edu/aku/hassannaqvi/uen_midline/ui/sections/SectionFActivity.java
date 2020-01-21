package edu.aku.hassannaqvi.uen_midline.ui.sections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.RadioGroup;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionFBinding;
import edu.aku.hassannaqvi.uen_midline.validator.ClearClass;

public class SectionFActivity extends AppCompatActivity {

    ActivitySectionFBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f);
        bi.setCallback(this);

        setUIComponent();
    }

    void setUIComponent() {

        bi.f114.setOnCheckedChangeListener((radioGroup, i) -> {

            if (i != bi.f114a.getId()) {
                ClearClass.ClearAllFields(bi.fldGrp1520, null);
            }
        });
    }
}
