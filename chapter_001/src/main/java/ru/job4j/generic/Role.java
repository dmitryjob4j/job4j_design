package ru.job4j.generic;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 2. Generic.
 * 5.2.2. Реализовать Store<T extends Base> [#288974]
 * Модель данных Role, наследник Base.
 *
 * @author D.Stepanov
 * @version 1
 * @since 24.05.2020.
 */
public class Role extends Base {
    private String role;

    public Role(String id, String role) {
        super(id);
        this.role = role;
    }
}
