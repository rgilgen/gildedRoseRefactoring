package com.gildedrose;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class BaseItem extends Item implements GildedItem {
    private static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    public BaseItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    public BaseItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void processQuality() {
        decreaseQualityBy(1);
    }

    @Override
    public void decreaseSellIn() {
        this.sellIn = this.sellIn - 1;
    }

    @Override
    public void processExpired() {
        decreaseQualityBy(1);
    }

    @Override
    public boolean isExpired() {
        return this.sellIn < 0;
    }

    protected void increaseQualityBy(int amount) {
        this.quality = min(this.quality + amount, MAX_QUALITY);
    }

    protected void increaseQuality() {
        increaseQualityBy(1);
    }

    protected void decreaseQualityBy(int amount) {
        this.quality = max(this.quality - amount, MIN_QUALITY);
    }
}
