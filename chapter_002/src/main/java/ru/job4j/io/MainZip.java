package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 2.Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 5.1.Архивировать проект.[#289010]
 * MainZip тестирование архивации.
 *
 * @since 06.07.2020
 */
public class MainZip {
    public static void main(String[] args) {
        ArgZip argZip = new ArgZip(args);
        System.out.println(argZip.directory() + " " + argZip.exclude() + " " + argZip.output());
        Path out = Paths.get("C:/arhiv/out.txt");
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("C:/arhiv/out.zip"));
             FileInputStream fis = new FileInputStream(out.toString());) {
            ZipEntry entry1 = new ZipEntry("out.txt");
            zout.putNextEntry(entry1);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
