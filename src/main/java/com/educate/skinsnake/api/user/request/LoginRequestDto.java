package com.educate.skinsnake.api.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class LoginRequestDto {
    @NonNull
    @NotEmpty
    private String username;
    @NonNull
    @NotEmpty
    private String password;
}
