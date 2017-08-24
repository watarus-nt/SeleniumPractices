package practicalGuide.chapter2;

import libs.WebDriverUtils.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by tranmanhhung on 8/6/2017.
 */
public class MouseBasedInteractions extends DriverBase {

    public MouseBasedInteractions() {
        super();
    }

    public MouseBasedInteractions(String browser) {
        super(browser);
    }

    public static void main(String[] args) throws InterruptedException {

        MouseBasedInteractions mouseBasedInteractions = new MouseBasedInteractions();
        WebDriver driver = mouseBasedInteractions.getDriver();

        String htmlFile = mouseBasedInteractions.getWorkingDirectory() + "\\HTML\\Chapter 2\\HTML\\Sortable.html";
        System.out.println("htmlFile = " + htmlFile);

        driver.get(htmlFile);
        mouseBasedInteractions.clickAndHoldAtCurrentLocation();
        Thread.sleep(1000);
        mouseBasedInteractions.clickAndHoldOnWebElement(driver);
        Thread.sleep(1000);
        mouseBasedInteractions.releaseOnWebElement(driver);
        Thread.sleep(1000);
        mouseBasedInteractions.moveToElement(driver);
    }

    public void clickAndHoldAtCurrentLocation() {
        Actions builder = new Actions(this.getDriver());
        builder.moveByOffset(200, 200)
                .clickAndHold()
                .moveByOffset(120, 0)
                .release()
                .perform();
    }

    public void clickAndHoldOnWebElement(WebDriver driver) {
        WebElement six = driver.findElement(By.name("six"));


        Actions builder = new Actions(driver);
        builder.clickAndHold(six)
                .moveByOffset(-120, -20)
                .release()
                .perform();

    }

    public void releaseOnWebElement(WebDriver driver) {
        WebElement six = driver.findElement(By.name("six"));
        WebElement one = driver.findElement(By.name("one"));

        Actions builder = new Actions(driver);
        builder.clickAndHold(six)
                .release(one)
                .perform();
    }

    public void moveToElement(WebDriver driver) {
        WebElement two = driver.findElement(By.name("two"));
        WebElement ten = driver.findElement(By.name("ten"));

        Actions builder = new Actions(driver);
        builder.moveToElement(ten)
                .clickAndHold()
//                .moveToElement(two)
                .release(two)
                .perform();
//        builder.clickAndHold(ten)
//                .release(two)
//                .perform();
    }
}
