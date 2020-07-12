package ru.job4j.io.consolCaht;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;

public class ConsolChat {
    public static void main(String[] args) {
        Path fileMassage = Paths.get("./chapter_002/data/botmessage.txt");
        BotMessage botMessage = new BotMessage(fileMassage.toString());
        botMessage.loadMessagToMap();
        UserMessage userMessage = new UserMessage();
        int i = 0;
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        while (i < 10) {
            stringJoiner.add(userMessage.userMassage());
            System.out.println(botMessage.message());
            i++;
        }
    }
}
