/**
 * Created by WataruS on 8/26/2017.
 */

import libs.WebDriverUtils.SeleniumKeywords;
import libs.WebDriverUtils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Logs.Log;
import utils.Utility;

public class ExampleTest {
    Log log;
    private WebDriver driver;
    private SeleniumKeywords seleniumKeywords;

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(String browser) throws Exception {
        log = Utility.createLog(this.getClass().getSimpleName());
        driver = WebDriverManager.createWebDriver(browser, log);
        seleniumKeywords = new SeleniumKeywords(driver, log);
    }

    @Test
    public void testName() throws Exception {

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
