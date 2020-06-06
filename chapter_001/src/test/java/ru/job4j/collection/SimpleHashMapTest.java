package ru.job4j.collection;

import org.junit.Test;
import org.junit.Before;
import ru.job4j.collectoin.SimpleHashMap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

/**
 * 2. Уровень - Джуниор. Блок 1. Структуры данных и алгоритмы. 5. Map.
 * 8. Реализовать собственную структуру данных - HashMap.
 */
public class SimpleHashMapTest {
    private SimpleHashMap<String, Integer> simpleHashMap;

    @Before
    public void setUp() {
        simpleHashMap = new SimpleHashMap<>();
    }

    @Test
    public void addNewElementToHasMapAndGet() {
        boolean result;
        result = simpleHashMap.insert("one", 1);
        assertTrue(result);
        result = simpleHashMap.insert("two", 2);
        assertTrue(result);
        result = simpleHashMap.insert("thre", 3);
        assertTrue(result);
        assertThat(simpleHashMap.get("one"), is(1));
        assertThat(simpleHashMap.get("two"), is(2));
        assertThat(simpleHashMap.get("thre"), is(3));
    }

    @Test
    public void hashDeletElementTrueAndeFalse() {
        simpleHashMap.insert("one", 1);
        simpleHashMap.insert("two", 2);
        simpleHashMap.insert("thre", 3);
        assertTrue(simpleHashMap.delete("one"));
        assertTrue(simpleHashMap.delete("two"));
        assertTrue(simpleHashMap.delete("thre"));
        assertFalse(simpleHashMap.delete("one"));
        assertFalse(simpleHashMap.delete("two"));
        assertFalse(simpleHashMap.delete("thre"));
    }

    @Test
    public void setKeyOneToOne() {
        simpleHashMap.insert("one", 1);
        assertThat(simpleHashMap.get("one"), is(1));
        simpleHashMap.insert("one", 2);
        assertThat(simpleHashMap.get("one"), is(2));
        simpleHashMap.insert("one", 3);
        assertThat(simpleHashMap.get("one"), is(3));
    }

    @Test
    public void sizeTableDefaultAndSizeTableSet() {
        SimpleHashMap<String, Integer> simpleHashMapSizeTable = new SimpleHashMap<>();
        int result = simpleHashMapSizeTable.lengthHashMap();
        assertThat(result, is(16));
        simpleHashMapSizeTable = new SimpleHashMap<>(3);
        result = simpleHashMapSizeTable.lengthHashMap();
        assertThat(result, is(3));
    }

    @Test
    public void dinamicSizeTable() {
        SimpleHashMap<Integer, Integer> dinamicSizeHashMap = new SimpleHashMap<>(2);
        int result = dinamicSizeHashMap.lengthHashMap();
        assertThat(result, is(2));
        dinamicSizeHashMap.insert(0, 1);
        dinamicSizeHashMap.insert(1, 1);
        dinamicSizeHashMap.insert(2, 2);
        result = dinamicSizeHashMap.lengthHashMap();
        assertThat(result, is(4));
        dinamicSizeHashMap.insert(3, 3);
        dinamicSizeHashMap.insert(4, 4);
        dinamicSizeHashMap.insert(5, 5);
        result = dinamicSizeHashMap.lengthHashMap();
        assertThat(result, is(8));
        int size = dinamicSizeHashMap.size();
        assertThat(size, is(6));
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorExeptionNoSuch() {
        simpleHashMap.insert("1", 1);
        Iterator<String> it = simpleHashMap.iterator();
        it.next();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iteratorModificationException() {
        simpleHashMap.insert("1", 1);
        simpleHashMap.insert("15", 15);
        Iterator<String> it = simpleHashMap.iterator();
        assertTrue(it.hasNext());
        assertTrue(it.hasNext());
        assertThat(simpleHashMap.get(it.next()), is(1));
        simpleHashMap.insert("14", 14);
        it.next();
    }

    @Test
    public void iteratorStepAndHasNext() {
        SimpleHashMap<Integer, Integer> simpleMap = new SimpleHashMap();
        simpleMap.insert(0, 0);
        simpleMap.insert(2, 2);
        simpleMap.insert(10, 10);
        simpleMap.insert(15, 15);
        Iterator<Integer> it = simpleMap.iterator();
        assertTrue(it.hasNext());
        assertTrue(it.hasNext());
        assertThat(simpleMap.get(it.next()), is(0));
        assertThat(simpleMap.get(it.next()), is(2));
        assertThat(simpleMap.get(it.next()), is(10));
        assertThat(simpleMap.get(it.next()), is(15));
        assertFalse(it.hasNext());

    }
}
