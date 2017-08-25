package io.endtest;

import libs.WebDriverUtils.DriverBase;
import libs.WebDriverUtils.SeleniumKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class LoginEndTest extends DriverBase {

    private SeleniumKeywords seleniumKeywords;
    private String homePageUrl = "https://endtest.io/";
    private String userEmail = "watarus.nt@gmail.com";
    private String userPassword = "12345678x@X";


    public LoginEndTest() {
        seleniumKeywords = new SeleniumKeywords(this.getDriver());
    }

    public static void main(String[] args) throws Exception {
        LoginEndTest loginEndTest = new LoginEndTest();
        WebDriver driver = loginEndTest.getDriver();
        for (String s : loginEndTest.getActionList(driver)) {
            System.out.println(s);
        }

        driver.quit();
    }

    private void openHomePage() throws Exception {
        seleniumKeywords.open_Url(homePageUrl);
    }

    private void userLogin() throws Exception {
        seleniumKeywords.click(By.id("loginLink"));
        seleniumKeywords.type_Text(By.id("userEmailLoginInput"), userEmail);
        seleniumKeywords.type_Text(By.id("userPasswordLoginInput"), userPassword);
        seleniumKeywords.click(By.id("loginButton"));

        try {
            String userNameInPage = seleniumKeywords.getText(By.id("userNameContainer"));
            Assert.assertTrue(userEmail.contains(userNameInPage));

            String urlAfterLogin = "https://endtest.io/tests";
            Assert.assertTrue(seleniumKeywords.checkUrlContains(urlAfterLogin));

            System.out.println("[PASSED] - userLogin - Logged in to EndTest with user email: " + userEmail);

        } catch (Exception ex) {
            System.out.println("[FAILED] - userLogin - User Home page is not loaded after logging in!");
            ex.printStackTrace();
        }
    }

    private void editTestSuit(WebDriver driver) throws Exception {
        seleniumKeywords.click(By.id("editTestSuiteButton"));
        seleniumKeywords.waitForElementToBePresent(By.id("headerCases"));

    }

    private void editTestCase(WebDriver driver, int testCaseID) throws Exception {
        By editTestCaseButtonXpathLocator = By.xpath(".//div[contains(@id, 'c') and @class='cases']["
                + testCaseID + "]/div[last()]");
        seleniumKeywords.click(editTestCaseButtonXpathLocator);
        seleniumKeywords.waitForElementToBePresent(By.name("stepDragButton"));
    }

    public List<String> getActionList(WebDriver driver) throws Exception {
        openHomePage();
        userLogin();
        editTestSuit(driver);
        editTestCase(driver, 2);

        List<String> actionList = new ArrayList<String>();
        List<WebElement> actionElementList = driver.findElements(By.xpath(".//*[@id='d1']/option"));
        for (WebElement element : actionElementList) {
            String actionText = element.getText();
            String actionValue = element.getAttribute("value");
            actionList.add(actionValue + " - " + actionText);
        }
        return actionList;
    }

}
