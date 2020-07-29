package ru.job4j.find;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.Контрольные вопросы.
 * Поиск файлов по критерию [#289015].
 * Исполняемый main
 *
 * @author DStepanov haoos@inbox.ru
 */
public class Find {
    /**
     * Основой main
     *
     * @param args String[]
     * @throws IOException IO
     */
    public static void main(String[] args) throws IOException {
        FindFiles findFiles = new FindFiles();
        ArgFind argFind = new ArgFind(args);
        SaveFind saveFind = new SaveFind();
        argFind.valid();
        String derictory = argFind.directory();
        String output = argFind.output();
        String search = argFind.search();
        String paramSearch = argFind.paramSearch();
        Predicate<Path> pathPredicate = findFiles.findParam(search, paramSearch);
        List<Path> list = findFiles.find(pathPredicate, Paths.get(derictory));
        saveFind.save(output, list);
    }
}
