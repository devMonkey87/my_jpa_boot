package com.example.postgresdemo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "POKEMONS")
public class Pokemon extends GenericModel {

    String name;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "type_id")
    Type type;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "image_id")
    Image image;

}
