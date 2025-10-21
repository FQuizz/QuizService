package com.fpt.quiz_service.service.impl;

import com.fpt.quiz_service.dto.CreateQuizRequest;
import com.fpt.quiz_service.dto.QuestionDto;
import com.fpt.quiz_service.dto.QuizDto;
import com.fpt.quiz_service.dto.UpdateQuizRequest;
import com.fpt.quiz_service.entity.Question;
import com.fpt.quiz_service.entity.Quiz;
import com.fpt.quiz_service.infrastructure.QuestionRepository;
import com.fpt.quiz_service.infrastructure.QuizRepository;
import com.fpt.quiz_service.mapper.QuestionMapper;
import com.fpt.quiz_service.mapper.QuizMapper;
import com.fpt.quiz_service.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@ResponseBody
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    @Override
    public List<QuizDto> getAllQuizzes() {
        return quizRepository.getAllPublicQuizzes()
            .stream()
            .map(QuizMapper.INSTANCE::toQuizDto)
            .toList();
    }

    @Override
    public List<QuizDto> getAllQuizByAdminId(Long adminId) {
        return quizRepository.getAllQuizzes(adminId)
            .stream()
            .map(QuizMapper.INSTANCE::toQuizDto)
            .toList();
    }

    @Override
    public Optional<QuizDto> getQuizById(UUID quizId) {
        return quizRepository.getQuizByQuizId(quizId)
            .map(quiz -> {
                QuizDto quizDto = QuizMapper.INSTANCE.toQuizDto(quiz);
                List<QuestionDto> questions =  questionRepository.getQuestionsInQuiz(quiz.getId())
                    .stream()
                    .map(QuestionMapper.INSTANCE::toQuestionDto)
                    .toList();
                quizDto.setQuestions(questions);
                return quizDto;
        });
    }

    @Override
    public void addQuestion(UUID quizId, UUID questionId) {
        quizRepository.addQuestion(quizId,questionId);
    }

    @Override
    public Optional<QuizDto> createQuiz(CreateQuizRequest request) {
        Quiz createdQuiz = QuizMapper.INSTANCE.toCreatedQuiz(request);
        return quizRepository.createQuiz(createdQuiz)
            .map(QuizMapper.INSTANCE::toQuizDto);
    }

    @Override
    public Optional<QuizDto> updateQuiz(UUID quizId, UpdateQuizRequest request) {
        return quizRepository.updateQuiz(quizId,QuizMapper.INSTANCE.toUpdatedQuiz(request))
            .map(QuizMapper.INSTANCE::toQuizDto);
    }

    @Override
    public void deleteQuiz(UUID quizId) {
        quizRepository.deleteQuiz(quizId);
    }
}
