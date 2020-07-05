package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 2.Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 5.1.Архивировать проект.[#289010]
 * MainZip тестирование архивации.
 *
 * @since 06.07.2020
 */
public class MainZip {
    /**
     * Тестовая архивация.
     *
     * @param args String[]
     * @throws IOException Exception
     */
    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        argZip.valid();
        Zip zip = new Zip();
        List<Path> searchFiles = zip.searchFiles(argZip.directory(), argZip.exclude());
        zip.packFiles(searchFiles, Paths.get(argZip.output()), argZip.directory());
    }
}
