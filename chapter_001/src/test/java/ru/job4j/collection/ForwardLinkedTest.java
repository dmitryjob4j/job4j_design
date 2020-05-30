package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collectoin.ForwardLinked;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 3. List
 * 6. Перевернуть связанный список [#288960]
 * тесты.
 *
 * @author D.Stepanov
 * @version 1
 * @since 27.05.2020.
 */
public class ForwardLinkedTest {

    @Test
    public void whenAddThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenAddAndRevertThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void whenDeletLinkedAndRevert() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        linked.deleteFirst();
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void deleteFirstOneElement() {
        ForwardLinked<Integer> forwardLinked = new ForwardLinked<>();
        forwardLinked.add(1);
        assertThat(forwardLinked.get(1), is(1));
        forwardLinked.deleteFirst();
        assertThat(forwardLinked.getSize(), is(0));
    }

    @Test
    public void addForwardLinked1and2() {
        ForwardLinked<Integer> forwardLinked = new ForwardLinked<>();
        forwardLinked.add(1);
        forwardLinked.add(2);
        forwardLinked.add(3);
        assertThat(forwardLinked.get(1), is(1));
        assertThat(forwardLinked.get(2), is(2));
        assertThat(forwardLinked.get(3), is(3));
    }

    @Test
    public void getAndDeleteElement() {
        ForwardLinked<Integer> forwardLinked = new ForwardLinked<>();
        forwardLinked.add(1);
        forwardLinked.add(2);
        forwardLinked.add(3);
        assertThat(forwardLinked.get(1), is(1));
        forwardLinked.deleteFirst();
        assertThat(forwardLinked.get(1), is(2));
        forwardLinked.deleteFirst();
        assertThat(forwardLinked.get(1), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFirst() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.deleteFirst();
        linked.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.deleteFirst();
    }

    @Test
    public void whenMultiDelete() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.deleteFirst();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
    }
}
