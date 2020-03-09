package edu.aku.hassannaqvi.uen_scans_bl.ui.other

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import edu.aku.hassannaqvi.uen_scans_bl.R
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    lateinit var bi: ActivityDashboardBinding
    lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        bi.callback = this
        db = DatabaseHelper(this)
    }

}