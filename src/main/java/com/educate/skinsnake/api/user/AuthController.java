package com.educate.skinsnake.api.user;

import com.educate.skinsnake.api.user.request.LoginRequestDto;
import com.educate.skinsnake.api.user.request.RegisterUserDto;
import com.educate.skinsnake.applkcation.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth")
@Api("Authentication controller")
public class AuthController {
    private final UserService userService;

    @ApiOperation(value = "User login endpoint")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The product was not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PostMapping(value = "/login")
    public String generateToken(@Valid @RequestBody LoginRequestDto loginRequest) {
        return userService.generateToken(loginRequest);
    }

    @ApiOperation(value = "User login endpoint")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The product was not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PostMapping(value = "/register")
    public String register(@Valid @RequestBody RegisterUserDto registerUserDto) {
        return userService.registerUser(registerUserDto);
    }
}




