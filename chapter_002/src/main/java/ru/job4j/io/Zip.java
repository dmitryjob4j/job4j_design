package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 2.Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 5.1.Архивировать проект.[#289010]
 * ArgZip разбивает входящий массив по параметрам.
 *
 * @since 06.07.2020
 */
public class Zip {
    /**
     * Упаковка списка файлов с сохронением подпапок
     *
     * @param sources   List
     * @param target    Path
     * @param derictory String
     */
    public void packFiles(List<Path> sources, Path target, String derictory) {
        int rootSize = derictory.length() + 1;
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toFile())))) {
            for (Path file : sources) {
                zip.putNextEntry(new ZipEntry(file.toAbsolutePath().toString().substring(rootSize)));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file.toFile()))) {
                    zip.write(out.readAllBytes());
                    System.out.println(file.toAbsolutePath().toString().substring(rootSize) + " +++add to ZIP+++ " + target.getFileName().toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
