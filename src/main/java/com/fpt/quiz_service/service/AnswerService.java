package com.fpt.quiz_service.service;

import com.fpt.quiz_service.dto.AnswerDto;
import com.fpt.quiz_service.dto.CreateAnswerRequest;
import com.fpt.quiz_service.dto.UpdateAnswerRequest;
import com.fpt.quiz_service.entity.Answer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AnswerService {
    /**
     * feat: get all answer in an attempt
     * actor: user
     *
     * @param attemptId attempt's identity
     * @return list of answers user selected in an attempt
     */
    @GetMapping("/attempts/{attemptId}/answers")
    List<Answer> getAllAnswer(@PathVariable UUID attemptId);

    /**
     * feat: get an answer
     * actor: user
     *
     * @param answerId answer's identity
     * @return a given answer
     */
    @GetMapping("/answers/{answerId}")
    Optional<Answer> getAnswer(@PathVariable UUID answerId);

    /**
     * feat: create an answer
     * actor: user
     *
     * @param attemptId attempt's identity
     * @return a created answer
     */
    @PostMapping("/attempts/{attemptId}/answers")
    Optional<AnswerDto> createAnswer(@PathVariable UUID attemptId, @RequestParam UUID questionId, @RequestParam List<UUID> choiceIds);

    /**
     * feat: update an answer
     * actor: user, admin
     * @param answerId answer's identity
     * @param request details of an updated answer
     * @return an updated answer
     */
    @PutMapping("/answers/{answerId}")
    Optional<Answer> updateAnswer(@PathVariable UUID answerId, @RequestBody UpdateAnswerRequest request);

    /**
     * feat: delete an answer
     * actor: user, admin
     *
     * @param answerId answer's identity
     */
    @DeleteMapping("/answers/{answerId}")
    void deleteAnswer(@PathVariable UUID answerId);
}
