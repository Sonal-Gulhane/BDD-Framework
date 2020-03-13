package com.LMS.genericUtils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    /*
    returns current date in required format
     */
    public static String currentDate(String format){
        DateTimeFormatter datetimeFormatter = DateTimeFormatter.ofPattern(format);
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        return zonedDateTime.format(datetimeFormatter);

    }
}
