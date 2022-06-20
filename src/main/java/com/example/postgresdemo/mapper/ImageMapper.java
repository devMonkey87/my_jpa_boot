package com.example.postgresdemo.mapper;

import com.example.postgresdemo.Utils;
import com.example.postgresdemo.dto.ImageDTO;
import com.example.postgresdemo.model.Image;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ImageMapper {


    @Named("toBase64")
    public static String toBase64(byte[] image) {
        return Utils.decodeByteArrayToBase64(image);
    }

    @Mapping(source = "image", target = "image", ignore = true)
    Image toModel(ImageDTO dto, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "image", target = "image", qualifiedByName = "toBase64")
    ImageDTO toDto(Image model, @Context CycleAvoidingMappingContext context);

}
