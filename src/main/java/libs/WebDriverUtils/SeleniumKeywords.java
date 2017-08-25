package libs.WebDriverUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Logs.Log;


public class SeleniumKeywords extends DriverBase {
    private WebDriverWait wait;

    public SeleniumKeywords(WebDriver driver, Log log) {
        super(driver, log);
        wait = new WebDriverWait(driver, 10);
    }

    public SeleniumKeywords() {
        wait = new WebDriverWait(driver, 10);
    }

    public SeleniumKeywords(WebDriver driver) {

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    public void open_Url(String url) throws Exception {
        log.info("Starting keyword open_Url with input: \"" + url + "\"");
        try {
            driver.manage().window().maximize();
            driver.get(url);
            verifyCurrentUrlContains(url);
            log.info("[PASSED] - open_Url ran succesfully!");
        } catch (Exception ex) {
            log.fail("[FAILED] - open_Url ran unsuccesfully! Exception occurs\n" + ex);
            throw ex;
        }
    }

    public void verifyCurrentUrlContains(String urlText) throws Exception {
        log.info("Starting verifyCurrentUrlContains keyword with input urlText = \""
                + urlText + "\"");
        try {
            wait.until(ExpectedConditions.urlContains(urlText));
            if (driver.getCurrentUrl().contains(urlText)) {
                log.info("[PASSED] - verifyCurrentUrlContains - Current URL contains input URL!");
            } else {
                throw new Exception("[FAILED] - verifyCurrentUrlContains - Current URL doesn't contain input URL!");
            }
        } catch (Exception ex) {
            log.fail("[FAILED] - verifyCurrentUrlContains - Exception occurs: " + ex);
            throw ex;
        }
    }

    public void verifyCurrentUrlEquals(String urlText) throws Exception {
        log.info("Starting verifyCurrentUrlEquals keyword with input urlText = \""
                + urlText + "\"");
        try {
            if (driver.getCurrentUrl().equals(urlText)) {
                log.info("[PASSED] - verifyCurrentUrlEquals - Current URL contains input URL!");
            } else {
                throw new Exception("[FAILED] - verifyCurrentUrlEquals - Current URL doesn't contain input URL!");
            }
        } catch (Exception ex) {
            log.fail("[FAILED] - verifyCurrentUrlEquals - Exception occurs: " + ex);
            throw ex;
        }
    }

    public Boolean checkUrlContains(String expectedString) {
        return driver.getCurrentUrl().contains(expectedString);
    }

    public WebElement find_Element(By elementLocator) {
        WebElement returnElement = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            returnElement = driver.findElement(elementLocator);
            log.info("[PASSED] - find_Element - find element successfully!");
        } catch (Exception ex) {
            log.fail("[FAILED] - find_Element - find element unsuccessfully!");
        }
        return returnElement;
    }

    public void click(By elementLocator) throws Exception {
        log.info("Starting keyword click with input: \"" + elementLocator + "\"");
        try {
            WebElement element = find_Element(elementLocator);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            log.info("[PASSED] - click - Clicked to element!");
        } catch (Exception ex) {
            log.fail("[FAILED] - click - Unable to click to element! Exception occur: \n" + ex);
            throw ex;
        }
    }

    public void click(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            log.info("[PASSED] - click - Clicked to element!");
        } catch (Exception ex) {
            log.fail("[FAILED] - click - Unable to click to element!");
            ex.printStackTrace();
        }
    }


    public void submit(By elementLocator) {
        try {
            find_Element(elementLocator).submit();
        } catch (Exception ex) {

        }
    }

    public void submit(WebElement element) {
        element.submit();
    }

    public void type_Text(By elementLocator, String text) throws Exception {
        log.info("Starting keyword type_Text with input: \"" + text + "\"");
        try {
            WebElement textBox = find_Element(elementLocator);
            textBox.clear();
            textBox.sendKeys(text);
            log.info("[PASSED] - type_Text - Type text succesfully!");
        } catch (Exception ex) {
            log.fail("[FAILED] - type_Text - Exception occur: \n" + ex);
            throw ex;
        }
    }


    public Boolean verifyElementTextEqual(WebElement element, String expectedText) {
        log.info("verifyElementTextEqual - Element text is: \"" + element.getText()
                + "\"");
        log.info("verifyElementTextEqual - expectedText is: \"" + expectedText);
        if (element.getText().equals(expectedText)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean verifyElementTextEndsWith(WebElement element, String expectedText) {
        log.info("verifyElementTextEndsWith - Element text is: \"" + element.getText()
                + "\"");
        log.info("verifyElementTextEndsWith - expectedText is: \"" + expectedText);
        if (element.getText().endsWith(expectedText)) {
            return true;
        } else {
            return false;
        }
    }

    public String getText(WebElement element) {
        String elementText = null;
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            log.info("getText - input element is: \"" + element + "\"");
            elementText = element.getText();
            log.info("[PASSED] - getText - Element text is : \"" + elementText + "\"");
        } catch (Exception ex) {
            log.fail("[FAILED] - getText - Unable to getText of input element.\n" + ex.getMessage());
        }

        return elementText;
    }

    public String getText(By elementLocator) {
        String elementText = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            log.info("getText - input element locator is: \"" + elementLocator + "\"");
            elementText = find_Element(elementLocator).getText();
            log.info("[PASSED] - getText - Element text is : \"" + elementText + "\"");
        } catch (Exception ex) {
            log.fail("[FAILED] - getText - Unable to getText of input element locator.\n" + ex.getMessage());
        }

        return elementText;
    }

    public void waitForElementToBePresent(By elementLocator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        } catch (Exception ex) {

        }
    }

    public void assertEquals(String actualString, String expectedString) throws Exception {
        log.info("Starting keyword assertEqual with \n"
                + "actualString: " + actualString
                + "\nexpectedString: " + expectedString);
        try {
            if (actualString.equals(expectedString)) {
                log.info("[PASSED] - assertEquals - Two input strings are the same!");
            } else {
                throw new Exception("[FAILED] assertEquals - Two input string are different!");
            }
        } catch (Exception ex) {
            log.fail("[FAILED] assertEquals - Exeception occurs" + ex);
            throw ex;
        }
    }

    public void assertTrue(Boolean result) throws Exception {
        log.info("Starting keyword assertTrue with \n"
                + "input Boolean value: " + result);
        try {
            if (result) {
                log.info("[PASSED] - assertTrue - Boolean value is given as input!");
            } else {
                throw new Exception("[FAILED] assertTrue - Input boolean value is FALSE!");
            }
        } catch (Exception ex) {
            log.fail("[FAILED] assertTrue - Exeception occurs" + ex);
            throw ex;
        }
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }


}
