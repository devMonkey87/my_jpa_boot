package com.example.postgresdemo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "IMAGES")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    @Lob
    private byte[] image;

    public Image(String description, byte[] image) {
        this.description = description;
        this.image = image;
    }
}
