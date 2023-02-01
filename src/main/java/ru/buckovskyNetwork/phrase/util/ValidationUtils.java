package ru.buckovskyNetwork.phrase.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.buckovskyNetwork.phrase.domen.response.constant.Errors;
import ru.buckovskyNetwork.phrase.domen.response.exception.CommonException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class ValidationUtils {
    private final Validator validator;



    public <T> void validationRequest(T req){

        if (req != null){
            Set<ConstraintViolation<T>> result = validator.validate(req);
            if(!result.isEmpty()) {
                String resultValidations = result.stream().map(ConstraintViolation::getMessage)
                        .reduce((s1, s2) -> s1 + ". " + s2).orElse("");
                log.error("Переданный в запросе json не валиден: {}", resultValidations);
                throw CommonException.builder().code(Errors.REQUEST_VALIDATION_ERROR)
                        .message(resultValidations).httpStatus(HttpStatus.BAD_REQUEST).build();
            }
        }
    }
}
