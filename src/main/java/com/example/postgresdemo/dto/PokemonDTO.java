package com.example.postgresdemo.dto;

import lombok.Data;

@Data
public class PokemonDTO extends AuditModelDTO {

    private String name;
    private TypeDto type;
    private ImageDTO image;
}
