package ru.sbt.rzn.barantsev;

import java.util.Comparator;

/**
 *  Реализация интерфейса Comparator для строк
 */
public class CustomStringComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() != o2.length())
            return (o1.length() - o2.length());
        return o1.compareTo(o2);
    }
}
