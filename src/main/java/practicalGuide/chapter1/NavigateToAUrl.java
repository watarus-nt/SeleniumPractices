package practicalGuide.chapter1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigFile.LoadConfigFile;

import java.util.List;

/**
 * Created by tranmanhhung on 8/5/2017.
 */
public class NavigateToAUrl {
    private static WebDriver driver;

    public static void navigateToUrl(String url) {
        driver.get(url);
        System.out.println("Title: " + driver.getTitle());
    }

    public static void googleSearchByName(String text) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(text);
        searchBox.submit();
        System.out.println("Title: " + driver.getTitle());
    }

    public static void googleSearchByTagName(String tagName) {
        List<WebElement> tags = driver.findElements(By.tagName(tagName));
        System.out.println("Number of " + tagName + " tag: " + tags.size());

        int i = 1;
        for (WebElement tag : tags) {
            System.out.println(i + ". Type: " + tag.getAttribute("type"));
            i++;
        }
    }

    public static void getAttributes(WebElement element) {
        System.out.println("Name of element: " + element.getAttribute("name"));
        System.out.println("Id of element: " + element.getAttribute("id"));
        System.out.println("Value of element: " + element.getAttribute("value"));
        System.out.println("Label of element: " + element.getAttribute("aria-label"));
        System.out.println("Type of element: " + element.getAttribute("type"));
    }

    public static void googleSearchUpperCase(String text) {
        navigateToUrl("http://www.google.com/ncr");
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys(Keys.chord(Keys.SHIFT, text));
        searchbox.submit();
        System.out.println("Tilte: " + driver.getTitle());

    }

    public static void getCssValue(WebElement element) {
        System.out.println("Font-Family of element: " + element.getCssValue("font-family"));
        System.out.println("background-colour of element: " + element.getCssValue("background-colour"));

    }

    public static void main(String[] args) {
        String chromeDriver = LoadConfigFile.getPropertyByName("chromeDriverPath");
        System.setProperty("webdriver.chrome.driver", chromeDriver);
        driver = new ChromeDriver();

        navigateToUrl("http://www.google.com/ncr");
//        googleSearchByName("Learning how to learn");
//        googleSearchUpperCase("learning how to learn");
//        googleSearchByTagName("input");
//        getAttributes(driver.findElement(By.name("btnK")));
//        getAttributes(driver.findElement(By.tagName("input")));
        getCssValue(driver.findElement(By.name("btnK")));
        driver.close();

    }
}
