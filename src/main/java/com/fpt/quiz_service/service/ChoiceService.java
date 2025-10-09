package com.fpt.quiz_service.service;

import com.fpt.quiz_service.dto.CreateChoiceRequest;
import com.fpt.quiz_service.dto.UpdateChoiceRequest;
import com.fpt.quiz_service.entity.Choice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface ChoiceService {
    /**
     * feat: get all choices in a question
     * actor: admin, user
     *
     * @param questionId question's identity
     * @return list of choices in a question
     */
    @GetMapping("/questions/{questionId}/choices")
    List<Choice> getAllChoice(@PathVariable UUID questionId);

    /**
     * feat: create a choice in a question
     * actor: admin
     *
     * @param questionId question's identity
     * @param request details of a created choice
     * @return a created choice
     */
    @PostMapping("/questions/{questionId}/choices")
    Choice createChoice(@PathVariable UUID questionId, @RequestBody CreateChoiceRequest request);

    /**
     * feat: update a choice
     * actor: admin
     *
     * @param choiceId choice's identity
     * @param request details of updated choice
     * @return an updated choice
     */
    @PutMapping("/choices/{choiceId}")
    Choice updateChoice(@PathVariable UUID choiceId, @RequestBody UpdateChoiceRequest request);

    /**
     * feat: delete a choice
     * actor: admin
     *
     * @param choiceId choice's identity
     */
    @DeleteMapping("/choices/{choiceId}")
    void deleteChoice(@PathVariable UUID choiceId);
}
