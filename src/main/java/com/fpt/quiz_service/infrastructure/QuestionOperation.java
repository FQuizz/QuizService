package com.fpt.quiz_service.infrastructure;

import com.fpt.quiz_service.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "questions",url = "http://localhost:8080")
public interface QuestionOperation {
    @GetMapping("/quizzes/{quizId}/questions")
    List<Question> getAllQuestions(@PathVariable UUID quizId);
    @GetMapping("/questions/{questionId}")
    Question getQuestion(@PathVariable UUID questionId);
    @PostMapping("/quizzes/{quizId}/questions")
    Question addQuestion(@PathVariable UUID quizId, @RequestBody Question question);
    @PutMapping("/questions/{questionId}")
    Question editQuestion(@PathVariable UUID questionId, @RequestBody Question question);
    @DeleteMapping("/questions/{questionId}")
    void deleteQuestion(@PathVariable UUID questionId);
}
