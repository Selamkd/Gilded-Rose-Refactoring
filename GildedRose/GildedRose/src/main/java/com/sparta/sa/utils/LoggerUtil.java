package com.sparta.sa.utils;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;
public class LoggerUtil {
    public static void setup(Logger logger) throws IOException {
        logger.setUseParentHandlers(false);
        // logger level
        logger.setLevel(Level.ALL);

         // console handler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINE);
        consoleHandler.setFormatter(new CustomFormatter());
        logger.addHandler(consoleHandler);
        // file handler
        FileHandler fileHandler = new FileHandler("src/main/resources/logFile.log",true);
        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(new XMLFormatter());
        logger.addHandler(fileHandler);

    }
}

