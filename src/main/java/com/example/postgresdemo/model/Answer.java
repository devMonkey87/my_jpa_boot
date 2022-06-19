package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter @Setter 
@RequiredArgsConstructor
@ToString 
@EqualsAndHashCode
@Table(name = "answers")
public class Answer extends AuditModel {

    public Answer (int id, String text, Question question){
        this.id = id;
        this.text = text;
        this.question = question;
    }

    @Id
    @GeneratedValue(generator = "answer_generator")
    @SequenceGenerator(
            name = "answer_generator",
            sequenceName = "answer_sequence",
            initialValue = 1
    )
    private int id;

    @Column(columnDefinition = "text")
    private String text;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;


}
