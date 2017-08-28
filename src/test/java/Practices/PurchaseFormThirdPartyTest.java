package Practices;

import com.awfulValentine.PurchaseForm;
import libs.WebDriverUtils.SeleniumKeywords;
import libs.WebDriverUtils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Logs.Log;
import utils.Utility;


public class PurchaseFormThirdPartyTest {
    Log log;
    private WebDriver driver;
    private PurchaseForm purchaseFormTest;
    private SeleniumKeywords seleniumKeywords;

    @BeforeTest
    public void setUp() throws Exception {
        log = Utility.createLog(this.getClass().getSimpleName());
//        driver = WebDriverManager.createWebDriver("ChromeProxy", log);
        driver = WebDriverManager.createWebDriver("FirefoxProxy", log);
        seleniumKeywords = new SeleniumKeywords(driver, log);
        purchaseFormTest = new PurchaseForm(seleniumKeywords);
    }

    @Test//(invocationCount = 20)
    public void thirdPartyTest() throws Exception {
        purchaseFormTest.purchaseTest("3rd-party-links");

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}