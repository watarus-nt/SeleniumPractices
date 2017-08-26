package utils.JsonParser.Example2;

import com.google.gson.Gson;

import java.io.FileReader;
import java.util.ArrayList;

public class Foo {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        TypeDTO[] myTypes = gson.fromJson(new FileReader("src/main/java/utils/JsonParser/Example1/input.json"), TypeDTO[].class);
        System.out.println(gson.toJson(myTypes));
    }
}

class TypeDTO {
    int id;
    String name;
    ArrayList<ItemDTO> items;
}

class ItemDTO {
    int id;
    String name;
    Boolean valid;
}