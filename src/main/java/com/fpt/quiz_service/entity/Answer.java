package com.fpt.quiz_service.entity;

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
public class Answer {
    private Long id;
    private UUID answerId;
    private Long point;
    private Integer accuracyFactor;
    private AnswerResult result;
    private UUID question;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
    private Attempt attempt;
    private List<Choice> choices;
}
