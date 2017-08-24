package libs.WebDriverUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AI_SeleniumKeywords {
    private WebDriverWait wait;
    private WebDriver driver;

    public AI_SeleniumKeywords(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    /*
    @Param url: the http url of the website you wanna open
     */
    public void getLink(String url) {
        try {
            driver.get(url);
        } catch (Exception ex) {

        }
    }

}
