package com.fpt.quiz_service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Choice {
    private UUID id;
    private String content;
    private Boolean isCorrect;
}
