package parser;

import org.apache.tools.ant.taskdefs.condition.IsTrue;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ListADT;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class XMLParserTest {

    XMLParser xmlParser;

    @Test
    public void testParseDocument() {
        ListADT<String> list;
        xmlParser = new XMLParser("C:\\Users\\Horus\\Sugako\\HW3\\src\\xmlFiles\\Sample10.xml");
        xmlParser.parseDocument();
        list = xmlParser.getErrors();
        if(list.isEmpty()) {
            Assert.assertTrue(true);

        } else{
            for(int i = 0; i < list.size(); i++) {
                System.out.println("What's happened: " + list.get(i));
            }
            Assert.assertTrue(false);
        }

    }
}