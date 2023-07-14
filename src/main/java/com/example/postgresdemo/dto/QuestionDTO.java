package com.example.postgresdemo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
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
