package com.awfulValentine;

import libs.WebDriverUtils.DriverBase;
import libs.WebDriverUtils.SeleniumKeywords;
import libs.WebDriverUtils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Logs.Log;

public class ProductValidationSingleProduct {
    private String productXpath;
    private String productUrl;
    private String productName;
    private String productDescription;
    private String productPrice;
    private String productRating;
    private SeleniumKeywords seleniumKeywords;

    public ProductValidationSingleProduct(SeleniumKeywords seleniumKeywords) {

        this.seleniumKeywords = seleniumKeywords;
    }

    public static void main(String[] args) throws Exception {

        Log log = new Log();
        WebDriver driver = WebDriverManager.createWebDriver("ChromeDriver", log);
        SeleniumKeywords seleniumKeywords = new SeleniumKeywords(driver, log);
        ProductValidationSingleProduct productValidationSingleProduct = new ProductValidationSingleProduct(seleniumKeywords);

        productValidationSingleProduct.validateProduct(driver);
        log.info("PASSED - Verification succesfully!");
    }

    private void select_desired_product_on_Homepage(WebDriver driver) throws Exception {
        String url = TestData.getBaseUrl() + "/" + getProductUrl();
        seleniumKeywords.open_Url(url);
    }


    private void verifyAttributesOnPage(WebDriver driver) throws Exception {
        DriverBase.log.info("Running verifyAttributesOnPage method");
        try {
            String currentProduct = "Current Product: " + getProductName();
            seleniumKeywords.assertTrue(driver.getCurrentUrl().contains(getProductUrl()));
            seleniumKeywords.assertEquals(seleniumKeywords.getText(By.className("category-title")), productName);
            seleniumKeywords.assertEquals(seleniumKeywords.getText(By.className("content")), "w" + productDescription);
            seleniumKeywords.assertTrue(seleniumKeywords.getText(By.className("price-tag")).contains(productPrice));
        } catch (Exception ex) {
            DriverBase.log.fail("Method verifyAttributesOnPage failed!\n" + ex.getMessage());
            throw ex;
        }


    }


    private void initialProductInfo() {
        setProductUrl(TestData.getFixtureVariable("fixture_4", "url"));
        setProductXpath("//div[@id='special-items']//a[contains(@href,'"
                + getProductUrl()
                + "') and @class='more-info']");
        setProductName(TestData.getFixtureVariable("fixture_4", "name"));
        setProductDescription(TestData.getFixtureVariable("fixture_4", "description"));
        setProductPrice(TestData.getFixtureVariable("fixture_4", "price"));
        setProductRating(TestData.getFixtureVariable("fixture_4", "rating"));
    }

    private void initialProductInfo(String fixture) {
        setProductUrl(TestData.getFixtureVariable(fixture, "url"));
        setProductXpath("//div[@id='special-items']//a[contains(@href,'"
                + getProductUrl()
                + "') and @class='more-info']");
        setProductName(TestData.getFixtureVariable(fixture, "name"));
        setProductDescription(TestData.getFixtureVariable(fixture, "description"));
        setProductPrice(TestData.getFixtureVariable(fixture, "price"));
        setProductRating(TestData.getFixtureVariable(fixture, "rating"));
    }

    public void validateProduct(WebDriver driver) throws Exception {
        initialProductInfo();

        select_desired_product_on_Homepage(driver);

        verifyAttributesOnPage(driver);

    }

    public void validateProductsFromFixture(WebDriver driver, String fixture) throws Exception {
        DriverBase.log.info("Running validateProductsFromFixture method");
        initialProductInfo(fixture);

        select_desired_product_on_Homepage(driver);
        verifyAttributesOnPage(driver);
    }

    public String getProductXpath() {
        return productXpath;
    }

    public void setProductXpath(String productXpath) {
        this.productXpath = productXpath;
    }

    public SeleniumKeywords getSeleniumKeywords() {
        return seleniumKeywords;
    }

    public void setSeleniumKeywords(SeleniumKeywords seleniumKeywords) {
        this.seleniumKeywords = seleniumKeywords;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductRating() {
        return productRating;
    }

    public void setProductRating(String productRating) {
        this.productRating = productRating;
    }
}
