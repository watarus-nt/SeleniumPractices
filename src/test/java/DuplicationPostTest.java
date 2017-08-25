import com.awfulValentine.DuplicationPost;
import com.awfulValentine.ProductReview;
import libs.WebDriverUtils.SeleniumKeywords;
import libs.WebDriverUtils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Logs.Log;
import utils.Utility;


public class DuplicationPostTest {
    Log log;
    private WebDriver driver;
    private ProductReview productReview;
    private SeleniumKeywords seleniumKeywords;

    @BeforeTest
    public void setUp() throws Exception {
        log = Utility.createLog(this.getClass().getSimpleName());
        driver = WebDriverManager.createWebDriver("ChromeDriver", log);
        seleniumKeywords = new SeleniumKeywords(driver, log);
        productReview = new ProductReview(seleniumKeywords);
    }

    @Test
    public void test_add_duplicate_post() throws Exception {
/*        String nameText = "w";
        String commentText = "####This is a test comment generated by Selenium" + nameText;
        String emailText = "w@selenium.com";
        String websiteUrl = "www.selenium.com";*/
        productReview.postCommentTwice(driver);

        DuplicationPost duplicationPost = new DuplicationPost(seleniumKeywords);
        duplicationPost.verifyDuplicate(driver);
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}