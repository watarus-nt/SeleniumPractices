package libs.WebDriverUtils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import utils.Listeners.TestNGCustom;
import utils.Logs.Log;

/**
 * Created by tranmanhhung on 8/6/2017.
 */

@Listeners(TestNGCustom.class)
public class DriverBase {
    public static WebDriver driver;
    public static Log log;


    private static String workingDirectory = System.getProperty("user.dir");

    public DriverBase(WebDriver driver, Log log) {
        this.driver = driver;
        this.log = log;
        this.driver.manage().window().maximize();
    }

    public DriverBase() {
        setDriver(WebDriverManager.initialChromeDriverWithoutProxy());
    }

    public DriverBase(String browser) {

        switch (browser.toLowerCase()) {
            case "firefox":
                setDriver(WebDriverManager.initialFirefoxDriver());
                break;
            case "chrome":
                setDriver(WebDriverManager.initialChromeDriverWithoutProxy());
                break;
            case "ie":
                setDriver(WebDriverManager.initialInternetExplorer());
                break;
        }
    }

    public DriverBase(String browser, Boolean SSLcertificate) {
        new DriverBase(browser);
    }

    public WebDriver getDriver() {

        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().window().maximize();
    }

    public String getWorkingDirectory() {
        return workingDirectory;
    }

    public void setWorkingDirectory(String workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

}
