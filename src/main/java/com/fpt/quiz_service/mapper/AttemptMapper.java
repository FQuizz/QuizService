package com.fpt.quiz_service.mapper;

import com.fpt.quiz_service.dto.AttemptDto;
import com.fpt.quiz_service.dto.CreateAttemptRequest;
import com.fpt.quiz_service.entity.Attempt;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface AttemptMapper {
    AttemptMapper INSTANCE = Mappers.getMapper(AttemptMapper.class);
    AttemptDto toAttemptDto(Attempt attempt);
    Attempt toAttempt(CreateAttemptRequest request);
}
