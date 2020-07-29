package ru.job4j.find;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.Контрольные вопросы.
 * Поиск файлов по критерию [#289015].
 * TEST FindFiles параметры поиска файла и сохранение в List
 **/
public class FindFileTest {
    @Rule
    public TemporaryFolder dirFolder = new TemporaryFolder();

    @Test
    public void findTreeFiles() throws IOException {
        File file1 = dirFolder.newFile("1.aaa");
        File file2 = dirFolder.newFile("2.aaa");
        File file3 = dirFolder.newFile("3.aaa");
        String derictory = file1.getParent();
        FindFiles findFiles = new FindFiles();
        List<Path> listFile = findFiles.find(path -> path.toFile().getName().endsWith(".aaa"), Paths.get(derictory));
        assertThat(listFile.size(), is(3));
        assertTrue(listFile.contains(Paths.get("1.aaa")));
        assertTrue(listFile.contains(Paths.get("2.aaa")));
        assertTrue(listFile.contains(Paths.get("3.aaa")));
    }

    @Test
    public void findOneFiles() throws IOException {
        File file1 = dirFolder.newFile("1.aaa");
        File file2 = dirFolder.newFile("2.aza");
        File file3 = dirFolder.newFile("3.zaa");
        String derictory = file1.getParent();
        FindFiles findFiles = new FindFiles();
        List<Path> listFile = findFiles.find(path -> path.toFile().getName().endsWith(".aaa"), Paths.get(derictory));
        assertThat(listFile.size(), is(1));
        assertThat(listFile.get(0).toString(), is("1.aaa"));
    }

    @Test
    public void findParamF() {
        String searchF = "java.java";
        String searchTest = "papa.java";
        String searchTest2 = "java.java";
        String param = "-f";
        FindFiles findFiles = new FindFiles();
        Predicate<Path> resultPredicate = findFiles.findParam(searchF, param);
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
        FindFiles findFiles = new FindFiles();
        Predicate<Path> resultPredicate = findFiles.findParam(searchM, param);
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
        FindFiles findFiles = new FindFiles();
        Predicate<Path> resultPredicate = findFiles.findParam(searchM, param);
        assertTrue(resultPredicate.test(Paths.get(searchTest1)));
        assertTrue(resultPredicate.test(Paths.get(searchTest2)));
        assertFalse(resultPredicate.test(Paths.get(searchTest3)));
    }
}
