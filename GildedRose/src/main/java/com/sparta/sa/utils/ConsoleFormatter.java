package com.sparta.sa.utils;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class ConsoleFormatter extends Formatter {
    private static final String ANSI_RESET = "\u001B[0;97m";
    private static final String ANSI_CYAN = "\u001B[96m";
    private static final String ANSI_RED = "\u001B[91m";
    private static final String ANSI_ORANGE = "\u001B[33m";
    private static final String ANSI_BRIGHT_ORANGE = "\u001B[38;5;202m";

    @Override
    public String format(LogRecord record){
        return switch (record.getLevel().getName()){
            case "SEVERE" ->
                   ANSI_RED +
                          "[" + record.getSourceClassName() + "]" +
                          "[" + record.getLevel() + "]" +
                          "-" + record.getMessage() + "!" +
                          ANSI_RESET
                          + "\n";
            case "WARNING" ->
                   ANSI_ORANGE+
                          "[" + record.getSourceClassName() + "]" +
                          "[" + record.getLevel() + "]" +
                          "-" + record.getMessage() + "!" +
                          ANSI_RESET
                          + "\n";
            case "INFO" ->
                   ANSI_CYAN +
                          "[" + record.getSourceClassName() + "]" +
                          "[" + record.getLevel() + "]" +
                          "-" + record.getMessage() + "!" +
                          ANSI_RESET
                          + "\n";
            case "CONFIG" ->
                   ANSI_BRIGHT_ORANGE +
                          "[" + record.getSourceClassName() + "]" +
                          "[" + record.getLevel() + "]" +
                          "-" + record.getMessage() + "!" +
                          ANSI_RESET
                          + "\n";
            default ->
                   "[" + record.getSourceClassName() + "]" +
                          "[" + record.getLevel() + "] " +
                          "- " + record.getMessage()
                          + "\n";
        };
    }
}