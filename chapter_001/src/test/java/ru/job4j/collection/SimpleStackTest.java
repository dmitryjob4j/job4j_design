package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collectoin.SimpleStack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 3. List
 * 4. Используя контейнер на базе связанного списка создать контейнер Stack [#288956]
 * тесты.
 *
 * @author D.Stepanov
 * @version 1
 * @since 27.05.2020.
 */
public class SimpleStackTest {
    @Test
    public void whenPushThenPoll() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void whenPushPollThenPushPoll() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.pop();
        stack.push(2);
        assertThat(stack.pop(), is(2));
    }

    @Test
    public void whenPushPushThenPollPoll() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.pop();
        assertThat(stack.pop(), is(1));
    }
}
