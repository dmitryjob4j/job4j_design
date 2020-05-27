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

    /**
     * Тест для отладки.
     */
    @Test
    public void pullTest() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertThat(stack.get(5), is(5));
        assertThat(stack.pop(), is(5));
        assertThat(stack.size(), is(4));
        assertThat(stack.get(4), is(4));
        assertThat(stack.pop(), is(4));
        assertThat(stack.size(), is(3));
        assertThat(stack.pop(), is(3));
        assertThat(stack.size(), is(2));
        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
        assertThat(stack.size(), is(0));
        stack.push(1);
        assertThat(stack.get(1), is(1));
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
