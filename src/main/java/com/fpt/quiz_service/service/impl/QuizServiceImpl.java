package com.fpt.quiz_service.service.impl;

import com.fpt.quiz_service.dto.CreateQuizRequest;
import com.fpt.quiz_service.dto.UpdateQuizRequest;
import com.fpt.quiz_service.entity.Quiz;
import com.fpt.quiz_service.entity.Visibility;
import com.fpt.quiz_service.infrastructure.QuizRepository;
import com.fpt.quiz_service.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@ResponseBody
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;
    @Override
    public List<Quiz> getAllQuizzes() {
        return quizRepository.getAllPublicQuiz();
    }

    @Override
    public List<Quiz> getAllQuizByAdminId(Long adminId) {
        return quizRepository.getAllQuizByAdminId(adminId);
    }

    @Override
    public Quiz getQuizById(UUID quizId) {
        return Optional.ofNullable(quizRepository.getQuizById(quizId)).orElse(null);
    }

    @Override
    public Quiz getQuizById(Long adminId, UUID quizId) {
        return Optional.ofNullable(quizRepository.getQuizById(adminId,quizId)).orElse(null);
    }

    @Override
    public Quiz createQuiz(Long adminId, CreateQuizRequest request) {
        return quizRepository.createQuiz(Quiz.builder()
                .id(UUID.randomUUID())
                .title(request.getTitle())
                .description(request.getDescription())
                .visibility(Optional.ofNullable(request.getVisibility()).orElse(Visibility.PUBLIC))
                .createBy(adminId)
                .createAt(LocalDateTime.now())
            .build());
    }

    @Override
    public void updateQuiz(Long adminId, UUID quizId, UpdateQuizRequest request) {
        Optional.ofNullable(quizRepository.getQuizById(adminId,quizId)).ifPresent(quiz -> {
            Optional.ofNullable(request.getTitle()).ifPresent(quiz::setTitle);
            Optional.ofNullable(request.getDescription()).ifPresent(quiz::setDescription);
            Optional.ofNullable(request.getVisibility()).ifPresent(quiz::setVisibility);
            quizRepository.editQuiz(quizId,quiz);
        });
    }

    @Override
    public void changeQuizVisibility(Boolean isPublic) {

    }

    @Override
    public void deleteQuiz(Long adminId, UUID quizId) {
        Optional.ofNullable(getQuizById(adminId,quizId))
            .ifPresent(quiz -> quizRepository.deleteQuizById(quiz.getId()));
    }
}
