package com.educate.skinsnake.api.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@EqualsAndHashCode
public class LoginUserDto {
    @NotNull
    @NotEmpty(message = "username must be set")
    private String username;
    @NotNull
    @NotEmpty(message = "Password must be set")
    private String password;
}