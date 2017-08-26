package utils;

import utils.Logs.Log;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Utility {

    public static boolean createFolder(String path) throws Exception {
        File theDir = new File(path.trim());

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            return theDir.mkdir();

        } else
            return false;
    }

    /**
     * Add log file.
     *
     * @param filePath The path of file
     * @param content  Content which you want append to file
     * @throws Exception
     */
    public static void addLogfile(String filePath, String content) throws Exception {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)));
        out.println(content.trim());
        out.close();
    }

    /**
     * Open log folder after test finished
     *
     * @param path The path of file
     * @throws Exception
     */
    public static void openLogFolder(String path) throws IOException {
        Runtime.getRuntime().exec("explorer.exe /select," + path);
    }

    public static Log createLog(String tcid) throws Exception {
        String tcidPath = "";
        //If Folder existed not create
        createFolder(Constants.suitePath);

        tcidPath = Constants.suitePath + File.separator + tcid.trim()
                + "_" + getDate() + "_" + getTime();

        //If Folder existed not create
        createFolder(tcidPath);
        Constants.TCIDPath = tcidPath;

        Constants.currentLogger = Constants.TCIDPath + File.separator + tcid.trim() + ".log";
        return new Log();
    }

    /**
     * Kill a process of window
     *
     * @param processName Name of process
     */
    public static void killProcess(String processName, Log log) throws Exception {
        log.info("Starting function killProcess(" + processName + ")");
        try {

            if (System.getProperty("os.name").startsWith("Windows")) {
                Runtime.getRuntime().exec("taskkill /F /IM " + processName.trim());
            } else if (System.getProperty("os.name").startsWith("Mac")) {
                Runtime.getRuntime().exec("killall " + processName.trim());
            }

        } catch (Exception ex) {
            log.fail("FAILED: Function killProcess run unsuccessfully", ex);
            throw ex;
        }
        log.info("PASSED: Function killProcess run successfully");


    }


    /**
     * Kill Process without log
     *
     * @param processName
     * @throws Exception
     * @author pminhhung
     */
    public static void killProcess(String processName) throws Exception {
        try {

            if (System.getProperty("os.name").startsWith("Windows")) {
                Runtime.getRuntime().exec("taskkill /F /IM " + processName.trim());
            } else if (System.getProperty("os.name").startsWith("Mac")) {
                Runtime.getRuntime().exec("killall " + processName.trim());
            }

        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Get date.
     *
     * @return Current date
     * @throws Exception
     */
    public static String getDate() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }


    /**
     * Get time.
     *
     * @return Current time
     * @throws Exception
     */
    public static String getTime() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("HHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static void writeToFile(List<String> content, String filename, Boolean overwriteFlag){
        File file = new File(filename);
        // if file doesnt exists, then create it
        if (overwriteFlag) {
            try {
                file.createNewFile();
                FileWriter fw = null;
                try {
                    fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
                    for (String line : content) {
                        bw.write(line);
                        bw.newLine();
                    }
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Done");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
