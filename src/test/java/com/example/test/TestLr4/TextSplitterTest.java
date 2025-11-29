package com.example.test.TestLr4;

import com.example.test.LR4.TextSplitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TextSplitterTest {

    @Test
    @DisplayName("Тестирование с пустым текстом")
    void testSplitWithEmptyText() {
        List<String> result = TextSplitter.splitIntoSentences("", ".!?");
        assertTrue(result.isEmpty(), "Список должен быть пустым для пустого текста");
    }

    @Test
    @DisplayName("Тестирование с null в качестве текста")
    void testSplitWithNullText() {
        List<String> result = TextSplitter.splitIntoSentences(null, ".!?");
        assertTrue(result.isEmpty(), "Список должен быть пустым для null текста");
    }

    @Test
    @DisplayName("Тестирование с пустыми разделителями")
    void testSplitWithEmptyDelimiters() {
        List<String> result = TextSplitter.splitIntoSentences("One sentence", "");
        assertEquals(List.of("One sentence"), result);
    }

    @Test
    @DisplayName("Тестирование с null в качестве разделителей")
    void testSplitWithNullDelimiters() {
        List<String> result = TextSplitter.splitIntoSentences("Another sentence", null);
        assertEquals(List.of("Another sentence"), result);
    }

    @Test
    @DisplayName("Тестирование текста без разделителей")
    void testSplitTextWithoutDelimiters() {
        List<String> result = TextSplitter.splitIntoSentences("Just one part", ".!?");
        assertEquals(List.of("Just one part"), result);
    }

    @Test
    @DisplayName("Тестирование стандартного случая с несколькими предложениями")
    void testSplitMultipleSentences() {
        List<String> result = TextSplitter.splitIntoSentences("First. Second! Third?", ".!?");
        assertEquals(List.of("First", "Second", "Third"), result);
    }

    @Test
    @DisplayName("Тестирование предложений с лишними пробелами")
    void testSplitWithExtraSpaces() {
        List<String> result = TextSplitter.splitIntoSentences("  First.  Second!  ", ".!?");
        assertEquals(List.of("First", "Second"), result);
    }
}
