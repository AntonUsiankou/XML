package by.gsu.epamlab;

import static by.gsu.epamlab.Constants.*;

public class Test {
    private final String name;
    private final String date;
    private final int mark;

    public Test(String name, String date, int mark) {
        this.name = name;
        this.date = date;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return name + DELIMITER + date + DELIMITER +  mark / TEN + DOT + mark % TEN;
    }
}
