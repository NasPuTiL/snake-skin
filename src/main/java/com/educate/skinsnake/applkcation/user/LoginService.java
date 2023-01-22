package com.educate.skinsnake.applkcation.user;

import com.educate.skinsnake.api.user.JWTResponseDto;
import com.educate.skinsnake.api.user.LoginUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginService {
    public JWTResponseDto loginUser(LoginUserDto loginUser) {
        log.info("Login user {}", loginUser.getUsername());
        return JWTResponseDto.builder().build();
    }
}