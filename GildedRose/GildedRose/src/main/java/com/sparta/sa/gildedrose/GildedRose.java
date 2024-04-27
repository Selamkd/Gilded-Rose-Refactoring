package com.sparta.sa.gildedrose;
import com.sparta.sa.utils.LoggerUtil;
import java.util.logging.Logger;
public class GildedRose {
    private static final Logger LOGGER = Logger.getLogger(GildedRose.class.getName());

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            //LOGGER.info("Processing item: " + items[i].name);

            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                //LOGGER.info("Normal item detected.");

                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {

                     //LOGGER.info(" Normal item quality Decreases by 1.");
                            items[i].quality = items[i].quality - 1;

                    }
                }
            } else {
               // LOGGER.info("Special item detected");

                // Increase quality for special items
                if (items[i].quality < 50) {
                    items[i].quality++;
                // quality increase for Backstage passes
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                       // LOGGER.info("Found backstage pass");
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                              //  LOGGER.info("sell in date less or equal to 10(backstage pass) increasing quality by 1");
                                items[i].quality++;
                            }
                        }

                        if (items[i].sellIn < 6) {

                            if (items[i].quality < 50) {
                                //LOGGER.info("sell in date less or equal to 5(backstage pass) increasing quality by 1(should be 3)");
                                items[i].quality++;
                            }
                        }
                    }
                }
            }
 // update sell in for all items except Sulfuras
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                // fixed logic for sell in update

                if(items[i].sellIn >0) {
                   // LOGGER.info("Updating sellIn..");
                    items[i].sellIn = items[i].sellIn - 1;
                }
            }
          // handle quality degradation for expired items
            if (items[i].sellIn <= 0) {
                //LOGGER.info("Item has expired");

                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                               // LOGGER.info("Quality decreases by 1 ");
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        //LOGGER.info("Setting quality to 0");
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < 50) {
                        //LOGGER.info("Increasing quality by 1.");
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
            //LOGGER.info("Updated item details: " + items[i]);
        }

    }
    }