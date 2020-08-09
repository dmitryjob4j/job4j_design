package ru.job4j.find;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindParam {
    /**
     * Dispatch.
     */
    private final Map<String, BiFunction<Path, String, Boolean>> dispathc = new HashMap<>();

    /**
     * Load initial handlers.
     *
     * @return current object.
     */
    public FindParam init() {
        this.dispathc.put(
                "-f",
                (p, s) -> p.getFileName().toString().equals(s)
        );
        this.dispathc.put(
                "-m",
                (p, s) -> {
                    String mask = s.replace("*", ".*").replace("?", ".?");
                    Pattern pat = Pattern.compile(mask);
                    Matcher mat = pat.matcher(p.getFileName().toString());
                    return mat.matches();
                }
        );
        this.dispathc.put(
                "-r",
                (p, s) -> {
                    Pattern pat = Pattern.compile(s);
                    Matcher mat = pat.matcher(p.getFileName().toString());
                    return mat.find();
                }
        );
        return this;
    }

    /**
     * Load handler and predict.
     *
     * @param key       String free param
     * @param findParam String free param
     */
    public void load(String key, BiFunction<Path, String, Boolean> findParam) {
        this.dispathc.put(key, findParam);
    }

    /**
     * Возврощаем предикат для поиска.
     *
     * @param key         String param
     * @param paramSearch String search
     * @return Predicate
     */
    public Predicate<Path> access(String key, String paramSearch) {
        return p -> this.dispathc.get(key).apply(p, paramSearch);
    }
}
