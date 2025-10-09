package com.fpt.quiz_service.service;

import com.fpt.quiz_service.dto.CreateQuestionRequest;
import com.fpt.quiz_service.dto.UpdateQuestionRequest;
import com.fpt.quiz_service.entity.Question;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QuestionService {
    /**
     * feat: get all question in a quiz by admin
     * actor: admin
     *
     * @param quizId quiz's identity
     * @param adminId admin's identity
     * @return list of question in a quiz
     */
    @GetMapping("admins/{adminId}/quizzes/{quizId}/questions")
    List<Question> getAllQuestionByAdmin(@PathVariable Long adminId, @PathVariable UUID quizId);

    /**
     * feat: get all question in a quiz by user
     * actor: user
     *
     * @param userId user's identity
     * @param attemptId attempt's identity
     * @return list of question in a quiz
     */
    @GetMapping("users/{userId}/attempts/{attemptId}/questions")
    List<Question> getAllQuestionByUser(@PathVariable Long userId, @PathVariable UUID attemptId);

    /**
     * feat: get a question with given id in a quiz by admin
     * actor: admin
     *
     * @param adminId admin's identity
     * @param questionId question's identity
     * @return a question with given id in a quiz
     */
    @GetMapping("admins/{adminId}/questions/{questionId}")
    Optional<Question> getQuestionByAdmin(@PathVariable Long adminId, @PathVariable UUID questionId);

    /**
     * feat: get a question with given id in a quiz by user
     * actor: user
     *
     * @param userId user's identity
     * @param attemptId attempt's identity
     * @param questionId question's identity
     * @return a question with given id in a quiz
     */
    @GetMapping("users/{userId}/attempts/{attemptId}/questions/{questionId}")
    Optional<Question> getQuestionByUser(@PathVariable Long userId, @PathVariable UUID attemptId, @PathVariable UUID questionId);

    /**
     * feat: create a new question
     * actor: admin
     *
     * @param adminId admin's identity
     * @param request details of created question
     * @return a created question
     */
    @PostMapping("/admin/{adminId}/questions")
    Question createQuestion(@PathVariable Long adminId, @RequestBody CreateQuestionRequest request);

    /**
     * feat: update a question
     * actor: admin
     *
     * @param adminId admin's identity
     * @param questionId question's identity
     * @param request details of the updated question
     * @return the updated question
     */
    @PutMapping("/admin/{adminId}/questions/{questionId}")
    Question updateQuestion(@PathVariable Long adminId, @PathVariable UUID questionId, @RequestBody UpdateQuestionRequest request);

    /**
     * feat: delete a question
     * actor: admin
     *
     * @param adminId admin's identity
     * @param questionId question's identity
     */
    @DeleteMapping("/admin/{adminId}/questions/{questionId}")
    void deleteQuestion(@PathVariable Long adminId, @PathVariable UUID questionId);
}
