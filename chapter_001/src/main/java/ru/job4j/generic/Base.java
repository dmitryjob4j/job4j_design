package ru.job4j.generic;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 2. Generic.
 * 5.2.2. Реализовать Store<T extends Base> [#288974]
 * абстракный класс Base базовая модель родитель User, Role.
 *
 * @author D.Stepanov
 * @version 1
 * @since 24.05.2020.
 */
public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
