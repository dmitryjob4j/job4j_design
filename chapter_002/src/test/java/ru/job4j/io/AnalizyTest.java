package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 2.Джуниор.2.Ввод-вывод.1.Ввод-вывод
 * 2.Анализ доступности сервера.[#289009]
 *
 * @since 28.06.2020
 */
public class AnalizyTest {
    private String target;
    private String source;
    private Analizy analizy;

    @Before
    public void setUp() {
        source = "./data/server.cvs";
        target = "./data/unavailable.cvs";
        analizy = new Analizy();
    }

    @Test
    public void analizeServerLog() {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(source))) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        analizy.unavailable(source, target);
        StringJoiner result = new StringJoiner("");
        String expecetd = "10:58:01;10:59:01;11:01:02;11:02:02;12:57:01;12:59:01;13:01:02;16:59:01;";
        try (BufferedReader readerRes = new BufferedReader(new FileReader(target))) {
            readerRes.lines().forEach(result::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(result.toString(), is(expecetd));
    }
}
