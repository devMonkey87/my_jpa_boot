package com.example.postgresdemo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "TYPE_ICONS")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class TypeIcon extends GenericModel {
    @Lob
    private byte[] data;
}
