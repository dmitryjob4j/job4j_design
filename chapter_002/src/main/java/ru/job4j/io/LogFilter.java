package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 0.4.BufferedOutputStream [#289006]
 *
 * @author DStepanov haoos@inbox.ru.
 * @since 22.06.2020.
 */
public class LogFilter {
    /**
     * Метод филтрует файл
     *
     * @param file name file.
     * @return fileFilter
     */
    public static List<String> filter(String file) {
        List<String> fileFilter = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().filter(i -> i.contains("404")).forEach(fileFilter::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileFilter;
    }

    /**
     * Метод сохраняет результат сортировки в файл.
     *
     * @param log  List
     * @param file File.txt
     */
    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            log.forEach(l -> out.write(l + System.lineSeparator()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Main
     *
     * @param args main
     */
    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        for (String l : log) {
            System.out.println(l);
        }
        save(log, "404.txt");
    }
}
