package practicalGuide.chapter3;

import libs.WebDriverUtils.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebWebDriverNavigateExample extends DriverBase {
    public WebWebDriverNavigateExample() {
        super();
    }

    public static void main(String[] args) {
        WebWebDriverNavigateExample webDriverNavigateExample = new WebWebDriverNavigateExample();
        WebDriver driver = webDriverNavigateExample.getDriver();

        driver.get("http://www.google.com/ncr");
        System.out.println("Title: " + driver.getTitle());

        driver.findElement(By.name("q")).sendKeys("packtpub");
        driver.findElement(By.name("btnK")).submit();
        System.out.println("Title: " + driver.getTitle());

        driver.navigate().back();
        System.out.println("Title: " + driver.getTitle());

        driver.navigate().refresh();
        driver.navigate().forward();
        System.out.println("Title: " + driver.getTitle());


    }
}
