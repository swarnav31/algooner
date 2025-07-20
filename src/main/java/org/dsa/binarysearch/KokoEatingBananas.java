package org.dsa.binarysearch;

import java.util.Arrays;

/**
 * LeetCode 875. Koko Eating Bananas (Medium)
 * <a href="https://leetcode.com/problems/koko-eating-bananas/">URL</a>
 */
class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Arrays.stream(piles).max().getAsInt();

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (canFinish(piles, mid, h)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        int hours = 0;
        for (int pile : piles) {
            int h0 = pile / speed + (pile % speed != 0 ? 1 : 0);
            hours += h0;
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        KokoEatingBananas koko = new KokoEatingBananas();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int result = koko.minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result); // Output: 4
    }
}
