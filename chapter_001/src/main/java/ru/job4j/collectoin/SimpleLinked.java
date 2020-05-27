package ru.job4j.collectoin;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 3. List
 * 2. Создать контейнер на базе связанного списка [#288958]
 *
 * @param <E>
 * @author D.Stepanov
 * @version 1
 * @since 27.05.2020.
 */
public class SimpleLinked<E> implements SimpleContainer<E> {
    private int size = 0;
    private int modCount = 0;
    private Node<E> first;
    private Node<E> last;

    public SimpleLinked() {
    }

    /**
     * Добовление элемента в конец
     *
     * @param e
     */
    @Override
    public void add(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = last;
        }
        size++;
        modCount++;
    }

    /**
     * Возврощает элемент по индексу.
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return findId(index).item;
    }

    /**
     * Поиск Node<E> по индексу элемента.
     *
     * @param index
     * @return
     */
    private Node<E> findId(int index) {
        Objects.checkIndex(index, size);
        Node<E> e = first;
        for (int i = 0; i < index; i++) {
            e = e.next;
        }
        return e;
    }

    /**
     * Добавление в начало списка.
     *
     * @param e
     */
    public void addFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = first;
        }
        size++;
        modCount++;
    }

    /**
     * Итератор прямой.
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            private int expectedModCount = modCount;
            private int iterStep;
            private Node<E> e = first;

            @Override
            public boolean hasNext() {
                return iterStep < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (iterStep == 0) {
                    iterStep++;
                    return e.item;
                } else {
                    iterStep++;
                    e = e.next;
                    return e.item;
                }
            }
        };
        return iterator;
    }

    /**
     * Вложенный класс Node.
     * Для установки ссылок на пред. и след. элемент.
     *
     * @param <E>
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
