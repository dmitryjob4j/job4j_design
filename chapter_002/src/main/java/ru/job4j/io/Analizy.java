package ru.job4j.io;

import java.io.*;
import java.util.*;

/**
 * 2.Джуниор.2.Ввод-вывод.1.Ввод-вывод
 * 2.Анализ доступности сервера.[#289009]
 *
 * @since 28.06.2020
 */
public class Analizy {
    public void unavailable(String source, String target) {
        Map<String, String> mapTarget = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            StringBuilder targetData = new StringBuilder();
            while (reader.ready()) {
                String[] lines = reader.readLine().split(" ");
                if (targetData.length() == 0 && (lines[0].equals("400") || lines[0].equals("500"))) {
                    targetData.append(lines[1]).append(";");
                }
                if (targetData.length() != 0 && (lines[0].equals("200") || lines[0].equals("300"))) {
                    targetData.append(lines[1]).append(";");
                    out.println(targetData);
                    targetData = new StringBuilder();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
