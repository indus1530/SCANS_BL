package edu.aku.hassannaqvi.uen_scans_bl.otherClasses

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FamilyMembersContract
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper

class FamilyMemContentProvider : ContentProvider() {

    lateinit var db: DatabaseHelper

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        TODO("Implement this to handle requests to delete one or more rows")
    }

    override fun getType(uri: Uri): String? {
        TODO("Implement this to handle requests for the MIME type of the data" +
                "at the given URI")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("Implement this to handle requests to insert a new row.")
    }

    override fun onCreate(): Boolean {
        db = DatabaseHelper(context)
        return true
    }

    override fun query(uri: Uri, projection: Array<String>?, selection: String?,
                       selectionArgs: Array<String>?, sortOrder: String?): Cursor? {

        return db.readableDatabase.query(FamilyMembersContract.SingleMember.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder)
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?,
                        selectionArgs: Array<String>?): Int {
        TODO("Implement this to handle requests to update one or more rows.")
    }
}
