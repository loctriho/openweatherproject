package com.openweatherapi.search.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static long datetoSeconds(String string_date) throws ParseException {

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

        Date d = f.parse(string_date);
        long timestamp= d.getTime() / 1000;
        return timestamp;
    }
}
