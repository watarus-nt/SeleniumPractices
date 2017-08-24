package practicalGuide.chapter5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class IAmTheEventListener2 extends AbstractWebDriverEventListener {

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("IAmTheEventListener2: Before Navigate To: " + url
                + " and Current url is: " + driver.getCurrentUrl());

    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("IAmTheEventListener2: After Navigate To: " + url
                + " and Current url is: " + driver.getCurrentUrl());

    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("IAmTheEventListener2: Before Navigate Back. Right now I'm at "
                + driver.getCurrentUrl());

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        System.out.println("IAmTheEventListener2: After Navigate Back. Right now I'm at "
                + driver.getCurrentUrl());

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on: " + element.toString());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on: " + element.toString());
    }

    /*    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to find " + element.toString()+ " By: " + by.toString());
    }


    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found " + element.toString() + " By: " + by.toString());
    }*/
}
