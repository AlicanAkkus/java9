package com.caysever.java9.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.lang.System.out;

public class CollectionsFactory {


    public static void main(String[] args) {
        List.of(1, 2, 3, 4, 5).forEach(out::println);

        Set.of(1, 2, 3, 4, 5).forEach(out::println);

        Map.of("one", 1, "two", 2, "three", 3, "four", 4, "five", 5)
                .forEach((key, value) -> System.out.println("Key : " + key + " Value : " + value));

    }

}
