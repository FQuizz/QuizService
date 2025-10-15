package com.fpt.quiz_service.infrastructure;

import com.fpt.quiz_service.entity.Quiz;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@FeignClient(name = "quizzes", url = "http://localhost:8080")
public interface QuizRepository {
    @GetMapping("/get-all-public-quizzes")
    List<Quiz> getAllPublicQuizzes();
    @GetMapping("/get-all-quizzes/{adminId}")
    List<Quiz> getAllQuizzes(@PathVariable Long adminId);
    @GetMapping("/get-quiz-by-quiz-id/{quizId}")
    Optional<Quiz> getQuizByQuizId(@PathVariable UUID quizId);
    @PostMapping("/create-quiz")
    Optional<Quiz> createQuiz(@RequestBody Quiz quiz);
    @PostMapping("/add-question/{quizId}/{questionId}")
    void addQuestion(@PathVariable UUID quizId, @PathVariable UUID questionId);
    @PutMapping("/update-quiz/{quizId}")
    Optional<Quiz> updateQuiz(@PathVariable UUID quizId, @RequestBody Quiz quiz);
    @DeleteMapping("/delete-quiz/{quizId}")
    void deleteQuiz(@PathVariable UUID quizId);
    @DeleteMapping("/delete-question/{quizId}/{questionId}")
    void deleteQuestion(@PathVariable Long quizId, @PathVariable Long questionId);
}
