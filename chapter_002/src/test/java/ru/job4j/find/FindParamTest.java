package ru.job4j.find;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.Контрольные вопросы.
 * Поиск файлов по критерию [#289015].
 * TEST FindParam праметр поиска Dispatcher.
 **/
public class FindParamTest {
    @Test
    public void findParamF() {
        String searchF = "java.java";
        String searchTest = "papa.java";
        String searchTest2 = "java.java";
        String param = "-f";
        FindParam findParam = new FindParam();
        findParam.init();
        Predicate<Path> resultPredicate = findParam.access(param, searchF);
        assertTrue(resultPredicate.test(Paths.get(searchF)));
        assertFalse(resultPredicate.test(Paths.get(searchTest)));
        assertTrue(resultPredicate.test(Paths.get(searchTest2)));
    }

    @Test
    public void findParamM() {
        String searchM = "*.jav?";
        String searchTest1 = "1.java";
        String searchTest2 = "2.javp";
        String searchTest3 = "1.jara";
        String param = "-m";
        FindParam findParam = new FindParam();
        findParam.init();
        Predicate<Path> resultPredicate = findParam.access(param, searchM);
        assertTrue(resultPredicate.test(Paths.get(searchTest1)));
        assertTrue(resultPredicate.test(Paths.get(searchTest2)));
        assertFalse(resultPredicate.test(Paths.get(searchTest3)));
    }

    @Test
    public void findParamR() {
        String searchM = ".*.ja.+a";
        String searchTest1 = "1.javraa";
        String searchTest2 = "2.jappppa";
        String searchTest3 = "1.jar";
        String param = "-r";
        FindParam findParam = new FindParam();
        findParam.init();
        Predicate<Path> resultPredicate = findParam.access(param, searchM);
        assertTrue(resultPredicate.test(Paths.get(searchTest1)));
        assertTrue(resultPredicate.test(Paths.get(searchTest2)));
        assertFalse(resultPredicate.test(Paths.get(searchTest3)));
    }
}
