package com.example.postgresdemo.mapper;

import com.example.postgresdemo.dto.TypeDto;
import com.example.postgresdemo.model.Type;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = TypeIconMapper.class)
public interface DataMapper {

    Type toModel(TypeDto dto);

    TypeDto toDto(Type model);
}
