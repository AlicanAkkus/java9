package com.caysever.java9.stream;

import java.util.List;

import static java.lang.System.err;
import static java.lang.System.out;

public class StreamImprovementExample {

    public static void main(String[] args) {

        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream().takeWhile(l -> l < 6).forEach(out::println);
        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream().dropWhile(l -> l < 6).forEach(err::println);

    }
}
