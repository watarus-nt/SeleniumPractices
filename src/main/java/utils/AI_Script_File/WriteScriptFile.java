package utils.AI_Script_File;

import utils.JsonParser.AI_Selenium.AI_Parser;
import utils.JsonParser.AI_Selenium.TestCaseDTO;
import utils.Utility;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WataruS on 8/26/2017.
 */
public class WriteScriptFile {
    private String packageName;
    private List<String> importList = new ArrayList<String>();
    private String classPart;
    private List<String> objectDeclarations = new ArrayList<String>();
    private List<String> setUpPart = new ArrayList<String>();
    private List<String> testPart = new ArrayList<String>();
    private List<String> testStepsPart = new ArrayList<String>();
    private List<String> tearDownPart = new ArrayList<String>();
    private AI_Parser parser;

    public WriteScriptFile() throws FileNotFoundException {
        parser = new AI_Parser();

    }

    public static void main(String[] args) throws FileNotFoundException {
        WriteScriptFile writeScriptFile = new WriteScriptFile();

        writeScriptFile.generateTestScripts();
    }

    public void generateTestScripts(){
        TestCaseDTO[] testCaseList = parser.getTestCaseDTO();
        for(int i = 0; i < testCaseList.length; i++){
            writeTestScriptFile(testCaseList[i].getName());
        }
    }

    public void writeTestScriptFile(String testName){
        List<String> content = createTestScriptContext(testName);
        String testScriptPath = "src/test/java/" + parser.getTestSuiteName() + "/" + testName + "Test.java";
        Utility.writeToFile(content, testScriptPath, true);
    }

    private List<String> createTestScriptContext(String testName){
        List<String> context = new ArrayList<String>();
        context.add(initialPackageName());
        context.addAll(initialImportList());
        context.add(initialClassPart(testName));
        context.addAll(initialObjectDeclarations());
        context.addAll(initialSetUpPart());
        context.addAll(initialTestPart());
        context.addAll(initialTearDownPart());
        context.add("}");

        clearOldContent();
        return context;
    }

    private void clearOldContent(){
        getImportList().clear();
        setClassPart("");
        getObjectDeclarations().clear();
        getSetUpPart().clear();
        getTestPart().clear();
        getTestStepsPart().clear();
        getTearDownPart().clear();
    }

    private String initialPackageName(){
        setPackageName("package " + parser.getTestSuiteName() + ";\n");
        return getPackageName();
    }

    private List<String> initialImportList(){
        this.importList.add("import libs.WebDriverUtils.SeleniumKeywords;");
        this.importList.add("import libs.WebDriverUtils.WebDriverManager;");
        this.importList.add("import org.openqa.selenium.WebDriver;");
        this.importList.add("import org.testng.annotations.AfterTest;");
        this.importList.add("import org.testng.annotations.BeforeTest;");
        this.importList.add("import org.testng.annotations.Parameters;");
        this.importList.add("import org.testng.annotations.Test;");
        this.importList.add("import utils.Logs.Log;");
        this.importList.add("import utils.Utility;");
        this.importList.add("");
        return getImportList();
    }

    private String initialClassPart(String testName){
        setClassPart("public class " + testName + "Test {\n");
        return getClassPart();
    }

    private List<String> initialObjectDeclarations(){
        this.objectDeclarations.add("\tLog log;");
        this.objectDeclarations.add("\tprivate WebDriver driver;");
        this.objectDeclarations.add("\tprivate SeleniumKeywords seleniumKeywords;");
        this.objectDeclarations.add("");
        return getObjectDeclarations();
    }

    private List<String> initialSetUpPart(){
        this.setUpPart.add("\t@Parameters({\"browser\"})");
        this.setUpPart.add("\t@BeforeTest");
        this.setUpPart.add("\tpublic void setUp(String browser) throws Exception {");
        this.setUpPart.add("\t\tlog = Utility.createLog(this.getClass().getSimpleName());");
        this.setUpPart.add("\t\tdriver = WebDriverManager.createWebDriver(browser, log);");
        this.setUpPart.add("\t\tseleniumKeywords = new SeleniumKeywords(driver, log);");
        this.setUpPart.add("\t}");
        this.setUpPart.add("");
        return getSetUpPart();
    }

    private List<String> initialTestPart(){
        this.testPart.add("\t@Test");
        this.testPart.add("\tpublic void testName() throws Exception {");
        this.testPart.addAll(initialTestStepPart());
        this.testPart.add("\t}");
        this.testPart.add("");
        return getTestPart();
    }

    private List<String> initialTestStepPart(){
        // add later after have a mapping between displayed action names
        // and implement action names
//        this.testStepsPart.add("\n");
        return getTestStepsPart();
    }

    private List<String> initialTearDownPart(){
        this.tearDownPart.add("\t@AfterTest");
        this.tearDownPart.add("\tpublic void tearDown() {");
        this.tearDownPart.add("\t\tdriver.quit();");
        this.tearDownPart.add("\t}");
        this.tearDownPart.add("");
        return getTearDownPart();
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<String> getImportList() {
        return importList;
    }

    public void setImportList(List<String> importList) {
        this.importList = importList;
    }

    public String getClassPart() {
        return classPart;
    }

    public void setClassPart(String classPart) {
        this.classPart = classPart;
    }

    public List<String> getObjectDeclarations() {
        return objectDeclarations;
    }

    public void setObjectDeclarations(List<String> objectDeclarations) {
        this.objectDeclarations = objectDeclarations;
    }

    public List<String> getSetUpPart() {
        return setUpPart;
    }

    public void setSetUpPart(List<String> setUpPart) {
        this.setUpPart = setUpPart;
    }

    public List<String> getTestPart() {
        return testPart;
    }

    public void setTestPart(List<String> testPart) {
        this.testPart = testPart;
    }

    public List<String> getTearDownPart() {
        return tearDownPart;
    }

    public void setTearDownPart(List<String> tearDownPart) {
        this.tearDownPart = tearDownPart;
    }

    public List<String> getTestStepsPart() {
        return testStepsPart;
    }

    public void setTestStepsPart(List<String> testStepsPart) {
        this.testStepsPart = testStepsPart;
    }
}
