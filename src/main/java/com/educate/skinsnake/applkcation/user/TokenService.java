package com.educate.skinsnake.applkcation.user;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String generateToken(Authentication authentication) {
        return "";
    }
}
