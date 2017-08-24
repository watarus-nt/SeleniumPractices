package practicalGuide.chapter3;

import libs.WebDriverUtils.DriverBase;
import libs.WebDriverUtils.SeleniumKeywords;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class CookieExamples extends DriverBase {
    private SeleniumKeywords seleniumKeywords;

    public CookieExamples() {
        super();
        seleniumKeywords = new SeleniumKeywords(this.getDriver());
    }

    public static void main(String[] args) {
        CookieExamples cookieExamples = new CookieExamples();
        WebDriver driver = cookieExamples.getDriver();

        String cookieFileName = "browser.data";
        File cookie = new File(cookieFileName);

        if (!cookie.exists()) {
//            Boolean logIn = cookieExamples.loginGoogle(driver);
//            Boolean logIn = cookieExamples.loginFacebook(driver);
            Boolean logIn = cookieExamples.loginPacktpub(driver);

            if (!logIn) {
                System.exit(1);
            }
            cookieExamples.getCookie(driver, cookieFileName);
            driver.close();
        } else {
            /*
            String fbUrl = "http://www.facebook.com";
            cookieExamples.loadCookieInfo(driver, cookieFileName, fbUrl);
            driver.get(fbUrl);

            String googleUrl = "http://www.google.com/ncr";
            cookieExamples.loadCookieInfo(driver, cookieFileName, googleUrl);
            driver.get(googleUrl);
            */
            String packtpubUrl = "http://www.packtpub.com";
            cookieExamples.loadCookieInfo(driver, cookieFileName, packtpubUrl);
            driver.get(packtpubUrl);
        }



/*        By gmailLinkLocator = By.linkText("Gmail");

//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.elementToBeClickable(gmailLinkLocator));

        WebElement gmailLink = driver.findElement(gmailLinkLocator);
        gmailLink.click();*/

    }

    public boolean loginGoogle(WebDriver driver) {
        seleniumKeywords.open_Url("http://www.google.com/ncr");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement signInButton = driver.findElement(By.id("gb_70"));
        signInButton.click();

        WebElement inputEmailBox = driver.findElement(By.id("identifierId"));
        inputEmailBox.sendKeys("zgeeper0306");
//        inputEmailBox.submit();
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.ENTER).perform();


        By inputPwBoxLocator = By.name("password");
        wait.until(ExpectedConditions.elementToBeClickable(inputPwBoxLocator));
        WebElement inputPwBox = driver.findElement(inputPwBoxLocator);
        inputPwBox.sendKeys("hunG1234");
//        inputPwBox.submit();
        builder.sendKeys(Keys.ENTER).perform();


        wait.until(ExpectedConditions.titleContains("Google"));

        By gmailLinkLocator = By.linkText("Gmail");
        wait.until(ExpectedConditions.presenceOfElementLocated(gmailLinkLocator));
        WebElement gmailLink = driver.findElement(gmailLinkLocator);


        Boolean _result = true;
        if (gmailLink.isDisplayed()) {
            System.out.println("[PASSED] - Logged in Google!");
        } else {
            System.out.println("[FAILED] - Can't find Gmail Hyperlink! Looks like you haven't logged in yet!");
            _result = false;
        }

        return _result;
    }

    public boolean loginFacebook(WebDriver driver) {
//        zgeeper0306@gmail.com; 123456@X
        seleniumKeywords.open_Url("http://www.facebook.com");
        driver.findElement(By.name("email")).sendKeys("wgeeper0305@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("vienhFbFctel1");
        driver.findElement(By.id("loginbutton")).click();

        Boolean _result = true;
        if (driver.findElement(By.id("findFriendsNav")).isDisplayed()) {
            System.out.println("[PASSED] - Logged in Facebook!");
        } else {
            System.out.println("[FAILED] - Can't find FindFriends button! Looks like you haven't logged in yet!");
            _result = false;
        }

        return _result;
    }

    public boolean loginPacktpub(WebDriver driver) {
//        zgeeper0306@gmail.com; 123456@X
        String username = "watarus.nt@gmail.com";
        String password = "vienhWpackttel1";
        seleniumKeywords.open_Url("http://www.packtpub.com");
        driver.findElement(By.className("login-popup")).click();


        WebDriverWait wait = new WebDriverWait(driver, 10);
/*        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);*/

        Actions builder = new Actions(driver);
        builder.sendKeys(username).perform();
        builder.sendKeys(Keys.TAB).perform();
        builder.sendKeys(password).perform();

        builder.sendKeys(Keys.ENTER).perform();

        Boolean _result = true;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account-bar-sign-out")));
            System.out.println("[PASSED] - Logged in Packtpub!");
        } catch (Exception ex) {
            System.out.println("[FAILED] - Can't find SignOut button! Looks like you haven't logged in yet!");
            System.out.println(ex);
            _result = false;
        }

        return _result;
    }

    public boolean getCookie(WebDriver driver, String cookieFilename) {
        Boolean _result = true;
        File f = new File(cookieFilename);
        try {
            f.delete();
            f.createNewFile();

            FileWriter fos = new FileWriter(f);
            BufferedWriter bos = new BufferedWriter(fos);

            for (Cookie cookie : driver.manage().getCookies()) {
                bos.write(cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain()
                        + ";" + cookie.getPath() + ";" + cookie.getExpiry() + ";" + cookie.isSecure());
                bos.newLine();
            }

            bos.flush();
            bos.close();
            fos.close();

        } catch (IOException e) {
            _result = false;
            e.printStackTrace();
        }

        return _result;
    }

    public WebDriver loadCookieInfo(WebDriver driver, String cookieFilename, String url) {

        try {
            File f2 = new File(cookieFilename);
            FileReader fr = new FileReader(f2);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer str = new StringTokenizer(line, ";");
                while (str.hasMoreTokens()) {
                    String name = str.nextToken();
                    String value = str.nextToken();
                    String domain = str.nextToken();
                    String path = str.nextToken();
                    Date expiry = null;
                    String dt;
                    if (!(dt = str.nextToken()).equals("null")) {
//                        expiry = new Date(); //can't use in Java 8
                        String dDate = dt;
                        try {
                            DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
                            expiry = formatter.parse(dDate);
                        } catch (ParseException ex) {
                            DateFormat formatter = new SimpleDateFormat("MMM dd HH:mm:ss zzz yyyy");
                            expiry = formatter.parse(dDate);
                        }
                    }
                    boolean isSecure = new Boolean(str.nextToken()).booleanValue();
                    Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
                    driver.manage().addCookie(ck);
                }
                seleniumKeywords.open_Url(url);


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return driver;
    }

}
