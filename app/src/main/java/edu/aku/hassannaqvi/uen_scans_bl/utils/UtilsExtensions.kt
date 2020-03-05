package edu.aku.hassannaqvi.uen_scans_bl.utils

import android.content.Context
import android.os.Environment
import androidx.core.content.ContextCompat
import java.io.File

fun checkSDCardAvailability(context: Context): Boolean {
    val isSDPresent = Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
    val isSDSupportedDevice = ContextCompat.getExternalFilesDirs(context, null)[1] != null
    return isSDSupportedDevice && isSDPresent
}

fun getImageSaveDirectory(context: Context, cluster: String, hhno: String): File? {
    return try {
        val path = ContextCompat.getExternalFilesDirs(context, null)[1].absolutePath
        val environment = path + File.separator + CreateTable.PROJECT_NAME + "_IMAGES" + File.separator + cluster + "_" + hhno
        val mediaDir = File(environment).apply { mkdirs() }
        if (mediaDir.exists())
            mediaDir else File(environment)
    } catch (ex: Exception) {
        null
    }
}