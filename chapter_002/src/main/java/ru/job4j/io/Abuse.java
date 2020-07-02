package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

/**
 * 2.Джуниор.2.Ввод-вывод.1.Ввод-вывод
 * 3.0.Тестирование IO[#289002]
 * пример
 * @since 2.07.2020
 */
public class Abuse {
    public static void drop(String source, String target, List<String> words) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            in.lines()
                    .flatMap(line -> Stream.of(line.split("\\s+")))
                    .filter(word -> !words.contains(word)).map(word -> word + " ")
                    .forEach(out::print);
        }
    }
}
