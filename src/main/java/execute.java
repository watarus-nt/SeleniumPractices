import utils.AI_Script_File.WriteScriptFile;
import utils.AI_XML_File.WriteTestXML;

/**
 * Created by WataruS on 8/27/2017.
 */
public class execute {
    public static void main(String[] args) throws Exception {
        WriteTestXML writeTestXML = new WriteTestXML();
        writeTestXML.createXml();
        writeTestXML.writeToFile();

        WriteScriptFile writeScriptFile = new WriteScriptFile();

        writeScriptFile.generateTestScripts();
    }
}
