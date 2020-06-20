package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * 2.Уровень-Джуниор.Блок 2.Ввод-вывод.1.Ввод-вывод
 * 0.1. FileOutputStream.
 * 0.2. FileInputStream [#289012].
 * пример.
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
            out.write(("6 / 2 = " + sixDivTwo + ";" + System.lineSeparator()).getBytes());
            out.write(("5 - 2 = " + fiveMinusTwo + ";" + System.lineSeparator()).getBytes());
            out.write(("4 * 2 = " + forTimeTwo + ";" + System.lineSeparator()).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Date date = new Date();
        try (FileInputStream in = new FileInputStream("input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            System.out.println(text);
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Date date1 = new Date();
        System.out.println(date1.getTime() - date.getTime());
    }
}
