package com.example.postgresdemo.mapper;

import com.example.postgresdemo.dto.AnswerDTO;
import com.example.postgresdemo.dto.QuestionDTO;
import com.example.postgresdemo.model.Answer;
import com.example.postgresdemo.model.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Question toModel(QuestionDTO dto);
    QuestionDTO toDto(Question model);

}
