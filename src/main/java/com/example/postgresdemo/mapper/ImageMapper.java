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
    public static String toBase64(byte[] image) {
        return Utils.decodeByteArrayToBase64(image);
    }

    @Mapping(source = "image", target = "image", qualifiedByName = "toBase64")
    public ImageDTO toDto(Image model);

    @Mapping(source = "image", target = "image", ignore = true)
    public Image toModel(ImageDTO dto);

}
