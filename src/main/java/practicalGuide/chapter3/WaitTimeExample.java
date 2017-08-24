package practicalGuide.chapter3;

import libs.WebDriverUtils.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitTimeExample extends DriverBase {
    public static void main(String[] args) {
        WaitTimeExample waitTimeExample = new WaitTimeExample();
        WebDriver driver = waitTimeExample.getDriver();
//        waitTimeExample.ImplicitWaitTimeExample(driver);
//        waitTimeExample.ExplicitWaitTimeExample(driver);
//        waitTimeExample.testExplicitWaitTitleContains(driver);
        waitTimeExample.testFluentWait(driver);
    }

    public void ImplicitWaitTimeExample(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://www.google.com");
//        driver.get("https://192.168.36.246:8443/mgmt");
        if (driver.findElement(By.name("q")).isDisplayed()) {
            System.out.println("Google Search page is loaded.");
        } else {
            System.out.println("Google Search page hasn't been loaded.");
        }
    }

    public void ExplicitWaitTimeExample(WebDriver driver) {
        driver.get("http://www.google.com");
        WebElement element = (new WebDriverWait(driver, 20)).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.name("q"));
            }
        });
        element.sendKeys("Packtpub");
        element.submit();
    }

    public void testExplicitWaitTitleContains(WebDriver driver) {
        driver.get("http://www.google.com/ncr");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("packtpub");
        searchBox.submit();

        //Create Wait using WebDriverWait.
        //This will wait for 10 seconds for timeout before title is updated with search term
        //If title is updated in specified time limit test will move to the text step
        //instead of waiting for 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //The WebDriverWait object will call the ExpectedConditions class object every 500 milliseconds until
        // it returns successfully.
        wait.until(ExpectedConditions.titleContains("packtpub"));

        System.out.println(driver.getTitle());
    }

    public void testFluentWait(WebDriver driver) {
        driver.get("http://www.google.com/ncr");
        try {
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("packtpub");
            searchBox.submit();

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(10, TimeUnit.SECONDS)
                    .pollingEvery(2, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);

            WebElement twitterLink = wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.partialLinkText("twitter"));
                }
            });
            driver.findElement(By.partialLinkText("twitter"));

        } catch (Exception ex) {

        }
    }
}
