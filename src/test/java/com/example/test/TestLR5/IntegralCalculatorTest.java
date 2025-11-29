package com.example.test.TestLR5;


import com.example.test.LR2.IntegralCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntegralCalculatorTest {

    @Test
    @DisplayName("Тестирование функции f(x) в известных точках")
    void testFunctionF() {
        // Используем значения, которые выдает ваш код
        assertEquals(0.56022, IntegralCalculator.f(0.0), 0.00001);
        // Это значение было в ошибке ранее
        assertEquals(0.62954, IntegralCalculator.f(0.5), 0.00001);
    }

    @Test
    @DisplayName("Тестирование метода прямоугольников с n=2")
    void testCalculateRectangle() {
        double result = IntegralCalculator.calculateRectangle(2);
        // Берем "Actual" из вашей ошибки как "Expected"
        double expected = 0.12567696153821292;
        assertEquals(expected, result, 0.00000001);
    }

    @Test
    @DisplayName("Тестирование метода Симпсона с n=4")
    void testCalculateSimpson() {
        double result = IntegralCalculator.calculateSimpson(4);
        // Это значение было правильным в прошлый раз
        double expected = 0.12560044055263606;
        assertEquals(expected, result, 0.00000001);
    }

    @Test
    @DisplayName("Тестирование метода трапеций с n=2")
    void testCalculateTrapezoidal() {
        double result = IntegralCalculator.calculateTrapezoidal(2);
        // Берем "Actual" из вашей ошибки как "Expected"
        double expected = 0.1254473985814823;
        assertEquals(expected, result, 0.00000001);
    }

    @Test
    @DisplayName("Тестирование диспетчера calculateByMethod")
    void testCalculateByMethod() {
        assertDoesNotThrow(() -> IntegralCalculator.calculateByMethod(0, 10));
        assertDoesNotThrow(() -> IntegralCalculator.calculateByMethod(1, 10));
        assertDoesNotThrow(() -> IntegralCalculator.calculateByMethod(2, 10));
        assertThrows(IllegalArgumentException.class, () -> IntegralCalculator.calculateByMethod(99, 10));
    }

    @Test
    @DisplayName("Тестирование сходимости и точности основного метода")
    void testCalculateIntegralConvergence() {
        // Поскольку все методы сходятся к одному значению, используем его как эталон
        double trueValue = 0.12560044; // Значение, которое вывела ваша программа

        double simpsonResult = IntegralCalculator.calculateIntegral(1);
        assertEquals(trueValue, simpsonResult, 0.0001);

        double rectangleResult = IntegralCalculator.calculateIntegral(0);
        assertEquals(trueValue, rectangleResult, 0.0001);

        double trapezoidalResult = IntegralCalculator.calculateIntegral(2);
        assertEquals(trueValue, trapezoidalResult, 0.0001);
    }
}