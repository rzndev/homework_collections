package ru.sbt.rzn.barantsev.dao;

import ru.sbt.rzn.barantsev.entity.TextEntity;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

/**
 * Загрузчик текста
 */
public class TextLoader {
    public static void init(Collection<TextEntity> c, String fileName) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                c.add(new TextEntity(line));
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("Error: file not found.  ");
        }
        catch(UnsupportedEncodingException ex) {
            System.out.println("Unsupported file encoding.");
        }
        catch(IOException ex) {
            System.out.println("Exception of type IOException occurred.");
        }
    }
}
