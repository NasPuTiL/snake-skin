package com.educate.skinsnake.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrorResponseDto> handleConstraintDeclarationException(ConstraintViolationException exception) {
        log.error(exception.getMessage());
        return buildApiErrorRepose(exception, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity buildApiErrorRepose(Exception ex, HttpStatus status) {
        return new ResponseEntity<>(ApiErrorResponseDto.builder()
                .message(ex.getMessage())
                .status(status)
                .error(status.value())
                .date(LocalDateTime.now().toString())
                .build(), status);
    }
}