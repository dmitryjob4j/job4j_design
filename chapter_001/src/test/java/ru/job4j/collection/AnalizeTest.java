package ru.job4j.collection;

import org.junit.Test;
import org.junit.Before;
import ru.job4j.collectoin.Analize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.assertThat;

/**
 * 2. Уровень - Джуниор. Блок 1. Структуры данных и алгоритмы. 7. Контрольные вопросы
 * 2. Статистику по коллекции.
 * тесты.
 *
 * @author DStepanov haoos@inbox.ru
 * @version 1
 * @since 13.06.2020
 */
public class AnalizeTest {
    private List<Analize.User> previos;
    private List<Analize.User> current;
    private Analize.User user1;
    private Analize.User user2;
    private Analize.User user3;
    private Analize.User user4;
    private Analize.User user5;
    private Analize.User user6;
    private Analize.User user7;
    private Analize.User user8;
    private Analize.User user9;
    private Analize.User user10;

    @Before
    public void setUp() {
        user1 = new Analize.User(1, "one");
        user2 = new Analize.User(2, "two");
        user3 = new Analize.User(3, "three");
        user4 = new Analize.User(4, "four");
        user5 = new Analize.User(5, "five");
        user6 = new Analize.User(6, "six");
        user7 = new Analize.User(7, "seven");
        user8 = new Analize.User(8, "eight");
        user9 = new Analize.User(9, "nine");
        user10 = new Analize.User(10, "ten");
        previos = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
    }

    @Test
    public void add0dell7cheng0() {
        Analize an = new Analize();
        current = Arrays.asList(user1, user2, user3);
        Analize.Info info = an.diff(previos, current);
        Analize.Info expect = new Analize.Info(0, 0, 7);
        assertThat(info, is(expect));
    }

    @Test
    public void add0dell5cheng2() {
        Analize an = new Analize();
        user5 = new Analize.User(5, "xxx");
        user6 = new Analize.User(6, "xxx");
        current = Arrays.asList(user1, user5, user6, user7, user8);
        Analize.Info info = an.diff(previos, current);
        Analize.Info expect = new Analize.Info(0, 2, 5);
        assertThat(info, is(expect));
    }

    @Test
    public void add2dell0cheng0() {
        Analize an = new Analize();
        Analize.User user11 = new Analize.User(11, "xxx");
        Analize.User user12 = new Analize.User(12, "xxx");
        current = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);
        Analize.Info info = an.diff(previos, current);
        Analize.Info expect = new Analize.Info(2, 0, 0);
        assertThat(info, is(expect));
    }

    @Test
    public void add0dell10cheng0() {
        Analize an = new Analize();
        current = new ArrayList<>();
        Analize.Info info = an.diff(previos, current);
        Analize.Info expect = new Analize.Info(0, 0, 10);
        assertThat(info, is(expect));
    }

    @Test
    public void add0dell0cheng0() {
        Analize an = new Analize();
        current = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
        Analize.Info info = an.diff(previos, current);
        Analize.Info expect = new Analize.Info(0, 0, 0);
        assertThat(info, is(expect));
    }
}
