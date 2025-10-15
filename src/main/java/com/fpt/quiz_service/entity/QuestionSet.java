package com.fpt.quiz_service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class QuestionSet {
    private Long id;
    private Quiz quiz;
    private Question question;
    private Integer position;
}
