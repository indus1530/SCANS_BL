package edu.aku.hassannaqvi.uen_scans_bl.utils

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import edu.aku.hassannaqvi.uen_scans_bl.R
import java.util.*

fun headerTextViews(context: Context, label: String): TextView {
    val headerTextView = TextView(context)
    headerTextView.setBackgroundColor(context.resources.getColor(R.color.darkPink))
    headerTextView.setTextColor(Color.WHITE)
    headerTextView.text = label
    headerTextView.textSize = 22f
    headerTextView.typeface = Typeface.SANS_SERIF
    headerTextView.gravity = Gravity.CENTER
    headerTextView.setPadding(20, 2, 20, 1)
    return headerTextView
}

fun bodyTextViews(context: Context, label: String, color: Int): TextView {
    val bodyTextView = TextView(context)
    bodyTextView.setBackgroundColor(context.resources.getColor(color))
    bodyTextView.setTextColor(Color.BLACK)
    bodyTextView.text = label
    bodyTextView.textSize = 15f
    bodyTextView.typeface = Typeface.MONOSPACE
    bodyTextView.gravity = Gravity.CENTER
    bodyTextView.setPadding(5, 5, 5, 5)
    return bodyTextView
}

fun componentHTableRow(mContext: Context, tbl: TableLayout, headers: Array<String>) {
    val componentBTableRow = TableRow(mContext)
    val params = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
    params.setMargins(1, 0, 0, 2)
    for (label in headers) {
        val textView: TextView = headerTextViews(mContext, label)
        textView.layoutParams = params
        componentBTableRow.addView(textView)
    }
    tbl.addView(componentBTableRow)
}

fun componentBTableRow(mContext: Context, tbl: TableLayout, body: ArrayList<Summary>?) {
    body?.let {
        for (i in body.indices) {
            val taleRowForTableD = TableRow(mContext)
            val getSum: Array<String> = getSummaryData(body[i])
            for (j in getSum.indices) {
                val params = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
                params.setMargins(1, 1, 0, 0)
                val textViewB: TextView = bodyTextViews(mContext, getSum[j], if (i % 2 == 0) R.color.dullWhiteOverlay else R.color.colorPrimaryLight)
                taleRowForTableD.addView(textViewB, params)
            }
            tbl.addView(taleRowForTableD)
        }
    }
}