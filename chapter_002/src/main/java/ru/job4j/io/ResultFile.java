package ru.job4j.io;

import java.io.FileOutputStream;

/**
 * 2.Уровень-Джуниор.Блок 2.Ввод-вывод.1.Ввод-вывод
 * 0.1. FileOutputStream.
 *
 * @since 20.06.2020
 */
public class ResultFile {
    public static void main(String[] args) {
        int six = 6;
        int two = 2;
        int four = 4;
        int five = 5;
        int sixDivTwo = six / two;
        int fiveMinusTwo = five - two;
        int forTimeTwo = four * two;
        try (FileOutputStream out = new FileOutputStream(
                "resultFile.txt")) {
            out.write(("Hello Dima;" + System.lineSeparator()).getBytes());
            out.write(("6 / 2 = " + String.valueOf(sixDivTwo) + ";" + System.lineSeparator()).getBytes());
            out.write(("5 - 2 = " + String.valueOf(fiveMinusTwo) + ";" + System.lineSeparator()).getBytes());
            out.write(("4 * 2 = " + String.valueOf(forTimeTwo) + ";" + System.lineSeparator()).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
