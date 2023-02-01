package ru.buckovskyNetwork.phrase.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.buckovskyNetwork.phrase.util.ValidationUtils;
import ru.buckovskyNetwork.phrase.domen.api.RegistrationReq;
import ru.buckovskyNetwork.phrase.domen.response.ErrorResponse;
import ru.buckovskyNetwork.phrase.domen.response.Response;
import ru.buckovskyNetwork.phrase.domen.response.Error;
import ru.buckovskyNetwork.phrase.domen.response.SuccessResponse;
import ru.buckovskyNetwork.phrase.domen.response.constant.Errors;
import ru.buckovskyNetwork.phrase.domen.response.exception.CommonException;
import ru.buckovskyNetwork.phrase.service.PhraseService;

@Slf4j
@Service
@RequiredArgsConstructor
public class PhraseServiceImpl implements PhraseService {
    @Override
    public ResponseEntity<Response> test(){
        return new ResponseEntity<>(SuccessResponse.builder().data("тест на хороший ответ пройден").build(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> test1(){
        return new ResponseEntity<>(ErrorResponse.builder().error(Error.builder().code(Errors.TEST).message("Тест на плохой ответ пройден").build()).build(),
                HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Response> test2(){
        throw CommonException.builder().code(Errors.TEST).message("Тест на обработку исключений пройден").httpStatus(HttpStatus.BAD_REQUEST).build();
    }

    private final ValidationUtils validationUtils;

    @Override
    public ResponseEntity<Response> registration(RegistrationReq req){

        validationUtils.validationRequest(req);
        return new ResponseEntity<Response>((SuccessResponse.builder().data("Всё отлично, валидация прошла успешно").build()), HttpStatus.OK);
    }
}
