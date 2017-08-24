package utils.Logs;


import utils.Constants;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.*;

public class Log {
    public String resultRemote = "";
    private Logger logger;

    public Log() throws Exception {
        this.logger = Logger.getLogger(this.getClass().getSimpleName());
        boolean append = true;
        FileHandler fh = new FileHandler(Constants.currentLogger, append);
        fh.setFormatter(new Formatter() {
            public String format(LogRecord rec) {
                StringBuffer buf = new StringBuffer(1000);
                buf.append(new java.util.Date());
                buf.append(' ');
                buf.append(rec.getLevel());
                buf.append(' ');
                buf.append(formatMessage(rec));
                buf.append('\n');
                return buf.toString();
            }
        });

        try {
            Handler[] handlers = logger.getHandlers();
            for (Handler handler : handlers) {
                logger.removeHandler(handler);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        logger.addHandler(fh);
        logger.setUseParentHandlers(false);
    }


    /**
     * Log info
     *
     * @param info
     */
    public String info(String info) {
        info = info.trim();
        this.logger.info(info.trim() + "\r\n");
        resultRemote += new java.util.Date() + " " + info.trim() + "\r\n";
        return info;
    }

    /**
     * reset value of resultRemote variable
     */
    public void resetResultRemote() {
        this.resultRemote = "";
    }

    /**
     * Log warning
     *
     * @param info
     */
    public void warning(String info) {
        info = info.trim();
        this.logger.warning(info.trim() + "\r\n");
        resultRemote += new java.util.Date() + " " + info.trim() + "\r\n";
    }


    /**
     * Log fail
     *
     * @param info : Used for exception
     */
    public void fail(String info, Exception ex) {
        String cause = getStackTraceForException(ex);
        this.logger.severe(info.trim() + "\r\n" + cause.trim() + "\r\n");
        resultRemote += new java.util.Date() + " " + info.trim() + "\r\n" + cause.trim() + "\r\n";

    }


    /**
     * Log fail
     *
     * @param info
     * @param ex
     */
    public void fail(String info, Throwable ex) {
        String cause = getStackTraceForException(ex);
        this.logger.severe(info.trim() + "\r\n" + cause + "\r\n");
        resultRemote += new java.util.Date() + " " + info.trim() + "\r\n" + cause.trim() + "\r\n";
    }

    /**
     * Log fail.
     *
     * @param info
     */
    public void fail(String info) {
        this.logger.severe(info.trim() + "\r\n");
        resultRemote += new java.util.Date() + " " + info.trim() + "\r\n";
    }

    /**
     * Log severe.
     *
     * @param info
     */
    public void severe(String info) {
        this.logger.severe(info.trim() + "\r\n");
        resultRemote += new java.util.Date() + " " + info.trim() + "\r\n";
    }


    /**
     * @param info
     */
    public void config(String info) {
        this.logger.config(info.trim() + "\r\n");
        resultRemote += new java.util.Date() + " " + info.trim() + "\r\n";
    }


    /**
     * getStackTraceForException
     *
     * @param e
     * @return
     */
    public String getStackTraceForException(Exception e) {
        StringWriter sw = new StringWriter(2000);
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.getBuffer().toString();
    }

    /**
     * getStackTraceForException
     *
     * @param e
     * @return
     */
    public String getStackTraceForException(Throwable e) {
        StringWriter sw = new StringWriter(2000);
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.getBuffer().toString();
    }


}
