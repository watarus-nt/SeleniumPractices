package practicalGuide.chapter5;

import libs.WebDriverUtils.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.WebEventListeners.DebugListenersExtends;

public class EventListenerExamples extends DriverBase {

    public static void main(String[] args) throws InterruptedException {
        EventListenerExamples eventListenerExamples = new EventListenerExamples();
        WebDriver driver = eventListenerExamples.getDriver();

        DebugListenersExtends debugListenersExtends = new DebugListenersExtends();
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(debugListenersExtends);


        try {
            eventFiringWebDriver.get("http://www.google.com/ncr");
//        Thread.sleep(2000);
            WebElement searchBox = eventFiringWebDriver.findElement(By.name("q"));
            searchBox.sendKeys("packpubt");
            searchBox.submit();
        } catch (Exception ex) {

        }

    }

}
