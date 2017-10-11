package com.caysever.java9.trywithresource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TryWithResourceExample {

    public static void main(String[] args) throws Exception {

        FileReader in = new FileReader(new File("src/com/caysever/java9", "author"));
        BufferedReader reader = new BufferedReader(in);
        try (reader; in) {
            System.out.println(reader.readLine());
        }
    }
}
