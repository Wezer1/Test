package com.example.test.LR4;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class TextSplitter {
    public static List<String> splitIntoSentences(String text, String delimiters) {
        List<String> sentences = new ArrayList<>();

        if (text == null || text.trim().isEmpty()) {
            return sentences;
        }

        if (delimiters == null || delimiters.trim().isEmpty()) {
            sentences.add(text.trim());
            return sentences;
        }

        StringTokenizer tokenizer = new StringTokenizer(text, delimiters);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (!token.isEmpty()) {
                sentences.add(token);
            }
        }

        return sentences;
    }
}