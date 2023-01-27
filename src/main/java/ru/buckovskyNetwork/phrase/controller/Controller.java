package ru.buckovskyNetwork.phrase.controller;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.buckovskyNetwork.phrase.domen.response.Response;
import ru.buckovskyNetwork.phrase.service.PhraseService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("phrase-service-public")
public class Controller {
    private final PhraseService phraseService;

    @GetMapping("/hello")
    public String hello(){
        String hello = "Hello, it's my network!";
        log.info(hello);
        return hello;
    }

    @PostMapping("/test")
    public ResponseEntity<Response> test(){
        log.info("Start endpoint TEST");
        ResponseEntity<Response> response = phraseService.test();
        log.info("End endpoint TEST: {}", response);
        return response;
    }
}
