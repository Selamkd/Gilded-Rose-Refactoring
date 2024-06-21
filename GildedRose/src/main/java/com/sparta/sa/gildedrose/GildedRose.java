package com.sparta.sa.gildedrose;

import com.sparta.sa.utils.LoggerUtil;

import java.util.logging.Logger;

public class GildedRose {
    Logger LOGGER = LoggerUtil.getLogger();

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    final String AGED_BRIE = "Aged Brie";
    final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    final String SULFURAS = "Sulfuras, Hand of Ragnaros";


    public void updateQuality() {
        updateNormalItems();
        updateAgedBrie();
        updateBackstagePasses();
        logSulfurasStatus();

    }


    public void updateNormalItems() {
        for (Item item : items) {
            String itemName = item.name;
            if (!itemName.equals(AGED_BRIE) && !itemName.equals(BACKSTAGE_PASS) && !itemName.equals(SULFURAS)) {
                LOGGER.info("Normal item detected");
                LOGGER.info(" Normal item sellIn before update: " + item.sellIn);
                LOGGER.info(" Normal item quality before update: " + item.quality);

                if (item.quality > 0) {
                    item.quality -= 1;
                }

                item.sellIn -= 1;

                if (item.sellIn <= 0 && item.quality > 0) {
                    item.quality -= 1;
                }

                LOGGER.info(" Normal item quality after update: " + item.quality);
                LOGGER.info(" Normal item sellIn after update: " + item.sellIn);

            }
        }

    }

    public void updateAgedBrie() {

        for (Item item : items) {
            if (item.name.equals(AGED_BRIE)) {
                LOGGER.info(" Aged Brie sellIn before update: " + item.sellIn);
                LOGGER.info(" Aged Brie quality before update: " + item.quality);

                item.sellIn -= 1;
                if (item.quality < 50) {
                    item.quality += 1;
                }

                if (item.sellIn < 0 && item.quality < 50) {
                    item.quality += 1;
                }
            }
            LOGGER.info("Aged Brie quality after update: " + item.quality);
            LOGGER.info("Aged Brie sellIn after update: " + item.sellIn);
        }
    }

    public void logSulfurasStatus() {
        for (Item item : items) {
            if (item.name.equals(SULFURAS)) {
                LOGGER.info("Sulfuras detected: " + item.name);
                LOGGER.info("Sulfuras quality remains unchanged: " + item.quality);
                LOGGER.info("Sulfuras sellIn remains unchanged: " + item.sellIn);
            }
        }
    }

    public void updateBackstagePasses() {
        for (Item item : items) {
            if (item.name.equals(BACKSTAGE_PASS)) {
                LOGGER.info(" Backstage pass sellIn before update: " + item.sellIn);
                LOGGER.info(" Backstage pass quality before update: " + item.quality);
                item.sellIn -= 1;
                if (item.sellIn > 10) {
                    item.quality += 1;
                } else if (item.sellIn <= 5) {
                    item.quality += 3;
                } else {
                    item.quality += 2;
                }
                if (item.sellIn == 0) {
                    item.quality = 0;
                }
                LOGGER.info(" Backstage pass sellIn after update: " + item.sellIn);
                LOGGER.info(" Backstage pass quality after update: " + item.quality);
            }

        }

    }
}