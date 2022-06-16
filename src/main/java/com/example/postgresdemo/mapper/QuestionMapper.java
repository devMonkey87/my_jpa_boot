package com.example.postgresdemo.mapper;

import com.example.postgresdemo.Utils;
import com.example.postgresdemo.dto.QuestionDTO;
import com.example.postgresdemo.model.Question;
import jdk.internal.joptsimple.internal.Strings;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Base64;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION)
public interface QuestionMapper {

    Question toModel(QuestionDTO dto, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(target = "image", source = "image", qualifiedByName = "toBase64"),
    })
    QuestionDTO toDto(Question model, @Context CycleAvoidingMappingContext context);

    @Named("toBase64")
    default String toBase64(Question question) {
        return Utils.decodeByteArrayToBase64(question.getImage());
    }
}
