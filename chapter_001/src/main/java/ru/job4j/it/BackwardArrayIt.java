package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2. Уровень - Джуниор.
 * Блок 1. Структуры данных и алгоритмы.
 * 1. Что такое итератор. [#288966].
 * модель данных - одномерный массив чисел с итератором в обратном порядке.
 *
 * @since 16.05.2020.
 */

public class BackwardArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int point;

    /**
     * @param data оьявление массива.
     */
    public BackwardArrayIt(int[] data) {
        this.data = data;
        this.point = data.length - 1;
    }

    @Override
    public boolean hasNext() {
        return point > -1;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point--];
    }
}
