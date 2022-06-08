package com.example.postgresdemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDTO extends AuditModelDTO {
    private int id;
    private String text;
}
