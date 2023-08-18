package com.example.postgresdemo.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class ImageDTO {

    private int id;
    private String description;
    @NonNull
    private String image;

}
