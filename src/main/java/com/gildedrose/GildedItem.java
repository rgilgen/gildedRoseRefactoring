package com.gildedrose;

import static java.lang.Math.min;

interface GildedItem {
    void processQuality();

    void decreaseSellIn();

    void processExpired();

    boolean isExpired();

}
