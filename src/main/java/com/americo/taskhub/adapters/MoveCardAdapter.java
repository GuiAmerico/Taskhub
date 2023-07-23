package com.americo.taskhub.adapters;

import com.americo.taskhub.adapters.out.repository.CardRepository;
import com.americo.taskhub.application.core.domain.Card;
import com.americo.taskhub.application.ports.in.MoveCardInputPort;
import com.americo.taskhub.application.ports.out.MoveCardOutputPort;

import com.americo.taskhub.config.log.AuditLog;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MoveCardAdapter implements MoveCardOutputPort {


    private final CardRepository cardRepository;

    @AuditLog(action = "Move Card")
    @Override
    public void moveCard(UUID columnId, UUID cardId) {
        cardRepository.moveCard(columnId, cardId);
    }
}
