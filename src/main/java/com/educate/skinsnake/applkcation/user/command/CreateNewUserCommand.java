package com.educate.skinsnake.applkcation.user.command;

import com.educate.skinsnake.domain.user.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateNewUserCommand {
    private String userName;
    private String password;
    private String email;
    private Role role;

}
