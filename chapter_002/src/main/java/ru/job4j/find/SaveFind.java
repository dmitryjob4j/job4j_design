package ru.job4j.find;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.Контрольные вопросы.
 * Поиск файлов по критерию [#289015].
 * Сохраняем результат поиска в файл
 */
public class SaveFind {
    /**
     * метод сохранениея коллекции в файл.
     *
     * @param file      String
     * @param listFiles List
     */
    public void save(String file, List<Path> listFiles) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            listFiles.forEach(f -> out.println(f.getFileName().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
