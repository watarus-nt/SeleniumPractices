package practicalGuide.chapter4;

import libs.WebDriverUtils.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebEventListeners.DebugListenersExtends;

public class SSLcertificateExamples extends DriverBase {

    public SSLcertificateExamples(String browser, Boolean SSLcertificate) {
        super(browser, SSLcertificate);
    }

    public static void main(String[] args) {
        String browser = "chrome";
//        String browser = "ie";

        SSLcertificateExamples ssLcertificateExamples = new SSLcertificateExamples(browser, true);
        WebDriver driver = ssLcertificateExamples.getDriver();

        DebugListenersExtends debugListenersExtends = new DebugListenersExtends();
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(debugListenersExtends);

        String url = "https://192.168.211.30:8443/mgmt";

        ssLcertificateExamples.loginToPolicyGuru(eventFiringWebDriver, url);
        eventFiringWebDriver.quit();
    }

    public void loginToPolicyGuru(WebDriver driver, String url) {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        if (driver instanceof InternetExplorerDriver) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.name("overridelink")));
                driver.findElement(By.name("overridelink")).click();
            } catch (NoSuchElementException ex) {
                System.out.println("Can't find overridelink");
                System.exit(1);
            }
        }

        By usernameLocator = By.name("userName");
        By passwordLocator = By.name("password");

        wait.until(ExpectedConditions.elementToBeClickable(usernameLocator));
        driver.findElement(usernameLocator).sendKeys("admin");
        driver.findElement(passwordLocator).sendKeys("SecureLogix1!");
        driver.findElement(passwordLocator).submit();

        try {
            wait.until(ExpectedConditions.titleContains("Realtime"));
            System.out.println("Passed - LoginEndTest succesfully!");
        } catch (Exception ex) {
            System.out.println("Failed - LoginEndTest failed, the page's tile doesn't contains \"Realtime\"");
            ex.printStackTrace();
        }
    }


}
