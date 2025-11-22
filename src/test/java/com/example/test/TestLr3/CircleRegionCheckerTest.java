package com.example.test.TestLr3;

import com.example.test.LR3.CircleRegionChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircleRegionCheckerTest {

    private CircleRegionChecker checker;
    private final double R = 10.0;

    /**
     * Этот метод выполняется перед каждым тестом.
     * Он идеально подходит для инициализации объектов, которые нужны в каждом тесте.
     */
    @BeforeEach
    void setUp() {
        System.out.println("Создание нового экземпляра CircleRegionChecker...");
        checker = new CircleRegionChecker(R);
    }

    @Test
    void testPointInShadedRegionQuadrant2() {
        System.out.println("Тест: Точка в закрашенной области (квадрант II)");
        int result = checker.testPoint(-R / 2.0, R / 2.0);
        assertEquals(CircleRegionChecker.REGION_1_SHADED, result, "Точка (-5, 5) должна принадлежать закрашенной области 1");
    }

    @Test
    void testPointOnCircleBorderInShadedRegionQuadrant2() {
        System.out.println("Тест: Точка на границе окружности в закрашенной области (квадрант II)");
        double x = -R / Math.sqrt(2);
        double y = R / Math.sqrt(2);
        int result = checker.testPoint(x, y);
        assertEquals(CircleRegionChecker.REGION_1_SHADED, result, "Точка на границе окружности в квадранте II должна принадлежать области 1");
    }

    @Test
    void testPointOnLineYEqualsMinusXInsideCircle() {
        System.out.println("Тест: Точка на линии y=-x внутри окружности");
        int result = checker.testPoint(-R / 3.0, R / 3.0);
        assertEquals(CircleRegionChecker.REGION_1_SHADED, result, "Точка на линии y=-x внутри окружности должна принадлежать закрашенной области 1");
    }

    @Test
    void testPointInUnshadedRegionQuadrant1() {
        System.out.println("Тест: Точка в незакрашенной области (квадрант I)");
        int result = checker.testPoint(R / 2.0, R / 2.0);
        assertEquals(CircleRegionChecker.REGION_2_UNSHADED, result, "Точка (5, 5) должна принадлежать незакрашенной области 2");
    }

    @Test
    void testPointOnAxesInsideCircle() {
        System.out.println("Тест: Точка на оси X внутри окружности");
        int result = checker.testPoint(R / 2.0, 0);
        assertEquals(CircleRegionChecker.REGION_2_UNSHADED, result, "Точка на оси X внутри окружности должна принадлежать незакрашенной области 2");
    }

    @Test
    void testPointAtOrigin() {
        System.out.println("Тест: Точка в начале координат");
        int result = checker.testPoint(0, 0);
        assertEquals(CircleRegionChecker.REGION_2_UNSHADED, result, "Начало координат должно принадлежать незакрашенной области 2");
    }

    @Test
    void testPointOutsideCircle() {
        System.out.println("Тест: Точка вне окружности");
        int result = checker.testPoint(2 * R, 2 * R);
        assertEquals(CircleRegionChecker.REGION_3_OUTSIDE, result, "Точка (20, 20) должна быть вне окружности (область 3)");
    }

    @Test
    void testPointJustOutsideCircleBoundary() {
        System.out.println("Тест: Точка сразу за границей окружности");
        int result = checker.testPoint(R * 1.01, 0);
        assertEquals(CircleRegionChecker.REGION_3_OUTSIDE, result, "Точка сразу за границей должна быть вне окружности (область 3)");
    }

    @Test
    void testPointJustInsideCircleBoundary() {
        System.out.println("Тест: Точка сразу внутри границы окружности");
        int result = checker.testPoint(R * 0.99, 0);
        assertEquals(CircleRegionChecker.REGION_2_UNSHADED, result, "Точка сразу внутри границы должна быть в незакрашенной области 2");
    }
}
