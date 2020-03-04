package edu.aku.hassannaqvi.uen_scans_bl.utils

import android.content.Context
import android.os.Environment
import androidx.core.content.ContextCompat
import java.io.File

fun checkSDCardAvailability(): Boolean {
    val isSDPresent = Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
//    val isSDSupportedDevice = Environment.isExternalStorageRemovable()
    return true && isSDPresent
}

fun getImageSaveDirectory(context: Context, cluster: String, hhno: String): File {

    val environment = ContextCompat.getExternalFilesDirs(context, null)[1].absolutePath + File.separator + CreateTable.PROJECT_NAME + "_IMAGES" + File.separator + cluster + "_" + hhno
    val mediaDir = File(environment).apply { mkdirs() }
    return if (mediaDir.exists())
        mediaDir else File(environment)
}