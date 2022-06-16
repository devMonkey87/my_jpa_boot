package com.example.postgresdemo.mapper;

import com.example.postgresdemo.Utils;
import com.example.postgresdemo.dto.QuestionDTO;
import com.example.postgresdemo.model.Question;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION)
public interface QuestionMapper {

    @Named("toBase64")
    public static String toBase64(byte[] image) {
        return Utils.decodeByteArrayToBase64(image);
    }

    @Mappings({
            @Mapping(source = "image", target = "image", ignore = true)
    })
    Question toModel(QuestionDTO dto, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(target = "image", source = "image", qualifiedByName = "toBase64"),
    })
    QuestionDTO toDto(Question model, @Context CycleAvoidingMappingContext context);
}
