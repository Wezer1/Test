package com.example.test.LR2;

public class SequenceSumCalculator {

    private static final int NUMBER_OF_TERMS = 50;

    public static void main(String[] args) {
        System.out.println("===== Вычисление суммы последовательности Фибоначчи =====");
        System.out.printf("Задано просуммировать первых %d членов (F0, F1, ..., F%d-1).%n", NUMBER_OF_TERMS, NUMBER_OF_TERMS);
        System.out.println("----------------------------------------------------------");

        try {
            long sum = calculateFibonacciSum(NUMBER_OF_TERMS);
            System.out.println("Вычисления успешно завершены.");
            System.out.printf("Сумма первых %d членов последовательности Фибоначчи: %d%n", NUMBER_OF_TERMS, sum);

        } catch (AssertionError e) {
            System.err.println("ОШИБКА: Во время вычислений было обнаружено арифметическое переполнение!");
            System.err.println("Детали: " + e.getMessage());
        }
        System.out.println("==========================================================");
    }

    public static long calculateFibonacciSum(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 0;
        }

        long sum = 0;
        long prev = 0;
        long current = 1;

        for (int i = 1; i < n; i++) {
            assert Long.MAX_VALUE - sum >= current :
                    "Арифметическое переполнение! Сумма превысила максимальное значение для типа long.";

            sum += current;

            assert Long.MAX_VALUE - prev >= current :
                    "Арифметическое переполнение при вычислении следующего числа Фибоначчи!";

            long next = prev + current;
            prev = current;
            current = next;
        }
        return sum;
    }
}
