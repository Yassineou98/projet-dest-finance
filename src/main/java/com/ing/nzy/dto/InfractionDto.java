package com.ing.nzy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfractionDto {

    private UUID id;
    private LocalDateTime createdDate;
    private String label;
    private Integer categorie;
    private String typePeine;
    private PersonDto person;
    private Boolean reglee;

}
