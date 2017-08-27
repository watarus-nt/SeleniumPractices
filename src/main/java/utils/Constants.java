package utils;

public class Constants {
    public static final String INTERNET_EXPLORER_DRIVER = "InternetExplorer"; // InternetExplorerDriver
    public static final String EDGE_DRIVER = "Microsoft"; // MicrosoftWebDriver
    public static final String FIREFOX_DRIVER = "Firefox"; // FirefoxDriver
    public static final String CHROME_DRIVER = "Chrome"; // ChromeDriver
    public static final String SAFARI_DRIVER = "Safari"; // SafariDriver
    //    public static String PROJECTHOME= System.getenv("AUTOPROJECTHOME");
    public static String PROJECTHOME = "";
    public static boolean grid_enabled = false;
    // ######################## Log & Report ##################################
    public static String productReport;
    public static String currentLogger;
    public static String suitePath;
    public static String xmlReport;
    public static String TCIDPath;
    public static String reportFolder;
    public static String reportTestOutput;
    public static byte numberCreateTSFolder = 0; // 0:Not yet  1: Created
    public static String currentTSName;
    public static String templateOfExcelOutPut;
    public static String exeDate; // to store execution date and time for reporting purpose.

    static {
        try {

            productReport = PROJECTHOME + "\\testdata\\datafiles\\ReportFile\\";
            currentLogger = "selenium_temp.log";

            suitePath = PROJECTHOME + "testReports";
            TCIDPath = "C:\\";
            reportFolder = PROJECTHOME + "testReports\\";
            reportTestOutput = PROJECTHOME + "\\test-output\\";
            templateOfExcelOutPut = PROJECTHOME + "\\templates\\";

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
