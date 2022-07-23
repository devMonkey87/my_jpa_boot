package com.example.postgresdemo.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class ImageDTO {

    private int id;
    private String description;
    private String image;

}
