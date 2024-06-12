package com.sparta.sa.gildedrose;

import com.sparta.sa.utils.LoggerUtil;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 21);
        GildedRose gildedRose = new GildedRose(new Item[]{backstagePass});
         gildedRose.updateQuality();
        System.out.println(backstagePass.quality);
        System.out.println(backstagePass.sellIn);


    }
}