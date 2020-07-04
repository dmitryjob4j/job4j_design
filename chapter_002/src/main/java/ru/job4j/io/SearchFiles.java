package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 4.1. Сканирование файловой системы. [#289001]
 * задание
 *
 * @since 04.07.2020
 */
public class SearchFiles implements FileVisitor<Path> {
    private Predicate<Path> predicate;
    private List<Path> pathList = new ArrayList<>();

    public SearchFiles(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (predicate.test(file)) {
            this.pathList.add(file.toAbsolutePath());
        }
        return FileVisitResult.CONTINUE;
    }

    /**
     * Возврощает список найденых файлов.
     *
     * @return List
     */
    public List<Path> getPaths() {
        return this.pathList;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        return FileVisitResult.CONTINUE;
    }
}
