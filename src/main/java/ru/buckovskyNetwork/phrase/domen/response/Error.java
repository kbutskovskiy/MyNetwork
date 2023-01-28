package ru.buckovskyNetwork.phrase.domen.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import ru.buckovskyNetwork.phrase.domen.response.constant.Errors;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {

    private Errors code;
    private String message;
}
