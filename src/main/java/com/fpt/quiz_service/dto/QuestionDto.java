package com.fpt.quiz_service.dto;

import com.fpt.quiz_service.entity.Choice;
import com.fpt.quiz_service.entity.QuestionType;
import com.fpt.quiz_service.entity.Status;
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
public class QuestionDto {
    private UUID questionId;
    private String content;
    private QuestionType questionType;
    private String fact;
    private Integer point;
    private Integer timeLimit;
    private Long createBy;
    private LocalDateTime createAt;
    private Long modifiedBy;
    private LocalDateTime modifiedAt;
    private List<ChoiceDto> choices;
}
