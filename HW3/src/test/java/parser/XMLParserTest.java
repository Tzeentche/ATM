package parser;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class XMLParserTest {

    XMLParser xmlParser = new XMLParser("C:\\Users\\Horus\\Sugako\\HW3\\src\\xmlFiles\\Sample4.xml");

    @Test
    public void testGetErrors() {
        xmlParser.getErrors();
    }

    @Test
    public void testParseDocument() {
        xmlParser.parseDocument();
    }
}