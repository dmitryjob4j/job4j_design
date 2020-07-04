package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 5. Валидация параметров запуска. [#289003]
 * задание выполнение через Маин
 *
 * @since 04.07.2020
 */
public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER. Or Argumetnt search is null");
        }
        Path start = Paths.get(args[0]);
        search(start, args[1]).forEach(System.out::println);
    }

    /**
     * Метод обробатывает SearchFiles
     *
     * @param root Path
     * @param ext  String
     * @return List
     * @throws IOException throws
     */
    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searchFiles = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searchFiles);
        return searchFiles.getPaths();
    }
}
