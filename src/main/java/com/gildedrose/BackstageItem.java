package com.gildedrose;

public class BackstageItem extends BaseItem {

    public BackstageItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public BackstageItem(Item item){
        super(item);
    }

    @Override
    public void processQuality() {
        if (this.sellIn > 10) {
            increaseQuality();
        } else if (this.sellIn > 5) {
            increaseQualityBy( 2);
        } else {
            increaseQualityBy( 3);
        }
    }

    @Override
    public void processExpired() {
        this.quality = 0;
    }


}
