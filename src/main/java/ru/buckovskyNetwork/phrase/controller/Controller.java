package ru.buckovskyNetwork.phrase.controller;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.buckovskyNetwork.phrase.domen.api.RegistrationReq;
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

    @PostMapping("/test1")
    public ResponseEntity<Response> test1(){
        log.info("Start endpoint test1 TEST");
        ResponseEntity<Response> response = phraseService.test1();
        log.info("End endpoint test1 TEST: {}", response);
        return response;
    }

    @PostMapping("/test2")
    public ResponseEntity<Response> test2(){
        ResponseEntity<Response> response = phraseService.test2();
        return response;
    }

    @PostMapping("/registration")
    public ResponseEntity<Response> registration(@RequestBody final RegistrationReq req){
        log.info("START endpoint registration: {}", req);
        ResponseEntity<Response> response = phraseService.registration(req);
        log.info("END endpoint registration: {}", req);
        return response;
    }
}
