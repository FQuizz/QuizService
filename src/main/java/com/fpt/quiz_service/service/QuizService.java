package com.fpt.quiz_service.service;

import com.fpt.quiz_service.dto.*;
import com.fpt.quiz_service.entity.Quiz;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QuizService {
    /**
     * feat: get all public quizzes
     * actor: user, admin
     *
     * @return list of quizzes in system
     */
    @GetMapping("/quizzes")
    List<QuizDto> getAllQuizzes(@RequestParam(required = false) UUID lastQuizId);

    /**
     * feat: get all quizzes that belong to admin
     * actor: admin
     *
     * @param adminId admin's identity
     * @return list of quizzes that belong to admin
     */
    @GetMapping("/admins/{adminId}/quizzes")
    List<QuizDto> getAllQuizByAdminId(@PathVariable Long adminId);

    @GetMapping("/admins/{adminId}/quizzes/report")
    List<QuizDto> getAllQuizByAdminIdForReport(@PathVariable Long adminId);

    /**
     * feat: get a quiz
     * actor: user, admin
     *
     * @param quizId quiz's identity
     * @return a quiz have the given identity
     */
    @GetMapping("/quizzes/{quizId}")
    Optional<QuizDto> getQuizById(@PathVariable UUID quizId);

    /**
     * feat: add a question to the quiz
     * actor: admin
     *
     * @param quizId quiz's identity
     * @param questionId question's identity
     */
    @PostMapping("/quizzes/{quizId}/questions/{questionId}")
    void addQuestion(@PathVariable UUID quizId, @PathVariable UUID questionId);

    /**
     * feat: create a new quiz
     * actor: admin
     *
     * @param request details of the quiz
     * @return a created quiz
     */

    @PostMapping("/quizzes")
    Optional<QuizDto> createQuiz( @Valid @RequestBody CreateQuizRequest request);

    /**
     * feat: edit details of the quiz
     * actor: admin
     *
     * @param quizId quiz's identity
     * @param request details of quiz will be updated
     */
    @PutMapping("/quizzes/{quizId}")
    Optional<QuizDto> updateQuiz( @PathVariable UUID quizId, @RequestBody UpdateQuizRequest request);

    /**
     * feat: delete a quiz
     * actor: admin
     * @param quizId quiz's identity
     */
    @DeleteMapping("/quizzes/{quizId}")
    void deleteQuiz( @PathVariable UUID quizId);

    @DeleteMapping("/quizzes/{quizId}/questions/{questionId}")
    void deleteQuestionFromQuiz(@PathVariable UUID quizId, @PathVariable UUID questionId);
}
