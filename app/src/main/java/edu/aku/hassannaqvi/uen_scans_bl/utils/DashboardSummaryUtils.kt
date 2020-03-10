package edu.aku.hassannaqvi.uen_scans_bl.utils

import android.content.Context
import android.database.Cursor
import edu.aku.hassannaqvi.uen_scans_bl.R

data class Summary(val formDate: String,
                   val cluster_no: String,
                   val hh_no: String,
                   val iStatus: String,
                   val user: String,
                   val member: String,
                   val wra: String,
                   val child: String,
                   val anthro: String,
                   val vision: String,
                   val hb: String)

data class SummaryAnthro(val formDate: String,
                         val cluster_no: String,
                         val hh_no: String,
                         val iStatus: String,
                         val user: String,
                         val member: String,
                         val wra: String,
                         val child: String,
                         val anthro: String,
                         val vision: String,
                         val hb: String)

private val getIstatusString: (Context, String) -> String = { mContext: Context, item: String ->
    when (item) {
        "1" -> mContext.resources.getString(R.string.a119a)
        "2" -> mContext.resources.getString(R.string.a119b)
        "3" -> mContext.resources.getString(R.string.a119c)
        "4" -> mContext.resources.getString(R.string.a119d)
        "5" -> mContext.resources.getString(R.string.a119e)
        "6" -> mContext.resources.getString(R.string.a119f)
        "7" -> mContext.resources.getString(R.string.a119g)
        "8" -> mContext.resources.getString(R.string.a119h)
        "9" -> mContext.resources.getString(R.string.a119i)
        "96" -> mContext.resources.getString(R.string.a119x)
        else -> "null"
    }
}

fun getSummaryFromCursor(context: Context, c: Cursor): Summary {
    return Summary(
            c.getString(c.getColumnIndex("formdate")),
            c.getString(c.getColumnIndex("cluster_code")),
            c.getString(c.getColumnIndex("hhno")),
            getIstatusString(context, c.getString(c.getColumnIndex("istatus"))),
            c.getString(c.getColumnIndex("username")),
            c.getString(c.getColumnIndex("member")),
            c.getString(c.getColumnIndex("mwra")),
            c.getString(c.getColumnIndex("child")),
            c.getString(c.getColumnIndex("anthro_mem")),
            c.getString(c.getColumnIndex("vision")),
            c.getString(c.getColumnIndex("hb"))
    )
}

fun getSummaryData(item: Summary): Array<String> {
    return arrayOf(
            item.hh_no,
            item.cluster_no,
            item.formDate,
            item.member,
            item.wra,
            item.child,
            item.anthro,
            item.hb,
            item.vision,
            item.user,
            item.iStatus)
}

fun getHeaders(): Array<String> {
    return arrayOf(
            "HH NO",
            "CLUSTER NO",
            "FORM DATE",
            "MEMBER",
            "MWRA",
            "CHILD",
            "ANTHRO MEMBERS",
            "HB",
            "VISION",
            "USER",
            "ISTATUS"
    )
}
