package com.caysever.java9.walker;

import java.util.List;
import java.util.stream.Collectors;

public class StackWalkerExample {

    public static void main(String[] args) {
        a();
    }

    private static void a() {
        b();
    }

    private static void b() {
        walker();
    }

    private static void walker() {
        StackWalker sw = StackWalker.getInstance();
        List<StackWalker.StackFrame> frames;

        frames = sw.walk(frames_ -> frames_.collect(Collectors.toList()));
        frames.forEach(System.out::println);
        System.out.println();

        long numFrames = sw.walk(frames_ -> frames_.count());
        System.out.printf("Total number of frames: %d%n%n", numFrames);
    }

}
