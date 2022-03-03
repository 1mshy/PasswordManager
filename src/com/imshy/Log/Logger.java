package com.imshy.Log;

import java.io.File;

public class Logger {
    private static Logger instance;
    private final String LOGFILENAME = "log.txt";
    private Logger() {

    }
    public static Logger initialize()
    {
        if(instance==null) instance = new Logger();
        return instance;
    }

    public File getLogFileInstance() {
        return new File(LOGFILENAME);
    }

    public void error(String error)
    {
    }
    public void log(String message)
    {
    }
}
