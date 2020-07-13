package ru.job4j.io.consolCaht;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;

public class ConsolChat {
    public static void main(String[] args) throws InterruptedException {
        Path fileMassage = Paths.get("./chapter_002/data/botmessage.txt");
        BotMessage botMessage = new BotMessage(fileMassage.toString());
        botMessage.loadMessagToMap();
        SaveDialog saveDialog = new SaveDialog("./chapter_002/data/storeMessage.txt");
        UserMessage userMessage = new UserMessage();
        int i = 0;
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        while (i < 10) {
            String userMasseg = userMessage.userMassage();
            stringJoiner.add(userMasseg);
            saveDialog.saveMessageToMap(userMasseg);
            String botMessag = botMessage.message();
            stringJoiner.add(botMessag);
            System.out.println(botMessag);
            saveDialog.saveMessageToMap(botMessag);
            i++;
        }
        saveDialog.saveToFile();
    }
}