package utils.JsonParser.Example4;

import com.google.gson.Gson;

import java.io.FileReader;
import java.util.ArrayList;

public class jsonParser {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        TestParamsJson[] myTypes = gson.fromJson(new FileReader("sampleAItest.json"), TestParamsJson[].class);
        System.out.println(gson.toJson(myTypes));
        System.out.println();
        System.out.println();

    }
}

class TestParamsJson {
    String browser;
    String URL;
    testSuiteJson testsuite;
}

class testSuiteJson {
    String name;
    ArrayList<testCaseJson> testcase;
}

class testCaseJson {
    String name;
    ArrayList<testStepJson> step;
}

class testStepJson {
    String name;
    String action;
    String texttoWrite;
    locateElementJson locateElement;
}

class locateElementJson {
    String by;
    String value;
}

