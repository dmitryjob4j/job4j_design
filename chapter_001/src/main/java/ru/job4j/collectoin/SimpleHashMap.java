package ru.job4j.collectoin;

import java.util.*;

/**
 * 2. Уровень - Джуниор. Блок 1. Структуры данных и алгоритмы. 5. Map.
 * 8. Реализовать собственную структуру данных - HashMap.
 *
 * @param <K>
 * @param <V>
 * @author DStepanov haoos@inbox.ru
 * @version 1
 * @since 06.06.2020
 */
public class SimpleHashMap<K, V> implements Iterable<K> {
    private int modCount = 0;
    private Node<K, V>[] table;
    private int size = 0;
    private int newSize;
    private final int sizeDefault = 16;
    private final float defaultLoadFactor = 0.75f;

    public SimpleHashMap() {
        this.newSize = this.sizeDefault;
        this.table = new Node[newSize];
    }

    public SimpleHashMap(int size) {
        this.newSize = size;
        this.table = new Node[newSize];
    }

    /**
     * Класс Node
     *
     * @param <K>
     * @param <V>
     */
    private static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<?, ?> node = (Node<?, ?>) o;
            return hash == node.hash
                    && Objects.equals(key, node.key)
                    && Objects.equals(value, node.value)
                    && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(hash, key, value, next);
        }
    }

    /**
     * Добовление нового значенея.
     *
     * @param key
     * @param value
     * @return
     */
    public boolean insert(K key, V value) {
        int index = index(hash(key));
        if (table[index] != null && !table[index].key.equals(key)) {
            return false;
        }
        table[index] = new Node<>(hash(key), key, value, null);
        modCount++;
        size++;
        newSizeTable();
        return true;
    }

    /**
     * Получение содержимого по ключу.
     *
     * @param key
     * @return
     */
    public V get(K key) {
        int index = index(hash(key));
        return table[index].value;
    }

    /**
     * Удаление карзины по ключу
     *
     * @param key
     * @return
     */
    public boolean delete(K key) {
        int index = index(hash(key));
        if (table[index] == null) {
            return false;
        }
        table[index] = null;
        size--;
        modCount++;
        return true;
    }

    /**
     * Вычисление hash обьекта по key
     *
     * @param key
     * @return
     */
    private int hash(K key) {
        int h = key.hashCode();
        return (key == null) ? 0 : (h ^ (h >>> 16));
    }

    /**
     * Вычисление номера корзины по hash
     *
     * @param hash
     * @return
     */
    private int index(int hash) {
        return hash & (newSize - 1);
    }

    /**
     * Возвращает количество элементов в коллекции.
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * Увелечение размера массива по заполнению.
     */
    private void newSizeTable() {
        if ((newSize * defaultLoadFactor) < size) {
            newSize += newSize;
            table = Arrays.copyOf(table, newSize);
        }
    }

    /**
     * Размер коллекции.
     *
     * @return
     */
    public int lengthHashMap() {
        return table.length;
    }

    /**
     * Итератор.
     *
     * @return
     */
    @Override
    public Iterator<K> iterator() {
        Iterator<K> iterator = new Iterator<K>() {
            private int expectedModCount = modCount;
            private int iterStep = 0;

            @Override
            public boolean hasNext() {
                while (iterStep < table.length && table[iterStep] == null) {
                    iterStep++;
                }
                return size > 0 && iterStep < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return table[iterStep++].key;
            }
        };
        return iterator;
    }
}
