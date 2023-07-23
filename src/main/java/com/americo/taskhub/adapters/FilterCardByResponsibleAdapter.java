package com.americo.taskhub.adapters;

import com.americo.taskhub.adapters.out.repository.CardRepository;
import com.americo.taskhub.adapters.out.repository.entity.CardEntity;
import com.americo.taskhub.adapters.out.repository.mapper.CardEntityMapper;
import com.americo.taskhub.application.core.domain.Card;
import com.americo.taskhub.application.ports.in.FilterCardByResponsibleInputPort;
import com.americo.taskhub.application.ports.out.FilterCardByResponsibleOutputPort;
import com.americo.taskhub.config.log.AuditLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@Component
public class FilterCardByResponsibleAdapter implements FilterCardByResponsibleOutputPort {

    private final CardRepository cardRepository;
    private final CardEntityMapper mapper = new CardEntityMapper();

    @AuditLog(action = "Filter Card")
    @Override
    public List<Card> filterCard(String responsibleName) {
        List<CardEntity> cardEntities = cardRepository.findByResponsible(responsibleName);
        return mapper.toCardList(cardEntities);
    }
}
