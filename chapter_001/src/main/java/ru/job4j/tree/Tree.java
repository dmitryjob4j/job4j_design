package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы.6. Tree
 * 2. Добавить метод boolean isBinary() [#288992]
 *
 * @param <E>
 * @author DStepanov haoos@inbox.ru
 * @version 1
 * @since 08.06.2020
 */
public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    /**
     * проверяет количество дочерних элементов <=2.
     *
     * @return true/false.
     */
    public boolean isBinary() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.children.size() > 2) {
                return false;
            }
            data.addAll(el.children);
        }
        return true;
    }

    /**
     * Добовление child к родителю.
     *
     * @param parent родитель.
     * @param child  дочерний.
     * @return true/false.
     */
    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> dad = findBy(parent);
        Optional<Node<E>> baby = findBy(child);
        if (dad.isEmpty()) {
            return false;
        }
        if (baby.isPresent()) {
            return false;
        }
        dad.get().children.add(new Node<>(child));
        return true;
    }

    /**
     * поиск узла.
     *
     * @param value findBy
     * @return true/fals
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
