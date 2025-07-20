package org.dsa.binarysearch;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class KokoEatingBananasTest {

    @Test
    void returnsMinimumSpeedForExactHours() {
        KokoEatingBananas koko = new KokoEatingBananas();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        assertEquals(4, koko.minEatingSpeed(piles, h));
    }

    @Test
    void returnsMinimumSpeedWhenSinglePile() {
        KokoEatingBananas koko = new KokoEatingBananas();
        int[] piles = {30};
        int h = 5;
        assertEquals(6, koko.minEatingSpeed(piles, h));
    }

    @Test
    void returnsMinimumSpeedWhenHoursEqualPiles() {
        KokoEatingBananas koko = new KokoEatingBananas();
        int[] piles = {3, 6, 7, 11};
        int h = 4;
        assertEquals(11, koko.minEatingSpeed(piles, h));
    }

    @Test
    void returnsMinimumSpeedWhenHoursGreaterThanPiles() {
        KokoEatingBananas koko = new KokoEatingBananas();
        int[] piles = {3, 6, 7, 11};
        int h = 10;
        assertEquals(3, koko.minEatingSpeed(piles, h));
    }
}