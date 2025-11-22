package com.example.test.LR3;

public class CircleRegionChecker {

    private final double R;

    public static final int REGION_1_SHADED = 1;
    public static final int REGION_2_UNSHADED = 2;
    public static final int REGION_3_OUTSIDE = 3;

    public CircleRegionChecker(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом.");
        }
        this.R = radius;
    }

    public int testPoint(double x, double y) {
        double distanceFromCenterSquared = x * x + y * y;
        double radiusSquared = R * R;

        if (distanceFromCenterSquared <= radiusSquared) {

            if (x * y < 0) {
                return REGION_1_SHADED;
            } else {
                return REGION_2_UNSHADED;
            }
        } else {
            return REGION_3_OUTSIDE;
        }
    }
}
