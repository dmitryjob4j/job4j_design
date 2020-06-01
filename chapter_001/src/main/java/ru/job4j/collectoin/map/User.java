package ru.job4j.collectoin.map;

import java.util.Calendar;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы.  5. Map
 * 1. Создать модель User
 *
 * @author DStepanov haoos@inbox.ru
 * @version 1
 * @since 01.06.2020.
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;

    /**
     * Конструктор
     *
     * @param name
     * @param children
     * @param birthday
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getChildren() {
        return children;
    }

    public Calendar getBirthday() {
        return birthday;
    }
}
