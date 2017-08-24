
package utils.ConfigFile;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by HungT on 8/13/2015.
 */
public class LoadConfigFile {
    public static String baseURL;
    public static String username;
    public static String password;


    public static String getPropertyByName(String property) {

        Properties prop = new Properties();
        InputStream input = null;
        String filename = "config.properties";

        try {


//	    		input = LoadConfigFile.class.getClassLoader().getResourceAsStream(filename);
            input = new FileInputStream(filename);

	    	/*	if(input==null){
                        System.out.println("Sorry, unable to find " + filename);
	    		    return " ";
	    		}
	 */
            //load a properties file from class path, inside static method
            //C:\Users\tranmanhhung\workspace\TIS_Traning\bin
            prop.load(input);

            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                if (key.equals(property)) {
                    return prop.getProperty(key);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return " ";
    }
}
