package ru.job4j.io;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 2.Джуниор.2.Ввод-вывод.1.Ввод-вывод
 * 3.0.Тестирование IO[#289002]
 *
 * @since 2.07.2020
 */
public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void analizeServerLog() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("200 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
            out.println("200 12:56:01");
            out.println("500 12:57:01");
            out.println("400 12:58:01");
            out.println("200 12:59:01");
            out.println("500 13:01:02");
            out.println("500 13:02:02");
            out.println("400 14:59:01");
            out.println("500 15:59:01");
            out.println("300 16:59:01");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder result = new StringBuilder();
        try (BufferedReader readerRes = new BufferedReader(new FileReader(target))) {
            readerRes.lines().forEach(result::append);
        }
        assertThat(result.toString(), is("10:58:01;10:59:01;11:01:02;11:02:02;12:57:01;12:59:01;13:01:02;16:59:01;"));
    }
}
