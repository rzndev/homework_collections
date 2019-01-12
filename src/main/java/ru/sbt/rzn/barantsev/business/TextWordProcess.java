package ru.sbt.rzn.barantsev.business;

import ru.sbt.rzn.barantsev.entity.TextEntity;
import ru.sbt.rzn.barantsev.entity.WordEntity;

import java.util.*;

/**
 * Методы обработки текста
 */
public class TextWordProcess {

    /**
     * Подсчет общего количества уникальных слов
     * @param text Текст для анализа
     * @return Количество уникальных слов
     */
    public static int getCountOfUniqueWords(Collection<TextEntity> text){
        int result = 0;
        Set<WordEntity> set = new TreeSet<>();
        for(TextEntity line: text)
            set.addAll(line.getWords());
        return set.size();
    }

    /**
     * Подсчет количества встречаемости слов
     * @param text Текст для анализа
     * @return Пары значений (слово, количество вхождений)
     */
    public static Map<WordEntity, Integer> getUniqueWordsStatistics(Collection<TextEntity> text) {
        Map<WordEntity, Integer> result = new TreeMap<>();
        for(TextEntity line: text)
            for(WordEntity entity : line.getWords()) {
                if (result.containsKey(entity)) {
                    result.put(entity, result.get(entity) + 1);
                } else {
                    result.put(entity, 1);
                }
            }
        return result;
    }

    /**
     * Получение строк в обратном порядке
     * @return Коллекция строк в обратном порядке
     */
    public static Collection<TextEntity> getStringsinReverseOrder(Collection<TextEntity> text)
    {
        ArrayList<TextEntity> result = new ArrayList<>(text);
        Collections.reverse(result);
        return result;
    }
}
