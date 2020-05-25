package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2. Уровень - Джуниор.
 * Блок 1. Структуры данных и алгоритмы.
 * 5.1.1. Итератор для двухмерного массива int[][][#288967]
 * модель данных - двумерного массива чисел с итератором в обратном порядке.
 *
 * @since 17.05.2020.
 */
public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return (row < data.length && data[row].length != 0) || (row != data.length - 1 && data[row].length == 0);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (!(column < data[row].length)) {
            column = 0;
            row++;
            while (data[row].length == 0) {
                row++;
            }
        }
        return data[row][column++];
    }
}
