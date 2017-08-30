package libs.WebDriverUtils;

import utils.Utility;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WataruS on 8/26/2017.
 */
public class ActionsMapping {
    public static Map<String, String> actions = new HashMap<String, String>();

    static {
        try {
            initialMapping();
            System.out.println("Load mapping succesfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        actions.put("Go to URL".toLowerCase(), "getLink");
//        actions.put("Click".toLowerCase(), "click");
//        actions.put("Write Text".toLowerCase(), "type_Text");
//        actions.put("Select Option".toLowerCase(), "selectOption");
//        actions.put(LoadConfigFile.getPropertyByName())
    }

    public static Boolean checkActionExists(String inputAction){
        return actions.containsKey(inputAction);
    }

    public static String getAction(String inputAction){
        if (checkActionExists(inputAction)){
            return actions.get(inputAction);
        } else {
            return null;
        }
    }


    public static void initialMapping() throws IOException {
        List<String> content = Utility.readFileLineByLine("config.properties");
        for (String line : content) {
            if (line.contains("selenium.")) {
                String keyword = line.split("=")[0].split("\\.")[1];
                String inputAction = line.split("=")[1].toLowerCase();
                actions.put(inputAction.trim().replaceAll("\\s+", ""), keyword);
            }
        }
    }



}
