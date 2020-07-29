package ru.job4j.find;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.Контрольные вопросы.
 * Поиск файлов по критерию [#289015].
 * Обрабатываем входные параметры для посика
 */
public class ArgFind {
    private final String[] args;
    private final Map<String, String> mapArgs = new HashMap<>();

    public ArgFind(String[] args) {
        this.args = args;
        load();
    }

    /**
     * Загрузка параметров поиска файлов
     * -d дериктория поиска
     * -n параметр поиска, имя файла, маска регулярное вырожение
     * -m поиск по маске, -f полнове совподение имени, -r регулярное вырожение.
     * -o файл для записи резултата
     */
    private void load() {
        if (args.length < 7) {
            System.out.println(" -d дериктория поиска\n -n параметр поиска, имя файла, маска регулярное вырожение\n"
                    + " -m поиск по маске, -f полнове совподение имени, -r регулярное вырожение.\n"
                    + " -o файл для записи резултата");
            throw new IllegalArgumentException("Parameters set incorrectly");
        }
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals("-d") || args[i].equals("-n") || args[i].equals("-o")) {
                mapArgs.put(args[i], args[i + 1]);
            }
            if (args[i].equals("-m") || args[i].equals("-f") || args[i].equals("-r")) {
                mapArgs.put(args[i], args[i]);
            }
        }
    }

    /**
     * Проверка праметров посика
     */
    public void valid() {
        if (!Files.isDirectory(Paths.get(directory()))) {
            throw new IllegalArgumentException("Parameters set -d incorrectly");
        }
        if (output().equals("") || Files.isDirectory(Paths.get(output()))) {
            throw new IllegalArgumentException("Parameters set -o incorrectly");
        }
        if (search().equals("")) {
            throw new IllegalArgumentException("Parameters set -n incorrectly");
        }
        if (!(paramSearch().equals("-m") || paramSearch().equals("-f") || paramSearch().equals("-r"))) {
            throw new IllegalArgumentException("Parameters set mask, full, regular incorrectly");
        }
        System.out.printf("-d дериктория поиска %s\n-n параметр поиска %s %s\n-m поиск по маске, -f полнове совподение имени, -r регулярное вырожение.\n-o файл для записи резултата %s\n", directory(), search(), paramSearch(), output());
    }

    /**
     * -d дериктория поиска
     *
     * @return String
     */
    public String directory() {
        return mapArgs.get("-d");
    }

    /**
     * -n имя файла
     *
     * @return String
     */
    public String search() {
        return mapArgs.get("-n");
    }

    /**
     * Параметры поиска -m поиск по маске, -f полнове совподение имени, -r регулярное вырожение.
     *
     * @return String
     */
    public String paramSearch() {
        String rsl = "-n";
        if (mapArgs.containsKey("-m")) {
            rsl = "-m";
        }
        if (mapArgs.containsKey("-f")) {
            rsl = "-f";
        }
        if (mapArgs.containsKey("-r")) {
            rsl = "-r";
        }
        return rsl;
    }

    /**
     * -o запись резултата в файл
     *
     * @return String
     */
    public String output() {
        return mapArgs.get("-o");
    }
}
