package utils.JsonParser.AI_Selenium;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class AI_Parser {

    private TestParamsDTO testParamsDTO;
    private TestSuiteDTO testSuiteDTO;
    private TestCaseDTO[] testCaseDTO;
    private TestStepDTO[] testStepDTO;
    private LocateElementDTO locateElementDTO;

    public AI_Parser() throws FileNotFoundException {
        Gson gson = new Gson();
        try {
            this.testParamsDTO = gson.fromJson(new FileReader("sampleAItest.json"), TestParamsDTO.class);
            setTestSuiteDTO(testParamsDTO.getTestsuite());
            setTestCaseDTO(getTestSuiteDTO().getTestcase());

        } catch (FileNotFoundException e) {
            System.out.println("[FAILED] - Can't find input sampleAItest.json file!");
            throw e;
        }
    }

    public String getTestSuiteName(){
        return testParamsDTO.getTestsuite().getName();
    }

    public String getBrowser(){
        return testParamsDTO.getBrowser();
    }

    public String getURL(){
        return testParamsDTO.getURL();
    }

    public int getNumberOfTestCases(){
        return getTestCaseDTO().length;
    }

    public String getTestCaseName(TestCaseDTO testCaseDTO){
        return testCaseDTO.getName();
    }


    public int getNumberOfTestStepInTestCase(TestCaseDTO testCaseDTO){
        return testCaseDTO.getStep().length;
    }
    public static void main(String[] args) throws FileNotFoundException {
        AI_Parser p = new AI_Parser();
        p.printTestSuiteDetails();
    }


    public void printTestSuiteDetails() throws FileNotFoundException {
        Gson gson = new Gson();
        TestParamsDTO params = gson.fromJson(new FileReader("sampleAItest.json"), TestParamsDTO.class);
        System.out.println("Broswer: " + params.getBrowser());
        System.out.println("URL: " + params.getURL());
        System.out.println("Testsuite name: " + params.getTestsuite().getName());
        int numberOfTestCases = params.getTestsuite().getTestcase().length;
        for (int i = 0; i < numberOfTestCases; i++) {
            TestCaseDTO testCaseDTO = params.getTestsuite().getTestcase()[i];
            System.out.println("Testcase " + (i + 1) + ": " + testCaseDTO.getName());
            int numberOfTestSteps = testCaseDTO.getStep().length;
            for (int j = 0; j < numberOfTestSteps; j++) {
                TestStepDTO testStepDTO = testCaseDTO.getStep()[j];
                System.out.println("\tStep name " + (j + 1) + " : " + testStepDTO.getName());
                int k = 0;
                System.out.println("\t\t" + (k + 1) + ". Name: " + testStepDTO.getName());
                System.out.println("\t\t" + (k + 2) + ". Action: " + testStepDTO.getAction());
                System.out.println("\t\t" + (k + 3) + ". Locate Element By: " + testStepDTO.getLocateElement().getBy());
                System.out.println("\t\t" + (k + 4) + ". Locate Element Value: " + testStepDTO.getLocateElement().getValue());
                if (testStepDTO.getTexttoWrite() != null){
                System.out.println("\t\t" + (k + 5) + ". Text To Write: " + testStepDTO.getTexttoWrite());}

            }

        }

    }

    public void example() throws FileNotFoundException {
        Gson gson = new Gson();

        // 1. JSON to Java object, read it from a file.
//        Staff staff = gson.fromJson(new FileReader("D:\\file.json"), Staff.class);
        // 2. JSON to Java object, read it from a Json String.
//        String jsonInString = "{'name' : 'mkyong'}";
//        Staff staff = gson.fromJson(jsonInString, Staff.class);

// JSON to JsonElement, convert to String later.
//        JsonElement json = gson.fromJson(new FileReader("D:\\file.json"), JsonElement.class);
//        String result = gson.toJson(json);

//        TestSuiteJson suite = gson.fromJson(new FileReader("sampleAItest.json"), TestSuiteJson.class);
        /*TestParams[] params = gson.fromJson(new FileReader("sampleAItest.json"), TestParams[].class);
        System.out.println(params[0].getBrowser());
        System.out.println(params[0].getURL());
        System.out.println(params[0].getTestsuite().getName());
        System.out.println(params[0].getTestsuite().getTestcase()[0].getName());
        System.out.println(params[0].getTestsuite().getTestcase()[0].getStep()[0].getName());
        System.out.println(params[0].getTestsuite().getTestcase()[0].getStep()[0].getAction());
        System.out.println(params[0].getTestsuite().getTestcase()[0].getStep()[0].getLocateElement().getBy());
        System.out.println(params[0].getTestsuite().getTestcase()[0].getStep()[0].getLocateElement().getValue());
        System.out.println(params[0].getTestsuite().getTestcase()[0].getStep()[0].getTexttoWrite());*/

        TestParamsDTO params = gson.fromJson(new FileReader("sampleAItest.json"), TestParamsDTO.class);
        System.out.println(params.getBrowser());
        System.out.println(params.getURL());
        System.out.println(params.getTestsuite().getName());
        System.out.println("Number of testcases: " + params.getTestsuite().getTestcase().length);
        System.out.println(params.getTestsuite().getTestcase()[0].getName());
        System.out.println("Number of test steps of testcase 1: " + params.getTestsuite().getTestcase()[0].getStep().length);
        System.out.println(params.getTestsuite().getTestcase()[0].getStep()[0].getName());
        System.out.println(params.getTestsuite().getTestcase()[0].getStep()[0].getAction());
        System.out.println(params.getTestsuite().getTestcase()[0].getStep()[0].getLocateElement().getBy());
        System.out.println(params.getTestsuite().getTestcase()[0].getStep()[0].getLocateElement().getValue());
        System.out.println(params.getTestsuite().getTestcase()[0].getStep()[0].getTexttoWrite());
    }

    public TestParamsDTO getTestParamsDTO() {
        return testParamsDTO;
    }

    public void setTestParamsDTO(TestParamsDTO testParamsDTO) {
        this.testParamsDTO = testParamsDTO;
    }

    public TestSuiteDTO getTestSuiteDTO() {
        return testSuiteDTO;
    }

    public void setTestSuiteDTO(TestSuiteDTO testSuiteDTO) {
        this.testSuiteDTO = testSuiteDTO;
    }

    public TestCaseDTO[] getTestCaseDTO() {
        return testCaseDTO;
    }

    public void setTestCaseDTO(TestCaseDTO[] testCaseDTO) {
        this.testCaseDTO = testCaseDTO;
    }

    public TestStepDTO[] getTestStepDTO() {
        return testStepDTO;
    }

    public void setTestStepDTO(TestStepDTO[] testStepDTO) {
        this.testStepDTO = testStepDTO;
    }

    public LocateElementDTO getLocateElementDTO() {
        return locateElementDTO;
    }

    public void setLocateElementDTO(LocateElementDTO locateElementDTO) {
        this.locateElementDTO = locateElementDTO;
    }
}
