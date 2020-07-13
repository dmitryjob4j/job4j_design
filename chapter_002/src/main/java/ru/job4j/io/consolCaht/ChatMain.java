package ru.job4j.io.consolCaht;
/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 6. Кодировка. [#289011]
 * Main запускаем консольный чат.
 *
 * @since 12.07.2020
 */
public class ChatMain {
    public static void main(String[] args) {
        String botLangFile = "./chapter_002/data/botmessage.txt";
        String saveChatFile = "./chapter_002/data/storeMessage.txt";
        ConsolChat consolChat = new ConsolChat();
        consolChat.chat(botLangFile, saveChatFile);
    }
}
