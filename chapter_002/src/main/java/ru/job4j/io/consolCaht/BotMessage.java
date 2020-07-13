package ru.job4j.io.consolCaht;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 6. Кодировка. [#289011]
 * Загружаем список фраз бота из файла.
 *
 * @since 12.07.2020
 */
public class BotMessage {
    private Map<Integer, String> messages = new HashMap<>();
    private Path fileMessage;

    /**
     * Получаем путь к файлу.
     *
     * @param fileMessage
     */
    public BotMessage(String fileMessage) {
        this.fileMessage = Paths.get(fileMessage);
        if (!this.fileMessage.toFile().isFile()) {
            throw new IllegalArgumentException("Системе не удается найти указанный путь");
        }
    }

    /**
     * Передаем содержимое в Map
     */
    public void loadMessagToMap() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.fileMessage.toFile()))) {
            String line;
            int i = 0;
            while ((line = read.readLine()) != null) {
                this.messages.put(i++, line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Генерируем случайную фразу из Map
     *
     * @return
     */
    public String message() throws InterruptedException {
        int randomMessage = new Random().nextInt(this.messages.size());
        Thread.sleep(500);
        return "Bot->" + this.messages.get(randomMessage);
    }
}
