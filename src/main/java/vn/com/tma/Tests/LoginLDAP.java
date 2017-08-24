package vn.com.tma.Tests;

import org.openqa.selenium.WebDriver;
import utils.ConfigFile.LoadConfigFile;
import vn.com.tma.pageObjects.AuthenticationPage;

/**
 * Created by tranmanhhung on 8/7/2017.
 */
public class LoginLDAP {
    public static void main(String[] args) {
        AuthenticationPage authenticationPage = new AuthenticationPage("NoProxy");
        WebDriver driver = authenticationPage.getDriver();

        String userName = LoadConfigFile.getPropertyByName("username");
        String password = LoadConfigFile.getPropertyByName("password");
        if (authenticationPage.loginLdap(driver, userName, password)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        driver.close();
    }
}
