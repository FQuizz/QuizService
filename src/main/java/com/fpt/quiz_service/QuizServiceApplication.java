package com.fpt.quiz_service;

import com.fpt.quiz_service.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.*;

@SpringBootApplication
@RequiredArgsConstructor
@EnableFeignClients(basePackages = "com.fpt.quiz_service.infrastructure")
public class QuizServiceApplication{
	private final QuizService quizService;
	public static void main(String[] args) {
		SpringApplication.run(QuizServiceApplication.class, args);
	}
}
