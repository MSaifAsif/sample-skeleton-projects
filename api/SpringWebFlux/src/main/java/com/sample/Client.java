package com.sample;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author saifasif
 */
public class Client {

    private final WebClient client = WebClient.create("http://localhost:8080");

    private final Mono<ClientResponse> result = client.get()
            .uri("/handle")
            .accept(MediaType.TEXT_PLAIN)
            .exchange();

    public String getResult() {
        return "\t(res) >> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
    }
}
