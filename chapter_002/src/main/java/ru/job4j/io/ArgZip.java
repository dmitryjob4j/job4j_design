package ru.job4j.io;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;

/**
 * 2.Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 5.1.Архивировать проект.[#289010]
 * ArgZip разбивает входящий массив по параметрам.
 *
 * @since 06.07.2020
 */
public class ArgZip {
    private final String[] args;

    /**
     * Конструктор принимает входящий массив.
     *
     * @param args String[]
     */
    public ArgZip(String[] args) {
        this.args = args;
    }

    /**
     * Проверка корректоности параметров
     *
     * @return boolean
     */
    public boolean valid() {
        if (Files.notExists(Paths.get(directory())) || output().equals("")) {
            throw new IllegalArgumentException("Parameters set -d incorrectly");
        }
        if (exclude().equals("")) {
            System.out.println("Parameters set -e is empty");
        }
        if (output().equals("")) {
            throw new IllegalArgumentException("Parameters set -o incorrectly");
        }
        return true;
    }

    /**
     * Путь проекту.
     *
     * @return String
     */
    public String directory() {
        return serchArgs(p -> p.equals("-d"), args);
    }

    /**
     * Файлы которые нужно исключить.
     *
     * @return String
     */
    public String exclude() {
        return serchArgs(p -> p.equals("-e"), args);
    }

    /**
     * Имя архива.
     *
     * @return String.
     */
    public String output() {
        return serchArgs(p -> p.equals("-o"), args);
    }

    /**
     * параметра в массиве args
     *
     * @param param      Predicat
     * @param arrayParam args
     * @return String
     */
    private String serchArgs(Predicate<String> param, String[] arrayParam) {
        for (int i = 0; i < arrayParam.length; i++) {
            if (param.test(arrayParam[i])) {
                return arrayParam[i + 1];
            }
        }
        return "";
    }
}
