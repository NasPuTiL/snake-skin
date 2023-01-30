package com.educate.skinsnake;

import com.educate.skinsnake.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class SkinSnakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkinSnakeApplication.class, args);
	}

}
