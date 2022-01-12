package cloud.caravana.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import cloud.caravana.algo.hello.Hello;

public class Algos {
    private static final Map<String, Callable<String>> byName = new HashMap<>(){{
        put("hello", () -> Hello.hello());
    }};

    public static Callable<String> byName(String name) {
        return byName.get(name);
    }
}
