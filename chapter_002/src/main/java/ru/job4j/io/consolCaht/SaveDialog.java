package ru.job4j.io.consolCaht;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 6. Кодировка. [#289011]
 * Сохроняем диалог в файл. формат \дата ыремя\Usermessag\BotMessag.
 *
 * @since 12.07.2020
 */
public class SaveDialog {
    private Map<Integer, String> dialogue = new HashMap<>();
    private int numMessag = 0;
    private Path fileStore;

    /**
     * Конструктор с файлом куда сохронять.
     *
     * @param file
     */
    public SaveDialog(String file) {
        this.fileStore = Paths.get(file);
    }

    /**
     * Сохраняет диалог в мап с добовлением текущей даты.
     *
     * @param message
     */
    public void saveMessageToMap(String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d:M:YYYY;HH:MM:s");
        Calendar calendar = new GregorianCalendar();
        String timeMessag = dateFormat.format(calendar.getTime()) + " " + message;
        dialogue.put(this.numMessag++, timeMessag);
    }

    /**
     * Сохраняет беседу в файл.
     */
    public void saveToFile() {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(this.fileStore.toFile())))) {
            this.dialogue.keySet().forEach(k -> out.print(dialogue.get(k) + System.lineSeparator()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
