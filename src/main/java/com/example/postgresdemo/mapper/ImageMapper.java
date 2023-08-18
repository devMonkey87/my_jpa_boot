package com.example.postgresdemo.mapper;

import com.example.postgresdemo.Utils;
import com.example.postgresdemo.dto.ImageDTO;
import com.example.postgresdemo.model.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ImageMapper {


    @Named("toBase64")
    static String toBase64(byte[] image) {
        return Utils.decodeByteArrayToBase64(image);
    }

    @Named("fromBase64")
    static byte[] fromBase64(String base64) {
        return java.util.Base64.getDecoder().decode(base64);
    }


    @Mapping(source = "image", target = "image", qualifiedByName = "toBase64")
    ImageDTO toDto(Image model);

    @Mapping(source = "image", target = "image", qualifiedByName = "fromBase64")
    @Mapping(target = "id", ignore = true)
    Image toModel(ImageDTO dto);


}
