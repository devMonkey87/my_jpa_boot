package com.example.postgresdemo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@Table(name = "IMAGES")
public class Image extends GenericModel {

    private String description;

    @Lob
    private byte[] image;

    public Image(String description, byte[] image) {
        this.description = description;
        this.image = image;
    }


}
