package com.example.postgresdemo.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter 
@RequiredArgsConstructor
@ToString 
@EqualsAndHashCode
public abstract class AuditModelDTO {
    private Date createdAt;
    private Date updatedAt;
}