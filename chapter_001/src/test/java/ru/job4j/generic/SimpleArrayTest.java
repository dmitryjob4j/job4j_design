package ru.job4j.generic;

import org.junit.Test;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *  2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 2. Generic.
 *  5.2.1. Реализовать SimpleArray<T> [#288973]
 *  Тесты.
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
        simpleArray.set(4, 5);
        assertThat(simpleArray.get(4), is(5));
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

    //тест на вывод catch
    @Test
    public void testCatchIndexOutOfBoundsException() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        simpleArray.get(5);
        assertThat(mem.toString(), is(String.format("Значение не найдено%n")));

        System.setOut(out);
    }

    //итератор
    @Test(expected = NoSuchElementException.class)
    public void iterExeption() {
        SimpleArray<Integer> array = new SimpleArray<>(1);
        array.next();
        array.next();
    }

    @Test
    public void nextValueAndHasNext() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        assertThat(simpleArray.hasNext(), is(true));
        assertThat(simpleArray.hasNext(), is(true));
        assertThat(simpleArray.next(), is(1));
        assertThat(simpleArray.next(), is(2));
        assertThat(simpleArray.next(), is(3));
        simpleArray.next();
        simpleArray.next();
        assertThat(simpleArray.hasNext(), is(false));
    }
}