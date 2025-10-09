package com.fpt.quiz_service.dto;

import com.fpt.quiz_service.entity.Visibility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateQuizRequest {
    private String title;
    private String description;
    private Visibility visibility;
}
