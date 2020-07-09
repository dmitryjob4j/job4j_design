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
        SearchFiles searchFiles = new SearchFiles(p -> !p.toFile().getName().endsWith(argZip.exclude()) && !p.toFile().getName().endsWith("zip"));
        Files.walkFileTree(Paths.get(argZip.directory()), searchFiles);
        List<Path> searches = searchFiles.getPaths();
        zip.packFiles(searches, Paths.get(argZip.output()), argZip.directory());
    }
}
