package ru.sbt.rzn.barantsev;

import ru.sbt.rzn.barantsev.business.TextWordProcess;
import ru.sbt.rzn.barantsev.dao.DataLoader;
import ru.sbt.rzn.barantsev.dao.TextLoader;
import ru.sbt.rzn.barantsev.entity.DataEntity;
import ru.sbt.rzn.barantsev.entity.TextEntity;
import ru.sbt.rzn.barantsev.entity.WordEntity;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String filename = "text.txt";
        if (args.length > 0)
            filename = args[0];

        Collection<TextEntity> textStrings = new ArrayList<>();
        TextLoader.init(textStrings, filename);

        System.out.println("Задание 1. Количество различных слов в файле: " + TextWordProcess.getCountOfUniqueWords(textStrings));

        Map<WordEntity, Integer> entries = TextWordProcess.getUniqueWordsStatistics(textStrings);
        System.out.println("\nЗадание 2. Список слов в порядке возрастания их длины:");
        System.out.println(entries.keySet().toString());

        System.out.println("\nЗадание 3. Таблица встречаемости слов:");
        Iterator<Map.Entry<WordEntity, Integer>> iteratorWords = entries.entrySet().iterator();
        while (iteratorWords.hasNext()) {
            Map.Entry<WordEntity, Integer> entry = iteratorWords.next();
            System.out.println(entry.getKey() + " встречается " + entry.getValue() + " раз");
        }

        System.out.println("\nЗадание 4. Строки файла в обратном порядке:");
        for(TextEntity textEntity4 : TextWordProcess.getStringsinReverseOrder(textStrings))
            System.out.println(textEntity4);

        DataEntity data = DataLoader.init(textStrings);
        System.out.println("\nЗадание 5. Обход списка строк файла в обратном порядке с использованием собственного итератора:");
        Iterator<TextEntity> it = data.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nЗадание 6. Вывод на экран строк, номера которых заданны пользователем");
        List<Integer> numbers = Arrays.asList(2, 5, 6);
        for(String currentItem : data.getStringsAtPositions(numbers)) {
            System.out.println(currentItem);
        }
    }
}
