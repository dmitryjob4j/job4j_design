package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collectoin.FreezeStr;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тестовые задания. Проверить две строчки на идентичность.
 * Проверить две строчки на идентичность.[#273008]
 * тесты
 *
 * @author DStepanov haoos@inbox.ru
 * @version 1
 * @since 29.06.2020.
 */
public class FreezeStrTest {
    @Test
    public void whenEq() {
        assertThat(FreezeStr.eq("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(FreezeStr.eq("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(FreezeStr.eq("heloo", "hello"), is(false));
    }
}
