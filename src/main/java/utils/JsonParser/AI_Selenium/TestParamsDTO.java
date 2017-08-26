package utils.JsonParser.AI_Selenium;

public class TestParamsDTO {
    private String browser;
    private String URL;
    private TestSuiteDTO testsuite;


    @Override
    public String toString() {
        return browser + "\n"
                + URL + "\n"
                + testsuite;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public TestSuiteDTO getTestsuite() {
        return testsuite;
    }

    public void setTestsuite(TestSuiteDTO testsuite) {
        this.testsuite = testsuite;
    }
}
