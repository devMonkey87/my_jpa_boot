package com.example.postgresdemo.mapper;

import com.example.postgresdemo.dto.AnswerDTO;
import com.example.postgresdemo.model.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    Answer toModel(AnswerDTO dto);

    AnswerDTO toDto(Answer model);

}
