package ru.job4j.generic;

import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 2. Generic.
 * 5.2.1. Реализовать SimpleArray<T> [#288973]
 * Тесты.
 * @version 3
 */
public class SimpleArrayTest {
    private SimpleArray<Integer> simpleArray;

    @Before
    public void setUp() {
        simpleArray = new SimpleArray<>(5);
    }

    @Test
    public void trueNewSimleArray() {
        assertNull(simpleArray.get(1));
        assertNull(simpleArray.get(4));
    }

    @Test
    public void addSimpleArrayIndex0() {
        simpleArray.add(1);
        assertThat(simpleArray.get(0), is(1));
    }

    @Test
    public void addAndGetSimpleArrayIndexMax() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(2));
        assertThat(simpleArray.get(2), is(3));
        assertThat(simpleArray.get(3), is(4));
        assertThat(simpleArray.get(4), is(5));
    }

    @Test
    public void setSemplePosition4set5() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        simpleArray.set(4, 7);
        assertThat(simpleArray.get(4), is(7));
    }

    @Test
    public void removeThenIndex3() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        simpleArray.remove(3);
        assertNull(simpleArray.get(4));
        assertThat(simpleArray.get(3), is(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void exceptionIndexOutOf() {
        simpleArray.set(1, 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void exceptionGetIndex() {
        simpleArray.get(5);
        assertNull(simpleArray.get(4));
    }

    //итератор
    @Test(expected = NoSuchElementException.class)
    public void iterExeption() {
        SimpleArray<Integer> array = new SimpleArray<>(1);
        Iterator<Integer> it = array.iterator();
        it.next();
        it.next();
    }

    @Test
    public void nextValueAndHasNext() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertNull(it.next());
    }
}