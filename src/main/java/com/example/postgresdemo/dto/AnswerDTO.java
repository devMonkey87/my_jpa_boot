package com.example.postgresdemo.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter 
@RequiredArgsConstructor
@ToString 
@EqualsAndHashCode
public class AnswerDTO extends AuditModelDTO {
    private int id;
    private String text;
}
