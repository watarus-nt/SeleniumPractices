import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import practicalGuide.chapter3.CookieExamples;

public class CookieExample {
    private WebDriver driver;
    private String cookieFileName = "browser.data";
    private CookieExamples cookieExamples;

    @BeforeTest
    public void setUp() {
        cookieExamples = new CookieExamples();
        this.driver = cookieExamples.getDriver();
    }


    @Test
    public void testLoginGoogle() {
        cookieExamples.loginGoogle(this.driver);

    }

    @Test
    public void testLoginFacebook() {
        cookieExamples.loginFacebook(this.driver);

    }

    @Test
    public void testLoginPackpubt() {
        cookieExamples.loginPacktpub(this.driver);

    }


    @AfterTest
    public void tearDown() {
        this.driver.close();
    }
}
