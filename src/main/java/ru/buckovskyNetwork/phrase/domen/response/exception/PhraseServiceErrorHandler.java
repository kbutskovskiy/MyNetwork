package ru.buckovskyNetwork.phrase.domen.response.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.buckovskyNetwork.phrase.domen.response.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.buckovskyNetwork.phrase.domen.response.constant.Errors;
import ru.buckovskyNetwork.phrase.domen.response.Error;



@ControllerAdvice
@Slf4j
public class PhraseServiceErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleErrorException(Exception ex){
        ex.printStackTrace();
        log.error("internal server error: {}", ex.toString());
        return new ResponseEntity<>(ru.buckovskyNetwork.phrase.domen.response.ErrorResponse.builder().error(Error.builder().code(Errors.INTERNAL_SERVER_ERROR).message("Внутренняя ошибка сервиса").build()).build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ErrorResponse> commonExceptionHandler(CommonException ex){
        log.error("common error: {}", ex.toString());
        return new ResponseEntity<>(ErrorResponse.builder().error(Error.builder().code(ex.getCode()).message(ex.getMessage()).build()).build(),
                ex.getHttpStatus());
    }

}
