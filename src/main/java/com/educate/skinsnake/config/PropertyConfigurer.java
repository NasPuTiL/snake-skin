package com.educate.skinsnake.config;

import com.educate.skinsnake.applkcation.user.SessionProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfigurer {

    @Bean
    @ConfigurationProperties("skin-snake")
    SessionProperties sessionProperties() {
        return new SessionProperties();
    }

    @Bean
    @ConfigurationProperties("rsa")
    RsaKeyProperties rsaKeyProperties() {
        return new RsaKeyProperties();
    }
}
