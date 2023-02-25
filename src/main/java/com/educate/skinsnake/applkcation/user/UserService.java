package com.educate.skinsnake.applkcation.user;

import com.educate.skinsnake.api.user.request.LoginRequestDto;
import com.educate.skinsnake.api.user.request.RegisterUserDto;
import com.educate.skinsnake.applkcation.user.command.CreateNewUserCommand;
import com.educate.skinsnake.applkcation.user.command.UserCommandBuilder;
import com.educate.skinsnake.domain.user.User;
import com.educate.skinsnake.domain.user.UserFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private final JwtEncoder jwtEncoder;
    private final SessionProperties sessionProperties;
    private final AuthenticationManager authentication;
    private final UserCommandBuilder userCommandBuilder;
    private final UserFactory userFactory;

    public String generateToken(LoginRequestDto loginRequest) {
        log.debug("Token generation for {}", loginRequest.getUsername());
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authenticate = authentication.authenticate(auth);
        return generateToken(authenticate);
    }

    @Transactional
    public String registerUser(RegisterUserDto registerUserDto) {
        log.info("Creating user {}", registerUserDto.getUsername());
        CreateNewUserCommand createNewUserCommand = userCommandBuilder.buildCreateNewUserCommand(registerUserDto);
        User user = userFactory.createUser(createNewUserCommand);
        log.debug("New user created {}.", user.getUsername());

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(registerUserDto.getUsername(), registerUserDto.getPassword());
        Authentication authenticate = authentication.authenticate(auth);
        return generateToken(authenticate);
    }

    private String generateToken(Authentication authenticate) {
        log.debug("Generating token for {}.", authenticate.getName());
        Instant now = Instant.now();
        String scope = authenticate.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(sessionProperties.getSessionExpired(), ChronoUnit.MINUTES))
                .subject(authenticate.getName())
                .claim("scope", scope)
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
