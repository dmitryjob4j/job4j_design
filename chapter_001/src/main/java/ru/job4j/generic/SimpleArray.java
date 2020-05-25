package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 2. Generic.
 * 5.2.1. Реализовать SimpleArray<T> [#288973]
 *
 * @param <T>
 * @author D.Stepanov
 * @version 4
 * @since 22.05.2020.
 */
public class SimpleArray<T> implements Iterable<T> {
    private int index = 0;
    private Object[] arrays;

    /**
     * Инициализация массива до размера size.
     *
     * @param size
     */
    public SimpleArray(int size) {
        this.arrays = new Object[size];
    }

    /**
     * Доболение элемента в массив.
     *
     * @param model
     */
    public void add(T model) {
        this.arrays[index++] = model;
    }

    /**
     * Устоналвиват занчение в заданную позицию массива.
     *
     * @param point
     * @param model
     */
    public void set(int point, T model) {
        this.arrays[Objects.checkIndex(point, index)] = model;
    }

    /**
     * Возвращает элемент массива.
     *
     * @param point
     * @return
     */
    public T get(int point) {
        return (T) this.arrays[Objects.checkIndex(point, index)];
    }

    /**
     * Удоляет заданный элемнет массива.
     *
     * @param point
     */
    public boolean remove(int point) {
        boolean rsl = false;
        int i = Objects.checkIndex(point, index);
        System.arraycopy(this.arrays, i + 1, this.arrays, i, index - 1 - i);
        this.arrays[index - 1] = null;
        index--;
        rsl = true;
        return rsl;
    }

    /**
     * итератор.
     */
    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            private int iterStep = 0;

            @Override
            public boolean hasNext() {
                return iterStep < arrays.length && iterStep < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) arrays[iterStep++];
            }
        };
        return iterator;
    }
}
