package by.gsu.epamlab;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static by.gsu.epamlab.Constants.*;

public class Utils {

    public static String getDateToString(Date date) {
        Format formatter = new SimpleDateFormat(DATE_PATTERN);
        return formatter.format(date);
    }

    public static Date getStringToDate(String date) {
        DateTimeFormatter parserDtf = DateTimeFormatter.ofPattern(DATE_LOCALE);
        LocalDate ldt = LocalDate.parse(date, parserDtf);
        return java.sql.Date.valueOf(ldt);
    }

    public static String getStringMark(int mark) {
        return (mark / TEN) + DOT + (mark % TEN);
    }
}
