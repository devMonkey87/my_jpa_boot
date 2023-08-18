package com.example.postgresdemo.mapper;

import com.example.postgresdemo.dto.PokemonDTO;
import com.example.postgresdemo.model.Pokemon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ImageMapper.class, DataMapper.class})
public interface PokemonMapper {

    Pokemon toModel(PokemonDTO dto);

    PokemonDTO toDto(Pokemon pokemon);

}
