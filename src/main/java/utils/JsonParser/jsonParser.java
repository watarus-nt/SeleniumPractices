package utils.JsonParser;

import com.google.gson.Gson;

import java.io.FileReader;
import java.util.ArrayList;

public class jsonParser {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        TestParamsDTO[] myTypes = gson.fromJson(new FileReader("sampleAItest.json"), TestParamsDTO[].class);
        System.out.println(gson.toJson(myTypes));
        System.out.println();
        System.out.println();

    }
}

class TestParamsDTO {
    String browser;
    String URL;
    testSuiteDTO testsuite;
}

class testSuiteDTO {
    String name;
    ArrayList<testCaseDTO> testcase;
}

class testCaseDTO {
    String name;
    ArrayList<testStepDTO> step;
}

class testStepDTO {
    String name;
    String action;
    String texttoWrite;
    locateElementDTO locateElement;
}

class locateElementDTO {
    String by;
    String value;
}

