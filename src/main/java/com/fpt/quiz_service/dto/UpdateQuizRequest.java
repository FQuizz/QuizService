package com.fpt.quiz_service.dto;

import com.fpt.quiz_service.entity.Visibility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateQuizRequest {
    private String title;
    private String description;
    private Visibility visibility;
}
