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
    private String userId;
    private String userName;
    private String email;
    private List<String> roles;
    private List<String> permissions;
}