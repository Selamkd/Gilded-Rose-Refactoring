package com.sparta.sa.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GildedRoseTests {


    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Items sellIn and quality decrement by one after updating quality")
    void itemsSellInAndQualityDecrementByOneAfterUpdatingQuality() {
        // Arrange
        Item[] item = new Item[]{new Item("Saffron",1,1)};
        GildedRose gildedRose = new GildedRose(item);
        gildedRose.updateQuality();
        // Act
        gildedRose.updateQuality();
        // Assert
       Assertions.assertEquals("Saffron", item[0].name);
       Assertions.assertEquals(0, item[0].quality);
        Assertions.assertEquals(0, item[0].sellIn);
    }

//    @Test
//    @DisplayName("Given sell by date is 0 check that quality decrements by 2")
//    void givenSellByDateIs0CheckThatQualityDecrementsBy2() {
//        // Arrange
//        Item[] item = new Item[]{new Item("Saffron",0,4)};
//        GildedRose gildedRose = new GildedRose(item);
//        // Act
//        gildedRose.updateQuality();
//        // Assert
//        Assertions.assertEquals(0, item[0].quality);
//
//    }
}



