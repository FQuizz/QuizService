package com.fpt.quiz_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Choice {
    private Long id;
    private UUID choiceId;
    private String content;
    private Boolean isCorrect;
    @JsonIgnore
    private Question question;
    @JsonIgnore
    private List<Answer> answers;
}
