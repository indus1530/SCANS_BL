package edu.aku.hassannaqvi.uen_scans_bl.datecollection

import org.threeten.bp.DateTimeException
import org.threeten.bp.LocalDate

class DateRepository {

    companion object {

        private fun getDate(year: Int, month: Int, day: Int): LocalDate? {
            return try {
                run { LocalDate.of(year, month, day) }
            } catch (e: DateTimeException) {
                null
            }
        }

        fun dateValidator(year: Int, month: Int, day: Int): Boolean = getDate(year, month, day) != null

        fun isDateLessThenDOB(year: Int, month: Int, day: Int, dt: LocalDate? = null): Boolean? {
            val calculateDate = getDate(year, month, day)
                    ?: return null
            val localDT = dt ?: LocalDate.now()
            return calculateDate < localDT
        }

        fun getCalculatedAge(year: Int, month: Int, day: Int): AgeModel? {

            val now = LocalDate.now()
            var curdate = now.dayOfMonth
            var curmonth = now.monthValue
            var curyear = now.year

            val calculateDate = getDate(year, month, if (day == 0) curdate else day)
                    ?: return null
            if (calculateDate > now) return null

            if (day > curdate) {
                curmonth -= 1
                curdate += calculateDate.lengthOfMonth()
            }

            if (month > curmonth) {
                curyear -= 1
                curmonth += 12
            }
            return AgeModel(curdate - day, curmonth - month, curyear - year)
        }
    }
}