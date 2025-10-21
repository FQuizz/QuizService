package com.fpt.quiz_service.dto;

import com.fpt.quiz_service.entity.AnswerResult;
import com.fpt.quiz_service.entity.Attempt;
import com.fpt.quiz_service.entity.Choice;
import com.fpt.quiz_service.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateAnswerRequest {
    private Long point;
    private Integer accuracyFactor;
    private AnswerResult result;
    private Question question;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
    private Attempt attempt;
    private List<Choice> choices;
}
