package com.jovicruz.points_of_interest.dtos;

import com.jovicruz.points_of_interest.domain.user.UserRole;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class registerDTO {
    @NotEmpty
    @NotNull
    private String login;
    @NotEmpty
    @NotNull
    private String password;
    private UserRole role;

}
