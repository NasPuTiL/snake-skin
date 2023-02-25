package com.educate.skinsnake.applkcation.user.command;

import com.educate.skinsnake.api.user.request.RegisterUserDto;
import com.educate.skinsnake.domain.user.Role;
import com.educate.skinsnake.domain.user.RoleRepository;
import com.educate.skinsnake.exception.SkinSnakeException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserCommandBuilder {
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateNewUserCommand buildCreateNewUserCommand(RegisterUserDto registerUser) {
        return CreateNewUserCommand.builder()
                .userName(registerUser.getUsername())
                .password(encodePassword(registerUser.getPassword()))
                .email(registerUser.getEmail())
                .role(findRoleByRoleNme(registerUser.getRoleName()))
                .build();
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    private Role findRoleByRoleNme(String roleName) {
        return roleRepository.findRoleByName(roleName).orElseThrow(() -> {
            log.error("Role with name {} not exists.", roleName);
            return new SkinSnakeException("Selected role not exists.", HttpStatus.BAD_REQUEST);
        });
    }
}
