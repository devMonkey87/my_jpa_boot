package com.example.postgresdemo.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@RequiredArgsConstructor
public abstract class GenericModel implements Serializable {

    @Column(name = "created_at")
    @CreationTimestamp
    public LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    public LocalDateTime updatedAt;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

}
