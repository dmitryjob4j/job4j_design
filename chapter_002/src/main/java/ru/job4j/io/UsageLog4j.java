package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 2. Уровень - Джуниор.Блок.2.Ввод-вывод.3.Логгирование.
 * 3.Slf4j-вывод переменных.[#288998]
 *
 * @since 18.07.2020
 */
public class UsageLog4j {
    /**
     * Константа.
     */
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
        byte bate1 = 1;
        short short2 = 2;
        boolean boolean3 = true;
        int int4 = 4;
        char char5 = 'c';
        long long6 = 6;
        double double7 = 7.77;
        float float8 = 888;
        LOG.debug("byte: {}, short: {}, boolean: {}, int: {}, char: {}, long: {}, double: {}, float: {}",
                bate1, short2, boolean3, int4, char5, long6, double7, float8);
    }
}
