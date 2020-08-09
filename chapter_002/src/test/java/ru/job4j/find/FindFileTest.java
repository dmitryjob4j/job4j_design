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
 * TEST FindFiles сохранение в List найденых файлов.
 **/
public class FindFileTest {
    @Rule
    public TemporaryFolder dirFolder = new TemporaryFolder();

    @Test
    public void findTreeFiles() throws IOException {
        File file1 = dirFolder.newFile("1.aaa");
        dirFolder.newFile("2.aaa");
        dirFolder.newFile("3.aaa");
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
        dirFolder.newFile("2.aza");
        dirFolder.newFile("3.zaa");
        String derictory = file1.getParent();
        FindFiles findFiles = new FindFiles();
        List<Path> listFile = findFiles.find(path -> path.toFile().getName().endsWith(".aaa"), Paths.get(derictory));
        assertThat(listFile.size(), is(1));
        assertThat(listFile.get(0).toString(), is("1.aaa"));
    }
}
