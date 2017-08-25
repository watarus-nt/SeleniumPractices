package utils.JsonParser;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class parser {
    public static void main(String[] args) throws FileNotFoundException {
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
        TestParams[] params = gson.fromJson(new FileReader("sampleAItest.json"), TestParams[].class);
        System.out.println(params[0].getBrowser());
        System.out.println(params[0].getURL());
        System.out.println(params[0].getTestsuite().getName());
        System.out.println(params[0].getTestsuite().getTestcase()[0].getName());
        System.out.println(params[0].getTestsuite().getTestcase()[0].getStep()[0].getName());
        System.out.println(params[0].getTestsuite().getTestcase()[0].getStep()[0].getAction());
        System.out.println(params[0].getTestsuite().getTestcase()[0].getStep()[0].getLocateElement().getBy());
        System.out.println(params[0].getTestsuite().getTestcase()[0].getStep()[0].getLocateElement().getValue());
        System.out.println(params[0].getTestsuite().getTestcase()[0].getStep()[0].getTexttoWrite());

    }
}
