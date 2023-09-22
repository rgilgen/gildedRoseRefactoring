package com.gildedrose;

import static com.gildedrose.ItemName.*;

class GildedRose {
    private static final int MAX_QUALITY = 50;
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
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(AGED_BRIE.getValue())
                && !items[i].name.equals(BACKSTAGE_PASSES.getValue())) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals(SULFURAS.getValue())) {
                        decreaseQuality(items[i]);
                    }
                }
            } else {
                increaseQuality(items[i]);

                if (items[i].name.equals(BACKSTAGE_PASSES.getValue())) {
                    if (items[i].sellIn < 11) {
                        increaseQuality(items[i]);
                    }

                    if (items[i].sellIn < 6) {
                        increaseQuality(items[i]);
                    }
                }
            }

            if (!items[i].name.equals(SULFURAS.getValue())) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(AGED_BRIE.getValue())) {
                    if (!items[i].name.equals(BACKSTAGE_PASSES.getValue())) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(SULFURAS.getValue())) {
                                decreaseQuality(items[i]);
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    increaseQuality(items[i]);
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
        item.quality = item.quality - 1;
    }
}
