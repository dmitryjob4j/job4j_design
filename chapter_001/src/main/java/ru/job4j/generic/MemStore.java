package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 2. Generic.
 * 5.2.2. Реализовать Store<T extends Base> [#288974]
 * универсальное хранилище MemStore.
 *
 * @author D.Stepanov
 * @version 1
 * @since 24.05.2020.
 */
public class MemStore<T extends Base> implements Store {
    private final List<T> mem = new ArrayList<>();

    /**
     * добовляет модель типа <Т> в хронилище.
     *
     * @param model
     */
    @Override
    public void add(Base model) {
        this.mem.add((T) model);

    }

    /**
     * заменяет модель в хронилище по найденому id.
     *
     * @param id
     * @param model
     * @return
     */
    @Override
    public boolean replace(String id, Base model) {
        Base find = findById(id);
        if (find != null) {
            int i = mem.indexOf(find);
            mem.set(i, (T) model);
            return true;
        } else {
            return false;
        }
    }

    /**
     * удоляет модель в хронилище по найденому id.
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(String id) {
        Base find = findById(id);
        if (find != null) {
            int i = mem.indexOf(find);
            mem.remove(i);
            return true;
        } else {
            return false;
        }
    }

    /**
     * ищет модель в хронилище по id.
     *
     * @param id
     * @return
     */
    @Override
    public Base findById(String id) {
        Base result = null;
        for (Base value : mem) {
            if (value.getId().equals(id)) {
                result = value;
                break;
            }
        }
        return result;
    }
}
