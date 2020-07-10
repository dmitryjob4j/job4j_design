package ru.job4j.io;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * 2.Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 5.1.Архивировать проект.[#289010]
 * ArgZip разбивает входящий массив по параметрам.
 *
 * @since 06.07.2020
 */
public class ArgZip {
    private final String[] args;
    private Map<String, String> mapArgs = new HashMap<>();

    /**
     * Конструктор принимает входящий массив.
     *
     * @param args String[]
     */
    public ArgZip(String[] args) {
        this.args = args;
        for (int i = 0; i < this.args.length - 1; i++) {
            switch (this.args[i]) {
                case "-d", "-o", "-e" -> {
                    this.mapArgs.put(this.args[i], this.args[i + 1]);
                    i++;
                }
            }
        }
    }

    /**
     * Проверка корректоности параметров
     *
     */
    public void valid() {
        if (Files.notExists(Paths.get(directory())) || output().equals("")) {
            throw new IllegalArgumentException("Parameters set -d incorrectly");
        }
        if (exclude().equals("")) {
            System.out.println("Parameters set -e is empty");
        }
        if (output().equals("")) {
            throw new IllegalArgumentException("Parameters set -o incorrectly");
        }
    }

    /**
     * Путь проекту.
     *
     * @return String
     */
    public String directory() {
        return this.mapArgs.get("-d");
    }

    /**
     * Файлы которые нужно исключить.
     *
     * @return String
     */
    public String exclude() {
        return this.mapArgs.get("-e");
    }

    /**
     * Имя архива.
     *
     * @return String.
     */
    public String output() {
        return this.mapArgs.get("-o");
    }
}
