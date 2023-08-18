package com.example.postgresdemo.dto;

import com.example.postgresdemo.utils.enums.PokemonType;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class TypeDto {
    @NonNull
    int id;
    PokemonType type;
    String description;
    TypeIconDTO icon;

}


