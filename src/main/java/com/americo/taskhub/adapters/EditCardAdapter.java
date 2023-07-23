package com.americo.taskhub.adapters;

import com.americo.taskhub.adapters.out.repository.CardRepository;
import com.americo.taskhub.adapters.out.repository.entity.CardEntity;
import com.americo.taskhub.adapters.out.repository.mapper.CardEntityMapper;
import com.americo.taskhub.application.core.domain.Card;
import com.americo.taskhub.application.ports.out.EditCardOutputPort;
import com.americo.taskhub.config.log.AuditLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Component
public class EditCardAdapter implements EditCardOutputPort {
    private final CardRepository cardRepository;
    private final CardEntityMapper mapper = new CardEntityMapper();

    @AuditLog(action = "Edit Card")
    @Override
    public Card editCard(UUID cardId, Card cardToBeEdited) {
        CardEntity cardEntity = cardRepository.findById(cardId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "No card results for ID: " + cardId));
        cardEntity = mapper.toCardEntity(cardToBeEdited);
        cardEntity.setId(cardId);

        return mapper.toCard(cardRepository.save(cardEntity));
    }
}
