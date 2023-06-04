package com.americo.taskhub.application.ports.in;

import com.americo.taskhub.application.core.domain.Board;
import com.americo.taskhub.application.core.domain.Card;

import java.util.UUID;

public interface EditCardInputPort {
    Card editCard(UUID cardId, Card cardToBeEdited);
}
