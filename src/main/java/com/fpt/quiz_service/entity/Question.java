package com.fpt.quiz_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    private Long id;
    private UUID questionId;
    private String content;
    @Builder.Default
    private QuestionType questionType = QuestionType.SINGLE_CHOICE;
    private String fact;
    @Builder.Default
    private Integer point = 1;
    @Builder.Default
    private Integer timeLimit = 20;
    private Long createBy;
    private LocalDateTime createAt;
    private Long modifiedBy;
    private LocalDateTime modifiedAt;
    @Builder.Default
    private Status status = Status.ACTIVE;
    List<Choice> choices;
}
