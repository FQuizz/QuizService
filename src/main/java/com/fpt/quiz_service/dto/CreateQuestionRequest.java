package com.fpt.quiz_service.dto;

import com.fpt.quiz_service.entity.Choice;
import com.fpt.quiz_service.entity.QuestionType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateQuestionRequest {
    @NotBlank
    private String content;
    private QuestionType questionType;
    private String fact;
    private Integer point;
    private Integer timeLimit;
    private List<Choice> choices;
}
