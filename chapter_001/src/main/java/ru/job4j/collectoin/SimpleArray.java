package ru.job4j.collectoin;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 3. List
 * 1. Динамический список на массиве. [#288957]
 *
 * @param <T>
 * @author D.Stepanov
 * @version 1
 * @since 25.05.2020.
 */
public class SimpleArray<T> implements Iterable<T> {
    private int index = 0;
    private int modCount = 0;
    private final int sizeDefault = 10;
    private int size = 0;
    private int newSize = 0;
    private Object[] container;

    /**
     * конструктор по умолчанию создает массив на 10 элементов.
     */
    public SimpleArray() {
        this.size = sizeDefault;
        this.newSize = sizeDefault;
        this.container = new Object[sizeDefault];
    }

    /**
     * конструктор создает массив размера size.
     *
     * @param size
     */
    public SimpleArray(int size) {
        this.size = size;
        this.newSize = size;
        this.container = new Object[size];
    }

    /**
     * добовляет элемент в массив.
     *
     * @param modell
     */
    public void add(T modell) {
        modCount++;
        if (index == size) {
            this.size += newSize;
            Object[] newContainer = new Object[size];
            System.arraycopy(this.container, 0, newContainer, 0, index);
            this.container = newContainer;
        }
        this.container[index++] = modell;
    }

    /**
     * возвращает элемент массива.
     *
     * @param point
     * @return
     */
    public T get(int point) {
        return (T) this.container[Objects.checkIndex(point, this.index)];
    }

    /**
     * возвращает размер массива
     *
     * @return
     */
    public int size() {
        return this.container.length;
    }

    /**
     * итератор.
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            int expectedModCount = modCount;
            int iterStep = 0;

            @Override
            public boolean hasNext() {
                return iterStep < container.length && iterStep < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[iterStep++];
            }
        };
        return iterator;
    }
}
