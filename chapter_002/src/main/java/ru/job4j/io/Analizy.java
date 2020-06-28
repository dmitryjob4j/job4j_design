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
            reader.lines()
                    .filter(l -> !l.isEmpty())
                    .map(l -> l.split(" "))
                    .forEach(l -> mapTarget.put(l[1], l[0]));
            StringBuilder tergetData = null;
            for (String data : mapTarget.keySet()) {
                String err = mapTarget.get(data);
                if (tergetData == null && (err.equals("400") || err.equals("500"))) {
                    tergetData = new StringBuilder(data + ";");
                }
                if (tergetData != null && (err.equals("200") || err.equals("300"))) {
                    tergetData.append(data).append(";");
                    out.println(tergetData);
                    tergetData = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
