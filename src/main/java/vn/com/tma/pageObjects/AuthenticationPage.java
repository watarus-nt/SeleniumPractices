package vn.com.tma.pageObjects;

import libs.WebDriverUtils.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tranmanhhung on 8/7/2017.
 */


public class AuthenticationPage extends DriverBase {

    @FindBy(id = "ft_un")
    WebElement userNameBox;

    @FindBy(id = "ft_pw")
    WebElement passWordBox;

    public AuthenticationPage(String browser) {
        super(browser);
    }

    public AuthenticationPage() {
        super();
    }

    public boolean loginLdap(WebDriver driver, String username, String password) {
        driver.get("http://www.google.com");
        boolean result = false;
        try {
            if (!driver.findElement(By.tagName("h2")).getText().equals("Please enter your username and password to continue")) {
                System.out.println("Your LDAP session has not been over yet");
            } else {
                userNameBox.sendKeys(username);
                passWordBox.sendKeys(password);
                passWordBox.submit();

                if (driver.findElement(By.tagName("p")).getText().contains("Authentication Refresh in")) {
                    System.out.println("LoginEndTest LDAP succesfully!");
                    result = true;
                } else {
                    System.out.println("LoginEndTest LDAP unsuccesfully!");
                }
            }
        } catch (Exception ex) {
            System.out.println("###################################Exception message: " + ex.getMessage() + "###################################");
            System.out.println(ex);
            System.out.println("############################################################################################################################################");
        }

        return result;
    }
}
