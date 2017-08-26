package Practices;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import practicalGuide.chapter4.SSLcertificateExamples;

public class SslCertificatesTestNg {

    private WebDriver driver;
    private String url = "https://192.168.211.30:8443/mgmt";
    private String browser = "chrome";
    private SSLcertificateExamples ssLcertificateExamples;

    @BeforeTest
    public void setUp() {
        ssLcertificateExamples = new SSLcertificateExamples(browser, true);
        this.driver = ssLcertificateExamples.getDriver();

    }

    @Test
    public void loginToPolicyGuru() {
        ssLcertificateExamples.loginToPolicyGuru(driver, url);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
