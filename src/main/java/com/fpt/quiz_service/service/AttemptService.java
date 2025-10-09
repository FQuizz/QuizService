package com.fpt.quiz_service.service;

import com.fpt.quiz_service.dto.CreateAttemptRequest;
import com.fpt.quiz_service.entity.Attempt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AttemptService {
    /**
     * feat: get all attempts of user
     * actor: user
     *
     * @param userId user's identity
     * @return list of attempts of user
     */
    @GetMapping("/users/{userId}/attempts")
    List<Attempt> getAllAttempts(@PathVariable Long userId);

    /**
     * feat: get a given attempt of user
     * actor: user
     *
     * @param userId user's identity
     * @param attemptId attempt's identity
     * @return a given attempt
     */
    @GetMapping("/users/{userId}/attempts/{attemptId}")
    Optional<Attempt> getAttempt(@PathVariable Long userId, @PathVariable UUID attemptId);

    /**
     * feat: create a new attempt
     * actor: user
     *
     * @param userId user's identity
     * @param request details of a created attempt
     * @return a created attempt
     */
    @PostMapping("/users/{userId}/attempts")
    Optional<Attempt> createAttempt(@PathVariable Long userId, @RequestBody CreateAttemptRequest request);
}
