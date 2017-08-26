package utils.XML_utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import utils.JsonParser.AI_Selenium.AI_Parser;
import utils.Utility;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WataruS on 8/26/2017.
 */
public class WriteTestXML {
    private String testSuiteName;
    private List<String> testCaseName = new ArrayList<String>();
    private String testSuiteFolderName;
    private String testClassFolderName;
    private Document doc;

    public WriteTestXML() {
        DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;
        try {
            icBuilder = icFactory.newDocumentBuilder();
            this.doc = icBuilder.newDocument();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public static void main(String[] args) throws Exception {
        WriteTestXML writeTestXML = new WriteTestXML();
        writeTestXML.createXml();
        writeTestXML.writeToFile();
    }

    public void getInfoFromJson() throws Exception {
        AI_Parser parser = new AI_Parser();
        setTestSuiteName(parser.getTestSuiteName());

        //Get testcases list
        for (int i = 0; i < parser.getNumberOfTestCases(); i++) {
            String testName = parser.getTestCaseName(parser.getTestCaseDTO()[i]);
            testCaseName.add(testName);
            testCaseName.add(testName + "Test");
        }
    }

    public void createFolders() throws Exception {

        // create folder to store test xml file under working directory
        setTestSuiteFolderName("testSuite/" + getTestSuiteName()
                + "_" + Utility.getDate()
                + "_" + Utility.getTime());
        Utility.createFolder("testSuite");
        Utility.createFolder(getTestSuiteFolderName());

        // create folder to store test class .java file under src/test/java
        setTestClassFolderName( "src/test/java/" + getTestSuiteName() );
        Utility.createFolder(getTestClassFolderName());

    }

    public void createXml() throws Exception {
        getInfoFromJson();
        createFolders();
        addDocType();
        this.doc.appendChild(addSuiteRootElement());
    }

    public Element addSuiteRootElement() {
        Element rootElement = doc.createElement("suite");

        rootElement.setAttribute("name", getTestSuiteName());
        rootElement.setAttribute("verbose", "2");

        addTestCaseElements(rootElement);

        return rootElement;
    }

    public void addTestCaseElements(Element rootElement){
        for (String test:getTestCaseName()){
            Element testElement = doc.createElement("test");
            testElement.setAttribute("name", test);
            testElement.setAttribute("preserver-order", "true");
            addClassName(testElement, test + "Test");
            rootElement.appendChild(testElement);
        }
    }

    public void addClassName(Element testElement, String className){
        Element classesElement = doc.createElement("classes");
        Element classElement = doc.createElement("class");
        classElement.setAttribute("name", getTestSuiteName() + "." + className);
        classesElement.appendChild(classElement);
        testElement.appendChild(classesElement);
    }

    public void writeToFile() throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(this.doc);
        StreamResult result = new StreamResult(new File(getTestSuiteFolderName() + "/ai.xml"));

        // Output to console for testing
        // StreamResult result = new StreamResult(System.out);

        transformer.transform(source, result);

        System.out.println("File saved!");
    }

    public void addDocType() {
//        rootElement.appendChild(doc.createTextNode("!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\""));
        Text textDTD = doc.createTextNode("!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\"");
        doc.appendChild(textDTD);
    }

    public String getTestSuiteName() {
        return testSuiteName;
    }

    public void setTestSuiteName(String testSuiteName) {
        this.testSuiteName = testSuiteName;
    }

    public List<String> getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(List<String> testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getTestSuiteFolderName() {
        return testSuiteFolderName;
    }

    public void setTestSuiteFolderName(String testSuiteFolderName) {
        this.testSuiteFolderName = testSuiteFolderName;
    }

    public String getTestClassFolderName() {
        return testClassFolderName;
    }

    public void setTestClassFolderName(String testClassFolderName) {
        this.testClassFolderName = testClassFolderName;
    }
}
