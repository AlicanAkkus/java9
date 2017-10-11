package com.caysever.java9.concurrent;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletedFeatureTimeoutExample {

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future = doWork("Hello Java9")
                .orTimeout(3, TimeUnit.SECONDS)
                .whenComplete((result, error) -> {
                    if (error == null) {
                        System.out.println("The result is: " + result);
                    } else {
                        System.out.println("Sorry, timeout in " + 3 + " seconds");
                    }
                });

        System.out.println(LocalDateTime.now());
    }

    static CompletableFuture<String> doWork(String s) throws Exception{
        Thread.sleep(5000);
        return CompletableFuture.completedFuture(s);
    }

}
