package com.example.postgresdemo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class AuditModelDTO {
    private Date createdAt;
    private Date updatedAt;
}