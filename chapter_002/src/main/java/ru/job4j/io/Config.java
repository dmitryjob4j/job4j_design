package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * 2. Уровень - Джуниор.Блок 2. Ввод-вывод.1. Ввод-вывод.1. Читаем файл конфигурации
 * 1. Читаем файл конфигурации [#289008]
 *
 * @author DStepanov haoos@inbox.ru
 * @since 25.06.2020.
 */
public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    /**
     * Считывает все ключи в карту values.
     * Пустые строки и коментарии пропускаяет.
     */
    @SuppressWarnings("checkstyle:LeftCurly")
    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines()
                    .filter(r -> !r.contains("#") && r.contains("="))
                    .map(r -> r.split("="))
                    .forEach(r -> this.values.put(r[0], r.length < 2 ? null : r[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Возврощает значение ключа.
     *
     * @param key
     * @return
     */
    public String value(String key) {
        if (!this.values.containsKey(key)) {
            throw new UnsupportedOperationException("Don't impl this method yet!");
        }
        return this.values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner((System.lineSeparator()));
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("C:\\projects\\job4j_design\\chapter_002\\data\\app.properties"));
    }
}
