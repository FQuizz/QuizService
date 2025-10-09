package com.fpt.quiz_service;

import com.fpt.quiz_service.dto.UpdateQuizRequest;
import com.fpt.quiz_service.entity.Quiz;
import com.fpt.quiz_service.entity.Visibility;
import com.fpt.quiz_service.infrastructure.QuestionRepository;
import com.fpt.quiz_service.infrastructure.QuizRepository;
import com.fpt.quiz_service.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.*;

@SpringBootApplication
@RequiredArgsConstructor
@EnableFeignClients
public class QuizServiceApplication implements CommandLineRunner{
	private final QuizService quizService;
	public static void main(String[] args) {
		SpringApplication.run(QuizServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		quizService.updateQuiz(1L,UUID.fromString("e8c9a7f2-3f1b-4f2c-a6a3-1e12cbe47475"), UpdateQuizRequest.builder()
			.title("Update Title")
			.visibility(Visibility.PRIVATE)
			.build());
	}
}
