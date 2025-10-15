package com.fpt.quiz_service.mapper;

import com.fpt.quiz_service.dto.CreateQuizRequest;
import com.fpt.quiz_service.dto.QuizDto;
import com.fpt.quiz_service.dto.UpdateQuizRequest;
import com.fpt.quiz_service.entity.Quiz;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuizMapper {

    QuizMapper INSTANCE = Mappers.getMapper(QuizMapper.class);

    QuizDto toQuizDto(Quiz quiz);
    Quiz toCreatedQuiz(CreateQuizRequest request);
    Quiz toUpdatedQuiz(UpdateQuizRequest request);
}
