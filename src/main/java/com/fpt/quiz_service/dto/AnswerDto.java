package com.fpt.quiz_service.dto;

import com.fpt.quiz_service.entity.AnswerResult;
import com.fpt.quiz_service.entity.Attempt;
import com.fpt.quiz_service.entity.Choice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@Builder
public class AnswerDto {
    private UUID answerId;
    private Long point;
    private Integer accuracyFactor;
    private AnswerResult result;
    private UUID question;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
    private List<UUID> correctChoices;
    private List<Choice> choices;
}
