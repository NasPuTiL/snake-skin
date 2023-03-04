package com.educate.skinsnake.exception;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder(access = AccessLevel.PACKAGE)
public class ApiErrorResponseDto {
    private HttpStatus status;
    private String message;
    private Integer error;
    private String date;
}