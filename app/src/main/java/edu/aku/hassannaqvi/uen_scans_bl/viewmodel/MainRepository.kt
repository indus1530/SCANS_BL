package edu.aku.hassannaqvi.uen_scans_bl.viewmodel

import android.os.AsyncTask
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FamilyMembersContract

class MainRepository(var item: FamilyMembersContract, var checks: Triple<Int, Int, Int>)
    : AsyncTask<Void, Void, Triple<Int, Int, Int>>() {

    override fun doInBackground(vararg params: Void?): Triple<Int, Int, Int> {

        when {
            item.age.toInt() in 16..48 && item.marital.toInt() != 2 -> checks.first + 1
            item.age.toInt() in 0..5 -> checks.second + 1
        }

        return Triple(0, 0, 0)
    }
}