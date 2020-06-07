package ru.job4j.tree;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы.6. Tree
 * 1. Создать элементарную структуру дерева.
 *
 * @author DStepanov haoos@inbox.ru
 * @version 1
 * @since 7.06.2020
 */
public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true));
    }

    @Test
    public void when6ElFindNotElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void addPerent6IsNotFind() {
        Tree<Integer> tree = new Tree<>(1);
        assertTrue(tree.add(1, 2));
        assertTrue(tree.add(1, 3));
        assertFalse(tree.add(6, 4));
    }

    @Test
    public void addPerenr2IsFindAndChild3IsFind() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        assertFalse(tree.add(2, 3));
    }

}