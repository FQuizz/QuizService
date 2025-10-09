package com.fpt.quiz_service.infrastructure;

import com.fpt.quiz_service.entity.Choice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface ChoiceOperation {
    @GetMapping("/questions/{questionId}/choices")
    List<Choice> getAllChoices(@PathVariable UUID questionId);
    @PostMapping("/questions/{questionId}/choices")
    Choice addChoice(@PathVariable UUID questionId, @RequestBody Choice choice);
    @PutMapping("/choices/{choiceId}")
    Choice editChoice(@PathVariable UUID choiceId, @RequestBody Choice choice);
    @DeleteMapping("/choices/{choicesId}")
    void deleteChoice(@PathVariable  UUID choiceId);
}
