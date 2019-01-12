package ru.sbt.rzn.barantsev.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Класс, содержащий обрабатываемый документ. Создан для выполнения задаий 5 и 6
 */
public class DataEntity implements Iterable<TextEntity> {

    ArrayList<TextEntity> data;

    public DataEntity() {
        data = new ArrayList<>();
    }

    public DataEntity(Collection<TextEntity> text) {
        data = new ArrayList<>(text);
    }

    @Override
    public Iterator<TextEntity> iterator() {
        return new TextEntityIterator(this);
    }

    /**
     * Получить список строк файла согласно переданным позициям
     * @param position Список позиций
     * @return Возвращает список строк из позиций, указанных в списке позиций
     */
    public List<String> getStringsAtPositions(List<Integer> position) {
        List<String> result = new ArrayList<>();
        if (null == position || null == data) return result;
        for(Integer val : position) {
            if (val < 0 || val >= data.size())
                result.add("INVALID POSITION");
            else
                result.add(data.get(val).toString());
        }
        return result;
    }
}
