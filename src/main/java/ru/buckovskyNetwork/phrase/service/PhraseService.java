package ru.buckovskyNetwork.phrase.service;

import org.springframework.http.ResponseEntity;
import ru.buckovskyNetwork.phrase.domen.api.RegistrationReq;
import ru.buckovskyNetwork.phrase.domen.response.Response;

public interface PhraseService {
    ResponseEntity<Response> test();
    ResponseEntity<Response> test1();
    ResponseEntity<Response> test2();
    ResponseEntity<Response> registration(RegistrationReq req);
}
