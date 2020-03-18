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
import edu.aku.hassannaqvi.uen_scans_bl.utils.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileInputStream


class DashboardActivity : AppCompatActivity() {

    lateinit var bi: ActivityDashboardBinding
    lateinit var client: DbxClientV2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        bi.callback = this


        //Working on dropbox connectivity
        // Create Dropbox client

        //Working on dropbox connectivity
        // Create Dropbox client
        val config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build()
        client = DbxClientV2(config, "2_Ak4O3Z0OAAAAAAAAAAPCuzIUgbAMOUt1haIazT_Pbe11VWl97JM3V4CKJL-pG3")

        // Get current account info
        runBlocking {
            processingDropBoxAccount()
        }

//        PopulatingData(this@DashboardActivity, MainApp.appInfo.dbHelper, bi).execute()
    }

    private suspend fun processingDropBoxAccount() {
        withContext(Dispatchers.IO) {
            val account = client.users().currentAccount

            // Get files and folder metadata from Dropbox root directory


            // Get files and folder metadata from Dropbox root directory
            /*var result = client.files().listFolder("")
            while (true) {
                for (metadata in result.entries) {
                    Log.d("Dashboard", metadata.pathLower)
                }
                if (!result.hasMore) {
                    break
                }
                result = client.files().listFolderContinue(result.cursor)
            }*/

            // Upload "test.txt" to Dropbox
            /*FileInputStream(getImageDirectory(this@DashboardActivity)!!.absolutePath + "/text.txt").use { item ->
                val metadata = client.files().uploadBuilder("/test.txt")
                        .uploadAndFinish(item)
            }*/

            val filesLst = getImageDirectory(this@DashboardActivity)?.listFiles()?.toMutableList()
                    ?: mutableListOf()
            iteratingItems(filesLst)

        }
    }

    private fun iteratingItems(filesLst: MutableList<File>) {

        filesLst.iterator().forEach { item ->
            if (item.isDirectory) {
                if (true == item.listFiles()?.isNotEmpty()) {
                    item.listFiles()?.toMutableList()?.let { iteratingItems(it) }
                }
            } else if (item.isFile) {
                sendingImagesToServer(item.absolutePath.substringAfterLast("/"), item)
            }
        }

    }

    private fun sendingImagesToServer(fileName: String, file: File) {
        FileInputStream(file).use { item ->
            val metadata = client.files().uploadBuilder("/$fileName/${file.absolutePath.substringAfterLast("/")}")
                    .uploadAndFinish(item)
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