package com.caysever.java9.resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TryWithResourceExample {


    public static void main(String[] args) throws Exception {

        FileReader in = new FileReader(new File("src/com/caysever/java9/resources", "java9-feature"));
        BufferedReader reader = new BufferedReader(in);
        try (reader; in) {
            reader.lines().forEach(System.err::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
