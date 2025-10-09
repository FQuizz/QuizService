package com.fpt.quiz_service.service.impl;

import com.fpt.quiz_service.dto.CreateQuizRequest;
import com.fpt.quiz_service.dto.UpdateQuizRequest;
import com.fpt.quiz_service.entity.Quiz;
import com.fpt.quiz_service.service.QuizService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@ResponseBody
public class QuizServiceImpl implements QuizService {

    @Override
    public List<Quiz> getAllQuizzes() {
        return List.of();
    }

    @Override
    public List<Quiz> getAllQuizByAdminId(Long adminId) {
        return List.of();
    }

    @Override
    public Quiz getQuizById(Long adminId, UUID quizId) {
        return null;
    }

    @Override
    public Quiz createQuiz(Long adminId, CreateQuizRequest request) {
        return null;
    }

    @Override
    public Quiz updateQuiz(Long adminId, UUID quizId, UpdateQuizRequest request) {
        return null;
    }

    @Override
    public void changeQuizVisibility(Boolean isPublic) {

    }

    @Override
    public void deleteQuiz(Long adminId, UUID quizId) {

    }
}
