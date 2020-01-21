package edu.aku.hassannaqvi.uen_midline.ui.sections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.databinding.ActivitySectionJ02Binding;

public class SectionJ02Activity extends AppCompatActivity {


    ActivitySectionJ02Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j02);
        bi.setCallback(this);
    }
}
