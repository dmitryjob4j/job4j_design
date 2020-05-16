package ru.job4j.it;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * 2. Уровень - Джуниор.
 * Блок 1. Структуры данных и алгоритмы.
 * 1. Что такое итератор. [#288966].
 * Тысты - пример.
 *
 * @since 16.05.2020.
 */
public class ArrayItTest {
    @Test
    public void whenMultiCallhasNextThenTrue() {
        ArrayIt it = new ArrayIt(new int[]{1, 2, 3});
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenReadSequence() {
        ArrayIt it = new ArrayIt(
                new int[]{1, 2, 3}
        );
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        ArrayIt it = new ArrayIt(
                new int[]{}
        );
        it.next();
    }
}
