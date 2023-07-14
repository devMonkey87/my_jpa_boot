package com.example.postgresdemo.mapper;

import com.example.postgresdemo.Utils;
import com.example.postgresdemo.dto.TypeIconDTO;
import com.example.postgresdemo.model.TypeIcon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface TypeIconMapper {


    @Named("toBase64")
    static String toBase64(byte[] image) {
        return Utils.decodeByteArrayToBase64(image);
    }

    @Mapping(source = "data", target = "data", qualifiedByName = "toBase64")
    @Mapping(target = "createdAt")
    @Mapping(target = "updatedAt")
    TypeIconDTO toDto(TypeIcon model);

    @Mapping(source = "data", target = "data", ignore = true)
    TypeIcon toModel(TypeIconDTO dto);

}
