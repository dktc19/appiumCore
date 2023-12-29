package net.fpt.utils;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.TimeZone;

public class DateUtil {
    static Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

    //Get the current day
    public static Integer getCurrentDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    //get the current month
    public static Integer getCurrentMonth() {
        return calendar.get(Calendar.MONTH) + 1;
    }

    //get the current year
    public static Integer getCurrentYear() {
        return calendar.get(Calendar.YEAR);
    }
}
