package com.fpt.quiz_service.service;

import com.fpt.quiz_service.dto.AttemptDto;
import com.fpt.quiz_service.dto.CreateAttemptRequest;
import com.fpt.quiz_service.entity.Attempt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AttemptService {
    /**
     * feat: get all attempts in a quiz
     * actor: user
     *
     * @param quizId quiz's identity
     * @return list of attempts of user
     */
    @GetMapping("/quizzes/{quizId}/attempts")
    List<AttemptDto> getAllAttempts(@PathVariable UUID quizId);

    /**
     * feat: get a given attempt of user
     * actor: user
     *
     * @param attemptId attempt's identity
     * @return a given attempt
     */
    @GetMapping("/attempts/{attemptId}")
    Optional<AttemptDto> getAttempt( @PathVariable UUID attemptId);

    /**
     * feat: create a new attempt
     * actor: user
     *
     * @param quizId quiz's identity
     * @param request details of a created attempt
     * @return a created attempt
     */
    @PostMapping("/quizzes/{quizId}/attempts")
    Optional<AttemptDto> createAttempt(@PathVariable UUID quizId, @RequestBody CreateAttemptRequest request);

    @PutMapping("/attempts/{attemptId}/finish")
    Optional<AttemptDto> finishAttempt(@PathVariable UUID attemptId);
}
