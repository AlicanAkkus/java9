package com.caysever.java9.reactive;

import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

public class PublisherExample {

    public static void main(String[] args) {

        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

        MySubscriber mySubscriber = new MySubscriber();
        publisher.subscribe(mySubscriber);

        IntStream.iterate(2, x -> x < 10000, x -> x * x).forEach(publisher::submit);
    }
}
