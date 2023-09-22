package com.gildedrose;

public class Conjured extends BaseItem{
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public Conjured(Item item) {
        super(item);
    }

    @Override
    public void processQuality() {
        decreaseQualityBy( 2);
    }

}
