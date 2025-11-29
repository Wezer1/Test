package com.example.test.LR6;

public class NumberConverter {

    public static long convertFromBase12ToBase10(String base12Number) {
        // 1. Проверка на некорректный или пустой ввод
        if (base12Number == null || base12Number.trim().isEmpty()) {
            throw new IllegalArgumentException("Входная строка не может быть null или пустой.");
        }

        long result = 0;
        // 2. Итерация по каждому символу строки
        for (int i = 0; i < base12Number.length(); i++) {
            char c = Character.toUpperCase(base12Number.charAt(i));
            int digitValue;

            // 3. Определение числового значения символа
            if (c >= '0' && c <= '9') {
                digitValue = c - '0';
            } else if (c == 'A') {
                digitValue = 10;
            } else if (c == 'B') {
                digitValue = 11;
            } else {
                // 4. Обработка недопустимого символа
                throw new IllegalArgumentException("Недопустимый символ '" + c + "' в 12-ричной системе счисления.");
            }

            // 5. Обновление результата
            result = result * 12 + digitValue;
        }

        return result;
    }
}
