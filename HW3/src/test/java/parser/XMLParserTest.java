package parser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class XMLParserTest {

    @DataProvider(name = "validXml")
    public Object[] getData(){
        Object[] myData = {"./src/xmlFiles/Sample1.xml",
                "./src/xmlFiles/Sample2.xml",
                "./src/xmlFiles/Sample3.xml",
                "./src/xmlFiles/Sample4.xml",
                "./src/xmlFiles/Sample5.xml",
                "./src/xmlFiles/Sample6.xml",
                "./src/xmlFiles/Sample7.xml",
                "./src/xmlFiles/Sample8.xml",
                "./src/xmlFiles/Sample9.xml",
                "./src/xmlFiles/Sample10.xml"};
        return myData;
    }

    @Test(dataProvider = "validXml")
    public void testXmlMixed(String param) {
        XMLParser parser = new XMLParser(param);
        try {
            parser.parseDocument();
        } catch (Exception e) {
            Assert.fail("Unexpected exception "+e.getMessage());
        }
        Assert.assertTrue(parser.getErrors().isEmpty(), "Parser found an error in valid file");
    }

}