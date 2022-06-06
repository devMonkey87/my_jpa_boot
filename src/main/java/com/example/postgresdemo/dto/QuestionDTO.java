package com.example.postgresdemo.dto;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class QuestionDTO extends AuditModelDTO {

    private int id;

    private String title;

    private String description;


}
