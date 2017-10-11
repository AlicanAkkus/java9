package com.caysever.java9.stream;

import java.util.stream.IntStream;

import static java.lang.System.out;

public class IterationExample {

    public static void main(String[] args) {

        IntStream.iterate(2, x -> x < 1000, x -> x * x).forEach(out::println);

    }
}
