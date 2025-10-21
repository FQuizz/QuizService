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
public class Quiz {
    private Long id;
    private UUID quizId;
    private String title;
    private String description;
    @Builder.Default
    private Integer totalQuestion = 0;
    private Long totalAttempt;
    @Builder.Default
    private Visibility visibility = Visibility.PUBLIC;
    private Long createBy;
    private LocalDateTime createAt;
    private Long modifiedBy;
    private LocalDateTime modifiedAt;
    @Builder.Default
    private Status status = Status.ACTIVE;
}
