package com.fpt.quiz_service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    private UUID id;
    private String content;
    private Boolean isActive;
    private QuestionType questionType;
    private Integer questionPosition;
    private List<Choice> choices;
}
