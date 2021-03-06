package utils.AI_XML_File;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utils.JsonParser.AI_Selenium.AI_Parser;
import utils.Utility;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
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
    private String testNgXmlPath;
    private String browser;
    private String URL;
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

        setBrowser(parser.getBrowser());;
        setURL(parser.getURL());

        //Get testcases list
        for (int i = 0; i < parser.getNumberOfTestCases(); i++) {
            String testName = parser.getTestCaseName(parser.getTestCaseDTO()[i]);
            testCaseName.add(testName + "Test");
        }
    }

    public void createFolders() throws Exception {

        // create folder to store test xml file under working directory
        setTestSuiteFolderName("testSuite/" + getTestSuiteName()
//                + "_" + Utility.getDate()
//                + "_" + Utility.getTime()
        );
        Utility.createFolder("testSuite");
        Utility.createFolder(getTestSuiteFolderName());

        // set a path of output testng.xml file (will rename as ai.xml)
        setTestNgXmlPath(getTestSuiteFolderName() + "/ai.xml");

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
            testElement.setAttribute("preserve-order", "true");
            addTestParam(testElement, "browser", getBrowser());
            addTestParam(testElement, "URL", getURL());
            addClassName(testElement, test);
            rootElement.appendChild(testElement);
        }
    }

    public void addTestParam(Element testElement, String name, String value){
        Element param = doc.createElement("parameter");
        param.setAttribute("name", name);
        param.setAttribute("value", value);
        testElement.appendChild(param);
    }
    public void addClassName(Element testElement, String className){
        Element classesElement = doc.createElement("classes");
        Element classElement = doc.createElement("class");
        classElement.setAttribute("name", getTestSuiteName() + "." + className);
        classesElement.appendChild(classElement);
        testElement.appendChild(classesElement);
    }

    public void writeToFile() throws TransformerException, IOException {
        StringWriter outputXmlStringWriter = new StringWriter();

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(this.doc);
//        StreamResult result = new StreamResult(new File(getTestSuiteFolderName() + "/ai.xml"));
        // Output to console for testing
        // StreamResult result = new StreamResult(System.out);

        transformer.transform(source, new StreamResult(outputXmlStringWriter));
        String outputXmlString = outputXmlStringWriter.toString()
                .replaceFirst("<!--", "\n<").replaceFirst("-->", ">\n");


        FileOutputStream outputXml = new FileOutputStream(new File(getTestNgXmlPath()));
        outputXml.write(outputXmlString.getBytes("UTF-8"));

        System.out.println("File saved!");
    }

    public void addDocType() {
//        rootElement.appendChild(doc.createTextNode("!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\""));
        Comment textDTD = doc.createComment("!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\"");
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

    public String getTestNgXmlPath() {
        return testNgXmlPath;
    }

    public void setTestNgXmlPath(String testNgXmlPath) {
        this.testNgXmlPath = testNgXmlPath;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
