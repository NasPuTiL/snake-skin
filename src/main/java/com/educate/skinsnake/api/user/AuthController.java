package com.educate.skinsnake.api.user;

import com.educate.skinsnake.applkcation.user.TokenService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
@AllArgsConstructor
@RequestMapping("token")
public class AuthController {

    private final TokenService tokenService;

    @ApiOperation(value = "User login endpoint")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The product was not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PostMapping(value = "/generate")
    public String generateToken(Authentication authentication) {
        log.debug("Token generation for {}", authentication.getName());
        return tokenService.generateToken(authentication);
    }

    @GetMapping
    public String test() {
        return "PERMITTED!";
    }
}
