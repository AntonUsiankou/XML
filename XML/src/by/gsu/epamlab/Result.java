package by.gsu.epamlab;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static by.gsu.epamlab.Constants.DOT;
import static by.gsu.epamlab.Constants.TEN;

public class Result {
    private String login;
    private String testName;
    private String date;
    private int mark;
    private SimpleDateFormat OUTPUT_DATE_FORMAT =
            new SimpleDateFormat("dd.MM.yyyy", Locale.US);
    public Result(String login, String testName, String date, int mark) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getStringDate() {
        return OUTPUT_DATE_FORMAT.format(new Date());
    }

    public String getStringMark(int mark) {
        return (mark / TEN) + DOT + (mark % TEN);
    }

    @Override
    public String toString() {
        return login + Constants.DELIMITER + testName + Constants.DELIMITER + getStringDate() + Constants.DELIMITER + getStringMark(mark);
    }
}
