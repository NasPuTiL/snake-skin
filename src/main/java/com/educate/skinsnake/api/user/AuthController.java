package com.educate.skinsnake.api.user;

import com.educate.skinsnake.applkcation.user.TokenService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class AuthController {

    private final TokenService tokenService;
    private final AuthenticationManager authentication;

    @ApiOperation(value = "User login endpoint")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The product was not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PostMapping(value = "/login")
    public String generateToken(@RequestBody LoginRequestDto loginRequest) {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        return tokenService.generateToken(authentication.authenticate(auth));
    }

    @ApiOperation(value = "User login endpoint2")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The product was not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PostMapping(value = "/token2")
    public String generateToken2(Authentication authentication) {
        log.debug("Token generation for {}", authentication.getName());
        return tokenService.generateToken(authentication);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER_ROLE')")
    public String test() {
        return "TEST POST";
    }

    @GetMapping(value = "t1")
    public String t1() {
        return "TEST t1";
    }
}
