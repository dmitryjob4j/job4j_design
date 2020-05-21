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
 * @since 22.05.2020.
 */
public class SimpleArray<T> implements Iterator<T> {
    private int index = 0;
    Object[] arrays;

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
        try {
            int i = Objects.checkIndex(this.index, this.arrays.length);
            this.arrays[i] = model;
            index++;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Значение не найдено");
        }
    }

    /**
     * Устоналвиват занчение в заданную позицию массива.
     *
     * @param point
     * @param model
     */
    public void set(int point, T model) {
        try {
            int i = Objects.checkIndex(point, this.arrays.length);
            this.arrays[i] = model;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Значение не найдено");
        }
    }

    /**
     * Возвращает элемент массива.
     *
     * @param position
     * @return
     */
    public T get(int position) {
        T rsl = null;
        try {
            int i = Objects.checkIndex(position, this.arrays.length);
            rsl = (T) this.arrays[i];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Значение не найдено");
        }
        return rsl;
    }

    /**
     * Удоляет заданный элемнет массива.
     *
     * @param point
     */
    public boolean remove(int point) {
        boolean rsl = false;
        try {
            int i = Objects.checkIndex(point, this.arrays.length);
            System.arraycopy(this.arrays, i + 1, this.arrays, i, this.arrays.length - i - 1);
            this.arrays[this.arrays.length - 1] = null;
            rsl = true;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Значение не найдено");
        }
        return rsl;
    }

    /**
     * итератор.
     */
    private int iterStep = 0;

    @Override
    public boolean hasNext() {
        return iterStep < this.arrays.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            return (T) this.arrays[iterStep++];
        }

    }
}
