package org.dsa.arraysandhash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KadaneAlgorithmTest {

    @Test
    void testMaxSubArraySum() {
        KadaneAlgorithm kadane = new KadaneAlgorithm();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, kadane.maxSubArray(nums));
    }

    @Test
    void testMaxSubArraySumWithAllNegative() {
        KadaneAlgorithm kadane = new KadaneAlgorithm();
        int[] nums = {-2, -3, -1};
        assertEquals(-1, kadane.maxSubArray(nums));
    }

    @Test
    void testMaxSubArraySumWithSingleElement() {
        KadaneAlgorithm kadane = new KadaneAlgorithm();
        int[] nums = {5};
        assertEquals(5, kadane.maxSubArray(nums));
    }

}