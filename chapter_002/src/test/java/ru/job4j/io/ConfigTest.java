package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * 2. Уровень - Джуниор.Блок 2. Ввод-вывод.1. Ввод-вывод.1. Читаем файл конфигурации
 * 1. Читаем файл конфигурации [#289008]
 * Тесты.
 *
 * @since 25.06.2020
 */
public class ConfigTest {

    @Test
    public void whenPairWithoutCommentName() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Dmitry Stepanov")
        );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenExeptionValue() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        String test = config.value("not");
    }

    @Test
    public void whenPairWithoutCommentHibernateDialect() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.dialect"),
                is("org.hibernate.dialect.PostgreSQLDialect")
        );
    }

    @Test
    public void whenPairWithoutCommentHibernateConnectionUrl() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.url"),
                is("jdbc:postgresql://127.0.0.1:5432/trackstudio")
        );
    }

    @Test
    public void whenPairWithoutValueNull() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertNull(config.value("ppp"));
    }
}
