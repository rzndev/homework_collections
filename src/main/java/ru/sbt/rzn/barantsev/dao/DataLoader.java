package ru.sbt.rzn.barantsev.dao;

import ru.sbt.rzn.barantsev.entity.DataEntity;
import ru.sbt.rzn.barantsev.entity.TextEntity;

import java.util.Collection;

/**
 * Загрузчик данных для DataEntity (для выполнения заданий 5 и 6)
 */
public class DataLoader {

    /**
     * Создание объекта DataEntity на основе коллекции элементов TextEntity
     * @param text Коллекция строк обрабатываемого текста
     * @return Документ
     */
    public static DataEntity init(Collection<TextEntity> text) {
        return new DataEntity(text);
    }
}
