package com.sparta.sa.utils;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LoggerUtil {
    private static Logger LOGGER;
    public static Logger getLogger() {
        if(LOGGER == null) {
            LOGGER = Logger.getLogger(Logger.class.getName());
            setUp();
        }
        return LOGGER;
    }

    public static void  setUp() {
        LOGGER.setUseParentHandlers(false);
        LOGGER.addHandler(getConsoleHandler());
//        LOGGER.addHandler(getFileHandler());
        LOGGER.setLevel(Level.FINE);
        LOGGER.info("Setting up Logger...");
    }

    private static ConsoleHandler getConsoleHandler(){
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINE);
        consoleHandler.setFormatter(new ConsoleFormatter());
        return consoleHandler;
    }

    private static FileHandler getFileHandler(){
        try {
            FileHandler fileHandler = new FileHandler("src/main/resources/logfile.log");
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new FileFormatter());
            return fileHandler;
        } catch (IOException e) {
            LOGGER.severe("Unable to create log file" + e.getMessage());
        }
        return null;
    }
}
