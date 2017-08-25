package com.awfulValentine;

import libs.WebDriverUtils.DriverBase;
import libs.WebDriverUtils.SeleniumKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class PurchaseForm {
    private SeleniumKeywords seleniumKeywords;

    public PurchaseForm(SeleniumKeywords seleniumKeywords) {
        this.seleniumKeywords = seleniumKeywords;
    }

    public void openPurchasePages(String purchaseFormType) throws Exception {
        DriverBase.log.info("Running openPurchasePages method");
        try {
            seleniumKeywords.open_Url(TestData.getBaseUrl() + "/purchase-forms/" + purchaseFormType);
            seleniumKeywords.verifyCurrentUrlContains(purchaseFormType);
            DriverBase.log.info("[PASSED] - openPurchasePages method ran succesfully!");
        } catch (Exception ex) {
            DriverBase.log.fail("[FAILED] - openPurchasePages method ran unsuccesfully!");
            throw ex;
        }
    }


    public void fill_purchase_form() throws Exception {
        DriverBase.log.info("Running fill_purchase_form method");
        try {
            seleniumKeywords.type_Text(By.id("name"), TestData.getFullName());
            seleniumKeywords.type_Text(By.id("cc"), TestData.getCreditCardNumber());
            seleniumKeywords.type_Text(By.id("month"), TestData.getMonthInFuture());
            seleniumKeywords.type_Text(By.id("year"), TestData.getYearInFuture());
            seleniumKeywords.click(By.id("go"));

//            waitForAjax();
//            waitForAnimation();
            String purchaseComplete = seleniumKeywords.getText(By.id("success"));
            seleniumKeywords.assertEquals(purchaseComplete, "Purchase complete!");

            DriverBase.log.info("[PASSED] - fill_purchase_form successfully!");
        } catch (Exception ex) {
            DriverBase.log.fail("[FAILED] - fill_purchase_form unsuccesfully!");
            throw ex;
        }
    }


    public void purchaseTest(String purchaseFormType) throws Exception {
        DriverBase.log.info("Running purchaseTest method");
        try {
            openPurchasePages(purchaseFormType);
            fill_purchase_form();
            DriverBase.log.info("[PASSED] - purchaseTest ran succesfully!");
        } catch (Exception ex) {
            DriverBase.log.fail("[FAILED] - purchaseTest ran unsuccesfully!");
            throw ex;
        }

    }

    public void waitForAjax() {
        seleniumKeywords.getWait().until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
    }


    public void waitForAnimation() {
        seleniumKeywords.getWait().until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                return (Boolean) js.executeScript("return jQuery(':animated').length == 0");
            }
        });
    }


}
