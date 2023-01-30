package com.educate.skinsnake.applkcation.user.command;

import com.educate.skinsnake.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PACKAGE)
public class CreateTokenCommand {
    private String accessToken;
    private String refreshToken;
    private User user;
}
