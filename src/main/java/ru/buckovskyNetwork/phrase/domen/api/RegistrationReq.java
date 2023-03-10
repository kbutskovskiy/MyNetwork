package ru.buckovskyNetwork.phrase.domen.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationReq {

    @NotBlank(message = "nickname должен быть заполнен")
    @Pattern(regexp = "^[a-zA-Z0-9а-яА-Я. _-]{4,15}$", message = "Некорректный никнейм")
    private String nickname;

    @NotBlank(message = "password должен быть заполнен")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я0-9.,:; _?@]{8,100}$", message = "Некорректный password")
    private String password;
}
