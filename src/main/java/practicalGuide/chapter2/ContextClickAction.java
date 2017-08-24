package practicalGuide.chapter2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by tranmanhhung on 8/6/2017.
 */
public class ContextClickAction extends MouseBasedInteractions {
    public ContextClickAction() {
        super();
    }

    public static void main(String[] args) {
        ContextClickAction contextClickAction = new ContextClickAction();

        WebDriver driver = contextClickAction.getDriver();

        String htmlFile = contextClickAction.getWorkingDirectory() + "\\HTML\\Chapter 2\\HTML\\ContextClick.html";
        System.out.println("htmlFile = " + htmlFile);


//        contextClickAction.contextClickCurrentLocationExample(driver);
        contextClickAction.contextClickOnElement(driver);
    }

    public void contextClickCurrentLocationExample(WebDriver driver) {

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("div-context")))
                .contextClick()
                .click(driver.findElement(By.name("Item 3")))
                .perform();


    }

    public void contextClickOnElement(WebDriver driver) {
        Actions builder = new Actions(driver);
        builder.contextClick(driver.findElement(By.id("div-context")))
                .click(driver.findElement(By.name("Item 3")))
                .perform();
    }
}
