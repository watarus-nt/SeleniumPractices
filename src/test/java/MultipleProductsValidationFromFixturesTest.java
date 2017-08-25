import com.awfulValentine.ProductValidationSingleProduct;
import com.awfulValentine.TestData;
import libs.WebDriverUtils.SeleniumKeywords;
import libs.WebDriverUtils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Logs.Log;
import utils.Utility;

import java.util.Map;


public class MultipleProductsValidationFromFixturesTest {
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
    public void productValidationFromFixtures() {
        Map<String, Object> products = TestData.getProductFixtures();
        for (String key : products.keySet()) {
            log.info("#############################Validating product with fixture \"" + key + "\"#############################");
            try {
                productValidationSingleProduct.validateProductsFromFixture(driver, key);
            } catch (Exception e) {
                log.info(e.getMessage());
            }
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}