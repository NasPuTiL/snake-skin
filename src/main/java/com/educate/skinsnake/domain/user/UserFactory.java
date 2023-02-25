package com.educate.skinsnake.domain.user;

import com.educate.skinsnake.applkcation.user.command.CreateNewUserCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserFactory {
    private final UserRepository userRepository;

    @Transactional
    public User createUser(CreateNewUserCommand createUserCommand) {
        User newUser = User.builder()
                .username(createUserCommand.getUserName())
                .password(createUserCommand.getPassword())
                .email(createUserCommand.getEmail())
                .role(createUserCommand.getRole())
                .build();
        return userRepository.save(newUser);
    }
}
