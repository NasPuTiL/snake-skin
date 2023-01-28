package com.educate.skinsnake.api.user;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@EqualsAndHashCode
public class JWTResponseDto {
    private String accessToken;
    private String tokenType = "Bearer";
    private String refreshToken;
    private String username;
    private String email;
    private String role;
    private List<String> permissions;
}