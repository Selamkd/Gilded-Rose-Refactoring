package com.sparta.sa.gildedrose;

public class Item {

    public String name;
    // Sell in indicates the number of days left to sell the items
    public int sellIn;
     // quality value indicates how valuable an item is
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}