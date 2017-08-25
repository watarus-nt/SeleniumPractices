import com.awfulValentine.ProductValidationSingleProduct;
import libs.WebDriverUtils.SeleniumKeywords;
import libs.WebDriverUtils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Logs.Log;
import utils.Utility;


public class SingleProductValidationTest {

    Log log;
    private ProductValidationSingleProduct productValidationSingleProduct;
    private WebDriver driver;
    private SeleniumKeywords seleniumKeywords;

    @BeforeTest
    public void setUp() throws Exception {
        log = Utility.createLog(this.getClass().getSimpleName());
        driver = WebDriverManager.createWebDriver("ChromeDriver", log);
        seleniumKeywords = new SeleniumKeywords(driver, log);
        productValidationSingleProduct = new ProductValidationSingleProduct(seleniumKeywords);
    }


    @Test
    public void validateSingleProduct() {
        try {
            productValidationSingleProduct.validateProduct(driver);
        } catch (Exception e) {
            log.info(e.getMessage());
        }

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}