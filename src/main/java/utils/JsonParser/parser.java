package utils.JsonParser;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class parser {
    public static void main(String[] args) throws FileNotFoundException {
        parser p = new parser();
        p.printTestSuiteDetails();
    }


    public void printTestSuiteDetails() throws FileNotFoundException {
        Gson gson = new Gson();
        TestParams params = gson.fromJson(new FileReader("sampleAItest.json"), TestParams.class);
        System.out.println(params.getBrowser());
        System.out.println(params.getURL());
        System.out.println(params.getTestsuite().getName());
        int numberOfTestCases = params.getTestsuite().getTestcase().length;
        for (int i = 0; i < numberOfTestCases; i++) {
            TestCaseJson testCaseJson = params.getTestsuite().getTestcase()[i];
            System.out.println("Testcase " + (i + 1) + ": " + testCaseJson.getName());
            int numberOfTestSteps = testCaseJson.getStep().length;
            for (int j = 0; j < numberOfTestSteps; j++) {
                int k = 0;
                TestStepJson testStepJson = testCaseJson.getStep()[j];
                System.out.println("\tStep name: " + testStepJson.getName());
                System.out.println("\t\t" + (k + 1) + ". Name: " + testStepJson.getName());
                System.out.println("\t\t" + (k + 2) + ". Action: " + testStepJson.getAction());
                System.out.println("\t\t" + (k + 3) + ". Locate Element By: " + testStepJson.getLocateElement().getBy());
                System.out.println("\t\t" + (k + 4) + ". Locate Element Value: " + testStepJson.getLocateElement().getValue());
                System.out.println("\t\t" + (k + 5) + ". Text To Write: " + testStepJson.getTexttoWrite());
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

        TestParams params = gson.fromJson(new FileReader("sampleAItest.json"), TestParams.class);
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


}
