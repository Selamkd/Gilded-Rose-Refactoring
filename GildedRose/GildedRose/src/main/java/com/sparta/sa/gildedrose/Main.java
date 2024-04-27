package com.sparta.sa.gildedrose;

import com.sparta.sa.utils.LoggerUtil;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            // Call setup method here
            LoggerUtil.setup(Logger.getLogger(GildedRose.class.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}