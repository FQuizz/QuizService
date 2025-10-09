package com.fpt.quiz_service.service;

import com.fpt.quiz_service.dto.CreateQuizRequest;
import com.fpt.quiz_service.dto.UpdateQuestionRequest;
import com.fpt.quiz_service.dto.UpdateQuizRequest;
import com.fpt.quiz_service.entity.Quiz;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface QuizService {
    /**
     * feat: get all public quizzes
     * actor: user, admin
     *
     * @return list of quizzes in system
     */
    @GetMapping("/quizzes")
    List<Quiz> getAllQuizzes();

    /**
     * feat: get all quizzes that belong to admin
     * actor: admin
     *
     * @param adminId admin's identity
     * @return list of quizzes that belong to admin
     */
    @GetMapping("/admins/{adminId}/quizzes")
    List<Quiz> getAllQuizByAdminId(@PathVariable Long adminId);

    /**
     * feat: get a public quiz
     * actor: user, admin
     *
     * @param quizId quiz's identity
     * @return a quiz have the given identity
     */
    @GetMapping("/quizzes/{quizId}")
    Quiz getQuizById(@PathVariable UUID quizId);

    /**
     * feat: get a quiz with specific identity
     * actor: admin
     *
     * @param adminId admin's identity
     * @param quizId quiz's identity
     * @return a quiz have the given identity
     */
    @GetMapping("/admins/{adminId}/quizzes/{quizId}")
    Quiz getQuizById(@PathVariable Long adminId, @PathVariable UUID quizId);

    /**
     * feat: create a new quiz
     * actor: admin
     *
     * @param adminId admin's identity
     * @param request details of the quiz
     * @return a created quiz
     */
    @PostMapping("/admins/{adminId}/quizzes")
    Quiz createQuiz(@PathVariable Long adminId, @RequestBody CreateQuizRequest request);

    /**
     * feat: edit details of the quiz
     * actor: admin
     *
     * @param adminId admin's identity
     * @param quizId quiz's identity
     * @param request details of quiz will be updated
     */
    @PutMapping("/admins/{adminId}/quizzes/{quizId}")
    void updateQuiz(@PathVariable Long adminId, @PathVariable UUID quizId, @RequestBody UpdateQuizRequest request);

    /**
     * feat: change a quiz visibility
     * actor: admin
     * @param isPublic state of quiz visibility
     */
    @PatchMapping("/admins/{adminId}/quizzes/{quizId}")
    void changeQuizVisibility(@RequestParam(name = "public") Boolean isPublic);

    /**
     * feat: delete a quiz
     * actor: admin
     * @param adminId admin's identity
     * @param quizId quiz's identity
     */
    @DeleteMapping("/admins/{adminId}/quizzes/{quizId}")
    void deleteQuiz(@PathVariable Long adminId, @PathVariable UUID quizId);
}
