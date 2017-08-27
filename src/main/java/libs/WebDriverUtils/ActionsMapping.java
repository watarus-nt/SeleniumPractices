package libs.WebDriverUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WataruS on 8/26/2017.
 */
public class ActionsMapping {
    public static Map<String, String> actions = new HashMap<String, String>();

    static {
        actions.put("Go to URL".toLowerCase(), "getLink");
        actions.put("Click".toLowerCase(), "click");
        actions.put("Write Text".toLowerCase(), "type_Text");
        actions.put("Print in Results".toLowerCase(), "printResult");
        actions.put("Select Option".toLowerCase(), "selectOption");
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


}
