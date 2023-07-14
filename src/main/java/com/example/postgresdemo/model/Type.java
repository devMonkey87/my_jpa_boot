package com.example.postgresdemo.model;

import com.example.postgresdemo.utils.enums.PokemonType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "TYPES")
public class Type implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    @Enumerated(EnumType.STRING)
    PokemonType type;
    String description;
    @OneToOne
    @JoinColumn(name = "icon_id")
    TypeIcon icon;
}
