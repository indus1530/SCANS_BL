package edu.aku.hassannaqvi.uen_scans_bl.viewmodel

import android.content.Context
import android.content.Intent
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FamilyMembersContract
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp
import edu.aku.hassannaqvi.uen_scans_bl.ui.sections.SectionK2Activity
import kotlinx.coroutines.*

class MainRepository(val context: Context, val item: MutableList<FamilyMembersContract>) {

    init {

        val result = GlobalScope.async { populateList() }

        runBlocking {
            context.startActivity(Intent(context, SectionK2Activity::class.java))
        }

    }

    private suspend fun populateList() = withContext(Dispatchers.IO) {
        MainApp.mwraChildren = Pair(item.map { it.serialno.toInt() }, item.map { it.name })
    }
}