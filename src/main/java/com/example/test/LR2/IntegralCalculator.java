package com.example.test.LR2;

import java.util.Locale;

public class IntegralCalculator {


    private static final double A = 0.4;
    private static final double B = 0.6;

    private static final double EPSILON = 0.0001;

    private static final int JOURNAL_NUMBER = 1;

    private static final String FIRST_NAME = "Чередниченко";
    private static final String LAST_NAME = "Максим";

    public static void main(String[] args) {
        try {
            int methodIndex = JOURNAL_NUMBER % 3;
            String methodName;
            switch (methodIndex) {
                case 0:
                    methodName = "Обобщенная формула прямоугольников (средние точки)";
                    break;
                case 1:
                    methodName = "Обобщенная формула Симпсона";
                    break;
                case 2:
                    methodName = "Обобщенная формула трапеций";
                    break;
                default:
                    throw new IllegalStateException("Недопустимый индекс метода: " + methodIndex);
            }

            System.out.println("===== Начало вычислений =====");
            System.out.printf("Интеграл от %.2f до %.2f%n", A, B);
            System.out.println("Метод: " + methodName);
            System.out.printf("Заданная точность (ε): %.5f%n", EPSILON);
            System.out.println("----------------------------------------");

            double result = calculateIntegral(methodIndex);

            System.out.println("----------------------------------------");
            System.out.printf("Итоговое значение интеграла: %.8f%n", result);
            System.out.println("===== Вычисления завершены =====");

        } catch (Exception e) {
            System.err.println("Произошла ошибка во время выполнения программы:");
            e.printStackTrace(System.err);
        }
    }

    private static double calculateIntegral(int methodIndex) {
        int n = 1; // Начальное количество разбиений
        double integral_n = 0.0;
        double integral_2n;
        double delta;
        int iteration = 0;

        int p = (methodIndex == 1) ? 2 : 1;
        double rungeDenominator = Math.pow(2, p) - 1;

        int fn = getLetterIndex(FIRST_NAME);
        int ln = getLetterIndex(LAST_NAME);
        System.out.printf("Отладочный вывод: FN=%d, LN=%d%n", fn, ln);

        do {
            iteration++;
            n *= 2;
            double h = (B - A) / n;

            integral_2n = calculateByMethod(methodIndex, n);

            delta = Math.abs(integral_2n - integral_n) / rungeDenominator;

            System.out.printf("[Итерация %d] n=%d, h=%.6f | I_n=%.8f, I_2n=%.8f | Δ=%.8f%n",
                    iteration, n, h, integral_n, integral_2n, delta);

            if (iteration == fn) {
                System.err.printf("--- ОТЛАДКА (Шаг %d) --- Значение интеграла: %.8f%n", fn, integral_2n);
            }
            if (iteration == ln) {
                System.out.printf("--- ТРАССИРОВКА (Шаг %d) --- Значение интеграла: %.8f%n", ln, integral_2n);
            }

            integral_n = integral_2n;

        } while (delta > EPSILON / 2);

        return integral_2n;
    }

    private static double calculateByMethod(int methodIndex, int n) {
        switch (methodIndex) {
            case 0: return calculateRectangle(n);
            case 1: return calculateSimpson(n);
            case 2: return calculateTrapezoidal(n);
            default: throw new IllegalArgumentException("Неизвестный метод: " + methodIndex);
        }
    }

    private static double calculateRectangle(int n) {
        double h = (B - A) / n;
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            double x = A + i * h + h / 2.0;
            assert x >= A && x <= B : "x вышел за границы в методе прямоугольников!";
            sum += f(x);
        }
        return sum * h;
    }

    private static double calculateSimpson(int n) {
        double h = (B - A) / n;
        double sum = f(A) + f(B);
        for (int i = 1; i < n; i++) {
            double x = A + i * h;
            assert x >= A && x <= B : "x вышел за границы в методе Симпсона!";
            if (i % 2 == 0) {
                sum += 2 * f(x);
            } else {
                sum += 4 * f(x);
            }
        }
        return sum * h / 3.0;
    }

    private static double calculateTrapezoidal(int n) {
        double h = (B - A) / n;
        double sum = 0.5 * (f(A) + f(B));
        for (int i = 1; i < n; i++) {
            double x = A + i * h;
            assert x >= A && x <= B : "x вышел за границы в методе трапеций!";
            sum += f(x);
        }
        return sum * h;
    }

    private static double f(double x) {
        double numerator = x * x + Math.sin(0.48 * (x + 2.0));
        double denominator = Math.exp(x * x + 0.38);
        return numerator / denominator;
    }

    private static int getLetterIndex(String name) {
        if (name == null || name.isEmpty()) {
            return 0;
        }
        return Character.toUpperCase(name.charAt(0)) - 'A' + 1;
    }
}
