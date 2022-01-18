package com.ing.nzy.dto.messages;

import com.ing.nzy.dto.InfractionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AmendeCreationEvent implements Serializable {

    static final long serialVersionUID = -8748289177798674896L;

    private InfractionDto infractionDto;

}
