package com.example.postgresdemo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "POKEMONS")
public class Pokemon extends GenericModel {

    String name;
    @OneToOne
    @JoinColumn(name = "type_id")
            
    Type type;
    @OneToOne
    @JoinColumn(name = "image_id")
    Image image;

}
