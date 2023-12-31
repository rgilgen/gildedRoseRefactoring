package com.gildedrose;

import static com.gildedrose.ItemName.*;

public class Program {

    public static void main(String... args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[]{
            new Item(DEXTERITY_VEST.getValue(), 10, 20),
            new Item(AGED_BRIE.getValue(), 2, 0),
            new Item(ELIXIR_MONGOOSE.getValue(), 5, 7),
            new Item(SULFURAS.getValue(), 0, 80),
            new Item(SULFURAS.getValue(), -1, 80),
            new Item(BACKSTAGE_PASSES.getValue(), 15, 20),
            new Item(BACKSTAGE_PASSES.getValue(), 10, 49),
            new Item(BACKSTAGE_PASSES.getValue(), 5, 49),
            new Item(CONJURED.getValue(), 3, 6)
        };
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < 31; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            app.printItems();
            System.out.println();
            app.dailyUpdate();
        }
    }
}
