package edu.kriale.xunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TriangleCheckerTest {
    @Test
    @DisplayName("Should refute the triangle with all negative side sizes")
    void testWithAllNegativeSideSizes() {
        Assertions.assertFalse(TriangleChecker.isTriangle(-5, -2, -1));
    }

    @Test
    @DisplayName("Test with negative side sizes")
    void testWithNegativeSideSize() {
        Assertions.assertFalse(TriangleChecker.isTriangle(3, 4.6, -1.123));
    }

    @Test
    @DisplayName("Test with side sizes of right triangle")
    void testWithSideSizesOfRightTriangle() {
        Assertions.assertTrue(TriangleChecker.isTriangle(4, 5, 3));
    }

    @Test
    @DisplayName("Test with side sizes of very acute triangle")
    void testWithSideSizesOfVeryAcuteTriangle() {
        Assertions.assertTrue(TriangleChecker.isTriangle(2.87, 97.34, 95.961));
    }

    @Test
    @DisplayName("Test with zero side sizes")
    void testWithZeroSideSizes() {
        Assertions.assertFalse(TriangleChecker.isTriangle(0, 0, 0));
    }

    @Test
    @DisplayName("Test with side size that equals to sum of other side sizes")
    void testWithSideSizeThatEqualsToSumOfOtherSideSizes() {
        Assertions.assertFalse(TriangleChecker.isTriangle(36.471, 17.90, 36.471 + 17.90));
    }

    @Test
    @DisplayName("Test with last too long side")
    void testWithLastTooLongSide() {
        Assertions.assertFalse(TriangleChecker.isTriangle(245, 124.7, 540));
    }

    @Test
    @DisplayName("Test with equal side sizes")
    void testWithEqualSideSizes() {
        Assertions.assertTrue(TriangleChecker.isTriangle(50, 50, 50));
    }

    @Test
    @DisplayName("Test with last negative side size")
    void testWithLastNegativeSideSize() {
        Assertions.assertFalse(TriangleChecker.isTriangle(30, 50, -40));
    }

    @Test
    @DisplayName("Test with side sizes of super acute triangle")
    void testWithSideSizesOfSuperAcuteTriangle() {
        Assertions.assertTrue(TriangleChecker.isTriangle(0.2,
                0.1,
                0.3));
    }
}
