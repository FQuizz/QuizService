package com.fpt.quiz_service.dto;

import com.fpt.quiz_service.entity.Answer;
import com.fpt.quiz_service.entity.AttemptStatus;
import com.fpt.quiz_service.entity.Quiz;
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
public class AttemptDto {
    private Long id;
    private UUID attemptId;
    private String username;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
    private AttemptStatus attemptStatus;
    private LocalDateTime completeAt;
    private Long score;
    private List<Answer> answers;
}
