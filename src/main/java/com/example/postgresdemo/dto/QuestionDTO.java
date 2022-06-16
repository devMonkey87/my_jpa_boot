package com.example.postgresdemo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionDTO extends AuditModelDTO {
    private int id;
    private String title;
    private String description;
    private List<AnswerDTO> answers;
    private String image;
}
