package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы.6. Tree
 * 1. Создать элементарную структуру дерева
 * интерфейс.
 *
 * @param <E>
 * @author DStepanov haoos@inbox.ru
 * @version 1
 * @since 7.06.2020
 */
public interface SimpleTree<E> {
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);

    /**
     * Node
     *
     * @param <E>
     */
    class Node<E> {
        final E value;
        final List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }
    }
}
