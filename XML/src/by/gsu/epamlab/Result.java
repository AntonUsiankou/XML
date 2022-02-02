package by.gsu.epamlab;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static by.gsu.epamlab.Constants.DOT;
import static by.gsu.epamlab.Constants.TEN;

public class Result {

    private String testName;
    private String date;
    private int mark;

    public Result(String testName, String date, int mark) {
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
        SimpleDateFormat OUTPUT_DATE_FORMAT =
                new SimpleDateFormat("dd.MM.yyyy", Locale.US);
        return OUTPUT_DATE_FORMAT.format(new Date());
    }

    public String getStringMark(int mark) {
        return (mark / TEN) + DOT + (mark % TEN);
    }

    @Override
    public String toString() {
        return testName + Constants.DELIMITER + getStringDate() + Constants.DELIMITER + getStringMark(mark);
    }
}
