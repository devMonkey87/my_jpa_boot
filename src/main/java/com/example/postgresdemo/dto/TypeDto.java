package com.example.postgresdemo.dto;

import com.example.postgresdemo.utils.enums.PokemonType;
import lombok.Data;

@Data
public class TypeDto {
    int id;
    PokemonType type;
    String description;
    TypeIconDTO icon;

}
