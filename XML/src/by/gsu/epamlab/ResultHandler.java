package by.gsu.epamlab;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static by.gsu.epamlab.Constants.TEN;

public class ResultHandler extends DefaultHandler {

    private List<Result> results = new ArrayList<Result>();

    private String value;
    private String login;

    private enum CurrentEnum {
        RESULTS, STUDENT, LOGIN, TESTS, TEST;
    }

    private CurrentEnum currentEnum;

    private enum TestAttributes {
        NAME, DATE, MARK
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentEnum = CurrentEnum.valueOf(qName.toUpperCase());
        if (currentEnum == CurrentEnum.TEST) {
            String testName = attributes.getValue(TestAttributes.NAME.name().toLowerCase());
            Date date = (Date) Utils.getStringToDate(attributes.getValue(TestAttributes.DATE.name().toLowerCase()));
            int mark = (int) (TEN * Double.parseDouble(attributes.getValue(TestAttributes.MARK.name().toLowerCase())));
            results.add(new Result(login, testName, date, mark));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentEnum == CurrentEnum.LOGIN) {
            value = new String(ch, start, length).trim();
            if (!value.isEmpty()) {
                login = value;
            }
        }
    }
    public void printList() {
        for (Result result : results) {
            System.out.println(result);
        }
    }
}