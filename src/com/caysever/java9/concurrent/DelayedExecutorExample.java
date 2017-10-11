package com.caysever.java9.concurrent;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class DelayedExecutorExample {

    public static void main(String[] args) throws Exception {
        Executor executor = CompletableFuture.delayedExecutor(5, TimeUnit.SECONDS);

        CompletableFuture future = new CompletableFuture<>();
        future.completeAsync(() -> "Hello Java9", executor)
                .thenAccept(msg -> System.out.println("accept: " + msg))
                .get();

        System.out.println(LocalDateTime.now());

        future.completeAsync(() -> doWork(), executor)
                .orTimeout(3, TimeUnit.SECONDS)
                .whenComplete((result, error) -> {
                    if (error == null) {
                        System.out.println("The result is: " + result);
                    } else {
                        System.out.println("Sorry, timeout in " + 3 + " seconds");
                    }
                }).get();

        // other statements
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("running outside... " + i + " s");
        }
    }

    private static Object doWork() {
        try {
            System.out.println("inside future: processing data...");

            return "JavaSampleApproach.com";
        } catch (Throwable e) {
            return "not detected";
        }
    }

}
