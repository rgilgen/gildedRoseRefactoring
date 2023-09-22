package com.gildedrose;

import static com.gildedrose.ItemName.*;

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
    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(AGED_BRIE.getValue())
                && !item.name.equals(BACKSTAGE_PASSES.getValue())) {
                if (!item.name.equals(SULFURAS.getValue())) {
                    decreaseQuality(item);
                }
            } else {
                increaseQuality(item);

                if (item.name.equals(BACKSTAGE_PASSES.getValue())) {
                    if (item.sellIn < 11) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < 6) {
                        increaseQuality(item);
                    }
                }
            }

            if (!item.name.equals(SULFURAS.getValue())) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE.getValue())) {
                    if (!item.name.equals(BACKSTAGE_PASSES.getValue())) {
                        if (!item.name.equals(SULFURAS.getValue())) {
                            decreaseQuality(item);
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    increaseQuality(item);
                }
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality = item.quality - 1;
        }
    }
}
