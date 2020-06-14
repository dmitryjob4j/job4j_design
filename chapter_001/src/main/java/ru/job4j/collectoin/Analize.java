package ru.job4j.collectoin;

import java.util.*;

/**
 * 2. Уровень - Джуниор. Блок 1. Структуры данных и алгоритмы. 7. Контрольные вопросы
 * 2. Статистику по коллекции.
 *
 * @author DStepanov haoos@inbox.ru
 * @version 1
 * @since 13.06.2020
 */
public class Analize {
    /**
     * Подсчет статистики двух коллекций.
     *
     * @param previous вхобные
     * @param current измененные
     * @return
     */
    public Info diff(List<User> previous, List<User> current) {
        int add = 0;
        int chengs = 0;
        int dell = 0;
        int noModif = 0;
        if (current.isEmpty()) {
            dell = previous.size();
            return new Info(add, chengs, dell);
        }
        for (User uP : previous) {
            for (User uC : current) {
                if (uP.id == uC.id && !uP.name.equals(uC.name)) {
                    chengs++;
                }
                if (uP.equals(uC)) {
                    noModif++;
                }
            }
        }
        dell = previous.size() - noModif - chengs;
        add = current.size() - (previous.size() - dell);
        return new Info(add, chengs, dell);
    }

    /**
     * Вложенный класс модель данных.
     */
    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    /**
     * Вложенный класс результат анализа двух коллекий.
     */
    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added
                    && changed == info.changed
                    && deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }
    }
}
