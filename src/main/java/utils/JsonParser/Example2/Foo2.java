package utils.JsonParser.Example2;

import com.google.gson.Gson;

import java.io.FileReader;
import java.util.ArrayList;


public class Foo2 {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        TypeDTO2[] myTypes = gson.fromJson(new FileReader("src/main/java/utils/JsonParser/Example1/input2.json"), TypeDTO2[].class);
        System.out.println(gson.toJson(myTypes));
    }
}

class TypeDTO2 {
    int id;
    String name;
    ArrayList<ItemDTO2> items[];
}

class ItemDTO2 {
    int id;
    String name;
    Boolean valid;
}