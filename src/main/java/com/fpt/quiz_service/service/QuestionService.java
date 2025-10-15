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
     * feat: get all question by admin
     * actor: admin
     *
     * @param adminId admin's identity
     * @return list of question in a quiz
     */
    @GetMapping("admins/{adminId}/questions")
    List<Question> getAllQuestionByAdmin(@PathVariable Long adminId);

    @PostMapping("/admins/{adminId}/questions/questions")
    Optional<Question> createQuestion(@PathVariable Long adminId, @RequestBody CreateQuestionRequest request);

    /**
     * feat: update a question
     * actor: admin
     *
     * @param questionId question's identity
     * @param request details of the updated question
     * @return the updated question
     */
    @PutMapping("/questions/{questionId}")
    Optional<Question> updateQuestion( @PathVariable UUID questionId, @RequestBody UpdateQuestionRequest request);

    /**
     * feat: delete a question
     * actor: admin
     *
     * @param questionId question's identity
     */
    @DeleteMapping("/questions/{questionId}")
    void deleteQuestion( @PathVariable UUID questionId);
}
