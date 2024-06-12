package gildedRoseTests;

import com.sparta.sa.gildedrose.GildedRose;
import com.sparta.sa.gildedrose.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GildedRoseTests {
  @Test
  @DisplayName("Normal Item:  sellIn and quality decrement by one after updating quality end of the day")
  void itemsSellInAndQualityDecrementByOneAfterUpdatingQuality() {
    // Arrange
    Item[] item = new Item[]{new Item("Saffron", 1, 1)};
    GildedRose gildedRose = new GildedRose(item);
    // first update
    gildedRose.updateQuality();
    // assert - first update
    Assertions.assertEquals(0, item[0].quality);
    Assertions.assertEquals(0, item[0].sellIn);
    // Second update
    gildedRose.updateQuality();
    // Assert - Second update
    Assertions.assertEquals(0, item[0].quality);
    Assertions.assertEquals(-1, item[0].sellIn);

  }

  @Test
  @DisplayName("Normal Item: Given sell by date is 0 check that quality decrements by 2")
  void givenSellByDateIs0CheckThatQualityDecrementsBy2() {
    // Arrange
    Item[] item = new Item[]{new Item("Saffron", 0, 4)};
    GildedRose gildedRose = new GildedRose(item);
    // Act
    gildedRose.updateQuality();
    // Assert
    Assertions.assertEquals(2, item[0].quality);

  }

  @Test
  @DisplayName("Normal item: Check quality of an item is never negative")
  void checkQualityOfAnItemIsNeverNegative() {
    // Arrange
    Item[] item = new Item[]{new Item("Saffron", 4, 1)};
    GildedRose gildedRose = new GildedRose(item);
    // Act
    gildedRose.updateQuality();
    gildedRose.updateQuality();
    gildedRose.updateQuality();
    // Assert
    Assertions.assertEquals(0, item[0].quality);

  }


  @Test
  @DisplayName("Aged Brie: Check Aged Brie increases in quality when sell it gets older")
  void checkAgedBrieIncreasesInQualityWhenSellItGetsOlder() {
    // Arrange
    Item agedBrie = new Item("Aged Brie", 10, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});
    // Act
    gildedRose.updateQuality();

    // Assert
    Assertions.assertEquals("Aged Brie", agedBrie.name);
    Assertions.assertEquals(6, agedBrie.quality);
    Assertions.assertEquals(9, agedBrie.sellIn);

  }
  @Test
  @DisplayName("Aged Brie: Check Aged Brie increases twice in quality when sell is less than 0")
  void checkAgedBrieIncreasesTwiceInQualityWhenSellInIslessThan0() {
    // Arrange
    Item agedBrie = new Item("Aged Brie", -1, 5);
    GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});
    // Act
    gildedRose.updateQuality();

    // Assert
    Assertions.assertEquals("Aged Brie", agedBrie.name);
    Assertions.assertEquals(7, agedBrie.quality);
    Assertions.assertEquals(-2, agedBrie.sellIn);

  }



  @Test
  @DisplayName("Aged Brie: Check that the quality of an item never exceeds more than 50")
  void checkThatTheQualityOfAnItemNeverExceedsMoreThan50() {
    // Arrange
    Item agedBrie = new Item("Aged Brie", 20, 49);
    GildedRose gildedRose = new GildedRose(new Item[]{agedBrie});
    // Act
    gildedRose.updateQuality();
    gildedRose.updateQuality();
    gildedRose.updateQuality();
    // Assert
    Assertions.assertEquals("Aged Brie", agedBrie.name);
    Assertions.assertEquals(50, agedBrie.quality);
    Assertions.assertEquals(17, agedBrie.sellIn);


  }

  @Test
  @DisplayName("Sulfuras: Check that Sulfuras quality is 80")
  void checkThatSulfurasQualityIs80() {
    // Arrange
    Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 20, 80);
    GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});
    // Assert
    Assertions.assertEquals(80, sulfuras.quality);

  }


  @Test
  @DisplayName("Sulfras: Check that the quality of sulfras doesn't decrease in quality")
  void checkThatTheQualityOfSulfrasDoesnTDecreaseInQuality() {
    // Arrange
    Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 20, 80);
    GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});
    // Act
    gildedRose.updateQuality();
    gildedRose.updateQuality();
    gildedRose.updateQuality();
    // Assert
    Assertions.assertEquals(80, sulfuras.quality);


  }

  @Test
  @DisplayName("Sulfras: Check that Sulfuras never gets sold")
  void checkThatSulfurasNeverGetsSold() {
    // Arrange
    Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 20, 80);
    GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});
    // Act
    gildedRose.updateQuality();
    gildedRose.updateQuality();
    gildedRose.updateQuality();
    // Assert
    Assertions.assertEquals(20, sulfuras.sellIn);

  }

  @Test
  @DisplayName("Backstage pass : Given sellIn date is greater than 10 quality increments by 1 ")
  void givenSellInDateIsGreaterThan10QualityIncrementsBy1() {
    // Arrange
    Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20);
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePass});
    // Act
    gildedRose.updateQuality();
    // Assert
    Assertions.assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);
    Assertions.assertEquals(11, backstagePass.sellIn);
    Assertions.assertEquals(21, backstagePass.quality);
  }


  @Test
  @DisplayName("Backstage pass: Given sell in date is 10 quality increments by 2")
  void givenSellInDateIs10QualityIncrementsBy2() {
    // Arrange
    Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 21);
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePass});
    // Act
    gildedRose.updateQuality();
    // Assert
    Assertions.assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);
    Assertions.assertEquals(10, backstagePass.sellIn);
    Assertions.assertEquals(23, backstagePass.quality);

  }

  @Test
  @DisplayName("Backstage pass: Given sell in date backstage pass is 9 quality increments by 2")
  void givenSellInDateBackstagePassIs9QualityIncrementsBy2() {
    // Arrange
    Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 21);
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePass});
    // Act
    gildedRose.updateQuality();
    // Assert
    Assertions.assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);
    Assertions.assertEquals(9, backstagePass.sellIn);
    Assertions.assertEquals(23, backstagePass.quality);

  }

  @Test
  @DisplayName("Backstage pass: Given sell in date backstage pass is 5 quality increments by 3")
  void givenSellInDateBackstagePassIs5QualityIncrementsBy3() {
    // Arrange
    Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 21);
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePass});
    // Act
    gildedRose.updateQuality();
    // Assert
    Assertions.assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);
    Assertions.assertEquals(4, backstagePass.sellIn);
    Assertions.assertEquals(24, backstagePass.quality);

  }


  @Test
  @DisplayName("Backstage pass: Given backstage pass sell in date is 4 quality increments by 3")
  void givenBackStageSellInDateBackstagePassIs4QualityIncrementsBy3() {
    // Arrange
    Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 21);
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePass});
    // Act
    gildedRose.updateQuality();
    // Assert
    Assertions.assertEquals(4, backstagePass.sellIn);
    Assertions.assertEquals(24, backstagePass.quality);

  }


  @Test
  @DisplayName("Backstage pass:- If sell in date is 0 quality resets to 0")
  void givenBackstagePassSellInDateIs0QualityResetsTo0() {
    // Arrange
    Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50);
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePass});
    // Act
    gildedRose.updateQuality();
    // Assert
    Assertions.assertEquals(0, backstagePass.sellIn);
    Assertions.assertEquals(0, backstagePass.quality);

  }
//    @Test
//    @DisplayName("Conjured item degrades in quality twice as fast as normal item")
//    void conjuredItemDegradesTwiceAsFast() {
//        // Arrange
//        Item conjuredItem = new Item("Conjured Moon Cake", 5, 10);
//        GildedRose gildedRose = new GildedRose(new Item[]{conjuredItem});
//
//        // Act
//        gildedRose.updateQuality();
//
//        // Assert
//        Assertions.assertEquals("Conjured Moon Cake", conjuredItem.name);
//        Assertions.assertEquals(8, conjuredItem.quality);
//    }


}



