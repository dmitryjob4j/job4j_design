package ru.job4j.io;

import java.io.File;
import java.util.Objects;

/**
 * 2.Уровень-Джуниор.Блок.2..Ввод-вывод.1.Ввод-вывод
 * 4.0. File [#289007]
 *
 * @since 03.07.2020
 */
public class Dir {
    /**
     * Вывод только файлов и их размеров.
     * @param args String[]
     */
    public static void main(String[] args) {
        File file = new File("c:/projects/job4j_design");
        if (!file.exists()) {
            throw new IllegalArgumentException(
                    String.format("Note exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(
                    String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File subfile : file.listFiles()) {
            if (subfile.isFile()) {
                System.out.println(subfile.getAbsoluteFile().getName()
                        + " - "
                        + subfile.getAbsoluteFile().length()
                        + " byte");
            }
        }
    }
}
