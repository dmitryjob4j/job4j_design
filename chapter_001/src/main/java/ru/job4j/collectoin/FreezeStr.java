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
        Map<String, Integer> l = stringToMap(left);
        Map<String, Integer> r = stringToMap(right);
        if (l.size() != r.size()) {
            return false;
        }
        for (String i : l.keySet()) {
            if (!r.containsKey(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * онвертирует строку в мап
     * @param string String
     * @return Map
     */
    private static Map<String, Integer> stringToMap(String string) {
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        int r = 0;
        for (String el : string.split("")) {
            if (map.containsKey(el)) {
                el = el + r;
                map.put(el, i++);
                r++;
            } else {
                map.put(el, i++);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String left = "JetBrainsIntelliJ IDEA Community Edition 2019.3.3libidea_rt.jar=54496:C:Program FilesJetBrainsIntelliJ IDEA Community Edition 2019.3.3";
        String right = "JetBrainsIntelliJ IDEA Community Edition 2019.3.3libidea_rt.jar=54496:C:Program FilesJetBrainsIntelliJ IDEA Community Edition 2019.3.3";
        boolean result;
        Date date1 = new Date();
        Map<String, Integer> l = stringToMap(left);
        Map<String, Integer> r = stringToMap(right);
        Date date2 = new Date();
        System.out.println(l);
        System.out.println(r);
        System.out.println(date2.getTime() - date1.getTime());
        Date date3 = new Date();
        result = eq(left, right);
        Date date4 = new Date();
        System.out.println(result);
        System.out.println(date4.getTime() - date3.getTime());
    }
}
