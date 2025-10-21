package com.fpt.quiz_service.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private boolean success;
    private String message;
    private int code;
    private LocalDateTime timestamp;
}
