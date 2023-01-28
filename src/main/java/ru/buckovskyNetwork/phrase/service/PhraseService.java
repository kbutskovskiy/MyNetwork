package ru.buckovskyNetwork.phrase.service;

import org.springframework.http.ResponseEntity;
import ru.buckovskyNetwork.phrase.domen.response.Response;

public interface PhraseService {
    ResponseEntity<Response> test();
    ResponseEntity<Response> test1();
    ResponseEntity<Response> test2();
}
