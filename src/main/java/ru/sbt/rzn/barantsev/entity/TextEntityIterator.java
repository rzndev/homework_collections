package ru.sbt.rzn.barantsev.entity;

import java.util.Iterator;

/**
 * Итератор для документа
 */
public class TextEntityIterator implements Iterator<TextEntity> {


    /**
     * Класс, для которого предназначен итератор
     */
    private DataEntity data;

    /**
     * Текущий индекс в массиве data класса DataEntity
     */
    private int position;

    /**
     *
     * @param data Документ, для которого используется итератор
     */
    TextEntityIterator(DataEntity data) {
        this.data = data;
        position = -1;
        if (data != null && data.data != null) {
            position = data.data.size() - 1;
        }
    }

    @Override
    public boolean hasNext() {
        return !(position < 0);
    }

    @Override
    public TextEntity next() {
        if (position < 0 || data == null || data.data == null || position >= data.data.size())
            throw new IndexOutOfBoundsException();
        return data.data.get(position--);
    }
}
