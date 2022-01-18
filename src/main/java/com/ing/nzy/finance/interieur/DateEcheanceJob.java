package com.ing.nzy.finance.interieur;

import com.ing.nzy.finance.services.AmendeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
@Slf4j
public class DateEcheanceJob {

    private final AmendeService amendeService;

    //chaque jour on test  la date d'echeance de tous les amendes non payee,
    // si elle ne sont pas payee apres la date d'echeance on envoi au ministre de l'interieur pour creer un avis de recherche
    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.DAYS)
    public void sendAvisDeRecherche() {
        log.debug("Recherche Job Executed");
        amendeService.amendesApresDateEcheance();
    }

}
