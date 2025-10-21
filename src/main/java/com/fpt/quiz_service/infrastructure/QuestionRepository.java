package com.fpt.quiz_service.infrastructure;

import com.fpt.quiz_service.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@FeignClient(name = "questions", url = "http://localhost:8080")
public interface QuestionRepository {
    @GetMapping("/get-all-questions-in-quiz/{id}")
    List<Question> getQuestionsInQuiz(@PathVariable Long id);
    @GetMapping("/get-all-questions/{adminId}")
    List<Question> getAllQuestions(@PathVariable Long adminId);
    @GetMapping("/get-question/{questionId}")
    Optional<Question> getQuestion(@PathVariable UUID questionId);
    @PostMapping("/create-question")
    Optional<Question> createQuestion( @RequestBody Question question);
    @PutMapping("/update-question/{questionId}")
    Optional<Question> updateQuestion(@PathVariable UUID questionId, @RequestBody Question question);
    @DeleteMapping("/delete-question/{questionId}")
    void deleteQuestion(@PathVariable UUID questionId);
}
