package practicalGuide.chapter5;

import libs.WebDriverUtils.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class IAmTheWebDriver extends DriverBase {
    public static void main(String... args) {
        IAmTheWebDriver iAmTheDriver = new IAmTheWebDriver();
        WebDriver driver = iAmTheDriver.getDriver();

        EventFiringWebDriver eventFiringDriver = new EventFiringWebDriver(driver);
        IAmTheEventListener2 eventListener = new IAmTheEventListener2();
        eventFiringDriver.register(eventListener);

        eventFiringDriver.get("http://www.google.com");
        eventFiringDriver.get("http://www.facebook.com");

        eventFiringDriver.navigate().forward();


    }

}
