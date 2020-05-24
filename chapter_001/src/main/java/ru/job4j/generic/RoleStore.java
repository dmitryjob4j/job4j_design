package ru.job4j.generic;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 2. Generic.
 * 5.2.2. Реализовать Store<T extends Base> [#288974]
 * хранилище RoleStore.
 *
 * @author D.Stepanov
 * @version 1
 * @since 24.05.2020.
 */
public class RoleStore implements Store<Role> {
    private final Store<Role> store = new MemStore<>();

    /**
     * добовляет модель типа Role в хронилище.
     *
     * @param model
     */
    @Override
    public void add(Role model) {
        store.add(model);
    }

    /**
     * заменяет модель в хронилище по найденому id.
     *
     * @param id
     * @param model
     * @return
     */
    @Override
    public boolean replace(String id, Role model) {
        return store.replace(id, model);
    }

    /**
     * удоляет модель в хронилище по найденому id.
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    /**
     * ищет модель в хронилище по id.
     *
     * @param id
     * @return
     */
    @Override
    public Role findById(String id) {
        return store.findById(id);
    }
}
