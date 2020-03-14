package edu.aku.hassannaqvi.uen_scans_bl.ui.other

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.v2.DbxClientV2
import edu.aku.hassannaqvi.uen_scans_bl.R
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivityDashboardBinding
import edu.aku.hassannaqvi.uen_scans_bl.utils.Summary
import edu.aku.hassannaqvi.uen_scans_bl.utils.componentBTableRow
import edu.aku.hassannaqvi.uen_scans_bl.utils.componentHTableRow
import edu.aku.hassannaqvi.uen_scans_bl.utils.getHeaders
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


class DashboardActivity : AppCompatActivity() {

    lateinit var bi: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        bi.callback = this


        //Working on dropbox connectivity
        // Create Dropbox client

        //Working on dropbox connectivity
        // Create Dropbox client
        val config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build()
        val client = DbxClientV2(config, "2_Ak4O3Z0OAAAAAAAAAAPCuzIUgbAMOUt1haIazT_Pbe11VWl97JM3V4CKJL-pG3")

        // Get current account info
        runBlocking {
            getInfo(client)
        }

//        PopulatingData(this@DashboardActivity, MainApp.appInfo.dbHelper, bi).execute()
    }

    suspend fun getInfo(client: DbxClientV2) {
        withContext(Dispatchers.IO) {
//            val account = client.users().currentAccount

            // Get files and folder metadata from Dropbox root directory


            // Get files and folder metadata from Dropbox root directory
            var result = client.files().listFolder("")
            while (true) {
                for (metadata in result.entries) {
                    System.out.println(metadata.pathLower)
                }
                if (!result.hasMore) {
                    break
                }
                result = client.files().listFolderContinue(result.cursor)
            }


        }
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