package com.example.postgresdemo.dto;

import lombok.Data;

@Data
public class AnswerDTO extends AuditModelDTO {

    private int id;
    private String text;
    private QuestionDTO question;


}
