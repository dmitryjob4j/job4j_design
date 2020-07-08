package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 2.Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 5.1.Архивировать проект.[#289010]
 * ArgZip разбивает входящий массив по параметрам.
 *
 * @since 06.07.2020
 */
public class Zip {
    private String derictore;
    private String exclude;
    private String output;
    private List<Path> sources;

    public Zip() {
    }

    public Zip(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        argZip.valid();
        this.derictore = argZip.directory();
        this.exclude = argZip.exclude();
        this.output = argZip.output();
        SearchFiles searchFiles = new SearchFiles(p -> !p.toFile().getName().endsWith(this.exclude));
        Files.walkFileTree(Paths.get(this.derictore), searchFiles);
        this.sources = searchFiles.getPaths();
    }

    public void packFiles(List<Path> sources, Path target) {

    }

    public void packSingleFile(Path source, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toFile())))) {
            zip.putNextEntry(new ZipEntry(source.toAbsolutePath().getFileName().toString()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Path source = Paths.get("C:/arhiv/1/out.txt");
        Path target = Paths.get("C:/arhiv/out.zip");
        Zip zip = new Zip();
        zip.packSingleFile(source, target);
    }
}
