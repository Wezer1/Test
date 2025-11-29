package com.example.test.TestLr6;

import com.example.test.LR6.NumberConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberConverterTest {

    @Test
    @DisplayName("Тестирование с пустой строкой")
    void testConvertWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> NumberConverter.convertFromBase12ToBase10(""));
    }

    @Test
    @DisplayName("Тестирование с null в качестве входных данных")
    void testConvertWithNull() {
        assertThrows(IllegalArgumentException.class, () -> NumberConverter.convertFromBase12ToBase10(null));
    }

    @Test
    @DisplayName("Тестирование с недопустимым символом")
    void testConvertWithInvalidCharacter() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> NumberConverter.convertFromBase12ToBase10("1C"));
        assertEquals("Недопустимый символ 'C' в 12-ричной системе счисления.", exception.getMessage());
    }

    @Test
    @DisplayName("Тестирование однозначного числа (цифра)")
    void testConvertSingleDigit() {
        assertEquals(8L, NumberConverter.convertFromBase12ToBase10("8"));
    }

    @Test
    @DisplayName("Тестирование однозначного числа (буква A)")
    void testConvertSingleLetterA() {
        assertEquals(10L, NumberConverter.convertFromBase12ToBase10("A"));
    }

    @Test
    @DisplayName("Тестирование однозначного числа (буква B)")
    void testConvertSingleLetterB() {
        assertEquals(11L, NumberConverter.convertFromBase12ToBase10("B"));
    }

    @Test
    @DisplayName("Тестирование многозначного числа (только цифры)")
    void testConvertMultiDigit() {
        assertEquals(12L, NumberConverter.convertFromBase12ToBase10("10"));
    }

    @Test
    @DisplayName("Тестирование многозначного числа (с буквами)")
    void testConvertWithLetters() {
        assertEquals(23L, NumberConverter.convertFromBase12ToBase10("1B"));
    }

    @Test
    @DisplayName("Тестирование длинного числа")
    void testConvertLongNumber() {
        assertEquals(1572L, NumberConverter.convertFromBase12ToBase10("AB0"));
    }

    @Test
    @DisplayName("Тестирование числа в нижнем регистре")
    void testConvertWithLowerCase() {
        // Используем число "1b" (в нижнем регистре), которое эквивалентно "1B".
        // Результат должен быть таким же, как и для "1B".
        assertEquals(23L, NumberConverter.convertFromBase12ToBase10("1b"));
    }
}
