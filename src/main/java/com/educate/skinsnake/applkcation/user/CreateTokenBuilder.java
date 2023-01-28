package com.educate.skinsnake.applkcation.user;

import com.educate.skinsnake.api.user.LoginUserDto;
import com.educate.skinsnake.domain.User;
import com.educate.skinsnake.domain.UserRepository;
import com.educate.skinsnake.exception.SkinSnakeException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@AllArgsConstructor
public class CreateTokenBuilder {
    //    private final JWTUtils jwtUtils;
    private final UserRepository userRepository;

    public CreateTokenCommand createTokenCommand(LoginUserDto userDto) {
        return null;
//        User user = findUserByUserName(userDto.getUsername());
//        List<GrantedAuthority> authorityList = Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
//        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), authorityList);
//        SecurityContextHolder.getContext().setAuthentication(authToken);
//        String token = jwtUtils.generateToken(userDto.getUsername());
//        return CreateTokenCommand.builder()
//                .accessToken(token)
//                .refreshToken(generateRefreshToken())
//                .user(user)
//                .build();
    }

    private String generateRefreshToken() {
        return UUID.randomUUID().toString().replace("-", Strings.EMPTY);
    }

    private User findUserByUserName(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> {
            log.error("User with username {} not exists", username);
            return new SkinSnakeException("Permission Denied", HttpStatus.UNAUTHORIZED);
        });
    }
}
