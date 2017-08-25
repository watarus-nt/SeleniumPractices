import com.awfulValentine.PurchaseForm;
import libs.WebDriverUtils.SeleniumKeywords;
import libs.WebDriverUtils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Logs.Log;
import utils.Utility;


public class PurchaseFormTest {
    Log log;
    private WebDriver driver;
    private PurchaseForm purchaseFormTest;
    private SeleniumKeywords seleniumKeywords;

    @BeforeTest
    public void setUp() throws Exception {
        log = Utility.createLog(this.getClass().getSimpleName());
        driver = WebDriverManager.createWebDriver("ChromeDriver", log);
        seleniumKeywords = new SeleniumKeywords(driver, log);
        purchaseFormTest = new PurchaseForm(seleniumKeywords);
    }

    @Test
    public void perfectWorldTest() throws Exception {
        purchaseFormTest.purchaseTest("perfect-world");
    }

    @Test
    public void slowAjaxTest() throws Exception {
        purchaseFormTest.purchaseTest("slow-ajax");
    }

    @Test
    public void slowAnimationTest() throws Exception {
        purchaseFormTest.purchaseTest("slow-animation");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}