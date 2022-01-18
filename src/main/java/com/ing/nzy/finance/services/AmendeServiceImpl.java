package com.ing.nzy.finance.services;

import com.ing.nzy.dto.messages.RechercheCreationEvent;
import com.ing.nzy.finance.configurations.MessageQueueConfiguration;
import com.ing.nzy.finance.converters.AmendeConverter;
import com.ing.nzy.finance.model.Amende;
import com.ing.nzy.finance.repositories.AmendeRepository;
import com.ing.nzy.dto.InfractionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AmendeServiceImpl implements AmendeService {

    private final AmendeRepository amendeRepository;
    private final AmendeConverter amendeConverter;
    private final JmsTemplate jmsTemplate;

    @Override
    public void ajouterAmende(InfractionDto infractionDto) {

        // convertir du type infraction au type amende + calcule date echeance + calcule le montant
        Amende amende = amendeConverter.infractionToAmend(infractionDto);

        // save to DB
        amendeRepository.saveAndFlush(amende);

    }

    @Override
    public void reglerAmende(Long amendeId) {

        Amende amende = amendeRepository.findById(amendeId).orElseThrow(RuntimeException::new);

        amende.setPayee(true);

        amendeRepository.saveAndFlush(amende);

    }

    @Override
    public void amendesApresDateEcheance() {

        amendeRepository
                .findAll()
                .stream()
                .filter(amende -> !amende.getPayee() && amende.getDateEcheance().isAfter(LocalDate.now()))
                .forEach(amende -> {
                   // envoyer message au ministere de l'interieur pour creer un avis de recherche
                    jmsTemplate.convertAndSend(MessageQueueConfiguration.CREATION_RECHERCHE_TOPIC,
                            RechercheCreationEvent.builder()
                                    .amendeDto(amendeConverter.amendeToAmendDto(amende))
                                    .build());
                    log.debug("Sent Jms Message With Cin {}", amende.getPersonCin());
                });
    }
}
