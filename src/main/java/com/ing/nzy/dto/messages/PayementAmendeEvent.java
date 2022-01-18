package com.ing.nzy.dto.messages;

import com.ing.nzy.dto.AmendDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayementAmendeEvent implements Serializable {

    static final long serialVersionUID = 373535592915511915L;

    private AmendDto amendDto;

}
