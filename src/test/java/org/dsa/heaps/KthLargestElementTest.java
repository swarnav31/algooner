package org.dsa.heaps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class KthLargestElementTest {

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 1, 5, 6, 4}, 2, 5),
                Arguments.of(new int[]{3, 2, 3, 1, 2, 4, 5, 5}, 4, 3),
                Arguments.of(new int[]{1}, 1, 1),
                Arguments.of(new int[]{7, 10, 4, 3, 20, 15}, 3, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testFindKthLargest(int[] nums, int k, int expected) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        Assertions.assertEquals(expected, kthLargestElement.findKthLargest(nums, k));
    }
}