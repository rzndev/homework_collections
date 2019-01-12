package ru.sbt.rzn.barantsev.entity;

import java.util.Objects;

/**
 * Слово
 */
public final class WordEntity implements Comparable<WordEntity> {
    private String word;

    WordEntity(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public int compareTo(WordEntity other) {
        if (word.length() != other.word.length())
            return (word.length() - other.word.length());
        return word.compareTo(other.word);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordEntity that = (WordEntity) o;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return word;
    }
}
