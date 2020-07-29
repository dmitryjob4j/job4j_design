package ru.job4j.find;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.Контрольные вопросы.
 * Поиск файлов по критерию [#289015].
 * Реализация интерфейса FileVisitor.
 */
public class SearchFind implements FileVisitor<Path> {
    private List<Path> listFiles = new ArrayList<>();
    private Predicate<Path> fileParam;

    /**
     * Конструктор принимает параметры поиска
     *
     * @param fileParam Predicate
     */
    public SearchFind(Predicate<Path> fileParam) {
        this.fileParam = fileParam;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (fileParam.test(file)) {
            System.out.println(file.getFileName().toString());
            listFiles.add(file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }

    /**
     * Возвращает List с результатом поиска списком Path
     *
     * @return List
     */
    public List<Path> listSearch() {
        return this.listFiles;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        return FileVisitResult.SKIP_SUBTREE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        return FileVisitResult.CONTINUE;
    }
}
