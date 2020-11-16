package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQualityWhenIsNotSulfurasShouldDecreaseSellIn() {
        // Given
        Item[] items = new Item[] {
                new Item("Aged Brie", 0, 0)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void updateQualityWhenIsAgedBrieOrBackstageAndQualityLessThanFiftyShouldIncreaseQuality() {
        // Given
        Item[] items = new Item[] {
                new Item("Aged Brie", 0, 24)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(25, app.items[0].quality);
        assertEquals(33, app.items[1].quality);
    }

    @Test
    void updateQualityWhenSellinDateIsLessThanZeroShouldDecreaseQualityByTwo() {
        // Given
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 0, 5)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void updateQualityWhenQualityIsEqualToZeroShouldNotBeNegative() {
        // Given
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 0, 0)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateQualityWhenAgedBrieGetOlderShouldIncreaseQualityByOne() {
        // Given
        Item[] items = new Item[] {
                new Item("Aged Brie", 5, 5)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void updateQualityWhenAgedBrieSellInDateIsNegativeShouldIcreaseQualityByOne() {
        // Given
        Item[] items = new Item[] {
                new Item("Aged Brie", 0, 5)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(7, app.items[0].quality);
    }

    @Test
    void updateQualityWhenQualityIsFiftyShouldNotIncrease() {
        // Given
        Item[] items = new Item[] {
                new Item("Aged Brie", 0, 50)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void updateQualityWhenIsSulfurasShouldNotDecreaseSellInAndQuality() {
        // Given
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 5, 7)
        };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertEquals(5, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }
}
