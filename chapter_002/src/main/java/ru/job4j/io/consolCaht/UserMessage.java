package ru.job4j.io.consolCaht;

import java.util.Scanner;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 6. Кодировка. [#289011]
 * Получаем сообщение из консоли.
 *
 * @since 12.07.2020
 */
public class UserMessage {
    private String name = "User";

    public UserMessage();

    /**
     * Конструктор с установкой имени пользователя.
     *
     * @param name
     */
    public UserMessage(String name) {
        this.name = name;
    }

    /**
     * Scaner сообщений пользователя
     *
     * @return String
     */
    public String userMassage() {
        Scanner input = new Scanner(System.in);
        System.out.print(this.name + "->");
        return this.name + ": " + input.nextLine();
    }
}
