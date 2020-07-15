package ru.job4j.io.consolchat;

import org.junit.Test;
import ru.job4j.consolchat.UserMessage;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.*;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 6. Кодировка. [#289011]
 * Тест UserMessage.
 *
 * @since 12.07.2020
 */
public class UserMessageTest {
    @Test
    public void testUserMessag() {
        UserMessage userMessage = new UserMessage();
        String message = "Привет";
        String result = userMessage.userWord(message);
        String expected = "User: Привет";
        assertThat(result, is(expected));
    }

    @Test
    public void userMessagNameSet() {
        UserMessage userMessage = new UserMessage("Danil");
        String result = userMessage.userWord("Пока");
        String expcted = "Danil: Пока";
        assertThat(result, is(expcted));
    }
}
