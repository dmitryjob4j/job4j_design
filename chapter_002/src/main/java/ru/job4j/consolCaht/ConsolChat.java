package ru.job4j.consolCaht;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 6. Кодировка. [#289011]
 * Консольный чат.
 *
 * @since 12.07.2020
 */
public class ConsolChat {

    /**
     * Метод запускает собирает консольный чат
     *
     * @param botLangFile String
     * @param saveChatFile String
     */
    public void chat(String botLangFile, String saveChatFile) {
        BotMessage botMessage = new BotMessage(botLangFile);
        SaveDialog saveDialog = new SaveDialog(saveChatFile);
        UserMessage userMessage = new UserMessage();
        String startStopBot = "User: продолжить";
        while (!startStopBot.equals("User: закончить")) {
            String user = userMessage.userWord();
            saveDialog.saveMessageToMap(user);
            if (user.equals("User: стоп")) {
                startStopBot = user;
            }
            if (user.equals("User: продолжить")) {
                startStopBot = user;
            }
            if (user.equals("User: закончить")) {
                startStopBot = user;
            }
            if (startStopBot.equals("User: продолжить")) {
                String bot = botMessage.botWord();
                System.out.println(bot);
                saveDialog.saveMessageToMap(bot);
            }
        }
        saveDialog.saveToFile();
    }
}