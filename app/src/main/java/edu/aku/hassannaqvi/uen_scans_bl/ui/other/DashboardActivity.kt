package edu.aku.hassannaqvi.uen_scans_bl.ui.other

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import edu.aku.hassannaqvi.uen_scans_bl.R
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivityDashboardBinding
import edu.aku.hassannaqvi.uen_scans_bl.utils.Summary
import edu.aku.hassannaqvi.uen_scans_bl.utils.componentBTableRow
import edu.aku.hassannaqvi.uen_scans_bl.utils.componentHTableRow
import edu.aku.hassannaqvi.uen_scans_bl.utils.getHeaders

class DashboardActivity : AppCompatActivity() {

    lateinit var bi: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        bi.callback = this

        PopulatingData(this@DashboardActivity, MainApp.appInfo.dbHelper, bi).execute()
    }

    class PopulatingData(var mContext: Context, var db: DatabaseHelper, var bi: ActivityDashboardBinding) : AsyncTask<ArrayList<Summary>?, ArrayList<Summary>?, ArrayList<Summary>?>() {

        override fun onPreExecute() {
            super.onPreExecute()
            componentHTableRow(mContext, bi.dashboardTable, getHeaders())
        }

        override fun onPostExecute(aVoid: ArrayList<Summary>?) {
            super.onPostExecute(aVoid)
            componentBTableRow(mContext, bi.dashboardTable, aVoid)
        }

        override fun doInBackground(vararg params: ArrayList<Summary>?): ArrayList<Summary>? {
            return db.getSummary(mContext)
        }

    }

}