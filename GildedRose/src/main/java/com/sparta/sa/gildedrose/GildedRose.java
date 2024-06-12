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
  }
  // update normal items

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

  public void updateAgedBrie(){

    for (Item item : items) {
      if(item.name.equals(AGED_BRIE)){
        LOGGER.info(" Aged Brie sellIn before update: " + item.sellIn);
        LOGGER.info(" Aged Brie quality before update: " + item.quality);

        item.sellIn -= 1;
        if(item.quality < 50) {
          item.quality += 1;
        }

        if(item.sellIn < 0 && item.quality < 50){
          item.quality += 1;
        }
      }
      LOGGER.info("Aged Brie quality after update: " + item.quality);
      LOGGER.info("Aged Brie sellIn after update: " + item.sellIn);
    }
  }

//    public void updateQuality() {
//
//        for (int i = 0; i < items.length; i++) {
//            LOGGER.info("Processing item: " + items[i].name);
//
//            if (!items[i].name.equals("Aged Brie")
//                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                LOGGER.info("Normal item detected.");
//
//                if (items[i].quality > 0) {
//                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//
//                     LOGGER.info(" Normal item quality Decreases by 1.");
//                            items[i].quality = items[i].quality - 1;
//
//                    }
//                }
//            } else {
//                LOGGER.info("Special item detected");
//
//                // Increase quality for special items
//                if (items[i].quality < 50) {
//                    items[i].quality++;
//                // quality increase for Backstage passes
//                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        LOGGER.info("Found backstage pass");
//                        if (items[i].sellIn < 11) {
//                            if (items[i].quality < 50) {
//                              //  LOGGER.info("sell in date less or equal to 10(backstage pass) increasing quality by 1");
//                                items[i].quality++;
//                            }
//                        }
//
//                        if (items[i].sellIn < 6) {
//
//                            if (items[i].quality < 50) {
//                                LOGGER.info("sell in date less or equal to 5(backstage pass) increasing quality by 1(should be 3)");
//                                items[i].quality++;
//                            }
//                        }
//                    }
//                }
//            }
// // update sell in for all items except Sulfuras
//            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//
//
//                if(items[i].sellIn >0) {
//                   LOGGER.info("Updating sellIn..");
//                    items[i].sellIn = items[i].sellIn - 1;
//                }
//            }
//          // handle quality degradation for expired items
//            if (items[i].sellIn <= 0) {
//                LOGGER.info("Item has expired");
//
//                if (!items[i].name.equals("Aged Brie")) {
//                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].quality > 0) {
//                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                               LOGGER.info("Quality decreases by 1 ");
//                                items[i].quality = items[i].quality - 1;
//                            }
//                        }
//                    } else {
//                        LOGGER.info("Setting quality to 0");
//                        items[i].quality = 0;
//                    }
//                } else {
//                    if (items[i].quality < 50) {
//                        LOGGER.info("Increasing quality by 1.");
//                        items[i].quality = items[i].quality + 1;
//                    }
//                }
//            }
//            LOGGER.info("Updated item details: " + items[i]);
//        }

//    }
}