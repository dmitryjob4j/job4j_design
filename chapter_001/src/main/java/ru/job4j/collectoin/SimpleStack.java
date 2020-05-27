package ru.job4j.collectoin;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 3. List
 * 4. Используя контейнер на базе связанного списка создать контейнер Stack [#288956]
 *
 * @param <T>
 * @author D.Stepanov
 * @version 1
 * @since 27.05.2020.
 */
public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    /**
     * Возвращает значение и удоляет элемент с конца.
     *
     * @return
     */
    public T pop() {
        return linked.deleteLast();
    }

    /**
     * Помещает значение в коллекцию.
     *
     * @param value
     */
    public void push(T value) {
        linked.add(value);
    }

    /**
     * Возвращает элемент по индексу.
     *
     * @param index
     * @return
     */
    public T get(int index) {
        return linked.get(index);
    }

    /**
     * Возвращает размер коллекции.
     *
     * @return
     */
    public int size() {
        return linked.getSize();
    }
}
