package utils.WebEventListeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class DebugListenersExtends extends AbstractWebDriverEventListener {
/*    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to find " + element.toString()+ " By: " + by.toString());
    }


    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found " + element.toString() + " By: " + by.toString());
    }*/

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to - Current url: " + driver.getCurrentUrl() + " | Target url: " + url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("After navigating to - Target url: " + url + " | Current url: " + driver.getCurrentUrl());
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        System.out.println("Exception occurs: ");
        System.out.println(throwable.getMessage());
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on: " + element.toString());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on: " + element.toString());
    }
}
