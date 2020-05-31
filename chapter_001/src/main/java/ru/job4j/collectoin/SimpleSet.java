package ru.job4j.collectoin;

import java.util.Iterator;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 4. Set
 * 1. Реализовать коллекцию Set на массиве
 *
 * @param <E>
 * @author DStepanov haoos@inbox.ru
 * @version 1
 * @since 31.05.2020
 */
public class SimpleSet<E> implements Iterable<E> {
    private final SimpleArray<E> sets = new SimpleArray<E>();

    /**
     * Добовляет элемент в коллекцию
     *
     * @param model
     */
    public void add(E model) {
        if (!equalsSet(model)) {
            sets.add(model);
        }
    }

    /**
     * Проверяет наличии добовлемого элемента в коллекции.
     *
     * @param model
     * @return
     */
    public boolean equalsSet(E model) {
        boolean rsl = false;
        for (E value : sets) {
            if (model.equals(value)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    /**
     * Итератор.
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return sets.iterator();
    }
}
