package libs.WebDriverUtils;


import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ConfigFile.LoadConfigFile;
import utils.Constants;
import utils.Logs.Log;

public class WebDriverManager {

    private static String firefoxDriverPath = LoadConfigFile.getPropertyByName("firefoxDriverPath");
    private static String chromeDriverPath = LoadConfigFile.getPropertyByName("chromeDriverPath");
    private static String ieDriverPath = LoadConfigFile.getPropertyByName("ieDriverPath");

    /**
     * Initialize Web Driver
     *
     * @param type
     * @param log
     * @return
     * @throws Exception
     */
    public static WebDriver createWebDriver(String type, Log log) throws Exception {
        log.info("Starting keyword createWebDriver ...");
        WebDriver driver = null;
        try {
//			driver = createWebDriver(type, log, "yes");
            driver = createWebDriver(type, log, "no");
            driver.manage().window().maximize();
        } catch (Exception ex) {
            ex.printStackTrace();
            log.fail("[FAILED] createWebDriver - Exception occurred", ex);
            throw ex;
        }

        log.info("[PASSED]  createWebDriver");
        return driver;
    }


    /**
     * Initialize Web Driver
     *
     * @param browserType
     * @param log
     * @param closeBrowser Yes/No
     * @throws Exception
     */
    public static WebDriver createWebDriver(String browserType, Log log, String closeBrowser) throws Exception {
        WebDriver driver = null;

        log.info("Creating web driver for desktop....");
        log.info("Type of WebDriver: " + browserType);

        if (!Constants.grid_enabled) // running in local mode
        {
            log.info("Grid is disabled");

            try {
                if (containsIgnoreCase(browserType.trim(), Constants.INTERNET_EXPLORER_DRIVER)) {
                    WebDriver webDriver = initialInternetExplorer();
                    return webDriver;
                } else if (containsIgnoreCase(browserType.trim(), Constants.EDGE_DRIVER)) {
                    System.setProperty("webdriver.edge.driver", ieDriverPath);
                    WebDriver webDriver = new EdgeDriver();
                    return webDriver;
                } else if (containsIgnoreCase(browserType.trim(), Constants.FIREFOX_DRIVER)) {
                    if (browserType.trim().toLowerCase().contains("proxy")) {
                        return initialFirefoxDriverWithProxy();
                    } else {
                        return initialFirefoxDriver();
                    }
                } else if (containsIgnoreCase(browserType.trim(), Constants.CHROME_DRIVER)) {
                    if (browserType.trim().toLowerCase().contains("proxy")) {
                        return initialChromeDriverWithProxy();
                    } else {
                        return initialChromeDriverWithoutProxy();
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                log.fail("[FAILED] createWebDriver - Exception occurred", ex);
                throw ex;
            }

            log.info("[PASSED] createWebDriver");
            return null;
        }

        return driver;
    }


    public static WebDriver initialFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", firefoxDriverPath);

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return new FirefoxDriver(capabilities);
    }

    public static WebDriver initialFirefoxDriverWithProxy() {
        System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.http", "10.10.10.10");
        profile.setPreference("network.proxy.http_port", 8080);
        return new FirefoxDriver(profile);
    }

    private static WebDriver initialChromeDriverWithProxy() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        // Add the libs.WebDriverUtils proxy capability.
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("10.10.10.10:8080");
        capabilities.setCapability("proxy", proxy);

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        return new ChromeDriver(capabilities);
    }

    public static WebDriver initialChromeDriverWithoutProxy() {

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        return new ChromeDriver();
    }

    public static WebDriver initialInternetExplorer() {
        DesiredCapabilities ieCapabilities = new DesiredCapabilities();
        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        ieCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        ieCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        ieCapabilities.setCapability("enablePersistentHover", false);
        ieCapabilities.setCapability("ignoreZoomSetting", true);
        ieCapabilities.setJavascriptEnabled(true);
        System.setProperty("webdriver.ie.driver", ieDriverPath);

        return new InternetExplorerDriver(ieCapabilities);
    }

    private WebDriver initialChromeDriverWithoutProxy(Boolean SSLcertificate) {
        if (!SSLcertificate) {
            return initialChromeDriverWithoutProxy();
        } else {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            return new ChromeDriver(capabilities);
        }
    }

    private static Boolean containsIgnoreCase(String string1, String string2){
        return string1.toLowerCase().contains(string2.toLowerCase());
    }

}
