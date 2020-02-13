package edu.aku.hassannaqvi.uen_scans_bl.viewmodel

import android.os.AsyncTask
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FamilyMembersContract

class MainRepository(var indexMWRA: FamilyMembersContract, var indexCHILD: FamilyMembersContract)
    : AsyncTask<Void, Void, Void>() {

    override fun doInBackground(vararg params: Void?): Void {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        var a = 0
    }

}