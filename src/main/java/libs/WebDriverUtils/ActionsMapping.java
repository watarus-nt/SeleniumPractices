package libs.WebDriverUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WataruS on 8/26/2017.
 */
public class ActionsMapping {
    private static Map<String, String> actions = new HashMap<String, String>();

    public ActionsMapping(){
        actions.put("Go to URL".toLowerCase(), "getLink");
        actions.put("Click".toLowerCase(), "click");
        actions.put("Write Text".toLowerCase(), "type_text");
        actions.put("Print in Results".toLowerCase(), "printResult");
        actions.put("Select Option".toLowerCase(), "selectOption");




    }


}
