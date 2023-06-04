package com.americo.taskhub.application.ports.in;

import com.americo.taskhub.application.core.domain.Card;

import java.util.List;
import java.util.UUID;

public interface FindAllCardsOfColumnInputPort {
    List<Card> findAllCardsOfColumn(UUID cardId);
}
