package com.example.postgresdemo.mapper;

import com.example.postgresdemo.dto.AnswerDTO;
import com.example.postgresdemo.dto.QuestionDTO;
import com.example.postgresdemo.model.Answer;
import com.example.postgresdemo.model.Question;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION)

public interface QuestionMapper {

    Question toModel(QuestionDTO dto, @Context CycleAvoidingMappingContext context);
    QuestionDTO toDto(Question model, @Context CycleAvoidingMappingContext context);

}
