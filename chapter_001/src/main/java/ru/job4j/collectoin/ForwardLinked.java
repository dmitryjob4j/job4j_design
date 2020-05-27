package ru.job4j.collectoin;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 3. List
 * 3. Удалить head в односвязном списке. [#288955]
 *
 * @param <T>
 * @author D.Stepanov
 * @version 1
 * @since 27.05.2020.
 */
public class ForwardLinked<T> implements SimpleContainer<T> {
    private Node<T> head;
    private int size = 1;

    /**
     * удаление первого элемента.
     */
    public void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
        size--;
    }

    /**
     * Добавление элемента.
     *
     * @param value
     */
    @Override
    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    /**
     * Возвращает элемент по индексу.
     *
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        return findNode(index).item;
    }

    /**
     * поиск Node по индексу.
     *
     * @param index
     * @return
     */
    public Node<T> findNode(int index) {
        Objects.checkIndex(index, size);
        Node<T> t = head;
        for (int i = 0; i < index; i++) {
            t = t.next;
        }
        return t;
    }

    /**
     * внутренний класс реализации Node<T>.
     *
     * @param <T>
     */
    private static class Node<T> {
        T item;
        Node<T> next;

        Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    /**
     * Итреатор прямой.
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.item;
                node = node.next;
                return value;
            }
        };
        return iterator;
    }
}
