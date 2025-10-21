package com.fpt.quiz_service.infrastructure;

import com.fpt.quiz_service.dto.CreateAnswerRequest;
import com.fpt.quiz_service.entity.Answer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@FeignClient(name = "answers", url = "http://localhost:8080")
public interface AnswerRepository {
    @GetMapping("/get-answers-in-attempt/{attemptId}")
    List<Answer> getAllAnswerInAttempt(@PathVariable UUID attemptId);
    @PostMapping("submit-answer/{attemptId}")
    Optional<Answer> submitAnswer(@PathVariable UUID attemptId, @RequestBody CreateAnswerRequest answer);
}
