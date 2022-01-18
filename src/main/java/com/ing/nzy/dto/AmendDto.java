package com.ing.nzy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AmendDto {

    private String id;

    private UUID infractionId;

    private Double montant;

    private String cin;

    private LocalDate dateCreation;

    private LocalDate dateEcheance;

    private Boolean payee;

}
