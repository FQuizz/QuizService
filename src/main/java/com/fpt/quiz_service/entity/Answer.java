package com.fpt.quiz_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    private UUID id;
    private Question question;
    private List<Choice> choices;
    private LocalDateTime answerAt;
    private Attempt attempt;
}
