package com.ing.nzy.finance.interieur;

import com.ing.nzy.dto.messages.AmendeCreationEvent;
import com.ing.nzy.finance.configurations.MessageQueueConfiguration;
import com.ing.nzy.finance.services.AmendeService;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Listener {

    private final AmendeService amendeService;

    @JmsListener(destination = MessageQueueConfiguration.CREATION_AMENDE_TOPIC)
    public void listen(AmendeCreationEvent amendeCreationEvent) {
        amendeService.ajouterAmende(amendeCreationEvent.getInfractionDto());
    }

}
