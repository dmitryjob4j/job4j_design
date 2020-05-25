package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 1. Iterator.
 * 5.1.4. Создать convert(Iterator<Iterator>) [#288965]
 * Задание.
 *
 * @author D.Stepanov haoos@inbox.ru.
 * @since 17.05.2020.
 */
public class Converter {
    public Iterator<Integer> converter(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> array = it.next();

            @Override
            public boolean hasNext() {
                while (it.hasNext() && !array.hasNext()) {
                    array = it.next();
                }
                return array.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array.next();
            }
        };
    }
}
