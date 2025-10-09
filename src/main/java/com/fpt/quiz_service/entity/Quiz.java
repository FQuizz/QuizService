package com.fpt.quiz_service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quiz {
    private UUID id;
    private String title;
    private String description;
    private Visibility visibility;
    private Long createBy;
    private LocalDateTime createAt;
}
