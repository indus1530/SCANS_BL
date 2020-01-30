package edu.aku.hassannaqvi.uen_scans_bl.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import edu.aku.hassannaqvi.uen_scans_bl.CONSTANTS;

public class DateUtils {

    public static int monthsBetweenDates(Date startDate, Date endDate) {

        Calendar start = Calendar.getInstance();
        start.setTime(startDate);

        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

        int monthsBetween = 0;
        int dateDiff = end.get(Calendar.DAY_OF_MONTH) - start.get(Calendar.DAY_OF_MONTH);

        if (dateDiff < 0) {
            int borrrow = end.getActualMaximum(Calendar.DAY_OF_MONTH);
            dateDiff = (end.get(Calendar.DAY_OF_MONTH) + borrrow) - start.get(Calendar.DAY_OF_MONTH);
            monthsBetween--;

            if (dateDiff > 0) {
                monthsBetween++;
            }
        }

        monthsBetween += end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
        monthsBetween += (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
        return monthsBetween;
    }

    public static String ageInYears(int day, int month, int year) {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        if (year < CONSTANTS.MINYEAR) return "0";

        dob.set(year, month, day);


        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        int ageInt = age;

        return Integer.toString(ageInt);
    }

    public static long ageInMonths(String year, String month) {
        return (long) ((Integer.valueOf(year) * 12) + Integer.valueOf(month));
    }

    public static String convertDateFormat(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date d = sdf.parse(dateStr);
            return new SimpleDateFormat("dd/MM/yyyy").format(d);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return "";
    }

    public static String getYearsBack(String format, int year) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(cal.getTime());
        cal.add(Calendar.YEAR, year);
        return new SimpleDateFormat(format).format(cal.getTime()); //"dd-MM-yyyy HH:mm"
    }

    public static String addYearsByDate(Calendar cal, String format, int year) {
        cal.setTime(cal.getTime());
        cal.add(Calendar.YEAR, year);
        return new SimpleDateFormat(format).format(cal.getTime()); //"dd-MM-yyyy HH:mm"
    }

    public static String getMonthsBack(String format, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(cal.getTime());
        cal.add(Calendar.MONTH, month);
        return new SimpleDateFormat(format).format(cal.getTime()); //"dd-MM-yyyy HH:mm"
    }

    public static String getDaysBack(String format, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(cal.getTime());
        cal.add(Calendar.DAY_OF_YEAR, day);
        return new SimpleDateFormat(format).format(cal.getTime()); //"dd-MM-yyyy HH:mm"
    }

    public static String getDOB(String format, int year, int month, int day) {

        int totalmonths = (year * 12) + month;

        Calendar cal = Calendar.getInstance();
        cal.setTime(cal.getTime());
        cal.add(Calendar.MONTH, -totalmonths);
        cal.add(Calendar.DAY_OF_MONTH, -day);

        return new SimpleDateFormat(format).format(cal.getTime());
    }

    public static int getAgeInYears(int year) {
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);

        return currentYear - year;
    }

    public static Calendar getCalendarDate(String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(value);
            calendar.setTime(date);
            return calendar;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    public static Calendar getDate(String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(value);
            calendar.setTime(date);
            return calendar;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    public static long ageInYearByDOB(String dateStr) {
        Calendar cal = getCalendarDate(dateStr);
        Date dob = cal.getTime();
        Date today = new Date();
        long diff = today.getTime() - dob.getTime();
        return (diff / (24 * 60 * 60 * 1000)) / 365;
    }

    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public static long ageInMonthsByDOB(Calendar cal) {
        Date dob = cal.getTime();
        Date today = new Date();
        long diff = today.getTime() - dob.getTime();
        double ageInMonths = (diff / (24 * 60 * 60 * 1000)) / 30.4375;
        return (long) Math.floor(ageInMonths);
    }

    public static long dobDiff(Calendar cal, Calendar cal2) {
        Date dob = cal.getTime();
        Date visitDate = cal2.getTime();
        long diff = visitDate.getTime() - dob.getTime();
        double ageInMonths = (diff / (24 * 60 * 60 * 1000)) / 30.4375;
        return (long) Math.floor(ageInMonths);
    }

    public static long ageInDaysByDOB(String dateStr) {
        Calendar cal = getCalDate(dateStr);
        Date dob = cal.getTime();
        Date today = new Date();
        long diff = today.getTime() - dob.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public static Calendar getCalDate(String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(value);
            calendar.setTime(date);
            return calendar;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    public static String getYearsAndMonthsBack(String format, int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(cal.getTime());
        cal.add(Calendar.YEAR, year);
        cal.add(Calendar.MONTH, month);
        return new SimpleDateFormat(format).format(cal.getTime()); //"dd-MM-yyyy HH:mm"
    }
}
