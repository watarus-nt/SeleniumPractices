package practicalGuide.chapter5;

import libs.WebDriverUtils.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Listeners extends DriverBase {
    public static void main(String[] args) {

        Listeners listeners = new Listeners();
        WebDriver driver = listeners.getDriver();

        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        IAmTheEventListener2 iAmTheEventListener2 = new IAmTheEventListener2();
        IAmTheEventListener iAmTheEventListener = new IAmTheEventListener();


        eventFiringWebDriver.register(iAmTheEventListener2);
//        eventFiringWebDriver.register(iAmTheEventListener);

        eventFiringWebDriver.navigate().to("http://www.google.com");
//        eventFiringWebDriver.get("http://www.facebook.com");
        eventFiringWebDriver.findElement(By.name("q")).sendKeys("packpubt");
//        eventFiringWebDriver.findElement(By.name("q")).submit();

        eventFiringWebDriver.findElement(By.name("btnK")).click();

    }
}
