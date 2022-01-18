package com.ing.nzy.finance.services;

import com.ing.nzy.dto.InfractionDto;

public interface AmendeService {

    void ajouterAmende(InfractionDto infractionDto);

    void reglerAmende(Long amendeId);

    void amendesApresDateEcheance();

}
