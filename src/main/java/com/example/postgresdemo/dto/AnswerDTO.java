package com.example.postgresdemo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AnswerDTO extends AuditModelDTO {

    List<AdditionalDataDTO> additionalDataDTOList;
    @EqualsAndHashCode.Include
    private int id;
    private String text;
}
