package com.fpt.quiz_service.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlers {
    private final ObjectMapper objectMapper;
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorResponse> handleFeignException(FeignException ex){
        try {
            String body = ex.contentUTF8();
            ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
            return ResponseEntity.status(ex.status()).body(error);
        } catch (Exception parseError) {
            return ResponseEntity
                .status(ex.status())
                .body(ErrorResponse.builder()
                    .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message("Some thing went go wrong, try later")
                    .success(false)
                    .timestamp(LocalDateTime.now())
                    .build());
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationFailed(Exception ex){
        return buildErrorResponse(ex,HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(Exception exception, HttpStatus status) {
        return ResponseEntity
            .status(status)
            .body(
                ErrorResponse.builder()
                    .success(false)
                    .message(exception.getMessage())
                    .code(status.value())
                    .build()
            );
    }
}
