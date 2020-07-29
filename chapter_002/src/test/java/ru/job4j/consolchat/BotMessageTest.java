package ru.job4j.consolchat;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 6. Кодировка. [#289011]
 * Тест BotMessage.
 *
 * @since 12.07.2020
 */
public class BotMessageTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void loadBotMessageToList() throws IOException {
        File message = folder.newFile("message");
        try (PrintWriter out = new PrintWriter(message)) {
            out.println("Пока");
        }
        BotMessage botMessage = new BotMessage(message.toString());
        String result = botMessage.getBotMessag();
        assertThat(result, is("Bot: Пока"));
    }
}
