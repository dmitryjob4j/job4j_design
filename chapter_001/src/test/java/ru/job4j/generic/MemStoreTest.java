package ru.job4j.generic;

import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 2. Generic.
 * 5.2.2. Реализовать Store<T extends Base> [#288974]
 * тест на MemStore.
 *
 * @author D.Stepanov
 * @version 1
 * @since 24.05.2020.
 */
public class MemStoreTest {
    private MemStore<User> memStore;

    @Before
    public void setUp() {
        memStore = new MemStore<>();
    }

    @Test
    public void add() {
        User user1 = new User("1", "Dima");
        User user2 = new User("2", "Vova");
        memStore.add(user1);
        memStore.add(user2);
        assertThat(memStore.findById("1"), is(user1));
        assertThat(memStore.findById("2"), is(user2));
    }

    @Test
    public void replace() {
        User user1 = new User("1", "Dima");
        User user2 = new User("2", "Vova");
        User user3 = new User("3", "Gena");
        memStore.add(user1);
        memStore.add(user2);
        memStore.replace("2", user3);
        assertNull(memStore.findById("2"));
        assertThat(memStore.findById("3"), is(user3));

    }

    @Test
    public void delete() {
        User user1 = new User("1", "Dima");
        User user2 = new User("2", "Vova");
        User user3 = new User("3", "Gena");
        memStore.add(user1);
        memStore.add(user2);
        memStore.add(user3);
        memStore.delete("1");
        memStore.delete("3");
        assertNull(memStore.findById("1"));
        assertNull(memStore.findById("3"));
        assertThat(memStore.findById("2"), is(user2));
    }

    @Test
    public void findById() {
        User user1 = new User("1", "Dima");
        User user2 = new User("2", "Vova");
        User user3 = new User("3", "Gena");
        memStore.add(user1);
        memStore.add(user2);
        memStore.add(user3);
        assertThat(memStore.findById("1"), is(user1));
        assertThat(memStore.findById("2"), is(user2));
        assertThat(memStore.findById("3"), is(user3));
        assertNull(memStore.findById("4"));
    }
}