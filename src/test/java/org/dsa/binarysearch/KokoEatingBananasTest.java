package org.dsa.binarysearch;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class KokoEatingBananasTest {

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{3, 6, 7, 11}, 8, 4),
                Arguments.of(new int[]{30}, 5, 6),
                Arguments.of(new int[]{3, 6, 7, 11}, 4, 11),
                Arguments.of(new int[]{3, 6, 7, 11}, 10, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testMinEatingSpeed(int[] piles, int h, int expected) {
        KokoEatingBananas koko = new KokoEatingBananas();
        assertEquals(expected, koko.minEatingSpeed(piles, h));
    }
}