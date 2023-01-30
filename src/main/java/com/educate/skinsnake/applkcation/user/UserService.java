package com.educate.skinsnake.applkcation.user;

import com.educate.skinsnake.api.user.JWTResponseDto;
import com.educate.skinsnake.api.user.LoginUserDto;
import com.educate.skinsnake.applkcation.user.command.CreateTokenBuilder;
import com.educate.skinsnake.applkcation.user.command.CreateTokenCommand;
import com.educate.skinsnake.domain.Token;
import com.educate.skinsnake.domain.TokenSaver;
import com.educate.skinsnake.domain.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private final TokenSaver tokenSaver;
    private final CreateTokenBuilder createTokenBuilder;

    public JWTResponseDto login(LoginUserDto userDto) {
        log.info("Login user {}.", userDto.getUsername());
        CreateTokenCommand tokenCommand = createTokenBuilder.createTokenCommand(userDto);
        final Token persist = tokenSaver.create(tokenCommand);
        return JWTResponseDto.builder()
                .accessToken(persist.getAccessToken())
                .refreshToken(persist.getRefreshToken())
                .email(Optional.of(persist.getUser())
                        .map(User::getEmail)
                        .orElse(null))
                .username(Optional.of(persist.getUser())
                        .map(User::getUsername)
                        .orElse(null))
                .role(Optional.of(persist.getUser())
                        .map(User::getRole)
                        .orElse(null))
                .permissions(Collections.singletonList("SAMPLE_PERMISSION"))
                .build();
    }
}