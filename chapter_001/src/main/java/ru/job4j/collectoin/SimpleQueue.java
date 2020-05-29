package ru.job4j.collectoin;

/**
 * 2. Уровень - Джуниор.Блок 1. Структуры данных и алгоритмы. 3. List
 * 5. Очередь на двух стеках [#288959]
 *
 * @param <T>
 * @author D.Stepanov
 * @version 2
 * @since 28.05.2020.
 */
public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    /**
     * Возвращает первое значине и удоляет его из коллекции.
     *
     * @return
     */
    public T poll() {
        inToOut(in, out);
        T rsl = out.pop();
        inToOut(out, in);
        return rsl;
    }

    /**
     * Помещает значение в конец коллекции.
     *
     * @param value
     */
    public void push(T value) {
        in.push(value);
    }

    /**
     * Метод перекладывает обьекты из коллекции in в колекцию out LiFo.
     * @param in
     * @param out
     */
    public void inToOut(SimpleStack<T> in, SimpleStack<T> out) {
        int size = in.size();
        for (int i = 0; i < size; i++) {
            out.push(in.pop());
        }
    }
}
