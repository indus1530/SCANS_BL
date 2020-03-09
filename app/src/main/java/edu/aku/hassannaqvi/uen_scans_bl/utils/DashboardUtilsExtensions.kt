package edu.aku.hassannaqvi.uen_scans_bl.utils

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import java.util.*

fun headerTextViews(context: Context, label: String): TextView {
    val headerTextView = TextView(context)
    headerTextView.setBackgroundColor(Color.BLACK)
    headerTextView.setTextColor(Color.WHITE)
    headerTextView.text = label
    headerTextView.textSize = 30f
    headerTextView.typeface = Typeface.SANS_SERIF
    headerTextView.gravity = Gravity.CENTER
    headerTextView.setPadding(10, 2, 10, 5)
    return headerTextView
}

fun bodyTextViews(context: Context, label: String): TextView {
    val bodyTextView = TextView(context)
    bodyTextView.setBackgroundColor(Color.BLACK)
    bodyTextView.setTextColor(Color.GREEN)
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
    params.setMargins(1, 0, 0, 3)
    for (label in headers) {
        val textView: TextView = headerTextViews(mContext, label)
        textView.textSize = 15f
        textView.layoutParams = params
        componentBTableRow.addView(textView)
    }
    tbl.addView(componentBTableRow)
}

fun componentBTableRow(mContext: Context, tbl: TableLayout, body: ArrayList<Summary>) {
    for (i in body.indices) {
        val taleRowForTableD = TableRow(mContext)
        val getSum: Array<String> = getSummaryData(body[i])
        for (j in getSum.indices) {
            val params = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
            params.setMargins(1, 1, 0, 0)
            val textViewB: TextView = bodyTextViews(mContext, getSum[j])
            taleRowForTableD.addView(textViewB, params)
        }
        tbl.addView(taleRowForTableD)
    }
}