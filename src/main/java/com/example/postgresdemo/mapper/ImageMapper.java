/*
package com.example.postgresdemo.mapper;

import com.example.postgresdemo.Utils;
import com.example.postgresdemo.dto.ImageDTO;
import com.example.postgresdemo.model.Image;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    @Named("toBase64")
    public static String toBase64(byte[] image) {
        return Utils.decodeByteArrayToBase64(image);
    }

    @Mappings({
            @Mapping(source = "image", target = "image", qualifiedByName = "toBase64")
    })
    Image toModel(ImageDTO dto, @Context CycleAvoidingMappingContext context);

    ImageDTO toDto(Image model, @Context CycleAvoidingMappingContext context);

}
*/
