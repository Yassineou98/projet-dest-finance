package com.ing.nzy.finance.converters;

import com.ing.nzy.dto.AmendDto;
import com.ing.nzy.dto.InfractionDto;
import com.ing.nzy.finance.model.Amende;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class AmendeConverterDecorator implements AmendeConverter {

    private AmendeConverter amendeConverter;

    @Autowired
    public void setAmendeConverter(AmendeConverter amendeConverter) {
        this.amendeConverter = amendeConverter;
    }

    @Override
    public Amende infractionToAmend(InfractionDto infractionDto) {

        Amende amende = amendeConverter.infractionToAmend(infractionDto);

        amende.setDateEcheance(LocalDate.now().plusMonths(3L));

        amende.setPayee(false);

        amende.setMontant(infractionDto.getCategorie() * 10D +
                ThreadLocalRandom.current().nextInt(10, 100));

        return amende;
    }

    @Override
    public AmendDto amendeToAmendDto(Amende amende) {
        return amendeConverter.amendeToAmendDto(amende);
    }
}
