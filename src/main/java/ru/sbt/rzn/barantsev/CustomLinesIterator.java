package ru.sbt.rzn.barantsev;

import java.util.Iterator;

/**
 * Итератор обхода списка в обратном порядке
 */
final class CustomLinesIterator implements Iterator<String> {

    /**
     * Класс, для которого предназначен итератор
     */
    private FileProcessor list;

    CustomLinesIterator(FileProcessor list) {
        this.list = list;
        pos = -1;
        if (list != null && list.stringsOfFile != null) {
            pos = list.stringsOfFile.size() - 1;
        }
    }

    /**
     * Текущий индекс в массиве stringsOfFile класса FileProcessor
     */
    private int pos;

    @Override
    public boolean hasNext() {
        return !(pos < 0);
    }

    @Override
    public String next() {
        if (pos < 0 || list == null || list.stringsOfFile == null || pos >= list.stringsOfFile.size())
            throw new IndexOutOfBoundsException();
        return list.stringsOfFile.get(pos--);
    }
}
