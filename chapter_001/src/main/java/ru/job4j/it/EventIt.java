package ru.job4j.it;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 1. Iterator.
 * 5.1.2. Создать итератор четные числа[#288964].
 * EventIt реализует итератор для четных чисел массива.
 *
 * @author D.Stepanov haoos@inbox.ru.
 * @since 17.05.2020.
 */
public class EventIt implements Iterator<Integer> {
    private final int[] numbers;
    private int point = 0;

    public EventIt(final int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * sendEvent метод определяет четный элемент массива или нет.
     *
     * @param event
     * @param i
     * @return
     */
    public boolean sendEvent(int[] event, int i) {
        return (event[i] % 2 == 0 && event[i] != 0);
    }


    @Override
    public boolean hasNext() {
        while (!sendEvent(numbers, point) && point < numbers.length - 1) {
            point++;
        }
        return sendEvent(numbers, point) && point < numbers.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            return numbers[point++];
        }
    }
}
