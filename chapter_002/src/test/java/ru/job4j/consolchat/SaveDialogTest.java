package ru.job4j.consolchat;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.1.Ввод-вывод
 * 6. Кодировка. [#289011]
 * Тест SaveDialog.
 *
 * @since 12.07.2020
 */
public class SaveDialogTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void savemassegToList() throws IOException {
        File message = folder.newFile("stor");
        SaveDialog saveDialog = new SaveDialog(message.toString());
        saveDialog.saveMessage("Привет");
        String result = saveDialog.getMessage(0);
        assertTrue(result.contains("Привет"));
    }

    @Test
    public void saveMessagToFile() throws IOException {
        File message = folder.newFile("stor");
        SaveDialog saveDialog = new SaveDialog(message.toString());
        saveDialog.saveMessage("Привет");
        saveDialog.saveToFile();
        String expect = saveDialog.getMessage(0);
        String result;
        try (BufferedReader in = new BufferedReader(new FileReader(message))) {
            result = in.readLine();
        }
        assertThat(result, is(expect));
    }
}
