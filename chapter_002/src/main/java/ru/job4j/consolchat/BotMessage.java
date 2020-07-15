package ru.job4j.consolchat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 6. Кодировка. [#289011]
 * Загружаем список фраз бота из файла.
 *
 * @since 12.07.2020
 */
public class BotMessage {
    private List<String> messages = new ArrayList<>();
    private Path fileMessage;

    /**
     * Получаем путь к файлу.
     *
     * @param fileMessage String
     */
    public BotMessage(String fileMessage) {
        this.fileMessage = Paths.get(fileMessage);
        if (!this.fileMessage.toFile().isFile()) {
            throw new IllegalArgumentException("Системе не удается найти указанный путь");
        }
        loadMessag();
    }

    /**
     * Передаем содержимое в List
     */
    private void loadMessag() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.fileMessage.toFile()))) {
            String line;
            while ((line = read.readLine()) != null) {
                this.messages.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Генерируем случайную фразу из Map
     *
     * @return String
     */
    public String getBotMessag() {
        int randomMessage = new Random().nextInt(this.messages.size());
        return "Bot: " + this.messages.get(randomMessage);
    }
}
