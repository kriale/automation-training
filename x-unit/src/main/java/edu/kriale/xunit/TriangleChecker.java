package edu.kriale.xunit;

public class TriangleChecker {
    private static final double PRECISION = 0.0000001;

    public static boolean isTriangle(double sideSizeA, double sideSizeB, double sideSizeC) {
        return sideSizeA > 0 && sideSizeB > 0 && sideSizeC > 0
                && sideSizeA < sideSizeB + sideSizeC
                && sideSizeB < sideSizeA + sideSizeC
                && sideSizeC < sideSizeB + sideSizeA;
    }
}
