package practicalGuide.chapter2;

import libs.WebDriverUtils.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by tranmanhhung on 8/5/2017.
 */
public class ActionBuildPerform extends DriverBase {
    private static WebElement one;
    private static WebElement three;
    private static WebElement five;

    public ActionBuildPerform() {
        super();
    }

    public ActionBuildPerform(String browser) {
        super(browser);
    }

    public static void clickElements3steps(WebDriver driver) {
        // Add all the actions into the Actions builder.
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL)
                .click(one)
                .click(three)
                .click(five)
                .keyUp(Keys.CONTROL);
        // Generate the composite action.
        Action compositeAction = builder.build();
        // Perform the composite action.
        compositeAction.perform();
    }

    public static void clickElements2steps(WebDriver driver) {
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL)
                .click(one)
                .click(three)
                .click(five)
                .keyUp(Keys.CONTROL);


        builder.perform();
    }

    public static void moveByOffsetAndClick(WebDriver driver) {
        Actions builder = new Actions(driver);
        builder.moveByOffset(three.getLocation().getX() + 1, three.getLocation().getY() + 1)
                .click()
                .perform();
    }

    public static void moveByOffsetFrom1to11to5(WebDriver driver) throws InterruptedException {
        int border = 1;
        int width = 100;
        int height = 80;

        Actions builder = new Actions(driver);
        //move to tile 1
        builder.moveByOffset(one.getLocation().getX() + 1, one.getLocation().getY() + 1)
                .click().perform();
        Thread.sleep(3000);
        //move to tile 11
        int tileX = 2 * width + 4 * border;
        int tileY = 2 * height + 4 * border;
        System.out.println("Tile 11X = " + tileX + " - Tile11Y = " + tileY);
        builder.moveByOffset(tileX, tileY)
                .click().perform();
        //move to tile 5
        Thread.sleep(3000);
        tileX = -2 * width - 4 * border;
        tileY = -height - 2 * border;
        System.out.println("Tile 5X = " + tileX + " - Tile5Y = " + tileY);
        builder.moveByOffset(tileX, tileY)
                .click().perform();
    }

    public static void clickOnWebElement(WebDriver driver) {
        Actions builder = new Actions(driver);
        builder.click(one)
                .click(three)
                .click(five)
                .perform();
    }

    public static void main(String[] args) throws InterruptedException {
        ActionBuildPerform actionBuildPerform = new ActionBuildPerform();
        WebDriver driver = actionBuildPerform.getDriver();

        String htmlFile = actionBuildPerform.getWorkingDirectory() + "\\HTML\\Chapter 2\\HTML\\Selectable.html";
        System.out.println("htmlFile = " + htmlFile);
        driver.get(htmlFile);
        one = driver.findElement(By.name("one"));
        three = driver.findElement(By.name("three"));
        five = driver.findElement(By.name("five"));

        clickElements3steps(driver);
        Thread.sleep(3000);
        clickElements2steps(driver);
        moveByOffsetAndClick(driver);

        moveByOffsetFrom1to11to5(driver);
        clickOnWebElement(driver);


    }

}

