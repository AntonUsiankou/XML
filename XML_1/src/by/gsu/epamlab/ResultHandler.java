package by.gsu.epamlab;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.gsu.epamlab.Constants.TEN;

public class ResultHandler extends DefaultHandler {

    private List<Result> results = new ArrayList<Result>();

    private String value;
    private String student;
    private String test;


    private static enum CurrentEnum {
        RESULTS, STUDENT, LOGIN, TESTS, TEST;
    }

    private static enum TestAttributes {
        NAME, DATE, MARK
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (CurrentEnum.valueOf(qName.toUpperCase()) == CurrentEnum.TEST) {
            String testName = attributes.getValue(TestAttributes.NAME.name().toLowerCase());
            String date = attributes.getValue(TestAttributes.DATE.name().toLowerCase());
            int mark = (int) (TEN * Double.parseDouble(attributes.getValue(TestAttributes.MARK.name().toLowerCase())));
            results.add(new Result(testName, date, mark));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (CurrentEnum.valueOf(qName.toUpperCase()) == CurrentEnum.LOGIN) {
            student = value;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = new String(ch, start, length);
    }

    public List<Result> load(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            FileInputStream file = new FileInputStream(fileName);
            parser.parse(file, this);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new IllegalStateException(e);
        }
        return results;
    }
}
