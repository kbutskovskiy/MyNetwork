package ru.buckovskyNetwork.phrase.service;

import org.springframework.http.ResponseEntity;
import ru.buckovskyNetwork.phrase.domen.response.Response;

public interface PhraseService {
    ResponseEntity<Response> test();
}
