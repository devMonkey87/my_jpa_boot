package com.example.postgresdemo.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter 
@RequiredArgsConstructor
@ToString 
@EqualsAndHashCode
public class QuestionDTO extends AuditModelDTO {
    private int id;
    private String title;
    private String description;
    private List<AnswerDTO> answers;
    private String image;
}
