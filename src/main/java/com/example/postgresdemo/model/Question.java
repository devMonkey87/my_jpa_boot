package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "QUESTIONS")
@JsonPropertyOrder({"id", "title", "description", "answers"})
public class Question extends GenericModel {

    @NotBlank
    @Size(min = 3, max = 100)
    private String title;
    @Column(columnDefinition = "text")
    private String description;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private List<Answer> answers;

    @Lob
    @Nullable
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Image image;

    public Question(int id, String title, String description, List<Answer> answers) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.answers = answers;
    }

}
