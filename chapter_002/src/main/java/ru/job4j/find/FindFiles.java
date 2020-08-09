package ru.job4j.find;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.Контрольные вопросы.
 * Поиск файлов по критерию [#289015].
 * Получаем список файлов.
 */
public class FindFiles {
    /**
     * Метод собирает список фалов в List
     *
     * @param filesMasc Predicate
     * @param directory Path
     * @return List
     * @throws IOException Exception
     */
    public List<Path> find(Predicate<Path> filesMasc, Path directory) throws IOException {
        System.out.println("Search result:" + System.lineSeparator() + "* * * * *");
        SearchFind searchFind = new SearchFind(filesMasc);
        Files.walkFileTree(directory, searchFind);
        System.out.println("* * * * *");
        return searchFind.listSearch();
    }
}
