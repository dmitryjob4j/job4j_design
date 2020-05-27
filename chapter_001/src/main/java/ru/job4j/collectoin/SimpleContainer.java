package ru.job4j.collectoin;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 3. List
 * 2. Создать контейнер на базе связанного списка [#288958]
 * интерфейс.
 * @param <E>
 * @author D.Stepanov
 * @version 1
 * @since 27.05.2020.
 */
public interface SimpleContainer<E> extends Iterable<E> {
    void add(E e);

    E get(int index);
}
