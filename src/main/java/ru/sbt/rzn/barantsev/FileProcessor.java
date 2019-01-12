package ru.sbt.rzn.barantsev;

import com.sun.deploy.util.ArrayUtil;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FileProcessor implements Iterable<String> {

    /**
     * Имя файла
     */
    private String fileName;

    /**
     * Получить имя файл
     * @return Имя файла
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Установить имя файла
     * @param fileName Имя файла
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Конструктор
     * @param fileName Имя файла
     */
    FileProcessor(String fileName) {
        this.fileName = fileName;
    }

    /**
     *  Гистограмма встречаемости слов
     */
    private Map<String, Integer> histogramOfWords;

    /**
     * Список строк файла
     */
    ArrayList<String> stringsOfFile;

    /**
     * Инициализация структур данных на основе содержимого файла, имя которого содержится в поле fileName
     * @return true, Если инициализация успешно выполнена, false - если при чтении файла произошли ошибки
     */
    public boolean init() {
        histogramOfWords = new TreeMap<>(new CustomStringComparator());
        stringsOfFile = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null){
                stringsOfFile.add(line);
                String[] words = line.split("[\\s.,!?\\-+=/]");
                for(String word : words) {
                    if (histogramOfWords.containsKey(word)) {
                        histogramOfWords.put(word, histogramOfWords.get(word) + 1);
                    } else {
                        histogramOfWords.put(word, 1);
                    }
                }
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("Error: file not found.  ");
            return false;
        }
        catch(UnsupportedEncodingException ex) {
            System.out.println("Unsupported file encoding.");
            return false;
        }
        catch(IOException ex) {
            System.out.println("Exception of type IOException occurred.");
            return false;
        }
        return true;
    }

    /**
     * Подсчет количества различных слов в анализируемом файле
     * @return Количество разлчных слов
     */
    public int getDifferentWordsCount() {
        int result = 0;
        if (null == histogramOfWords) return 0;
        return histogramOfWords.keySet().size();
    }

    /**
     * Формирование отсортированного списка различных слов файла
     * @return Список различных строк файла, отсортированный в порядке, определяемым CustomStringComparator
     */
    public String getSortedWordsList() {
        Set<String> debug = histogramOfWords.keySet();
        return histogramOfWords.keySet().toString();
    }

    /**
     * Получить гистограмму слов
     * @return Возвращает тип Map<String, Integer>, содержащий информацию о слове и количестве его вхождений в текст
     */
    public Map<String, Integer> getHistogramOfWords() {
        return histogramOfWords;
    }

    public String getStringsinReverseOrder()
    {
        StringBuilder sb = new StringBuilder();
        ListIterator<String> iterator = stringsOfFile.listIterator(stringsOfFile.size());
        while (iterator.hasPrevious()) {
            sb.append(iterator.previous());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Реализация интерфейса Iterable
     * @return Итератор
     */
    @Override
    public Iterator<String> iterator() {
        return new CustomLinesIterator(this);
    }

    /**
     * Получить список строк файла согласно переданным позициям
     * @param pos Список позиций
     * @return Возвращает список строк из позиций, указанных в списке позиций
     */
    public List<String> getStringsAtPositions(List<Integer> pos) {
        List<String> result = new ArrayList<>();
        if (null == pos || null == stringsOfFile) return result;
        for(Integer val : pos) {
            if (val < 0 || val >= stringsOfFile.size())
                result.add("INVALID POSITION");
            else
                result.add(stringsOfFile.get(val));
        }
        return result;
    }

}
