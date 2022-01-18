package com.ing.nzy.finance.converters;

import com.ing.nzy.dto.AmendDto;
import com.ing.nzy.finance.model.Amende;
import com.ing.nzy.dto.InfractionDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateConverter.class})
@DecoratedWith(AmendeConverterDecorator.class)
public interface AmendeConverter {
    @Mapping(source = "id", target = "infractionId")
    @Mapping(source = "person.cin", target = "personCin")
    @Mapping(source = "id", target = "id", ignore = true)
    Amende infractionToAmend(InfractionDto infractionDto);

    @Mapping(source = "personCin", target = "cin")
    AmendDto amendeToAmendDto(Amende amende);
}
