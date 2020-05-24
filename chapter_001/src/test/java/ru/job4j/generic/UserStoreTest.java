package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 2. Generic.
 * 5.2.2. Реализовать Store<T extends Base> [#288974]
 * тест на UserStore.
 *
 * @author D.Stepanov
 * @version 1
 * @since 24.05.2020.
 */
public class UserStoreTest {
    private UserStore userUserStore;

    @Before
    public void setUp() {
        userUserStore = new UserStore();
    }

    @Test
    public void add() {
        User user1 = new User("1", "Dima");
        User user2 = new User("2", "Vova");
        userUserStore.add(user1);
        userUserStore.add(user2);
        assertThat(userUserStore.findById("1"), is(user1));
        assertThat(userUserStore.findById("2"), is(user2));
    }

    @Test
    public void replace() {
        User user1 = new User("1", "Dima");
        User user2 = new User("2", "Vova");
        User user3 = new User("3", "Gena");
        userUserStore.add(user1);
        userUserStore.add(user2);
        userUserStore.replace("2", user3);
        assertNull(userUserStore.findById("2"));
        assertThat(userUserStore.findById("3"), is(user3));
    }

    @Test
    public void delete() {
        User user1 = new User("1", "Dima");
        User user2 = new User("2", "Vova");
        User user3 = new User("3", "Gena");
        userUserStore.add(user1);
        userUserStore.add(user2);
        userUserStore.add(user3);
        userUserStore.delete("1");
        userUserStore.delete("3");
        assertNull(userUserStore.findById("1"));
        assertNull(userUserStore.findById("3"));
        assertThat(userUserStore.findById("2"), is(user2));
    }

    @Test
    public void findById() {
        User user1 = new User("brq", "Dima");
        User user2 = new User("2", "Vova");
        User user3 = new User("3", "Gena");
        userUserStore.add(user1);
        userUserStore.add(user2);
        userUserStore.add(user3);
        assertThat(userUserStore.findById("brq"), is(user1));
        assertThat(userUserStore.findById("2"), is(user2));
        assertThat(userUserStore.findById("3"), is(user3));
        assertNull(userUserStore.findById("4"));
    }
}