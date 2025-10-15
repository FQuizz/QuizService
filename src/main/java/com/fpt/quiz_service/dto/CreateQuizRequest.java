package com.fpt.quiz_service.dto;

import com.fpt.quiz_service.entity.Visibility;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateQuizRequest {
    @NotBlank
    private String title;
    private String description;
    private Visibility visibility;
}
