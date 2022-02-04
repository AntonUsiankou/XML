package by.gsu.epamlab;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static by.gsu.epamlab.Constants.*;

public class Result {
    private String login;
    private String testName;
    private Date date;
    private int mark;
    public Result(String login, String testName, Date date, int mark) {
        this.login = login;
        this.testName = testName;
        this.mark = mark;
        this.date = date;
    }


    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }


    public String getDateToString(Date date) {
        Format formatter = new SimpleDateFormat(DATE_PATTERN);
        return formatter.format(date);
    }

    public static Date getStringToDate(String date) {
        DateTimeFormatter parserDtf = DateTimeFormatter.ofPattern(DATE_LOCALE);
        LocalDate ldt = LocalDate.parse(date, parserDtf);
        return java.sql.Date.valueOf(ldt);
    }

    public String getStringMark(int mark) {
        return (mark / TEN) + DOT + (mark % TEN);
    }

    @Override
    public String toString() {
        return login + Constants.DELIMITER + testName + Constants.DELIMITER + getDateToString(date) + Constants.DELIMITER + getStringMark(mark);
    }
}
