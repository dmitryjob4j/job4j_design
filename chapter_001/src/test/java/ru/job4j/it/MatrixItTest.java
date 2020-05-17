package ru.job4j.it;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.NoSuchElementException;

/**
 * 2. Уровень - Джуниор.
 * Блок 1. Структуры данных и алгоритмы.
 * 5.1.1. Итератор для двухмерного массива int[][][#288967]
 * Тесты.
 *
 * @author D.Stepanov (haoos@inbox.ru).
 * @since 17.05.2020.
 */
public class MatrixItTest {
    @Test
    public void when4El() {
        MatrixIt it = new MatrixIt(
                new int[][]{
                        {1}
                }
        );
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenFirstEmptyThenNext() {
        MatrixIt it = new MatrixIt(
                new int[][]{
                        {},
                        {1}
                }
        );
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenRowHasDiffSize() {
        MatrixIt it = new MatrixIt(
                new int[][]{
                        {1},
                        {2, 3}
                }
        );
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test
    public void whenFreEmpty() {
        MatrixIt it = new MatrixIt(
                new int[][]{
                        {1},
                        {},
                        {},
                        {},
                        {2}
                }
        );
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenFirstEmptyThenHasNext() {
        MatrixIt it = new MatrixIt(
                new int[][]{
                        {},
                        {1}
                }
        );
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenEmpty() {
        MatrixIt it = new MatrixIt(
                new int[][]{
                        {}
                }
        );
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyThenNext() {
        MatrixIt it = new MatrixIt(
                new int[][]{
                        {}
                }
        );
        it.next();
    }

    @Test
    public void whenMultiHasNext() {
        MatrixIt it = new MatrixIt(
                new int[][]{
                        {},
                        {1}
                }
        );
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenFirstEmptyHasNext() {
        MatrixIt it = new MatrixIt(
                new int[][]{
                        {},
                        {1}
                }
        );
        assertThat(it.hasNext(), is(true));
    }
}
