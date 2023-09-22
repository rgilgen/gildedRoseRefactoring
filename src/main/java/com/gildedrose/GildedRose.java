package com.gildedrose;

import static com.gildedrose.ItemName.*;
import static java.lang.Math.max;
import static java.lang.Math.min;

class GildedRose {
    private static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * Smells:
     * Magic Number
     * Naming
     * Index Naming
     */
    public void dailyUpdate() {
        for (Item item : items) {
            dailyItemUpdate(item);
        }
    }

    private void dailyItemUpdate(Item item) {
        processQuality(item);
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            processExpired(item);
        }
    }

    private void processExpired(Item item) {
        if (item.name.equals(AGED_BRIE.getValue())) {
            increaseQuality(item);
        } else if (item.name.equals(BACKSTAGE_PASSES.getValue())) {
            item.quality = 0;
        } else if (!item.name.equals(SULFURAS.getValue())) {
            decreaseQualityBy(item, 1);
        }
    }

    private void decreaseSellIn(Item item) {
        if (!item.name.equals(SULFURAS.getValue())) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void processQuality(Item item) {
        if (item.name.equals(BACKSTAGE_PASSES.getValue())) {
            if (item.sellIn > 10) {
                increaseQuality(item);
            } else if (item.sellIn > 5) {
                increaseQualityBy(item, 2);
            } else {
                increaseQualityBy(item, 3);
            }
        } else if (item.name.equals(AGED_BRIE.getValue())) {
            increaseQuality(item);
        } else if (item.name.equals(CONJURED.getValue())) {
            decreaseQualityBy(item, 2);
        } else if (!item.name.equals(SULFURAS.getValue())) {
            decreaseQualityBy(item, 1);
        }
    }

    private void increaseQualityBy(Item item, int amount) {
        item.quality = min(item.quality + amount, MAX_QUALITY);
    }

    private void increaseQuality(Item item) {
        increaseQualityBy(item, 1);
    }

    private void decreaseQualityBy(Item item, int amount) {
        item.quality = max(item.quality - amount, MIN_QUALITY);
    }
}
