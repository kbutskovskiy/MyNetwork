package ru.buckovskyNetwork.phrase.domen.response.exception;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import ru.buckovskyNetwork.phrase.domen.response.constant.Errors;


@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class CommonException extends RuntimeException{
    private final Errors code;
    private final String message;
    private final HttpStatus httpStatus;
}
