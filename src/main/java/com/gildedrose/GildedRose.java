package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

import static com.gildedrose.ItemName.*;

class GildedRose {
    List<GildedItem> items = new ArrayList<>();

    public GildedRose(Item[] items) {
        for (Item item : items) {
            mapToGildetItem(item);
        }
    }

    private void mapToGildetItem(Item item) {
        if (item.name.equals(BACKSTAGE_PASSES.getValue())) {
            this.items.add(new BackstageItem(item));
        } else if (item.name.equals(AGED_BRIE.getValue())) {
            this.items.add(new AgedBrie(item));
        } else if (item.name.equals(SULFURAS.getValue())) {
            this.items.add(new Sulfuras(item));
        } else if (item.name.equals(CONJURED.getValue())) {
            this.items.add(new Conjured(item));
        } else {
            this.items.add(new BaseItem(item));
        }
    }

    /**
     * Smells:
     * Magic Number
     * Naming
     * Index Naming
     */
    public void dailyUpdate() {
        for (GildedItem item : items) {
            dailyItemUpdate(item);
        }
    }

    private void dailyItemUpdate(GildedItem item) {
        item.processQuality();
        item.decreaseSellIn();
        if (item.isExpired()) {
            item.processExpired();
        }
    }


    public void printItems() {
        for (GildedItem item : items) {
            System.out.println(item);
        }
    }
}
