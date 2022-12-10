package com.saurabh.webclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class WebClientDemoController {

    @Autowired
    private WebClient.Builder builder;

    @GetMapping("/posts")
    public ResponseEntity<String> getAllPost() {
        String postslst = builder.build()
                .get()
                .uri("https://jsonplaceholder.typicode.com/posts")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return ResponseEntity.ok(postslst);
    }
}
