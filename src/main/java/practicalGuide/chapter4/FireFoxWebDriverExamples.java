package practicalGuide.chapter4;

import libs.WebDriverUtils.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class FireFoxWebDriverExamples extends DriverBase {

    public FireFoxWebDriverExamples(String browser) {
        super(browser);
    }

    public static void main(String[] args) {
        FireFoxWebDriverExamples fireFoxDriverExamples = new FireFoxWebDriverExamples("firefox");
        /*
        WebDriver driver = fireFoxDriverExamples.getDriver();
        driver.get("http://www.google.com/ncr");
        */
        fireFoxDriverExamples.addExtensionToProfileExample().get("http://www.google.com");

    }

    public WebDriver addExtensionToProfileExample() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        try {
            firefoxProfile.addExtension(new File("FirefoxExtensions//firebug@software.joehewitt.com.xpi"));
//            firefoxProfile.addExtension(new File("FirefoxExtensions//FireXPath@pierre.tholence.com.xpi"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        WebDriver driver = new FirefoxDriver(firefoxProfile);
        return driver;
    }

}
