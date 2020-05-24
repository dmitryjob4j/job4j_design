package ru.job4j.generic;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 2. Generic.
 * 5.2.2. Реализовать Store<T extends Base> [#288974]
 * тест на RoleStore.
 *
 * @author D.Stepanov
 * @version 1
 * @since 24.05.2020.
 */
public class RoleStoreTest {
    private RoleStore roleStore;

    @Before
    public void setUP() {
        roleStore = new RoleStore();
    }

    @Test
    public void add() {
        Role role1 = new Role("1", "jun");
        Role role2 = new Role("2", "menter");
        roleStore.add(role1);
        roleStore.add(role2);
        assertThat(roleStore.findById("1"), is(role1));
        assertThat(roleStore.findById("2"), is(role2));
    }

    @Test
    public void replace() {
        Role role1 = new Role("1", "jun");
        Role role2 = new Role("2", "menter");
        Role role3 = new Role("3", "midle");
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.replace("2", role3);
        assertNull(roleStore.findById("2"));
        assertThat(roleStore.findById("3"), is(role3));

    }

    @Test
    public void delete() {
        Role role1 = new Role("1", "jun");
        Role role2 = new Role("2", "menter");
        Role role3 = new Role("3", "midle");
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        roleStore.delete("1");
        roleStore.delete("3");
        assertNull(roleStore.findById("1"));
        assertNull(roleStore.findById("3"));
        assertThat(roleStore.findById("2"), is(role2));
    }

    @Test
    public void findById() {
        Role role1 = new Role("1", "jun");
        Role role2 = new Role("2", "menter");
        Role role3 = new Role("3", "midle");
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        assertThat(roleStore.findById("1"), is(role1));
        assertThat(roleStore.findById("2"), is(role2));
        assertThat(roleStore.findById("3"), is(role3));
        assertNull(roleStore.findById("4"));
    }
}