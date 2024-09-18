package com.jovicruz.points_of_interest.dtos.auth;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class authenticationDTO {
    @NotEmpty
    @NotNull
    private String login;
    @NotEmpty
    @NotNull
    private String password;


}
