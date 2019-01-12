package ru.sbt.rzn.barantsev;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String filename = "text.txt";
        if (args.length > 0)
            filename = args[0];
        FileProcessor processor = new FileProcessor(filename);
        // выполненение анализа файла и заполнение структур файла FileProcessor для получения результата
        processor.init();
        // вывод результатов
        System.out.println("Задание 1. Количество различных слов в файле: " + processor.getDifferentWordsCount());

        System.out.println("\nЗадание 2. Список слов в порядке возрастания их длины:");
        System.out.println(processor.getSortedWordsList());

        System.out.println("\nЗадание 3. Таблица встречаемости строк:");
        Iterator<Map.Entry<String, Integer>> entries = processor.getHistogramOfWords().entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Integer> entry = entries.next();
            System.out.println(entry.getKey() + " встречается " + entry.getValue() + " раз");
        }

        System.out.println("\nЗадание 4. Строки файла в обратном порядке:");
        System.out.println(processor.getStringsinReverseOrder());

        System.out.println("\nЗадание 5. Обход списка строк файла в обратном порядке:");
        Iterator<String> it = processor.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nЗадание 6. Вывод на экран строк, номера которых заданны пользователем");
        List<Integer> numbers = Arrays.asList(2, 5, 6);
        for(String currentItem : processor.getStringsAtPositions(numbers)) {
            System.out.println(currentItem);
        }
    }
}
