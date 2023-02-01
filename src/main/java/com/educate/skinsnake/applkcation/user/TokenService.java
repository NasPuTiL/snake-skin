package com.educate.skinsnake.applkcation.user;

import org.springframework.security.core.Authentication;

//@Service
//@AllArgsConstructor
public class TokenService {

//    private final JwtEncoder jwtEncoder;
//    private final SessionProperties sessionProperties;

public String generateToken(Authentication authentication){
//        Instant now = Instant.now();
//        String scope = authentication.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(" "));
//        JwtClaimsSet claims = JwtClaimsSet.builder()
//                .issuer("self")
//                .issuedAt(now)
//                .expiresAt(now.plus(sessionProperties.getSessionExpired(), ChronoUnit.MINUTES))
//                .subject(authentication.getName())
//                .claim("scope", scope)
//                .build();
//        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        return"null";
        }
}
