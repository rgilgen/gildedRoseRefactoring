package com.gildedrose;

public class Sulfuras extends BaseItem{

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    public void processQuality() {
    }

    @Override
    public void decreaseSellIn() {
    }

    @Override
    public void processExpired() {
    }
}
