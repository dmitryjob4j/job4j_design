package ru.job4j.io;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 2. Уровень - Джуниор.Блок.2.Ввод-вывод.3.Логгирование.
 * 1.Log4j.Логирование системы.[#288996]
 *
 * @since 18.07.2020
 */
public class UsageLog4j {
    private static final Logger LOG = LogManager.getLogger(UsageLog4j.class.getName());

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
