package com.fpt.quiz_service.service.impl;

import com.fpt.quiz_service.dto.CreateQuestionRequest;
import com.fpt.quiz_service.dto.UpdateQuestionRequest;
import com.fpt.quiz_service.entity.Question;
import com.fpt.quiz_service.infrastructure.QuestionRepository;
import com.fpt.quiz_service.mapper.QuestionMapper;
import com.fpt.quiz_service.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ResponseBody
@RestController
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    @Override
    public List<Question> getAllQuestionByAdmin(Long adminId) {
        return questionRepository.getAllQuestions(adminId);
    }

    @Override
    public Question getQuestion(UUID questionId) {
        return questionRepository.getQuestion(questionId).get();
    }

    @Override
    public Optional<Question> createQuestion(Long adminId, CreateQuestionRequest request) {
        Question question = QuestionMapper.INSTANCE.toCreatedQuestion(request);
        question.setCreateBy(adminId);
        question.setModifiedBy(adminId);
        return questionRepository.createQuestion(question);
    }

    @Override
    public Optional<Question> updateQuestion(UUID questionId, UpdateQuestionRequest request) {
        Question question = QuestionMapper.INSTANCE.toUpdatedQuestion(request);
        return questionRepository.updateQuestion(questionId,question);
    }

    @Override
    public void deleteQuestion(UUID questionId) {
        questionRepository.deleteQuestion(questionId);
    }
}
