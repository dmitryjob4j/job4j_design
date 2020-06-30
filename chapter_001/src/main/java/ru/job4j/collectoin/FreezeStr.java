package ru.job4j.collectoin;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Тестовые задания. Проверить две строчки на идентичность.
 * Проверить две строчки на идентичность.[#273008]
 *
 * @author DStepanov haoos@inbox.ru
 * @version 1
 * @since 29.06.2020.
 */
public class FreezeStr {
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        Map<String, Integer> map = stringToMap(left, right);
        for(String el: map.keySet()) {
            if(map.get(el)%2 != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param first String
     * @param second String
     * @return Map
     */
    private static Map<String, Integer> stringToMap(String first, String second) {
        Map<String, Integer> map = new HashMap<>();
        String string = first.concat(second);
        for (String el : string.split("")) {
            if (map.containsKey(el)) {
                map.put(el, (map.get(el) + 1));
            } else {
                map.put(el, 1);
            }
        }
        return map;
    }
}
