package org.dsa.arraysandhash;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KadaneAlgorithmTest {

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
                Arguments.of(new int[]{-2, -3, -1}, -1),
                Arguments.of(new int[]{5}, 5),
                Arguments.of(new int[]{1, 2, 3, -2, 5}, 9),
                Arguments.of(new int[]{-1, -2, -3}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testMaxSubArray(int[] nums, int expected) {
        KadaneAlgorithm kadane = new KadaneAlgorithm();
        assertEquals(expected, kadane.maxSubArray(nums));
    }
}