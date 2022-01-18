package com.ing.nzy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveAmendDto {

    private BigDecimal amount;
    private String cin;
    private String remarks;
    private Boolean isPayed;

}
