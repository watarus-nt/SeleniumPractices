package practicalGuide.chapter2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by tranmanhhung on 8/6/2017.
 */
public class DoubleClickAction extends MouseBasedInteractions {
    private WebElement button;

    public DoubleClickAction() {
        super();
    }

    public static void main(String[] args) {
        DoubleClickAction doubleClickAction = new DoubleClickAction();
        WebDriver driver = doubleClickAction.getDriver();

        String htmlFile = doubleClickAction.getWorkingDirectory() + "\\HTML\\Chapter 2\\HTML\\DoubleClick.html";
        System.out.println("htmlFile = " + htmlFile);
        doubleClickAction.setButton(driver.findElement(By.name("dblClick")));

        doubleClickAction.doubleClickExample(driver);

    }

    public WebElement getButton() {
        return button;
    }

    public void setButton(WebElement button) {
        this.button = button;
    }

    public void doubleClickExample(WebDriver driver) {
        Actions builder = new Actions(driver);
//        builder.doubleClick(getButton()).perform();

        builder.moveToElement(getButton()).doubleClick().perform();
    }
}
