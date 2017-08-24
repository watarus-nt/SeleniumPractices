package practicalGuide.chapter3;

import libs.WebDriverUtils.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class WindowHandlingExample extends DriverBase {
    public WindowHandlingExample() {
        super();
    }

    public static void main(String[] args) {
        WindowHandlingExample windowHandlingExample = new WindowHandlingExample();
        WebDriver driver = windowHandlingExample.getDriver();
//        windowHandlingExample.switchWindowExample(driver);
        windowHandlingExample.swtichAmongFrames(driver);
    }

    public void switchWindowExample(WebDriver driver) {

        String htmlFile = this.getWorkingDirectory() + "\\HTML\\Chapter 3\\HTML\\Window.html";
        driver.get(htmlFile);

        System.out.println("htmlFile = " + htmlFile);
        String window1 = driver.getWindowHandle();
        System.out.println("First window handle is: " + window1);

        openLinkInNewWindow(driver);
        String window2 = driver.getWindowHandle();
        System.out.println("Second window handle is: " + window2);
        System.out.println("Title of second window: " + driver.getTitle());

        System.out.println("Number of window handles so far: " + driver.getWindowHandles().size());
        System.out.println("Switch back to first window: ");
        driver.switchTo().window(window1);
        System.out.println("Title: " + driver.getTitle());

        closeAllOpenWindows(driver);
    }

    public void openLinkInNewWindow(WebDriver driver) {
        WebElement googleLink = driver.findElement(By.linkText("Google Search"));
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.SHIFT)
                .click(googleLink)
                .keyUp(Keys.SHIFT)
                .perform();
        ArrayList<String> setWindow = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(setWindow.get(setWindow.size() - 1));

    }

    public void closeAllOpenWindows(WebDriver driver) {
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window).close();
        }
    }

    public void swtichAmongFrames(WebDriver driver) {
        String htmlFile = this.getWorkingDirectory() + "\\HTML\\Chapter 3\\HTML\\Frames.html";
        driver.get(htmlFile);

        driver.switchTo().frame(0);
        WebElement textbox1 = driver.findElement(By.name("1"));
        textbox1.sendKeys("Frame 1");

        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);
        WebElement textbox2 = driver.findElement(By.name("2"));
        textbox2.sendKeys("Frame 2");

    }

}
