package utils.JsonParser.Example1;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class JsonToJava {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        Person person = gson.fromJson(new FileReader("src/main/java/utils/JsonParser/Example1/server1.json"), Person.class);

        System.out.println(person);

    }
}
