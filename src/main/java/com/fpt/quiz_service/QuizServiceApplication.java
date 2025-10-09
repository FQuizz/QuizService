package com.fpt.quiz_service;

import com.fpt.quiz_service.entity.Quiz;
import com.fpt.quiz_service.infrastructure.QuestionRepository;
import com.fpt.quiz_service.infrastructure.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.*;

@SpringBootApplication
@RequiredArgsConstructor
@EnableFeignClients
public class QuizServiceApplication implements CommandLineRunner {
	private final QuizRepository quizService;
	private final QuestionRepository questionService;
	public static void main(String[] args) {
		SpringApplication.run(QuizServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Quiz quiz = quizService.getAllQuizzes().stream()
			.filter(q -> Objects.equals(q.getTitle(),"Math"))
			.toList().getFirst();
		System.out.println(questionService.getAllQuestions(quiz.getId()));
	}
}
