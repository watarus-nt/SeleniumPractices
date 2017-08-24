package practicalGuide.chapter3;

import libs.WebDriverUtils.DriverBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshotExample extends DriverBase {
    public TakeScreenshotExample() {
        super();
    }

    public static void main(String[] args) throws IOException {
        TakeScreenshotExample takeScreenshotExample = new TakeScreenshotExample();
        WebDriver driver = takeScreenshotExample.getDriver();

        driver.get("http://www.packtpub.com");

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println(srcFile.getAbsolutePath());

        File trgDir = new File("packtpub.png");
        FileUtils.copyFile(srcFile, trgDir);

        driver.close();

    }
}
