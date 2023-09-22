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
            if (item.name.equals(BACKSTAGE_PASSES.getValue())) {
                if (item.sellIn > 10) {
                    increaseQuality(item);
                }
                else if (item.sellIn < 11 && item.sellIn > 5) {
                    increaseQuality(item);
                    increaseQuality(item);
                }

                else {
                    increaseQuality(item);
                    increaseQuality(item);
                    increaseQuality(item);
                }
            } else if (item.name.equals(AGED_BRIE.getValue())) {
                increaseQuality(item);
            } else if (!item.name.equals(SULFURAS.getValue())) {
                decreaseQuality(item);
            }

            if (!item.name.equals(SULFURAS.getValue())) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (item.name.equals(AGED_BRIE.getValue())) {
                    increaseQuality(item);
                } else {
                    if (item.name.equals(BACKSTAGE_PASSES.getValue())) {
                        item.quality = 0;
                    } else {
                        if (!item.name.equals(SULFURAS.getValue())) {
                            decreaseQuality(item);
                        }
                    }
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
