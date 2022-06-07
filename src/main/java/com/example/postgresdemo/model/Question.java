package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Table(name = "questions")
@JsonPropertyOrder({"id", "title", "description", "answers" })
public class Question extends AuditModel {

    private static final long serialVersionUID = -5502043778089640767L;

    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1
    )
    private int id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private List<Answer> answers;

}
