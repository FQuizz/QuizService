package com.fpt.quiz_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChoiceDto {
    private UUID choiceId;
    private String content;
    private Boolean isCorrect;
}
