package ru.job4j.find;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.Контрольные вопросы.
 * Поиск файлов по критерию [#289015].
 * TEST SaveFind Сохраняем результат поиска в файл
 **/
public class SaveFindTest {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void saveListTooFiles() throws IOException {
        File file = temporaryFolder.newFile("file");
        List<Path> listPath = new ArrayList<>();
        Path path = Paths.get("app.java");
        listPath.add(path);
        SaveFind saveFind = new SaveFind();
        saveFind.save(file.toString(), listPath);
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("app.java"));
    }
}
