package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collectoin.SimpleLinked;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 3. List
 * 2. Создать контейнер на базе связанного списка [#288958]
 * тесты.
 *
 * @author D.Stepanov
 * @version 1
 * @since 27.05.2020.
 */
public class SimpleLinkedTest {
    @Test
    public void addLinked() {
        SimpleLinked<String> simpleLinked = new SimpleLinked<>();
        simpleLinked.add("a");
        simpleLinked.add("b");
        simpleLinked.add("c");
        assertThat(simpleLinked.get(0), is("a"));
        assertThat(simpleLinked.get(1), is("b"));
        assertThat(simpleLinked.get(2), is("c"));
    }

    @Test
    public void addOneE() {
        SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
        simpleLinked.add(1);
        assertThat(simpleLinked.get(0), is(1));
    }

    @Test
    public void addFirstOne() {
        SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
        simpleLinked.addFirst(1);
        assertThat(simpleLinked.get(0), is(1));
    }

    @Test
    public void addFirst2to3to1to5() {
        SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
        simpleLinked.add(2);
        simpleLinked.add(3);
        simpleLinked.addFirst(1);
        assertThat(simpleLinked.get(0), is(1));
        simpleLinked.addFirst(5);
        assertThat(simpleLinked.get(0), is(5));
    }

    //итератор
    @Test(expected = NoSuchElementException.class)
    public void iterExceptionNextNoSoch() {
        SimpleLinked<String> simpleLinked = new SimpleLinked<>();
        Iterator<String> iterator = simpleLinked.iterator();
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iterModifException() {
        SimpleLinked<String> simpleLinked = new SimpleLinked<>();
        simpleLinked.add("a");
        Iterator<String> iterator = simpleLinked.iterator();
        simpleLinked.add("b");
        iterator.next();
    }

    @Test
    public void iterStep0to1() {
        SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
        simpleLinked.add(1);
        simpleLinked.add(2);
        Iterator<Integer> it = simpleLinked.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void iterStep0to1to2to3andAddFirst() {
        SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
        simpleLinked.addFirst(3);
        simpleLinked.addFirst(2);
        simpleLinked.addFirst(1);
        Iterator<Integer> iterator = simpleLinked.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
    }
}
