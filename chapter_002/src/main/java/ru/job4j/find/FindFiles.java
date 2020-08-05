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
 * Обработка параметров поиска и списка фалов
 */
public class FindFiles {
    /**
     * Метод собирает список фалов в List
     *
     * @param filesMasc Predicate
     * @param directory Path
     * @return List
     * @throws IOException IOExeption
     */
    public List<Path> find(Predicate<Path> filesMasc, Path directory) throws IOException {
        System.out.println("Search result:" + System.lineSeparator() + "* * * * *");
        SearchFind searchFind = new SearchFind(filesMasc);
        Files.walkFileTree(directory, searchFind);
        System.out.println("* * * * *");
        return searchFind.listSearch();
    }

    /**
     * Метод определяет расширенные параметры поиска
     *
     * @param search      String
     * @param paramSearch String
     * @return Predicate
     */
    public Predicate<Path> findParam(String search, String paramSearch) {
        Predicate<Path> result;
        switch (paramSearch) {
            case "-m" -> {
                String mask = search.replace("*", ".*").replace("?", ".?");
                result = path -> {
                    Pattern pat = Pattern.compile(mask);
                    Matcher mat = pat.matcher(path.getFileName().toString());
                    return mat.matches();
                };
            }
            case "-r" -> result = path -> {
                Pattern pat = Pattern.compile(search);
                Matcher mat = pat.matcher(path.getFileName().toString());
                return mat.find();
            };
            default -> result = path -> path.getFileName().toString().equals(search);
        }
        return result;
    }
}
