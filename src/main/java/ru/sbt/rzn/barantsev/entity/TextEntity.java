package ru.sbt.rzn.barantsev.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Строка слов
 */

public class TextEntity {
    /**
     * Слова в строке
     */
    private List<WordEntity> wordsOfLine;

    /**
     * Оригинал строки
     */
    private String originalString;

    /**
     * Создание строки
     * @param line Исходная строка, на основе которой создается экземпляр класса
     */
    public TextEntity(String line) {
        this.originalString = line;
        wordsOfLine = new ArrayList<>();
        String[] words = line.split("[\\s.,!?\\-+=/]");
        for(String word : words) {
            wordsOfLine.add(new WordEntity(word));
        }
    }

    public List<WordEntity> getWords() {
        return wordsOfLine;
    }

    @Override
    public String toString() {
        return originalString;
    }
}
