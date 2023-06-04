package com.americo.taskhub.application.ports.out;

import com.americo.taskhub.application.core.domain.Card;

import java.util.UUID;

public interface EditCardOutputPort {
    Card editCard(UUID cardId, Card cardToBeEdited);
}
