package com.gildedrose;

public class AgedBrie extends BaseItem {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void processQuality() {
        increaseQuality();
    }

    @Override
    public void processExpired() {
        increaseQuality();
    }
}
