package com.sparta.sa.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GildedRoseTests {


    @Test
    @DisplayName("Items sellIn and quality decrement by one after updating quality")
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

    @Test
    @DisplayName("Given sell by date is 0 check that quality decrements by 2")
    void givenSellByDateIs0CheckThatQualityDecrementsBy2() {
        // Arrange
        Item[] item = new Item[]{new Item("Saffron",0,4)};
        GildedRose gildedRose = new GildedRose(item);
        // Act
        gildedRose.updateQuality();
        // Assert
        Assertions.assertEquals(2, item[0].quality);

    }

 @Test
 @DisplayName("Check quality of an item is never negative")
 void checkQualityOfAnItemIsNeverNegative() {
     // Arrange
     Item[] item = new Item[]{new Item("Saffron",4,1)};
     GildedRose gildedRose = new GildedRose(item);
     // Act
     gildedRose.updateQuality();
     gildedRose.updateQuality();
     gildedRose.updateQuality();
     // Assert
     Assertions.assertEquals( 0, item[0].quality);

 }



}



