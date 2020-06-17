package ru.job4j.collectoin;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 2. Уровень - Джуниор. Блок 1. Структуры данных и алгоритмы. 7. Контрольные вопросы
 * 2. Статистику по коллекции.
 *
 * @author DStepanov haoos@inbox.ru
 * @version 2
 * @since 17.06.2020
 */
public class Analize {
    /**
     * Подсчет статистики двух коллекций.
     *
     * @param previous вхобные
     * @param current  измененные
     * @return Info
     */
    public Info diff(List<User> previous, List<User> current) {
        Map<Integer, User> prev = toMap(previous);
        int add = 0;
        int chengs = 0;
        int dell;
        if (current.isEmpty()) {
            dell = prev.size();
            return new Info(add, chengs, dell);
        }
        for (User user : current) {
            User tmp = prev.remove(user.id);
            if(tmp == null){
                add++;
            }else if(!tmp.name.equals(user.name)){
                chengs++;
            }
        }
        dell = prev.size();
        return new Info(add, chengs, dell);
    }

    /**
     * преобразование list(User) в Map(Integer, User).
     *
     * @param list List(User)
     * @return map
     */
    private Map<Integer, User> toMap(List<User> list) {
        return list.stream()
                .distinct()
                .collect(Collectors
                        .toMap(
                                i -> i.id,
                                u -> u
                        )
                );
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
