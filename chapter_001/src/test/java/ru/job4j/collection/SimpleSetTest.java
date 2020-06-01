package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.collectoin.SimpleSet;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 4. Set
 * 1. Реализовать коллекцию Set на массиве
 * Тест.
 *
 * @author DStepanov haoos@inbox.ru
 * @version 1
 * @since 31.05.2020
 */
public class SimpleSetTest {
    private SimpleSet<String> set;

    @Before
    public void setUp() {
        set = new SimpleSet<>();
    }

    @Test
    public void testEqualsSetElement() {
        set.add("Anton");
        set.add("Stas");
        set.add("Pavel");
        assertThat(set.contains("Stas"), is(true));
        assertThat(set.contains("Dima"), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void setIteratorExeptionNoSoch() {
        Iterator<String> iterator = set.iterator();
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void setIteratorExeptionModification() {
        set.add("Petr");
        set.add("Ivan");
        Iterator<String> it = set.iterator();
        assertThat(it.next(), is("Petr"));
        set.add("Dima");
        it.next();
    }

    @Test
    public void iterTestHasNext() {
        set.add("Ivan");
        set.add("Keks");
        Iterator<String> it = set.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(false));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void testAddEqualsElement() {
        set.add("Ivan");
        set.add("Keks");
        set.add("Peks");
        set.add("Ivan");
        set.add("Ivan");
        set.add("Keks");
        set.add("Keks");
        set.add("Peks");
        set.add("Zebra");
        Iterator<String> it = set.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Ivan"));
        assertThat(it.next(), is("Keks"));
        assertThat(it.next(), is("Peks"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Zebra"));
        assertThat(it.hasNext(), is(false));
    }
}
