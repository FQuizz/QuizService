package com.fpt.quiz_service.mapper;

import com.fpt.quiz_service.dto.CreateQuestionRequest;
import com.fpt.quiz_service.dto.QuestionDto;
import com.fpt.quiz_service.dto.UpdateQuestionRequest;
import com.fpt.quiz_service.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);
    QuestionDto toQuestionDto(Question question);
    Question toCreatedQuestion(CreateQuestionRequest request);
    Question toUpdatedQuestion(UpdateQuestionRequest request);
}
