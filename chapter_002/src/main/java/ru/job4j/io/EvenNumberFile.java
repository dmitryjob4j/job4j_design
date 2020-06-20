package ru.job4j.io;

import java.io.FileInputStream;

/**
 * 2.Уровень-Джуниор.Блок 2.Ввод-вывод.1.Ввод-вывод
 * 0.2. FileInputStream [#289012].
 * задание.
 *
 * @since 20.06.2020
 */
public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                if (((Integer.valueOf(line)) % 2) == 0) {
                    System.out.println(line + " четное число");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
