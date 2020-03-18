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
        val environment = path.plus(File.separator).plus(CreateTable.PROJECT_NAME).plus("_IMAGES").plus(File.separator).plus(cluster).plus("_").plus(hhno)
        val mediaDir = File(environment).apply { mkdirs() }
        if (mediaDir.exists())
            mediaDir else File(environment)
    } catch (ex: Exception) {
        null
    }
}

fun getImageDirectory(context: Context): File? {
    return try {
        val path = ContextCompat.getExternalFilesDirs(context, null)[1].absolutePath
        val environment = path.plus(File.separator).plus(CreateTable.PROJECT_NAME).plus("_IMAGES").plus(File.separator)
        val mediaDir = File(environment).apply { mkdirs() }
        if (mediaDir.exists())
            mediaDir else File(environment)
    } catch (ex: Exception) {
        null
    }
}

fun createFileOnSDCard(context: Context) {
    try {
        val root = context.applicationContext.getExternalFilesDirs(null)
        val sdcardRoot = root.last().absolutePath.split("/").dropLast(4).joinToString("/")
        val rootFolder = File(sdcardRoot)
        val newFile = File(rootFolder, "abc.temp")
        newFile.createNewFile()
    } catch (ex: Exception) {
        throw RuntimeException(ex.message)
    }
}