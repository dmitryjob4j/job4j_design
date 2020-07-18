package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 2. Уровень - Джуниор.Блок.2.Ввод-вывод.3.Логгирование.
 * 2. Simple Loggin Facade 4 Java.[#288997]
 *
 * @since 18.07.2020
 */
public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}
