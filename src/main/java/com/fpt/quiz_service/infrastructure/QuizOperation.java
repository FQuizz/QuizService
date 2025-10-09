package com.fpt.quiz_service.infrastructure;

import com.fpt.quiz_service.entity.Quiz;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@ResponseBody
@FeignClient(name = "quizzes", url = "http://localhost:8080")
public interface QuizOperation {
    @GetMapping("/quizzes")
    List<Quiz> getAllQuizzes();
    @GetMapping("/quizzes/{quizId}")
    Quiz getQuizById(@PathVariable  UUID quizId);
    @PostMapping("/quizzes")
    Quiz createQuiz(@RequestBody Quiz quiz);
    @PutMapping("/quizzes/{quizId}")
    Quiz editQuiz(@PathVariable UUID quizId, @RequestBody Quiz quiz);
    @DeleteMapping("/quizzes/{quizId}")
    void deleteQuizById(@PathVariable UUID quizId);
}
