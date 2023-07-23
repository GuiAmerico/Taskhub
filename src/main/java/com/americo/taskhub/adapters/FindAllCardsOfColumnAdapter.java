package com.americo.taskhub.adapters;

import com.americo.taskhub.adapters.out.repository.CardRepository;
import com.americo.taskhub.adapters.out.repository.entity.CardEntity;
import com.americo.taskhub.adapters.out.repository.mapper.CardEntityMapper;
import com.americo.taskhub.application.core.domain.Card;
import com.americo.taskhub.application.ports.out.FindAllCardsOfColumnOutputPort;
import com.americo.taskhub.config.log.AuditLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Component
public class FindAllCardsOfColumnAdapter implements FindAllCardsOfColumnOutputPort {
    private final CardRepository cardRepository;
    private final CardEntityMapper mapper = new CardEntityMapper();

    @AuditLog(action = "Find All Cards Of Column")
    @Override
    public List<Card> findAllCardsOfColumn(UUID columnId) {
        List<CardEntity> cardEntities = cardRepository.findByColumn(columnId);
        if (cardEntities.isEmpty()){
            throw new ResponseStatusException(NOT_FOUND, "No cards results for column with ID: " + columnId);
        }
        return mapper.toCardList(cardEntities);
    }
}
