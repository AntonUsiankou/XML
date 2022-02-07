import by.gsu.epamlab.ResultHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;

import static by.gsu.epamlab.Constants.*;

public class Runner {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        ResultHandler parserResultHandler = new ResultHandler();
        try {
            SAXParser parser = factory.newSAXParser();
            FileInputStream filePath = new FileInputStream(PATH + FILE_NAME + EXT_XSM);
            parser.parse(filePath, parserResultHandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new IllegalStateException(e);
        }
        parserResultHandler.printList();
    }
}