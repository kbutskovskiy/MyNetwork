package ru.buckovskyNetwork.phrase.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.buckovskyNetwork.phrase.domen.response.ErrorResponse;
import ru.buckovskyNetwork.phrase.domen.response.Response;
import ru.buckovskyNetwork.phrase.domen.response.Error;
import ru.buckovskyNetwork.phrase.service.PhraseService;

@Slf4j
@Service
@RequiredArgsConstructor
public class PhraseServiceImpl implements PhraseService {
    @Override
    public ResponseEntity<Response> test(){
        return new ResponseEntity<>(ErrorResponse.builder().error(Error.builder().code("VALIDATION_ERROR").message("Я люблю Катюшу").build()).build(),
                HttpStatus.BAD_REQUEST);
    }
}
