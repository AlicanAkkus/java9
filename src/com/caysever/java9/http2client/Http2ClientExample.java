package com.caysever.java9.http2client;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;

import static java.lang.System.out;

public class Http2ClientExample {

    public static void main(String[] args) throws Exception {
        URI uri = new URI("https://alicanakkus.github.io");
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandler.asString());

        out.println(response.statusCode());
        out.println(response.version());
        out.println(response.body());


    }
}
