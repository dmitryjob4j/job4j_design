package ru.job4j.collectoin;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 3. List
 * 6. Перевернуть связанный список [#288960]
 *
 * @param <T>
 * @author D.Stepanov
 * @version 1
 * @since 27.05.2020.
 */
public class ForwardLinked<T> implements SimpleContainer<T> {
    private Node<T> head;
    private int size = 0;

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
     * Удаление последнего элемента.
     */
    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T result;
        if (head.next != null) {
            Node<T> last = findNode(size - 1);
            result = last.next.item;
            last.next = null;
        } else {
            result = head.item;
            head = null;
        }
        size--;
        return result;
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
            size++;
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
        index -= 1;
        Objects.checkIndex(index, size);
        Node<T> t = head;
        for (int i = 0; i < index; i++) {
            t = t.next;
        }
        return t;
    }

    /**
     * Переворачивает односвязный список
     */
    public void revert() {
        Node<T> first = head;
        Node<T> second = first.next;
        Node<T> third = second.next;

        Node<T> next = third;
        Node<T> prev = second;

        first.next = null;
        second.next = first;

        while (next != null) {
            Node<T> temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
        }
        head = prev;
    }

    /**
     * Возвращает размер коллекции. Если return "0" значит пуста.
     *
     * @return
     */
    public int getSize() {
        return size;
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
