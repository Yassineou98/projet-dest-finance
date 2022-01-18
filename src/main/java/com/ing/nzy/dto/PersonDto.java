package com.ing.nzy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDto {

    private UUID id;
    private String cin;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String job;
    private List<InfractionDto> infractions;
    private Boolean avisDeRecherche;

}
