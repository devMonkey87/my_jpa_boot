package com.example.postgresdemo.mapper;

import com.example.postgresdemo.Utils;
import com.example.postgresdemo.dto.QuestionDTO;
import com.example.postgresdemo.model.Image;
import com.example.postgresdemo.model.Question;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION)
public interface QuestionMapper {

    @Named("toBase64")
    public static String toBase64(Image image) {
        return Utils.decodeByteArrayToBase64(image.getImage());
    }

    @Mappings({
            @Mapping(source = "image", target = "image", ignore = true)
    })
    Question toModel(QuestionDTO dto);

    @Mappings({
            @Mapping(target = "image", source = "image", qualifiedByName = "toBase64", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    })
    QuestionDTO toDto(Question model);
}
