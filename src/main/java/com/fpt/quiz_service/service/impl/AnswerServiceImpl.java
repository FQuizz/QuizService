package com.fpt.quiz_service.service.impl;

import com.fpt.quiz_service.dto.CreateAnswerRequest;
import com.fpt.quiz_service.dto.UpdateAnswerRequest;
import com.fpt.quiz_service.entity.*;
import com.fpt.quiz_service.infrastructure.AnswerRepository;
import com.fpt.quiz_service.infrastructure.QuestionRepository;
import com.fpt.quiz_service.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


record AnswerCalculateResult( Long point, Integer accuracyFactor, AnswerResult result){
    public static AnswerCalculateResult calculate(Question question,List<UUID> correctChoiceIds, List<UUID> userChoiceIds){
        long totalPoint = 0L;
        int countCorrectAnswer = 0;
        for(UUID correctChoiceId : correctChoiceIds) {
            if (userChoiceIds.contains(correctChoiceId)) {
                totalPoint += question.getPoint();
                countCorrectAnswer++;
            }
        }
        AnswerResult result;
        int accuracyFactor = Math.round((float)countCorrectAnswer / correctChoiceIds.size() * 100);
        switch (accuracyFactor){
            case 100:
                result = AnswerResult.CORRECT;
                break;
            case 0:
                result = AnswerResult.IN_CORRECT;
                break;
            default:
                result = AnswerResult.PARTIAL_CORRECT;
                break;
        }
        return new AnswerCalculateResult(accuracyFactor * totalPoint,accuracyFactor,result);
    }
}

@RestController
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    @Override
    public List<Answer> getAllAnswer(UUID attemptId) {
        return List.of();
    }

    @Override
    public Optional<Answer> getAnswer(UUID answerId) {
        return Optional.empty();
    }

    @Override
    public Optional<Answer> createAnswer( UUID attemptId,  UUID questionId,  List<UUID> choiceIds) {
        // Check if question exists
        Optional<Question> optionalQuestion = questionRepository.getQuestion(questionId);
        if (optionalQuestion.isEmpty()) return Optional.empty();
        Question question = optionalQuestion.get();

        // Precompute all choices & their IDs
        List<Choice> allChoices = question.getChoices();
        List<UUID> validChoiceIds = allChoices.stream()
            .map(Choice::getChoiceId)
            .toList();

        // Validate selected choices
        if (!validChoiceIds.containsAll(choiceIds)) return Optional.empty();

        // Compute correct choices
        List<UUID> correctChoiceIds = allChoices.stream()
            .filter(Choice::getIsCorrect)
            .map(Choice::getChoiceId)
            .toList();

        // Calculate result
        AnswerCalculateResult calculateResult = AnswerCalculateResult.calculate(
            question, correctChoiceIds, choiceIds
        );

        // Filter selected choices
        List<Choice> selectedChoices = allChoices.stream()
            .filter(c -> choiceIds.contains(c.getChoiceId()))
            .toList();

        // Submit answer
        return answerRepository.submitAnswer(
            attemptId,
            CreateAnswerRequest.builder()
                .point(calculateResult.point())
                .accuracyFactor(calculateResult.accuracyFactor())
                .result(calculateResult.result())
                .question(question)
                .choices(selectedChoices)
                .build()
        );
    }

    @Override
    public Optional<Answer> updateAnswer(UUID answerId, UpdateAnswerRequest request) {
        return Optional.empty();
    }

    @Override
    public void deleteAnswer(UUID answerId) {

    }
}
