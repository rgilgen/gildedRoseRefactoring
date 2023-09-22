package com.gildedrose;

public enum ItemName {
    DEXTERITY_VEST("+5 Dexterity Vest"),
    AGED_BRIE("Aged Brie"),
    ELIXIR_MONGOOSE("Elixir of the Mongoose"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert");

    private final String value;

    ItemName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
