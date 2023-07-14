package com.example.postgresdemo.dto;

import lombok.Data;

@Data
public class AdditionalDataDTO {

    int originalPrice;
    String type;

    public AdditionalDataDTO(String key, Integer value) {
    }

    public AdditionalDataDTO() {

    }
}
