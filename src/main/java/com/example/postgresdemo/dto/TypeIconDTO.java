package com.example.postgresdemo.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class TypeIconDTO extends AuditModelDTO {
    private int id;
    private String data;
}
