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
public class RechercheCreationEvent implements Serializable {

    static final long serialVersionUID = 5976611858274461138L;

    private AmendDto amendeDto;

}
