package ru.job4j.consolchat;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 6. Кодировка. [#289011]
 * Консольный чат.
 *
 * @since 12.07.2020
 */
public class ConsolChat {

    /**
     * @param startChat   String
     * @param pauseChat   String
     * @param stopChats   String
     * @param botMessage  BotMessage
     * @param saveDialog  SaveDialog
     * @param userMessage UserDialog
     */
    public void chat(String startChat, String pauseChat, String stopChats, BotMessage botMessage, SaveDialog saveDialog, UserMessage userMessage) {
        String startBot = userMessage.getName() + ": " + startChat;
        String pauseBot = userMessage.getName() + ": " + pauseChat;
        String stopChat = userMessage.getName() + ": " + stopChats;
        String startStopExit = startBot;
        while (!startStopExit.equals(stopChat)) {
            String user = userMessage.userWord();
            saveDialog.saveMessage(user);
            if (user.equals(pauseBot)) {
                startStopExit = user;
            }
            if (user.equals(startBot)) {
                startStopExit = user;
            }
            if (user.equals(stopChat)) {
                startStopExit = user;
            }
            if (startStopExit.equals(startBot)) {
                String bot = botMessage.getBotMessag();
                System.out.println(bot);
                saveDialog.saveMessage(bot);
            }
        }
        saveDialog.saveToFile();
    }
}