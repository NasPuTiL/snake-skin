package com.educate.skinsnake.domain;

import com.educate.skinsnake.applkcation.user.CreateTokenCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
@AllArgsConstructor
public class TokenSaver {
    private final TokenRepository tokenRepository;

    public Token create(@NotNull CreateTokenCommand createTokenCommand) {
        return tokenRepository.save(Token.builder()
                .accessToken(createTokenCommand.getAccessToken())
                .refreshToken(createTokenCommand.getRefreshToken())
                .user(createTokenCommand.getUser())
                .build());
    }
}
