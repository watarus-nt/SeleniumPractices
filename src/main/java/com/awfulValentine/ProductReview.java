package com.awfulValentine;

import libs.WebDriverUtils.DriverBase;
import libs.WebDriverUtils.SeleniumKeywords;
import libs.WebDriverUtils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Logs.Log;

import java.time.LocalDateTime;

public class ProductReview {

    //    private String productXpath = "//div[@id='special-items']//a[contains(@href,'our-love-is-special') and @class='more-info']";
    private String productXpath;
    private String nameText = "wb";
    private String emailText = "w@selenium.com";
    private String websiteUrl = "www.selenium.com";
    private String rating = "3.5";
    private String commentText;
    private SeleniumKeywords seleniumKeywords;

    public ProductReview(SeleniumKeywords seleniumKeywords) {

        commentText = generate_unique_comment();
        this.seleniumKeywords = seleniumKeywords;
    }

    public static void main(String[] args) throws Exception {
        Log log = new Log();
        WebDriver driver = WebDriverManager.createWebDriver("ChromeDriver", log);
        SeleniumKeywords seleniumKeywords = new SeleniumKeywords(driver, log);
        ProductReview productReview = new ProductReview(seleniumKeywords);


        productReview.postComment(driver);
        productReview.verifyPostedComment(driver);


        productReview.setNameText("abc");
        productReview.setCommentText();
        productReview.postComment(driver);
        productReview.verifyPostedComment(driver);

        driver.quit();
    }

    private String generate_unique_comment() {
        LocalDateTime today = LocalDateTime.now();
        return "This is a test comment generated by Selenium at " + today.toString();
    }

    private void initialCommentDetails() {
        setNameText(TestData.getFullName());
        setEmailText(TestData.getEmail());
        setWebsiteUrl(TestData.getWebsite());
        setRating(TestData.getRating());
        setCommentText(TestData.getBuzzword());
    }

    private void navigateToHomePage(WebDriver driver) {
        DriverBase.log.info("Running navigateToHomePage method");
        String url = TestData.getBaseUrl();
        DriverBase.log.info("Open Homepage: " + url);
        driver.get(url);
    }

    private void openDesiredProductInfo(WebDriver driver, String XpathAddress) throws Exception {
        DriverBase.log.info("Running openDesiredProductInfo method");
        DriverBase.log.info("Input XpathAddress = " + XpathAddress);
        By productInfoLocator = By.xpath(XpathAddress);
        seleniumKeywords.click(productInfoLocator);
    }

    public void openProductPage(WebDriver driver) throws Exception {
        DriverBase.log.info("Running openProductPage method");
        navigateToHomePage(driver);

        productXpath = "//div[@id='special-items']//a[contains(@href,'"
                + TestData.getFixtureVariable("fixture_4", "url")
                + "') and @class='more-info']";
        openDesiredProductInfo(driver, productXpath);
    }

    public void postComment(WebDriver driver) throws Exception {
        openProductPage(driver);
        initialCommentDetails();

        fill_To_Form();

    }

    public void postCommentTwice(WebDriver driver) throws Exception {
        openProductPage(driver);
        initialCommentDetails();

        fill_To_Form();

        openProductPage(driver);
        fill_To_Form();
    }

    private void fill_To_Form() throws Exception {
        seleniumKeywords.type_Text(By.name("author"), getNameText());

        seleniumKeywords.type_Text(By.name("email"), getEmailText());

        seleniumKeywords.type_Text(By.name("url"), getWebsiteUrl());

        seleniumKeywords.click(By.xpath("//a[@title='" + getRating() + "']"));

        seleniumKeywords.type_Text(By.name("comment"), getCommentText());

        seleniumKeywords.submit(By.name("submit"));
    }

    public void verifyPostedComment(WebDriver driver) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("#comment-"));
        Boolean verifyResult = true;
        try {
//            WebElement userComment_Name = driver.findElement(By.partialLinkText(websiteUrl));
            WebElement userComment_Name = driver.findElement(By.xpath("//*[contains(@id,\"li-comment-\")][last()]//span/a"));

            seleniumKeywords.verifyElementTextEndsWith(userComment_Name, nameText);
            DriverBase.log.info("PASSED - Correct comment's username is showed on the page!");
        } catch (Exception ex) {
            DriverBase.log.fail("FAILED - Incorrect comment's username!");
            verifyResult = false;
            throw ex;
        }

            WebElement userComment_Content = driver.findElement(By.xpath("//*[contains(@id,\"li-comment-\")][last()]//p"));
        try {
            seleniumKeywords.verifyElementTextEqual(userComment_Content, commentText);
                DriverBase.log.info("PASSED - Correct comment content is showed!");
        } catch (Exception ex) {
            verifyResult = false;
            DriverBase.log.fail("FAILED - Incorrect comment content is showed!");
            throw ex;
        }
        if (!verifyResult) {
            DriverBase.log.fail("FAILED when verifying posted comment!");
        }

    }

    public String getNameText() {
        return nameText;
    }

    public void setNameText(String nameText) {
        this.nameText = nameText;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public void setCommentText() {
        this.commentText = generate_unique_comment();
    }

    public SeleniumKeywords getSeleniumKeywords() {
        return seleniumKeywords;
    }

    public void setSeleniumKeywords(SeleniumKeywords seleniumKeywords) {
        this.seleniumKeywords = seleniumKeywords;
    }

    public String getProductXpath() {
        return productXpath;
    }

    public void setProductXpath(String productXpath) {
        this.productXpath = productXpath;
    }

    public String getEmailText() {
        return emailText;
    }

    public void setEmailText(String emailText) {
        this.emailText = emailText;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
