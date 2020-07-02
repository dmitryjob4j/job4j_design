package ru.job4j.io;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.List;
/**
 * 2.Джуниор.2.Ввод-вывод.1.Ввод-вывод
 * 3.0.Тестирование IO[#289002]
 * пример теста.
 * @since 2.07.2020
 */
public class AbuseTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void drop() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("hello foolish dude ");
        }
        Abuse.drop(source.getAbsolutePath(), target.getAbsolutePath(), List.of("foolish"));
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("hello dude "));
    }
}
