package com.caysever.java9.http2client;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

import static java.lang.System.out;

public class AsyncHttp2ClientExample {

    public static void main(String[] args) throws Exception {
        URI uri = new URI("https://alicanakkus.github.io");
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request, HttpResponse.BodyHandler.asString());

        Thread.sleep(5000);
        if (response.isDone()) {
            out.println(response.get().statusCode());
            out.println(response.get().version());
            out.println(response.get().body());
        } else {
            response.cancel(true);
            out.println("Request took more than 5 seconds... cancelling.");
        }
    }
}
