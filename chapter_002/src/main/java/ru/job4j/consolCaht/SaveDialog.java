package ru.job4j.consolCaht;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 6. Кодировка. [#289011]
 * Сохроняем диалог в файл. формат \дата ыремя\Usermessag\BotMessag.
 *
 * @since 12.07.2020
 */
public class SaveDialog {
    private List<String> dialogue = new ArrayList<>();
    private int numMessag = 0;
    private Path fileStore;

    /**
     * Конструктор с файлом куда сохронять.
     *
     * @param file String
     */
    public SaveDialog(String file) {
        this.fileStore = Paths.get(file);
    }

    /**
     * Сохраняет диалог в мап с добовлением текущей даты.
     *
     * @param message String
     */
    public void saveMessageToMap(String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d:M:yyyy;HH:mm:ss");
        Calendar calendar = new GregorianCalendar();
        String timeMessag = dateFormat.format(calendar.getTime()) + " " + message;
        dialogue.add(timeMessag);
    }

    /**
     * Сохраняет беседу в файл.
     */
    public void saveToFile() {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(this.fileStore.toFile())))) {
            this.dialogue.forEach(d -> out.print(d + System.lineSeparator()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
