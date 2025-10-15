package com.fpt.quiz_service.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Attempt {
    private UUID id;
    private String username;
    private LocalDateTime startAt;
    private LocalDateTime completeAt;
    private Integer score;
    private List<Answer> answers;
}
