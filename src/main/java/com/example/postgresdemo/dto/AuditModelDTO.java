package com.example.postgresdemo.dto;

import lombok.Data;

import java.util.Date;

@Data
public abstract class AuditModelDTO {
    private Date createdAt;
    private Date updatedAt;
}
