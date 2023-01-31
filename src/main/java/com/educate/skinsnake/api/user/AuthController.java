package com.educate.skinsnake.api.user;

import com.educate.skinsnake.applkcation.user.TokenService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
public class AuthController {

    private final TokenService tokenService;

    @ApiOperation(value = "User login endpoint")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The product was not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PostMapping(value = "/token")
    public String generateToken(Authentication authentication) {
        String s = tokenService.generateToken(authentication);
        System.out.println("s = " + s);
        return s;
    }


    @ApiOperation(value = "User login endpoint")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The product was not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @GetMapping
    public String test(Principal principal) {
        return "Hello " + principal.getName() + "!";
    }
}
