package com.fpt.quiz_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fpt.quiz_service.entity.Status;
import com.fpt.quiz_service.entity.Visibility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizDto {
    private UUID quizId;
    private String title;
    private String description;
    private Integer totalQuestion;
    private Long totalAttempt;
    private Visibility visibility;
    private Long createBy;
    private LocalDateTime createAt;
    private Long modifiedBy;
    private LocalDateTime modifiedAt;
    private List<QuestionDto> questions;
}
