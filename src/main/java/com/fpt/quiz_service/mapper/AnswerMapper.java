package com.fpt.quiz_service.mapper;

import com.fpt.quiz_service.dto.AnswerDto;
import com.fpt.quiz_service.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);
    @Mapping(target = "correctChoices",ignore = true)
    AnswerDto toAnswerDto(Answer answer);
}
