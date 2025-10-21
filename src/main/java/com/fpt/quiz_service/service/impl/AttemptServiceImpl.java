package com.fpt.quiz_service.service.impl;

import com.fpt.quiz_service.dto.AttemptDto;
import com.fpt.quiz_service.dto.CreateAttemptRequest;
import com.fpt.quiz_service.entity.Attempt;
import com.fpt.quiz_service.infrastructure.AttemptRepository;
import com.fpt.quiz_service.mapper.AttemptMapper;
import com.fpt.quiz_service.service.AttemptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RestController
@RequiredArgsConstructor
public class AttemptServiceImpl implements AttemptService {
    private final AttemptRepository attemptRepository;
    @Override
    public List<AttemptDto> getAllAttempts(UUID quizId) {
        return attemptRepository.getAllAttempt(quizId)
            .stream()
            .map(AttemptMapper.INSTANCE::toAttemptDto)
            .toList();
    }

    @Override
    public Optional<AttemptDto> getAttempt(UUID attemptId) {
        return attemptRepository.getAttempt(attemptId)
            .map(AttemptMapper.INSTANCE::toAttemptDto);
    }

    @Override
    public Optional<AttemptDto> createAttempt(UUID quizId, CreateAttemptRequest request) {
        return attemptRepository.createAttempt(quizId,AttemptMapper.INSTANCE.toAttempt(request))
            .map(AttemptMapper.INSTANCE::toAttemptDto);
    }

    @Override
    public Optional<AttemptDto> finishAttempt(UUID attemptId) {
        return attemptRepository.finishAttempt(attemptId)
            .map(AttemptMapper.INSTANCE::toAttemptDto);
    }
}
